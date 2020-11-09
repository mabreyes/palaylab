package io.github.projectbukirin.palaylab

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.ScrollingMovementMethod
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import io.github.projectbukirin.palaylab.DiseasesViewPager.*

class DiseasesDefinition : AppCompatActivity() {
    var textView: TextView? = null
    var textViewDetection: TextView? = null
    var detectionText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_definition)

        setSupportActionBar(findViewById(R.id.toolbar_definition))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Bacterial Leaf Blight"

        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        val diseasesViewPager = DiseasesViewPager(this)
        viewPager.adapter = diseasesViewPager
        textView = findViewById<View>(R.id.definition) as TextView
        textViewDetection = findViewById<View>(R.id.detection) as TextView
        detectionText = findViewById<View>(R.id.detectionText) as TextView
        val s1 = SpannableString("Bacterial Leaf Blight\n")
        val ss1 = SpannableString("Disease\n\n")
        val s2 = SpannableString("About\n")
        val s3 = SpannableString("""
    Bacterial leaf blight is caused by Xanthomonas oryzae pv. oryzae.  It causes wilting of seedlings and yellowing and drying of leaves. The disease is most likely to develop in areas that have weeds and stubbles of infected plants. It can occur in both tropical and temperate environments, particularly in irrigated and rainfed lowland areas. In general, the disease favors temperatures at 25−34°C, with relative humidity above 70%. It is commonly observed when strong winds and continuous heavy rains occur, allowing the disease-causing bacteria to easily spread through ooze droplets on lesions of infected plants. Bacterial blight can be severe in susceptible rice varieties under high nitrogen fertilization.
    
    """.trimIndent())
        val s4 = SpannableString("\nSymptoms\n")
        val s5 = SpannableString("Check for wilting and yellowing of leaves, or wilting of seedlings (also called kresek). " +
                "On seedlings, infected leaves turn grayish green and roll up. As the disease progresses, the leaves turn yellow to straw-colored and wilt, " +
                "leading whole seedlings to dry up and die. Kresek on seedlings may sometimes be confused with early rice stem borer damage.  To distinguish " +
                "kresek symptoms from stem borer damage, squeeze the lower end of infected seedlings between the fingers. Kresek symptoms should show yellowish " +
                "bacterial ooze coming out of the cut ends. Unlike plants infested with stem borer, rice plants with kresek are not easily pulled out from soil.")
        val s6 = SpannableString("\n\nManagement Strategies\n")
        val s7 = SpannableString("""
    A. Preventive Methods
    ▪ Seed treatment with bleaching powder (100g/l) and zinc sulfate (2%) reduce bacterial blight.
    ▪ Seed treatment - seed soaking for 8 hours in Agrimycin (0.025%) and wettable ceresan (0.05%) followed by hot water treatment for 30 min at 52-54oC;
    ▪  seed soaking for 8 hours in ceresan (0.1%) and treat with Streptocyclin (3g in 1 liter);
    ▪ Spray neem oil 3% or NSKE 5%
    ▪ Spray fresh cow dung extract for the control of bacterial blight. Dissolve 20 g cow dung in one liter of water; allow to settle and sieve. Use supernatant liquid. (starting from initial appearance of the disease and another at fortnightly interval)
    
    B. Cultural Methods
    ▪ Grow Tolerant varieties (IR 20 IR 72, PONMANI, TKM 6).
    ▪ Secure disease free seed
    ▪ Grow nurseries preferably in isolated upland conditions
    ▪ Avoid clipping of seedlings during transplanting.
    ▪ Balanced fertilization, avoid excess N-application
    ▪ Skip N-application at booting (if disease is moderate)
    ▪ Drain the field (except at flowering stage of the crop)
    ▪ Destruction of weeds and collateral hosts
    ▪ Avoid flow of water from affected fields
    ▪  Maintain proper plant spacing
    
    C. Chemical Methods
    ▪ Seed treatment with bleaching powder (100g/l) and zinc sulfate (2%) reduce bacterial blight.
    ▪ Seed treatment - seed soaking for 8 hours in Agrimycin (0.025%) and wettable ceresan (0.05%) followed by hot water treatment for 30 min at 52-54oC;
    ▪  seed soaking for 8 hours in ceresan (0.1%) and treat with Streptocyclin (3g in 1 liter);
    ▪ Spray Streptomycin sulphate + Tetracycline combination 300 g + Copper oxychloride 1.25kg/ha. If necessary, repeat 15 days later.
    ▪ Application of bleaching powder @ 5 kg/ha in the irrigation water is recommended in the kresek stage.
    ▪  Foliar spray with copper fungicides alternatively with Strepto-cyclin (250 ppm) to check secondary spread.
    """.trimIndent())
        val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        s1.setSpan(StyleSpan(Typeface.BOLD), 0, s1.length, flag)
        s1.setSpan(RelativeSizeSpan(2.5f), 0, s1.length, flag)
        s1.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length, flag)
        ss1.setSpan(RelativeSizeSpan(1.7f), 0, ss1.length, flag)
        ss1.setSpan(StyleSpan(Typeface.BOLD), 0, ss1.length, flag)
        s2.setSpan(StyleSpan(Typeface.BOLD), 0, s2.length, flag)
        s2.setSpan(RelativeSizeSpan(2f), 0, s2.length, flag)
        s2.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length, flag)
        s3.setSpan(RelativeSizeSpan(1.5f), 0, s3.length, flag)
        s3.setSpan(StyleSpan(Typeface.NORMAL), 0, s3.length, flag)
        s4.setSpan(StyleSpan(Typeface.BOLD), 0, s4.length, flag)
        s4.setSpan(RelativeSizeSpan(2f), 0, s4.length, flag)
        s4.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length, flag)
        s5.setSpan(StyleSpan(Typeface.NORMAL), 0, s5.length, flag)
        s5.setSpan(RelativeSizeSpan(1.5f), 0, s5.length, flag)
        s6.setSpan(StyleSpan(Typeface.BOLD), 0, s6.length, flag)
        s6.setSpan(RelativeSizeSpan(2f), 0, s6.length, flag)
        s6.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length, flag)
        s7.setSpan(StyleSpan(Typeface.NORMAL), 0, s7.length, flag)
        s7.setSpan(RelativeSizeSpan(1.5f), 0, s7.length, flag)
        val bold = Typeface.createFromAsset(assets, "gorditabold.ttf")
        val medium = Typeface.createFromAsset(assets, "gorditamedium.ttf")
        val regular = Typeface.createFromAsset(assets, "gorditaregular.ttf")
        s1.setSpan(CustomTypefaceSpan("", bold), 0, s1.length, flag)
        ss1.setSpan(CustomTypefaceSpan("", medium), 0, ss1.length, flag)
        s2.setSpan(CustomTypefaceSpan("", bold), 0, s2.length, flag)
        s3.setSpan(CustomTypefaceSpan("", regular), 0, s3.length, flag)
        s4.setSpan(CustomTypefaceSpan("", bold), 0, s4.length, flag)
        s5.setSpan(CustomTypefaceSpan("", regular), 0, s5.length, flag)
        s6.setSpan(CustomTypefaceSpan("", bold), 0, s6.length, flag)
        val builder = SpannableStringBuilder()
        builder.append(s1)
        builder.append(ss1)
        builder.append(s2)
        builder.append(s3)
        builder.append(s4)
        builder.append(s5)
        builder.append(s6)
        builder.append(s7)
        textView!!.text = builder
        textView!!.movementMethod = ScrollingMovementMethod()
        val db = DatabaseHelper(this)
        val count = db.countInfo("Bacterial Leaf Blight").toString()
        val thisWeek = db.countThisWeek("Bacterial Leaf Blight").toString()
        val counterDetections = SpannableString.valueOf("$count\nTotal")
        counterDetections.setSpan(RelativeSizeSpan(3f), 0, count.length, flag)
        counterDetections.setSpan(StyleSpan(Typeface.BOLD), 0, count.length, flag)
        val counterDetectionsTW = SpannableString.valueOf("$thisWeek\nThis Week")
        counterDetectionsTW.setSpan(RelativeSizeSpan(3f), 0, thisWeek.length, 0)
        counterDetectionsTW.setSpan(StyleSpan(Typeface.BOLD), 0, thisWeek.length, 0)
        textViewDetection!!.text = counterDetections
        detectionText!!.text = counterDetectionsTW
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

    class DiseaseDefinition2 : AppCompatActivity() {
        var textView: TextView? = null
        var textViewDetection: TextView? = null
        var detectionText: TextView? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_definition)

            setSupportActionBar(findViewById(R.id.toolbar_definition))
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Rice Blast"

            val viewPager = findViewById<ViewPager>(R.id.viewpager)
            val diseasesViewPager = DiseasesViewPager2(this)
            viewPager.adapter = diseasesViewPager
            textView = findViewById<View>(R.id.definition) as TextView
            textViewDetection = findViewById<View>(R.id.detection) as TextView
            detectionText = findViewById<View>(R.id.detectionText) as TextView
            val s1 = SpannableString("Rice Blast\n")
            val ss1 = SpannableString("Disease\n\n")
            val s2 = SpannableString("About\n")
            val s3 = SpannableString("""
    Blast is caused by the fungus Magnaporthe oryzae. It can affect all above ground parts of a rice plant: leaf, collar, node, neck, parts of panicle, and sometimes leaf sheath. Blast can occur wherever blast spores are present. It occurs in areas with low soil moisture, frequent and prolonged periods of rain shower, and cool temperature in the daytime. In upland rice, large day-night temperature differences that cause dew formation on leaves and overall cooler temperatures favor the development of the disease. Rice can have blast in all growth stages. However, leaf blast incidence tends to lessen as plants mature and develop adult plant resistance to the disease.
    
    """.trimIndent())
            val s4 = SpannableString("\nSymptoms\n")
            val s5 = SpannableString("Check the leaf and collar for lesions that include: initial symptoms appear as white to gray-green " +
                    "lesions or spots, with dark green borders; older lesions on the leaves are elliptical or spindle-shaped and whitish to gray centers with red to " +
                    "brownish or necrotic border. Check for other symptoms that include some resemble diamond shape, wide in the center and pointed toward either and " +
                    "lesions can enlarge and coalesce, growing together, to kill the entire leaves.")
            val s6 = SpannableString("\n\nManagement Strategies\n")
            val s7 = SpannableString("""
    A. Cultural Methods
    ▪ Planting resistant varieties against the rice blast is the most practical and economical way of controlling rice blast.
    ▪ Use of Tolerant varieties (CO 47, CO 50, ADT 36, ADT 37, ASD 16, ASD 20, ADT 39, ASD 19, TPS 3, White ponni, ADT 44, BPT 5204, CORH, Palghuna, Swarnamukhi, Swathi, Prabhat, IR - 64, IR - 36, Jaya)
    ▪  Avoid excess N - fertilizer application
    ▪ Apply nitrogen in three split doses.
    ▪ Remove weed hosts from bunds.
    
    B. Preventive Methodss
    ▪ Avoid dry nurseries.
    ▪ Avoid late planting.
    ▪ Burning of straw and stubbles after harvest
    ▪ Avoid grasses and other weeds on bunds and inside.
    ▪ Dry seed treatment with Pseudomonas fluorescens talc formulation @10g/kg of seed.
    ▪ Stagnate water to a depth of 2.5cm over an area of 25m2 in the nursery. Sprinkle 2.5 kg of P. fluorescens (talc) and mix with stagnated water. Soak the root system of seedlings for 30 min and transplant.
    ▪ Spray P. fluorescens (talc) formulation @ 0.5% from 45 days after transplanting at 10 day intervals, three times.
    
    C. Chemical Methods
    ▪ Do not apply lower/higher doses of fungicides.
    ▪ Spray before 11.00 AM/after 3.00 PM.
    ▪ Avoid noon hours for spraying.
    ▪ Seed treatment at 2.0 g/kg seed with Captan or Carbendazim or Thiram or Tricyclazole.
    ▪ Systemic fungicides such as pyroquilon and tricyclazole are possible chemicals for controlling the disease.
    ▪ Spraying of Tricyclazole at 1g/lit of water or Edifenphos at 1 ml/lit of water or Carbendazim at 1.0 gm/lit.
    ▪ 3 to 4 sprays each at nursery, tillering stage and panicle emergence stage may be required for complete control.
    ▪ Nursery stage: Light infection - Spray Carbendazim or Edifenphos @ 1.0 gm/lit.
    ▪ Pre-Tillering to Mid-Tillering: Light at 2 to 5 % disease severities - Apply Edifenphos or Carbendazim @ 1.0 gm/lit. Delay top dressing of N fertilizers when infection is seen.
    ▪ Panicle initiation to booting: At 2 to 5% leaf area damage- spray Edifenphos or Carbendazim or Tricyclazole @ 1.0 gm/lit.
    ▪ Flowering and after: At 5 % leaf area damage or 1 to 2 % neck infection spray Edifenphos or Carbendazim or Tricyclazole @ 1 g /lit of water.
    """.trimIndent())
            val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            s1.setSpan(StyleSpan(Typeface.BOLD), 0, s1.length, flag)
            s1.setSpan(RelativeSizeSpan(2.5f), 0, s1.length, flag)
            s1.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length, flag)
            ss1.setSpan(RelativeSizeSpan(1.7f), 0, ss1.length, flag)
            ss1.setSpan(StyleSpan(Typeface.BOLD), 0, ss1.length, flag)
            s2.setSpan(StyleSpan(Typeface.BOLD), 0, s2.length, flag)
            s2.setSpan(RelativeSizeSpan(2f), 0, s2.length, flag)
            s2.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length, flag)
            s3.setSpan(RelativeSizeSpan(1.5f), 0, s3.length, flag)
            s3.setSpan(StyleSpan(Typeface.NORMAL), 0, s3.length, flag)
            s4.setSpan(StyleSpan(Typeface.BOLD), 0, s4.length, flag)
            s4.setSpan(RelativeSizeSpan(2f), 0, s4.length, flag)
            s4.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length, flag)
            s5.setSpan(StyleSpan(Typeface.NORMAL), 0, s5.length, flag)
            s5.setSpan(RelativeSizeSpan(1.5f), 0, s5.length, flag)
            s6.setSpan(StyleSpan(Typeface.BOLD), 0, s6.length, flag)
            s6.setSpan(RelativeSizeSpan(2f), 0, s6.length, flag)
            s6.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length, flag)
            s7.setSpan(StyleSpan(Typeface.NORMAL), 0, s7.length, flag)
            s7.setSpan(RelativeSizeSpan(1.5f), 0, s7.length, flag)
            val bold = Typeface.createFromAsset(assets, "gorditabold.ttf")
            val medium = Typeface.createFromAsset(assets, "gorditamedium.ttf")
            val regular = Typeface.createFromAsset(assets, "gorditaregular.ttf")
            s1.setSpan(CustomTypefaceSpan("", bold), 0, s1.length, flag)
            ss1.setSpan(CustomTypefaceSpan("", medium), 0, ss1.length, flag)
            s2.setSpan(CustomTypefaceSpan("", bold), 0, s2.length, flag)
            s3.setSpan(CustomTypefaceSpan("", regular), 0, s3.length, flag)
            s4.setSpan(CustomTypefaceSpan("", bold), 0, s4.length, flag)
            s5.setSpan(CustomTypefaceSpan("", regular), 0, s5.length, flag)
            s6.setSpan(CustomTypefaceSpan("", bold), 0, s6.length, flag)
            val builder = SpannableStringBuilder()
            builder.append(s1)
            builder.append(ss1)
            builder.append(s2)
            builder.append(s3)
            builder.append(s4)
            builder.append(s5)
            builder.append(s6)
            builder.append(s7)
            textView!!.text = builder
            textView!!.movementMethod = ScrollingMovementMethod()
            val db = DatabaseHelper(this)
            val count = db.countInfo("Blast").toString()
            val thisWeek = db.countThisWeek("Blast").toString()
            val counterDetections = SpannableString.valueOf("$count\nTotal")
            counterDetections.setSpan(RelativeSizeSpan(3f), 0, count.length, flag)
            counterDetections.setSpan(StyleSpan(Typeface.BOLD), 0, count.length, flag)
            val counterDetectionsTW = SpannableString.valueOf("$thisWeek\nThis Week")
            counterDetectionsTW.setSpan(RelativeSizeSpan(3f), 0, thisWeek.length, 0)
            counterDetectionsTW.setSpan(StyleSpan(Typeface.BOLD), 0, thisWeek.length, 0)
            textViewDetection!!.text = counterDetections
            detectionText!!.text = counterDetectionsTW
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

    class DiseaseDefinition3 : AppCompatActivity() {
        var textView: TextView? = null
        var textViewDetection: TextView? = null
        var detectionText: TextView? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_definition)

            setSupportActionBar(findViewById(R.id.toolbar_definition))
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Sheath Blight"

            val viewPager = findViewById<ViewPager>(R.id.viewpager)
            val diseasesViewPager = DiseasesViewPager3(this)
            viewPager.adapter = diseasesViewPager
            textView = findViewById<View>(R.id.definition) as TextView
            textViewDetection = findViewById<View>(R.id.detection) as TextView
            detectionText = findViewById<View>(R.id.detectionText) as TextView
            val s1 = SpannableString("Sheath Blight\n")
            val ss1 = SpannableString("Disease\n\n")
            val s2 = SpannableString("About\n")
            val s3 = SpannableString("""
    Sheath blight is a fungal disease caused by Rhizoctonia solani. Infected leaves senesce or dry out and die more rapidly, young tillers can also be destroyed. As a result, the leaf area of the canopy can significantly be reduced by the disease. This reduction in leaf area, along with the diseased-induced senescence of leaves and young infected tillers are the primary causes of yield reduction. Sheath blight is a fungal disease caused by Rhizoctonia solani. Infected leaves senesce or dry out and die more rapidly, young tillers can also be destroyed. As a result, the leaf area of the canopy can significantly be reduced by the disease. This reduction in leaf area, along with the diseased-induced senescence of leaves and young infected tillers are the primary causes of yield reduction.
    
    """.trimIndent())
            val s4 = SpannableString("\nSymptoms\n")
            val s5 = SpannableString("Symptoms are usually observed from tillering to milk stage in a rice crop and include oval or ellipsoidal greenish " +
                    "gray lesions, usually 1-3 cm long, on the leaf sheath, initially just above the soil or water level in the case of conventionally flooded rice. Under favorable " +
                    "conditions, these initial lesions multiply and expand to the upper part of the sheaths, the leaves, and then spread to neighboring tillers belonging to different " +
                    "hills (transplanted rice) or plants (direct-seeded rice). Lesions on the leaves usually have irregular lesions, often with gray-white centers and brown margins " +
                    "as they grow older. In subtropical environments, the disease is mostly initiated by sclerotia (up to two million of which can be produced per square meter " +
                    "in a diseased crop). In tropical ecosystems, however, the role of sclerotia in initiating the disease is uncertain. In any case, the pathogen does not produce aerially " +
                    "dispersed spores; its dispersal is essentially dependent on hyphae running on plant tissues and producing new infections Sheath blight has symptoms similar to stem rot " +
                    "and stemborer infestation. To confirm the cause of disease, check for irregular lesions usually found on the leaf sheaths (initially water-soaked to greenish gray and " +
                    "later becomes grayish white with brown margin). Also check for presence of sclerotia.")
            val s6 = SpannableString("\n\nManagement Strategies\n")
            val s7 = SpannableString("""
    A. Preventive Methods
    ▪ Seed treatment with Pseudomonas fluorescens @ of 10g/kg of seed followed by seedling dip @ of 2.5 kg or products/ha dissolved in 100 litres and dipping for 30 minutes.
    ▪ Soil application of P.fluorescens @ of 2.5 kg/ha after 30 days of transplanting (This product should be mixed with 50 kg of FYM/Sand and then applied.
    ▪ Foliar spray of Pseudomonas fluorescens at 0.2% concentration, commencing from 45 days after transplanting at 10 days interval for 3 times depending upon the intensity of disease.
    
    B. Cultural Methods
    ▪ Apply FYM 12.5 t/ha or green manure 6.25 t/ha to promote antagonistic microflora
    ▪ Avoid excess doses of fertilizers.
    ▪ Adopt optimum spacing.
    ▪ Eliminate weed hosts.
    ▪ Apply organic amendments.
    ▪ Avoid flow of irrigation water from infected fields to healthy fields.
    ▪ Deep ploughing in summer and burning of stubbles.
    
    C. Chemical Methods
    ▪ Control of sheath blight has been mainly through the use of foliar fungicides.
    ▪ Carbendazim (1 g/lit), Propiconazole (1ml/lit) may be applied.
    ▪ Spraying of infected plants with fungicides, such as Benomyl and Iprodione, and antibiotics, such as Validamycin and Polyoxin, is effective against the disease
    ▪ Spray Carbendazim 250 g or Chlorothalonil 1 kg or Edifenphos 1 lit/ha.
    """.trimIndent())
            val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            s1.setSpan(StyleSpan(Typeface.BOLD), 0, s1.length, flag)
            s1.setSpan(RelativeSizeSpan(2.5f), 0, s1.length, flag)
            s1.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length, flag)
            ss1.setSpan(RelativeSizeSpan(1.7f), 0, ss1.length, flag)
            ss1.setSpan(StyleSpan(Typeface.BOLD), 0, ss1.length, flag)
            s2.setSpan(StyleSpan(Typeface.BOLD), 0, s2.length, flag)
            s2.setSpan(RelativeSizeSpan(2f), 0, s2.length, flag)
            s2.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length, flag)
            s3.setSpan(RelativeSizeSpan(1.5f), 0, s3.length, flag)
            s3.setSpan(StyleSpan(Typeface.NORMAL), 0, s3.length, flag)
            s4.setSpan(StyleSpan(Typeface.BOLD), 0, s4.length, flag)
            s4.setSpan(RelativeSizeSpan(2f), 0, s4.length, flag)
            s4.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length, flag)
            s5.setSpan(StyleSpan(Typeface.NORMAL), 0, s5.length, flag)
            s5.setSpan(RelativeSizeSpan(1.5f), 0, s5.length, flag)
            s6.setSpan(StyleSpan(Typeface.BOLD), 0, s6.length, flag)
            s6.setSpan(RelativeSizeSpan(2f), 0, s6.length, flag)
            s6.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length, flag)
            s7.setSpan(StyleSpan(Typeface.NORMAL), 0, s7.length, flag)
            s7.setSpan(RelativeSizeSpan(1.5f), 0, s7.length, flag)
            val bold = Typeface.createFromAsset(assets, "gorditabold.ttf")
            val medium = Typeface.createFromAsset(assets, "gorditamedium.ttf")
            val regular = Typeface.createFromAsset(assets, "gorditaregular.ttf")
            s1.setSpan(CustomTypefaceSpan("", bold), 0, s1.length, flag)
            ss1.setSpan(CustomTypefaceSpan("", medium), 0, ss1.length, flag)
            s2.setSpan(CustomTypefaceSpan("", bold), 0, s2.length, flag)
            s3.setSpan(CustomTypefaceSpan("", regular), 0, s3.length, flag)
            s4.setSpan(CustomTypefaceSpan("", bold), 0, s4.length, flag)
            s5.setSpan(CustomTypefaceSpan("", regular), 0, s5.length, flag)
            s6.setSpan(CustomTypefaceSpan("", bold), 0, s6.length, flag)
            val builder = SpannableStringBuilder()
            builder.append(s1)
            builder.append(ss1)
            builder.append(s2)
            builder.append(s3)
            builder.append(s4)
            builder.append(s5)
            builder.append(s6)
            builder.append(s7)
            textView!!.text = builder
            textView!!.movementMethod = ScrollingMovementMethod()
            val db = DatabaseHelper(this)
            val count = db.countInfo("Sheath Blight").toString()
            val thisWeek = db.countThisWeek("Sheath Blight").toString()
            val counterDetections = SpannableString.valueOf("$count\nTotal")
            counterDetections.setSpan(RelativeSizeSpan(3f), 0, count.length, flag)
            counterDetections.setSpan(StyleSpan(Typeface.BOLD), 0, count.length, flag)
            val counterDetectionsTW = SpannableString.valueOf("$thisWeek\nThis Week")
            counterDetectionsTW.setSpan(RelativeSizeSpan(3f), 0, thisWeek.length, 0)
            counterDetectionsTW.setSpan(StyleSpan(Typeface.BOLD), 0, thisWeek.length, 0)
            textViewDetection!!.text = counterDetections
            detectionText!!.text = counterDetectionsTW
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

    class DiseaseDefinition4 : AppCompatActivity() {
        var textView: TextView? = null
        var textViewDetection: TextView? = null
        var detectionText: TextView? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_definition)

            setSupportActionBar(findViewById(R.id.toolbar_definition))
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Tungro"

            val viewPager = findViewById<ViewPager>(R.id.viewpager)
            val diseasesViewPager = DiseasesViewPager4(this)
            viewPager.adapter = diseasesViewPager
            textView = findViewById<View>(R.id.definition) as TextView
            textViewDetection = findViewById<View>(R.id.detection) as TextView
            detectionText = findViewById<View>(R.id.detectionText) as TextView
            val s1 = SpannableString("Tungro\n")
            val ss1 = SpannableString("Disease\n\n")
            val s2 = SpannableString("About\n")
            val s3 = SpannableString("""
    Rice tungro disease is caused by the combination of two viruses, which are transmitted by leafhoppers. It causes leaf discoloration, stunted growth, reduced tiller numbers and sterile or partly filled grains. Tungro infects cultivated rice, some wild rice relatives and other grassy weeds commonly found in rice paddies. Tungro disease viruses are transmitted from one plant to another by leafhoppers that feed on tungro-infected plants. The most efficient vector is the green leafhopper. Leafhoppers can acquire the viruses from any part of the infected plant by feeding on it, even for a short time. It can, then, immediately transmit the viruses to other plants within 5−7 days. The viruses do not remain in the leafhopper's body unless it feeds again on an infected plant and re-acquires the viruses. Tungro infection can occur during all growth stages of the rice plant. It is most frequently seen during the vegetative phase. Plants are most vulnerable at tillering stage. Tungro incidence depends on the availability of the virus sources and vector population. Other than infected rice plants in the farmer's field, other primary sources for tungro, include stubble of previous crops, new growth from infected stubbles that had not been properly plowed under and harrowed effectively, volunteer rice, and infected plants in nearby rice fields. Seedlings raised in nurseries or seedbeds can also be infected with Tungro prior to transplanting and can be a primary source of virus. Transplanting seedlings from nurseries in tungro-infected areas has also shown to increase infection rates in the field, particularly, in cases where seedbed is in a tungro-endemic area or when the nursery duration is 5−6 weeks. However, this is not believed to be a very strong mechanism in initiating epidemics, because the competitiveness of tungro-infected seedlings is low; they can die rapidly after transplanting.
    
    """.trimIndent())
            val s4 = SpannableString("\nSymptoms\n")
            val s5 = SpannableString("First, check for presence of leafhoppers. Leafhoppers are the known carriers of the tungro virus. " +
                    "Second is to check leaves for discoloration. Yellow or orange-yellow discoloration is noticeable in tungro-infected plants. Discoloration " +
                    "begins from the leaf tip and extends down to the blade or the lower leaf portion. Infected leaves may also show mottled or striped appearance, " +
                    "rust-colored spots, and interveinal necrosis. Tungro-infected plants also show symptoms of stunting, delayed flowering which may delay maturity, " +
                    "reduced number of tillers, small and not completely exserted panicles, as well as a higher than normal percentage of sterile panicles or partially " +
                    "filled grains, covered with dark brown blotches. The degree of stunting and of leaf discoloration varies with rice varieties, strains of the viruses, " +
                    "the age of the plant when infected, and with the environment. In varieties that carry some resistance to the disease, infected plants exhibit " +
                    "no discoloration or only a mild discoloration that may disappear as the plants mature. Tungro symptoms can be mistaken for physiological disorders. " +
                    "Specifically, the yellowing of the plant and its stunted height can be confused as nitrogen and zinc deficiencies and water stress, pest infestation " +
                    "such as stem borer infestation, plant hopper infestation, and rat damage, and other diseases such as grassy stunt virus disease and orange leaf. " +
                    "Where available, Tungro can be confirmed using serological tools such as Latex agglutination test, Enzyme Linked Immunosorbent Assays (ELISA) and " +
                    "Rapid Immunofilter Paper Assays (RIPA).")
            val s6 = SpannableString("\n\nManagement Strategies\n")
            val s7 = SpannableString("""
    A. Trap methods
    ▪ Light traps are to be set up to attract and control the leaf hopper vectors as well as to monitor the population.
    ▪ In the early morning, the population of leafhopper alighting near the light trap should be killed by spraying/dusting the insecticides.
    ▪ This should be practiced every day.
    
    B. Cultural Methods
    ▪ Planting of resistant varieties against tungro virus disease is the most economical means of managing the disease.
    ▪ Use resistant varieties like IR 36, IR 50, ADT 37, Ponmani,Co 45, Co 48, Surekha, Vikramarya, Bharani, IR 36   andwhite ponni .
    ▪ Among the cultural management practices, adjusting the date of planting is recommended.
    ▪  Likewise, observing a fallow period of at least a month to eliminate hosts and viruses and vectors of the disease.
    ▪  In epidemic areas follow rotation with pulses or oil seeds.
    ▪ Apply neem cake @ 12.5 kg/20 cent nursery as basal dose.
    ▪ Ploughing and harrowing the field to destroy stubbles right after harvest in order to eradicate other tungro hosts are also advisable.
    ▪ Destruction of weed hosts on bunds.
    
    C. Chemical Methods
    ▪  Leaf yellowing can be minimized by spraying 2 % urea mixed with Mancozeb at 2.5 gm/lit.
    ▪ Instead of urea foliar fertilizer like multi-K (potassium nitrate) can be sprayed at 1 per cent which impart resistance also because of high potassium content.
    ▪ Green leaf hoppers as vectors are to be controlled effectively in time by spraying.
    ▪ Spray insecticides twice, 15 and 30 days after transplanting
    
    D. Spray Two rounds of any one of the following insecticides
    ▪ Monocrotophos 36 WSC (40 ml/ha)
    ▪ Fenthion 100 EC (40 ml/ha) may be sprayed 15 and 30 days after transplanting.
    ▪  The vegetation on the bunds should also be sprayed with the insecticides. Maintain 2.5 cm of water in the nursery and broadcast anyone of the following in 20 cents Carbofuran 3 G 3.5 kg (or) Phorate 10 G 1.0 kg (or) Quinalphos 5 G 2.0 kg
    ▪ In nursery when virus infection is low, apply Carbofuran granules @ 1 kg/ha to control vector population.
    ▪ During pre-tillering to mid-tillering when one affected hill/m is observed apply Carbofuran granules @ 3.5kg/ha or spray Monocrotophos @ 1.6 to 2.2ml/lit to control insect vector.
    """.trimIndent())
            val flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            s1.setSpan(StyleSpan(Typeface.BOLD), 0, s1.length, flag)
            s1.setSpan(RelativeSizeSpan(2.5f), 0, s1.length, flag)
            s1.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length, flag)
            ss1.setSpan(RelativeSizeSpan(1.7f), 0, ss1.length, flag)
            ss1.setSpan(StyleSpan(Typeface.BOLD), 0, ss1.length, flag)
            s2.setSpan(StyleSpan(Typeface.BOLD), 0, s2.length, flag)
            s2.setSpan(RelativeSizeSpan(2f), 0, s2.length, flag)
            s2.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length, flag)
            s3.setSpan(RelativeSizeSpan(1.5f), 0, s3.length, flag)
            s3.setSpan(StyleSpan(Typeface.NORMAL), 0, s3.length, flag)
            s4.setSpan(StyleSpan(Typeface.BOLD), 0, s4.length, flag)
            s4.setSpan(RelativeSizeSpan(2f), 0, s4.length, flag)
            s4.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length, flag)
            s5.setSpan(StyleSpan(Typeface.NORMAL), 0, s5.length, flag)
            s5.setSpan(RelativeSizeSpan(1.5f), 0, s5.length, flag)
            s6.setSpan(StyleSpan(Typeface.BOLD), 0, s6.length, flag)
            s6.setSpan(RelativeSizeSpan(2f), 0, s6.length, flag)
            s6.setSpan(ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length, flag)
            s7.setSpan(StyleSpan(Typeface.NORMAL), 0, s7.length, flag)
            s7.setSpan(RelativeSizeSpan(1.5f), 0, s7.length, flag)
            val bold = Typeface.createFromAsset(assets, "gorditabold.ttf")
            val medium = Typeface.createFromAsset(assets, "gorditamedium.ttf")
            val regular = Typeface.createFromAsset(assets, "gorditaregular.ttf")
            s1.setSpan(CustomTypefaceSpan("", bold), 0, s1.length, flag)
            ss1.setSpan(CustomTypefaceSpan("", medium), 0, ss1.length, flag)
            s2.setSpan(CustomTypefaceSpan("", bold), 0, s2.length, flag)
            s3.setSpan(CustomTypefaceSpan("", regular), 0, s3.length, flag)
            s4.setSpan(CustomTypefaceSpan("", bold), 0, s4.length, flag)
            s5.setSpan(CustomTypefaceSpan("", regular), 0, s5.length, flag)
            s6.setSpan(CustomTypefaceSpan("", bold), 0, s6.length, flag)
            val builder = SpannableStringBuilder()
            builder.append(s1)
            builder.append(ss1)
            builder.append(s2)
            builder.append(s3)
            builder.append(s4)
            builder.append(s5)
            builder.append(s6)
            builder.append(s7)
            textView!!.text = builder
            textView!!.movementMethod = ScrollingMovementMethod()
            val db = DatabaseHelper(this)
            val count = db.countInfo("Tungro").toString()
            val thisWeek = db.countThisWeek("Tungro").toString()
            val counterDetections = SpannableString.valueOf("$count\nTotal")
            counterDetections.setSpan(RelativeSizeSpan(3f), 0, count.length, flag)
            counterDetections.setSpan(StyleSpan(Typeface.BOLD), 0, count.length, flag)
            val counterDetectionsTW = SpannableString.valueOf("$thisWeek\nThis Week")
            counterDetectionsTW.setSpan(RelativeSizeSpan(3f), 0, thisWeek.length, 0)
            counterDetectionsTW.setSpan(StyleSpan(Typeface.BOLD), 0, thisWeek.length, 0)
            textViewDetection!!.text = counterDetections
            detectionText!!.text = counterDetectionsTW
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
}