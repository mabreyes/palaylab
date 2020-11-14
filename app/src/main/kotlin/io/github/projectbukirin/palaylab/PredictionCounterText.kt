package io.github.projectbukirin.palaylab

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class PredictionCounterText(val detectionName: String) {
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val dbReference = firebaseDatabase.getReference("palaylab-users-prod-01")
    private val userId: String? = FirebaseAuth.getInstance().currentUser?.uid
    private val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
    private val date = Date()
    private val dateToday = dateFormat.format(date)
    private val query: Query = dbReference.child("predictions").orderByChild("uuid").equalTo(userId)

    fun getPredictionToday(finishedCallback: CounterCallback<Int>) {
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var ctr = 0
                for (ds in snapshot.children) {
                    val dName = ds.child("detectionName").getValue<String>(String::class.java)
                    val dDate = ds.child("detectionDate").getValue<String>(String::class.java)
                    if (dName == detectionName && dDate == dateToday) {
                        ctr++
                    } else {
                    }
                }
                finishedCallback.callback(ctr)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getPredictionTotal(finishedCallback: CounterCallback<Int>) {
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var ctr = 0
                for (ds in snapshot.children) {
                    val dName = ds.child("detectionName").getValue<String>(String::class.java)
                    if (dName == detectionName) {
                        ctr++
                    } else {
                    }
                }
                finishedCallback.callback(ctr)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getPredictionThisWeek(finishedCallback: CounterCallback<Int>) {
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var ctr = 0
                for (ds in snapshot.children) {
                    val dName = ds.child("detectionName").getValue<String>(String::class.java)
                    val dDate = ds.child("detectionDate").getValue<String>(String::class.java)
                    val ddd: Date = SimpleDateFormat("yyyy-MM-dd").parse(dDate)
                    val c = Calendar.getInstance()
                    c.firstDayOfWeek = Calendar.MONDAY

                    c[Calendar.DAY_OF_WEEK] = Calendar.MONDAY
                    c[Calendar.HOUR_OF_DAY] = 0
                    c[Calendar.MINUTE] = 0
                    c[Calendar.SECOND] = 0
                    c[Calendar.MILLISECOND] = 0

                    val monday = c.time
                    val nextMonday = Date(monday.time + 7 * 24 * 60 * 60 * 1000)

                    val isThisWeek = ddd.after(monday) && ddd.before(nextMonday)

                    if (dName == detectionName && isThisWeek) {
                        ctr++
                    } else {
                    }
                }
                finishedCallback.callback(ctr)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}