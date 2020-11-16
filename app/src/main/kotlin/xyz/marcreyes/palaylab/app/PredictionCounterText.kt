package xyz.marcreyes.palaylab.app

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

                    val currentCalendar = Calendar.getInstance()
                    val week = currentCalendar[Calendar.WEEK_OF_YEAR]
                    val year = currentCalendar[Calendar.YEAR]
                    val targetCalendar = Calendar.getInstance()
                    targetCalendar.time = SimpleDateFormat("yyyy-MM-dd").parse(dDate)
                    val targetWeek = targetCalendar[Calendar.WEEK_OF_YEAR]
                    val targetYear = targetCalendar[Calendar.YEAR]

                    val isThisWeek = week == targetWeek && year == targetYear

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