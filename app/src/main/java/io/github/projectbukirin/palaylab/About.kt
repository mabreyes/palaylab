package io.github.projectbukirin.palaylab

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val imageButton = findViewById<View>(R.id.imageButton3) as ImageButton
        imageButton.setOnClickListener { backActivity() }
        val textView = findViewById<View>(R.id.link) as TextView
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

    fun backActivity() {
        finish()
    }

    override fun onBackPressed() {
        finish()
    }
}