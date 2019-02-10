package io.github.projectbukirin.smartrice;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.projectbukirin.smartrice.R;

public class DiseasesDefinition extends AppCompatActivity {
    TextView textView, textViewDetection, detectionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        ViewPager viewPager = findViewById(R.id.viewpager);
        DiseasesViewPager diseasesViewPager = new DiseasesViewPager(this);
        viewPager.setAdapter(diseasesViewPager);

        textView = (TextView) findViewById(R.id.definition);

        textViewDetection = (TextView) findViewById(R.id.detection);
        detectionText = (TextView) findViewById(R.id.detectionText);
        SpannableString s1 = new SpannableString("Bacterial Blight\n");
        SpannableString ss1 = new SpannableString("Disease\n\n");
        SpannableString s2 = new SpannableString("Statistics\n");
        SpannableString s3 = new SpannableString("Bacterial blight is caused by Xanthomonas oryzae pv. oryzae.  It causes wilting of seedlings and " +
                "yellowing and drying of leaves. The disease is most likely to develop in areas that have weeds and stubbles of infected plants. It can occur " +
                "in both tropical and temperate environments, particularly in irrigated and rainfed lowland areas. In general, the disease favors temperatures " +
                "at 25−34°C, with relative humidity above 70%. It is commonly observed when strong winds and continuous heavy rains occur, allowing the " +
                "disease-causing bacteria to easily spread through ooze droplets on lesions of infected plants. Bacterial blight can be severe in susceptible " +
                "rice varieties under high nitrogen fertilization.\n");
        SpannableString s4 = new SpannableString("\nSymptoms\n");
        SpannableString s5 = new SpannableString("Check for wilting and yellowing of leaves, or wilting of seedlings (also called kresek). " +
                "On seedlings, infected leaves turn grayish green and roll up. As the disease progresses, the leaves turn yellow to straw-colored and wilt, " +
                "leading whole seedlings to dry up and die. Kresek on seedlings may sometimes be confused with early rice stem borer damage.  To distinguish " +
                "kresek symptoms from stem borer damage, squeeze the lower end of infected seedlings between the fingers. Kresek symptoms should show yellowish " +
                "bacterial ooze coming out of the cut ends. Unlike plants infested with stem borer, rice plants with kresek are not easily pulled out from soil.");
        SpannableString s6 = new SpannableString("\n\nTreatment\n");
        SpannableString s7 = new SpannableString("Treatment");

        int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
        s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
        s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
        s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
        ss1.setSpan(new RelativeSizeSpan(1), 0, ss1.length(), flag);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), flag);
        s2.setSpan(new StyleSpan(Typeface.BOLD), 0, s2.length(), flag);
        s2.setSpan(new RelativeSizeSpan(2f), 0, s2.length(), flag);
        s2.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length(), flag);
        s3.setSpan(new RelativeSizeSpan(1.5f), 0, s3.length(), flag);
        s3.setSpan(new StyleSpan(Typeface.NORMAL), 0, s3.length(), flag);
        s4.setSpan(new StyleSpan(Typeface.BOLD), 0, s4.length(), flag);
        s4.setSpan(new RelativeSizeSpan(2), 0, s4.length(), flag);
        s4.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length(), flag);
        s5.setSpan(new StyleSpan(Typeface.NORMAL), 0, s5.length(), flag);
        s5.setSpan(new RelativeSizeSpan(1.5f), 0, s5.length(), flag);
        s6.setSpan(new StyleSpan(Typeface.BOLD), 0, s6.length(), flag);
        s6.setSpan(new RelativeSizeSpan(2), 0, s6.length(), flag);
        s6.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length(), flag);
        s7.setSpan(new StyleSpan(Typeface.NORMAL), 0, s7.length(), flag);
        s7.setSpan(new RelativeSizeSpan(1.5f), 0, s7.length(), flag);

        s1.setSpan(new TypefaceSpan("circularblack"), 0, s1.length(), flag);
        ss1.setSpan(new TypefaceSpan("circularmedium"), 0, ss1.length(), flag);
        s2.setSpan(new TypefaceSpan("circularblack"), 0, s2.length(), flag);
        s3.setSpan(new TypefaceSpan("circularbook"), 0, s3.length(), flag);
        s4.setSpan(new TypefaceSpan("circularblack"), 0, s4.length(), flag);
        s5.setSpan(new TypefaceSpan("circularblack"), 0, s5.length(), flag);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(s1);
        builder.append(ss1);
        builder.append(s2);
        builder.append(s3);
        builder.append(s4);
        builder.append(s5);
        builder.append(s6);
        builder.append(s7);
        textView.setText(builder);
        textView.setMovementMethod(new ScrollingMovementMethod());

        ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });

        DatabaseHelper db = new DatabaseHelper(this);

        String count = String.valueOf(db.countInfo("Bacterial Leaf Blight"));

        String thisWeek = String.valueOf(db.countThisWeek("Bacterial Leaf Blight"));

        textViewDetection.setText(count + " Detections");
        detectionText.setText(thisWeek + " This Week");

    }
    public void backActivity(){
        finish();

    }
    @Override
    public void onBackPressed(){
        finish();
    }


    public static class DiseaseDefinition2 extends AppCompatActivity {
        TextView textView, textViewDetection, detectionText;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_definition);

            ViewPager viewPager = findViewById(R.id.viewpager);
            DiseasesViewPager.DiseasesViewPager2 diseasesViewPager = new DiseasesViewPager.DiseasesViewPager2(this);
            viewPager.setAdapter(diseasesViewPager);

            textView = (TextView) findViewById(R.id.definition);
            textViewDetection = (TextView) findViewById(R.id.detection);
            detectionText = (TextView) findViewById(R.id.detectionText);
            SpannableString s1 = new SpannableString("Rice Blast\n");
            SpannableString ss1 = new SpannableString("Disease\n\n");
            SpannableString s2 = new SpannableString("Statistics\n");
            SpannableString s3 = new SpannableString("Blast is caused by the fungus Magnaporthe oryzae. It can affect all above ground parts of a rice plant: " +
                    "leaf, collar, node, neck, parts of panicle, and sometimes leaf sheath. Blast can occur wherever blast spores are present. It occurs in areas with " +
                    "low soil moisture, frequent and prolonged periods of rain shower, and cool temperature in the daytime. In upland rice, large day-night temperature " +
                    "differences that cause dew formation on leaves and overall cooler temperatures favor the development of the disease. Rice can have blast in all growth " +
                    "stages. However, leaf blast incidence tends to lessen as plants mature and develop adult plant resistance to the disease.\n");
            SpannableString s4 = new SpannableString("\nSymptoms\n");
            SpannableString s5 = new SpannableString("Check the leaf and collar for lesions that include: initial symptoms appear as white to gray-green " +
                    "lesions or spots, with dark green borders; older lesions on the leaves are elliptical or spindle-shaped and whitish to gray centers with red to " +
                    "brownish or necrotic border. Check for other symptoms that include some resemble diamond shape, wide in the center and pointed toward either and " +
                    "lesions can enlarge and coalesce, growing together, to kill the entire leaves.");
            SpannableString s6 = new SpannableString("\n\nTreatment\n");
            SpannableString s7 = new SpannableString("Treatment");

            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
            s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
            s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
            ss1.setSpan(new RelativeSizeSpan(1), 0, ss1.length(), flag);
            ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), flag);
            s2.setSpan(new StyleSpan(Typeface.BOLD), 0, s2.length(), flag);
            s2.setSpan(new RelativeSizeSpan(2f), 0, s2.length(), flag);
            s2.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length(), flag);
            s3.setSpan(new RelativeSizeSpan(1.5f), 0, s3.length(), flag);
            s3.setSpan(new StyleSpan(Typeface.NORMAL), 0, s3.length(), flag);
            s4.setSpan(new StyleSpan(Typeface.BOLD), 0, s4.length(), flag);
            s4.setSpan(new RelativeSizeSpan(2), 0, s4.length(), flag);
            s4.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length(), flag);
            s5.setSpan(new StyleSpan(Typeface.NORMAL), 0, s5.length(), flag);
            s5.setSpan(new RelativeSizeSpan(1.5f), 0, s5.length(), flag);
            s6.setSpan(new StyleSpan(Typeface.BOLD), 0, s6.length(), flag);
            s6.setSpan(new RelativeSizeSpan(2), 0, s6.length(), flag);
            s6.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length(), flag);
            s7.setSpan(new StyleSpan(Typeface.NORMAL), 0, s7.length(), flag);
            s7.setSpan(new RelativeSizeSpan(1.5f), 0, s7.length(), flag);

            s1.setSpan(new TypefaceSpan("circularblack"), 0, s1.length(), flag);
            ss1.setSpan(new TypefaceSpan("circularmedium"), 0, ss1.length(), flag);
            s2.setSpan(new TypefaceSpan("circularblack"), 0, s2.length(), flag);
            s3.setSpan(new TypefaceSpan("circularbook"), 0, s3.length(), flag);
            s4.setSpan(new TypefaceSpan("circularblack"), 0, s4.length(), flag);
            s5.setSpan(new TypefaceSpan("circularblack"), 0, s5.length(), flag);

            SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append(s1);
            builder.append(ss1);
            builder.append(s2);
            builder.append(s3);
            builder.append(s4);
            builder.append(s5);
            builder.append(s6);
            builder.append(s7);
            textView.setText(builder);
            textView.setMovementMethod(new ScrollingMovementMethod());

            ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
            androidImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    backActivity();
                }
            });

            DatabaseHelper db = new DatabaseHelper(this);

            String count = String.valueOf(db.countInfo("Blast"));
            String thisWeek = String.valueOf(db.countThisWeek("Blast"));

            textViewDetection.setText(count + " Detections");
            detectionText.setText(thisWeek + " This Week");

        }
        public void backActivity(){
            finish();

        }
        @Override
        public void onBackPressed(){
            finish();
        }

    }

    public static class DiseaseDefinition3 extends AppCompatActivity {
        TextView textView, textViewDetection, detectionText;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_definition);

            ViewPager viewPager = findViewById(R.id.viewpager);
            DiseasesViewPager.DiseasesViewPager3 diseasesViewPager = new DiseasesViewPager.DiseasesViewPager3(this);
            viewPager.setAdapter(diseasesViewPager);

            textView = (TextView) findViewById(R.id.definition);
            textViewDetection = (TextView) findViewById(R.id.detection);
            detectionText = (TextView) findViewById(R.id.detectionText);
            SpannableString s1 = new SpannableString("Sheath Blight\n");
            SpannableString ss1 = new SpannableString("Disease\n\n");
            SpannableString s2 = new SpannableString("Statistics\n");
            SpannableString s3 = new SpannableString("Sheath blight is a fungal disease caused by Rhizoctonia solani. Infected leaves senesce or dry out and die " +
                    "more rapidly, young tillers can also be destroyed. As a result, the leaf area of the canopy can significantly be reduced by the disease. " +
                    "This reduction in leaf area, along with the diseased-induced senescence of leaves and young infected tillers are the primary causes of yield reduction. " +
                    "Sheath blight is a fungal disease caused by Rhizoctonia solani. Infected leaves senesce or dry out and die more rapidly, young tillers can also be destroyed. " +
                    "As a result, the leaf area of the canopy can significantly be reduced by the disease. This reduction in leaf area, along with the diseased-induced senescence " +
                    "of leaves and young infected tillers are the primary causes of yield reduction.\n");
            SpannableString s4 = new SpannableString("\nSymptoms\n");
            SpannableString s5 = new SpannableString("Symptoms are usually observed from tillering to milk stage in a rice crop and include oval or ellipsoidal greenish " +
                    "gray lesions, usually 1-3 cm long, on the leaf sheath, initially just above the soil or water level in the case of conventionally flooded rice. Under favorable " +
                    "conditions, these initial lesions multiply and expand to the upper part of the sheaths, the leaves, and then spread to neighboring tillers belonging to different " +
                    "hills (transplanted rice) or plants (direct-seeded rice). Lesions on the leaves usually have irregular lesions, often with gray-white centers and brown margins " +
                    "as they grow older. In subtropical environments, the disease is mostly initiated by sclerotia (up to two million of which can be produced per square meter " +
                    "in a diseased crop). In tropical ecosystems, however, the role of sclerotia in initiating the disease is uncertain. In any case, the pathogen does not produce aerially " +
                    "dispersed spores; its dispersal is essentially dependent on hyphae running on plant tissues and producing new infections Sheath blight has symptoms similar to stem rot " +
                    "and stemborer infestation. To confirm the cause of disease, check for irregular lesions usually found on the leaf sheaths (initially water-soaked to greenish gray and " +
                    "later becomes grayish white with brown margin). Also check for presence of sclerotia.");
            SpannableString s6 = new SpannableString("\n\nTreatment\n");
            SpannableString s7 = new SpannableString("Treatment");

            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
            s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
            s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
            ss1.setSpan(new RelativeSizeSpan(1), 0, ss1.length(), flag);
            ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), flag);
            s2.setSpan(new StyleSpan(Typeface.BOLD), 0, s2.length(), flag);
            s2.setSpan(new RelativeSizeSpan(2f), 0, s2.length(), flag);
            s2.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length(), flag);
            s3.setSpan(new RelativeSizeSpan(1.5f), 0, s3.length(), flag);
            s3.setSpan(new StyleSpan(Typeface.NORMAL), 0, s3.length(), flag);
            s4.setSpan(new StyleSpan(Typeface.BOLD), 0, s4.length(), flag);
            s4.setSpan(new RelativeSizeSpan(2), 0, s4.length(), flag);
            s4.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length(), flag);
            s5.setSpan(new StyleSpan(Typeface.NORMAL), 0, s5.length(), flag);
            s5.setSpan(new RelativeSizeSpan(1.5f), 0, s5.length(), flag);
            s6.setSpan(new StyleSpan(Typeface.BOLD), 0, s6.length(), flag);
            s6.setSpan(new RelativeSizeSpan(2), 0, s6.length(), flag);
            s6.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length(), flag);
            s7.setSpan(new StyleSpan(Typeface.NORMAL), 0, s7.length(), flag);
            s7.setSpan(new RelativeSizeSpan(1.5f), 0, s7.length(), flag);

            s1.setSpan(new TypefaceSpan("circularblack"), 0, s1.length(), flag);
            ss1.setSpan(new TypefaceSpan("circularmedium"), 0, ss1.length(), flag);
            s2.setSpan(new TypefaceSpan("circularblack"), 0, s2.length(), flag);
            s3.setSpan(new TypefaceSpan("circularbook"), 0, s3.length(), flag);
            s4.setSpan(new TypefaceSpan("circularblack"), 0, s4.length(), flag);
            s5.setSpan(new TypefaceSpan("circularblack"), 0, s5.length(), flag);

            SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append(s1);
            builder.append(ss1);
            builder.append(s2);
            builder.append(s3);
            builder.append(s4);
            builder.append(s5);
            builder.append(s6);
            builder.append(s7);
            textView.setText(builder);
            textView.setMovementMethod(new ScrollingMovementMethod());

            ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
            androidImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    backActivity();
                }
            });

            DatabaseHelper db = new DatabaseHelper(this);

            String count = String.valueOf(db.countInfo("Sheath Blight"));
            String thisWeek = String.valueOf(db.countThisWeek("Sheath Blight"));

            textViewDetection.setText(count + " Detections");
            detectionText.setText(thisWeek + " This Week");

        }
        public void backActivity(){
            finish();

        }
        @Override
        public void onBackPressed(){
            finish();
        }

    }

    public static class DiseaseDefinition4 extends AppCompatActivity {
        TextView textView, textViewDetection, detectionText;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_definition);

            ViewPager viewPager = findViewById(R.id.viewpager);
            DiseasesViewPager.DiseasesViewPager4 diseasesViewPager = new DiseasesViewPager.DiseasesViewPager4(this);
            viewPager.setAdapter(diseasesViewPager);

            textView = (TextView) findViewById(R.id.definition);
            textViewDetection = (TextView) findViewById(R.id.detection);
            detectionText = (TextView) findViewById(R.id.detectionText);
            SpannableString s1 = new SpannableString("Tungro\n");
            SpannableString ss1 = new SpannableString("Disease\n\n");
            SpannableString s2 = new SpannableString("Statistics\n");
            SpannableString s3 = new SpannableString("Rice tungro disease is caused by the combination of two viruses, which are transmitted by leafhoppers. " +
                    "It causes leaf discoloration, stunted growth, reduced tiller numbers and sterile or partly filled grains. Tungro infects cultivated rice, " +
                    "some wild rice relatives and other grassy weeds commonly found in rice paddies. Tungro disease viruses are transmitted from one plant to " +
                    "another by leafhoppers that feed on tungro-infected plants. The most efficient vector is the green leafhopper. Leafhoppers can acquire " +
                    "the viruses from any part of the infected plant by feeding on it, even for a short time. It can, then, immediately transmit the viruses to " +
                    "other plants within 5−7 days. The viruses do not remain in the leafhopper's body unless it feeds again on an infected plant and re-acquires " +
                    "the viruses. Tungro infection can occur during all growth stages of the rice plant. It is most frequently seen during the vegetative phase. " +
                    "Plants are most vulnerable at tillering stage. Tungro incidence depends on the availability of the virus sources and vector population. " +
                    "Other than infected rice plants in the farmer's field, other primary sources for tungro, include stubble of previous crops, new growth " +
                    "from infected stubbles that had not been properly plowed under and harrowed effectively, volunteer rice, and infected plants in nearby rice fields. " +
                    "Seedlings raised in nurseries or seedbeds can also be infected with Tungro prior to transplanting and can be a primary source of virus. " +
                    "Transplanting seedlings from nurseries in tungro-infected areas has also shown to increase infection rates in the field, particularly, " +
                    "in cases where seedbed is in a tungro-endemic area or when the nursery duration is 5−6 weeks. However, this is not believed to be a very strong " +
                    "mechanism in initiating epidemics, because the competitiveness of tungro-infected seedlings is low; they can die rapidly after transplanting.\n");
            SpannableString s4 = new SpannableString("\nSymptoms\n");
            SpannableString s5 = new SpannableString("First, check for presence of leafhoppers. Leafhoppers are the known carriers of the tungro virus. " +
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
                    "Rapid Immunofilter Paper Assays (RIPA).");
            SpannableString s6 = new SpannableString("\n\nTreatment\n");
            SpannableString s7 = new SpannableString("Treatment");

            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
            s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
            s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
            ss1.setSpan(new RelativeSizeSpan(1), 0, ss1.length(), flag);
            ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, ss1.length(), flag);
            s2.setSpan(new StyleSpan(Typeface.BOLD), 0, s2.length(), flag);
            s2.setSpan(new RelativeSizeSpan(2f), 0, s2.length(), flag);
            s2.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s2.length(), flag);
            s3.setSpan(new RelativeSizeSpan(1.5f), 0, s3.length(), flag);
            s3.setSpan(new StyleSpan(Typeface.NORMAL), 0, s3.length(), flag);
            s4.setSpan(new StyleSpan(Typeface.BOLD), 0, s4.length(), flag);
            s4.setSpan(new RelativeSizeSpan(2), 0, s4.length(), flag);
            s4.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s4.length(), flag);
            s5.setSpan(new StyleSpan(Typeface.NORMAL), 0, s5.length(), flag);
            s5.setSpan(new RelativeSizeSpan(1.5f), 0, s5.length(), flag);
            s6.setSpan(new StyleSpan(Typeface.BOLD), 0, s6.length(), flag);
            s6.setSpan(new RelativeSizeSpan(2), 0, s6.length(), flag);
            s6.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s6.length(), flag);
            s7.setSpan(new StyleSpan(Typeface.NORMAL), 0, s7.length(), flag);
            s7.setSpan(new RelativeSizeSpan(1.5f), 0, s7.length(), flag);

            s1.setSpan(new TypefaceSpan("circularblack"), 0, s1.length(), flag);
            ss1.setSpan(new TypefaceSpan("circularmedium"), 0, ss1.length(), flag);
            s2.setSpan(new TypefaceSpan("circularblack"), 0, s2.length(), flag);
            s3.setSpan(new TypefaceSpan("circularbook"), 0, s3.length(), flag);
            s4.setSpan(new TypefaceSpan("circularblack"), 0, s4.length(), flag);
            s5.setSpan(new TypefaceSpan("circularblack"), 0, s5.length(), flag);

            SpannableStringBuilder builder = new SpannableStringBuilder();
            builder.append(s1);
            builder.append(ss1);
            builder.append(s2);
            builder.append(s3);
            builder.append(s4);
            builder.append(s5);
            builder.append(s6);
            builder.append(s7);
            textView.setText(builder);
            textView.setMovementMethod(new ScrollingMovementMethod());

            ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
            androidImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    backActivity();
                }
            });

            DatabaseHelper db = new DatabaseHelper(this);

            String count = String.valueOf(db.countInfo("Tungro"));
            String thisWeek = String.valueOf(db.countThisWeek("Tungro"));

            textViewDetection.setText(count + " Detections");
            detectionText.setText(thisWeek + " This Week");

        }
        public void backActivity(){
            finish();

        }
        @Override
        public void onBackPressed(){
            finish();
        }

    }
}
