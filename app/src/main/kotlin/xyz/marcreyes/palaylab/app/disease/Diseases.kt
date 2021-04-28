package xyz.marcreyes.palaylab.app.disease

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import xyz.marcreyes.palaylab.app.about.About
import xyz.marcreyes.palaylab.app.custom.CustomListView
import xyz.marcreyes.palaylab.app.disease.DiseasesDefinition.*
import xyz.marcreyes.palaylab.app.authentication.LoginActivity
import xyz.marcreyes.palaylab.app.R

class Diseases : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var list: ListView? = null
    var diseasename: Array<String?> = arrayOf("Bacterial Leaf Blight", "Rice Blast", "Sheath Blight", "Tungro")
    var desc: Array<String?> = arrayOf("Disease", "Disease", "Disease", "Disease")
    var imgid: Array<Int?> = arrayOf(R.drawable.bacterialblight, R.drawable.riceblast, R.drawable.sheathblight, R.drawable.tungro)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseases)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
        }

        setSupportActionBar(findViewById(R.id.toolbar_diseases))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Diseases"

        list = findViewById<View>(R.id.disease_list) as ListView
        val customListview = CustomListView(this, diseasename, desc, imgid)
        list!!.adapter = customListview
        list!!.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    val intent = Intent()
                    intent.setClass(this@Diseases, DiseasesDefinition::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent1 = Intent()
                    intent1.setClass(this@Diseases, DiseaseDefinition2::class.java)
                    startActivity(intent1)
                }
                2 -> {
                    val intent2 = Intent()
                    intent2.setClass(this@Diseases, DiseaseDefinition3::class.java)
                    startActivity(intent2)
                }
                3 -> {
                    val intent3 = Intent()
                    intent3.setClass(this@Diseases, DiseaseDefinition4::class.java)
                    startActivity(intent3)
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_actionbar, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}