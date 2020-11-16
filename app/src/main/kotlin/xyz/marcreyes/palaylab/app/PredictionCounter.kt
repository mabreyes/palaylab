package xyz.marcreyes.palaylab.app

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
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
                val counterDetectionsToday = SpannableString.valueOf("$ctr\nToday")
                counterDetectionsToday.setSpan(RelativeSizeSpan(3f), 0, ctr.toString().length, 0)
                counterDetectionsToday.setSpan(StyleSpan(Typeface.BOLD), 0, ctr.toString().length, 0)
                textViewId.text = counterDetectionsToday
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
                val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                val counterDetections = SpannableString.valueOf("$ctr\nTotal")
                counterDetections.setSpan(RelativeSizeSpan(3f), 0, ctr.toString().length, flag)
                counterDetections.setSpan(StyleSpan(Typeface.BOLD), 0, ctr.toString().length, flag)
                textViewId.text = counterDetections
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
                val counterDetectionsTW = SpannableString.valueOf("$ctr\nThis Week")
                counterDetectionsTW.setSpan(RelativeSizeSpan(3f), 0, ctr.toString().length, 0)
                counterDetectionsTW.setSpan(StyleSpan(Typeface.BOLD), 0, ctr.toString().length, 0)
                textViewId.text = counterDetectionsTW
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}