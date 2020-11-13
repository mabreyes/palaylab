package io.github.projectbukirin.palaylab

import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class PredictionCounter(val detectionName: String, val textViewId: TextView) {
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val dbReference = firebaseDatabase.getReference("palaylab-users-prod-01")
    private val userId: String? = FirebaseAuth.getInstance().currentUser?.uid
    private val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
    private val date = Date()
    private val dateToday = dateFormat.format(date)
    private val query: Query = dbReference.child("predictions").orderByChild("uuid").equalTo(userId)

    fun getPredictionToday() {
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
                textViewId.text = ctr.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getPredictionTotal() {
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
                textViewId.text = ctr.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getPredictionThisWeek() {
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
                textViewId.text = ctr.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}