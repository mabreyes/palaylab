package xyz.marcreyes.palaylab.app.Main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import xyz.marcreyes.palaylab.app.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Handler().postDelayed({
            val mainIntent = Intent(this@HomeActivity, MainActivity::class.java)
            this@HomeActivity.startActivity(mainIntent)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_TIME_OUT = 2000
    }
}