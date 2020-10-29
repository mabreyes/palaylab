package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import io.github.projectbukirin.palaylab.DiseasesDefinition.*

class Diseases : AppCompatActivity() {
    var list: ListView? = null
    var diseasename: Array<String?> = arrayOf("Bacterial Leaf Blight", "Rice Blast", "Sheath Blight", "Tungro")
    var desc: Array<String?> = arrayOf("Disease", "Disease", "Disease", "Disease")
    var imgid: Array<Int?> = arrayOf(R.drawable.bacterialblight, R.drawable.riceblast, R.drawable.sheathblight, R.drawable.tungro)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseases)
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
        val androidImageButton = findViewById<View>(R.id.imageButton3) as ImageButton
        androidImageButton.setOnClickListener { backActivity() }
    }

    fun backActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        val intent = Intent(this@Diseases, MainActivity::class.java)
        startActivity(intent)
    }
}