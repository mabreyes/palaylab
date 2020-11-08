package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import io.github.projectbukirin.palaylab.PestsDefinition.*

class Pest : AppCompatActivity() {
    var list: ListView? = null
    var pestename: Array<String?> = arrayOf("Army Worm", "Golden Apple Snail", "Green Leafhopper", "Rice Black Bug", "Rice Ear Bug")
    var desc: Array<String?> = arrayOf("Pest", "Pest", "Pest", "Pest", "Pest")
    var imgid: Array<Int?> = arrayOf(R.drawable.armyworm, R.drawable.goldenapplesnail, R.drawable.greenleafhopper, R.drawable.riceblackbug, R.drawable.riceearbug)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pest)

        setSupportActionBar(findViewById(R.id.toolbar_pests))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pests"

        list = findViewById<View>(R.id.pestitem) as ListView
        val customListview = CustomListView(this, pestename, desc, imgid)
        list!!.adapter = customListview
        list!!.onItemClickListener = OnItemClickListener { adapterView, view, position, l ->
            when (position) {
                0 -> {
                    val intent = Intent()
                    intent.setClass(this@Pest, PestsDefinition::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent1 = Intent()
                    intent1.setClass(this@Pest, PestDefinition2::class.java)
                    startActivity(intent1)
                }
                2 -> {
                    val intent2 = Intent()
                    intent2.setClass(this@Pest, PestDefinition3::class.java)
                    startActivity(intent2)
                }
                3 -> {
                    val intent3 = Intent()
                    intent3.setClass(this@Pest, PestDefinition4::class.java)
                    startActivity(intent3)
                }
                4 -> {
                    val intent4 = Intent()
                    intent4.setClass(this@Pest, PestDefinition5::class.java)
                    startActivity(intent4)
                }
            }
        }
    }

    fun backActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
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