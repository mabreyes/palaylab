package xyz.marcreyes.palaylab.app.Authentication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import xyz.marcreyes.palaylab.app.R

class UpdatePassword : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var passwordEt: EditText

    private lateinit var changePasswordBtn: Button
    private lateinit var back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
        }

        passwordEt = findViewById(R.id.password_edt_text)

        changePasswordBtn = findViewById(R.id.reset_pass_btn)
        back = findViewById(R.id.back_btn)

        back.setOnClickListener {
            finish()
        }

        changePasswordBtn.setOnClickListener {
            var password: String = passwordEt.text.toString()
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()
            } else {
                auth.currentUser?.updatePassword(password)
                        ?.addOnCompleteListener(this, OnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Password changes successfully", Toast.LENGTH_LONG)
                                        .show()
                                finish()
                            } else {
                                Toast.makeText(this, "password not changed", Toast.LENGTH_LONG)
                                        .show()
                            }
                        })
            }
        }
    }
}