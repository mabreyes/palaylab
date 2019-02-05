package com.example.rickydanobantonare.smartrice;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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

public class PestsDefinition extends AppCompatActivity {
    TextView textView, textViewDetection, detectionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);

        ViewPager viewPager = findViewById(R.id.viewpager);
        PestsViewPager pestsViewPager = new PestsViewPager(this);
        viewPager.setAdapter(pestsViewPager);

        textView = (TextView) findViewById(R.id.definition);
        textViewDetection = (TextView) findViewById(R.id.detection);
        detectionText = (TextView) findViewById(R.id.detectionText);

        SpannableString s1 = new SpannableString("Armyworm\n");
        SpannableString ss1 = new SpannableString("Infestation\n\n");
        SpannableString s2 = new SpannableString("Statistics\n");
        SpannableString s3 = new SpannableString("Armyworms are caterpillars that attack rice. A single armyworm egg mass " +
                "contains hundreds of eggs. Each female lays 800−1000 eggs during its lifetime of about one week. Armyworm " +
                "feeds on rice by cutting off leaves and young seedlings at the plant's base. They can also cut off rice panicles " +
                "from base. Adult armyworms survive better and produce more eggs when the temperature is at 15°C maximum, " +
                "and when plants are naturally fertilized. Periods of drought followed by heavy rains, and the presence of " +
                "alternate hosts also sustain the development of armyworms. Armyworms are nocturnal. The larvae usually feed " +
                "in the upper portion of the rice canopy on cloudy days or at night; while the adult feeds, mates, and migrates " +
                "at night and rests in daytime at the base of the plant. In dryland fields, armyworm pupa can be found in the soil " +
                "or at the base of the rice plants. In wetlands, they pupate on the plants or on grassy areas along the field borders.\n");
        SpannableString s4 = new SpannableString("\nSymptoms\n");
        SpannableString s5 = new SpannableString("Check for feeding damage. Armyworms feed on leaf tips and along leaf margins. " +
                "When they eat whole leaves, they can remove them completely or leave only the midribs. Armyworm damage can be mistaken " +
                "for cutworm feeding. The characteristic form of armyworm damage is leaf removal. To confirm, check for the presence of " +
                "the insect and its egg mass.");
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

        String count = String.valueOf(db.countInfo("Army Worm"));
        String thisWeek = String.valueOf(db.countThisWeek("Army Worm"));

        textViewDetection.setText(count + " Detections");
        detectionText.setText(thisWeek + " This Week");

    }

    public void backActivity() {
        finish();

    }

    @Override
    public void onBackPressed() {
        finish();
    }


    public static class PestDefinition2 extends AppCompatActivity {
        TextView textView, textViewDetection, detectionText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_definition);

            ViewPager viewPager = findViewById(R.id.viewpager);
            PestsViewPager.PestViewPager2 pestsViewPager = new PestsViewPager.PestViewPager2(this);
            viewPager.setAdapter(pestsViewPager);

            textView = (TextView) findViewById(R.id.definition);
            textViewDetection = (TextView) findViewById(R.id.detection);
            detectionText = (TextView) findViewById(R.id.detectionText);

            SpannableString s1 = new SpannableString("Golden Apple-snail\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("Statistics\n");
            SpannableString s3 = new SpannableString("There are more than 100 species of apple snail that exists. Two species, " +
                    "Pomacea canaliculata and Pomacea maculata, commonly known as Golden Apple Snails, are highly invasive and cause " +
                    "damage to rice crops. They were introduced to Asia, from South America, in the 1980s as potential food for people, " +
                    "but it unfortunately became a major pest of rice. Golden apple snails eat young and emerging rice plants. They cut " +
                    "the rice stem at the base, destroying the whole plant. Snails are able to spread through irrigation canals, " +
                    "natural water distribution pathways, and during flooding events. When water is absent, apple snails are able " +
                    "to bury themselves in the mud and hibernate for up to six months. When water is re-applied to fields, snails " +
                    "may emerge. They damage direct wet-seeded rice and transplanted rice up to 30 days old. Once the rice plant " +
                    "reaches 30−40 days, it will become thick enough to resist the snail.\n");
            SpannableString s4 = new SpannableString("\nSymptoms\n");
            SpannableString s5 = new SpannableString("To distinguish golden apple snails from native snails, check its color and size. " +
                    "Golden apple snails have muddy brown shell and golden pinkish or orange-yellow flesh. They are bigger and lighter " +
                    "in color compared to native snails. Its eggs are bright pink in color. To confirm snail damage, check for missing hills, " +
                    "cut leaves, and cut stems.");
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

            String count = String.valueOf(db.countInfo("Golden Apple Snail"));
            String thisWeek = String.valueOf(db.countThisWeek("Golden Apple Snail"));

            textViewDetection.setText(count + " Detections");
            detectionText.setText(thisWeek + " This Week");

        }

        public void backActivity() {
            finish();

        }

        @Override
        public void onBackPressed() {
            finish();
        }

    }

    public static class PestDefinition3 extends AppCompatActivity {
        TextView textView, textViewDetection, detectionText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_definition);

            ViewPager viewPager = findViewById(R.id.viewpager);
            PestsViewPager.PestViewPager3 pestsViewPager = new PestsViewPager.PestViewPager3(this);
            viewPager.setAdapter(pestsViewPager);

            textView = (TextView) findViewById(R.id.definition);
            textViewDetection = (TextView) findViewById(R.id.detection);
            detectionText = (TextView) findViewById(R.id.detectionText);

            SpannableString s1 = new SpannableString("Green Leaf Hopper\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("Statistics\n");
            SpannableString s3 = new SpannableString("Two species of green leafhoppers (GLH) can spread tungro: Nephotettix malayanus " +
                    "and Nephotettix virescens. Green leafhoppers are the most common leafhoppers in rice fields and are primarily critical " +
                    "because they spread the viral disease tungro. Both nymphs and adults feed by extracting plant sap with their needle-shaped " +
                    "mouthparts. Staggered planting encourages population growth of GLH. Green leafhoppers are common in rainfed and irrigated " +
                    "wetland environments. They are not prevalent in upland rice. Both the nymphs and adults feed on the dorsal surface of the " +
                    "leaf blades rather than the ventral surface. They prefer to feed on the lateral leaves rather than the leaf sheaths and the " +
                    "middle leaves. They also prefer rice plants that have been fertilized with large amount of nitrogen.\n");
            SpannableString s4 = new SpannableString("\nSymptoms\n");
            SpannableString s5 = new SpannableString("Rice fields infested by GLH can have tungro, yellow dwarf, yellow-orange leaf, and " +
                    "transitory yellowing diseases. Symptoms include: stunted plants and reduced vigor, reduced number of productive tillers, and " +
                    "withering or complete plant drying. Tungro-infected crops may sometimes be confused with nitrogen deficiency or iron toxicity " +
                    "or acid soils. To confirm the cause of the problem, check for virus infected plants in the fields, and the presence of the " +
                    "insect which could be white or pale yellow eggs inside leaf sheaths or midribs, yellow or pale green nymphs with or without " +
                    "black markings, and pale green adults with or without black markings feeding on upper parts of the crop.");
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

            String count = String.valueOf(db.countInfo("Green Leafhopper"));
            String thisWeek = String.valueOf(db.countThisWeek("Green Leafhopper"));

            textViewDetection.setText(count + " Detections");
            detectionText.setText(thisWeek + " This Week");

        }

        public void backActivity() {
            finish();

        }

        @Override
        public void onBackPressed() {
            finish();
        }

    }

    public static class PestDefinition4 extends AppCompatActivity {
        TextView textView, textViewDetection, detectionText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_definition);

            ViewPager viewPager = findViewById(R.id.viewpager);
            PestsViewPager.PestViewPager4 pestsViewPager = new PestsViewPager.PestViewPager4(this);
            viewPager.setAdapter(pestsViewPager);

            textView = (TextView) findViewById(R.id.definition);
            textViewDetection = (TextView) findViewById(R.id.detection);
            detectionText = (TextView) findViewById(R.id.detectionText);

            SpannableString s1 = new SpannableString("Rice Black-bug\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("Statistics\n");
            SpannableString s3 = new SpannableString("In the Philippines’ setup, there are three (3) species of bugs that attack rice. " +
                    "They are common black bug, Malayan black bug, and Japanese black bug. Black bugs remove the sap of the plant. They can " +
                    "cause browning of leaves, deadheart, and bugburn. Their damage also causes stunting in plants, reduced tiller number, and " +
                    "formation of whiteheads. On severe cases, black bugs weaken the plant preventing them from producing seeds. The insect is " +
                    "common in rainfed and irrigated wetland environments. It prefers continuously cropped irrigated rice areas and poorly drained fields. " +
                    "Damages are observed more frequently in dry season rice crops and densely planted fields. Black bug flight patterns are affected by the " +
                    "lunar cycle; on full moon nights, large numbers of adults swarm to light sources. Staggered planting of the rice crop and excessive " +
                    "nitrogen also favor the buildup of the pest. During non-rice periods, the presence of alternate breeding site favors population increase.\n");
            SpannableString s4 = new SpannableString("\nSymptoms\n");
            SpannableString s5 = new SpannableString("First step is to check leaves for discoloration. Black bug damage can cause reddish brown or yellowing " +
                    "of plants. Leaves also have chlorotic lesions. Next is to check for decreased tillering. Bugburn symptoms show wilting of tillers with no " +
                    "visible honeydew deposits or sooty molds. Plants are also stunted and can develop stunted panicles, no panicles, incompletely exerted " +
                    "panicles, and unfilled spikelets or whiteheads at booting stage. Furthermore, check for deadhearts. Deadhearts can also be caused by stemborer. " +
                    "To confirm cause of damage, pull infected plants. In black bug damage, infected plants cannot be pulled at the bases. Heavy infestation and \"bugburn\" " +
                    "is usually visible after heading or maturing.");
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

            String count = String.valueOf(db.countInfo("Black Bug"));
            String thisWeek = String.valueOf(db.countThisWeek("Black Bug"));

            textViewDetection.setText(count + " Detections");
            detectionText.setText(thisWeek + " This Week");

        }

        public void backActivity() {
            finish();

        }

        @Override
        public void onBackPressed() {
            finish();
        }

    }

    public static class PestDefinition5 extends AppCompatActivity {
        TextView textView, textViewDetection, detectionText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_definition);

            ViewPager viewPager = findViewById(R.id.viewpager);
            PestsViewPager.PestViewPager5 pestsViewPager = new PestsViewPager.PestViewPager5(this);
            viewPager.setAdapter(pestsViewPager);

            textView = (TextView) findViewById(R.id.definition);
            textViewDetection = (TextView) findViewById(R.id.detection);
            detectionText = (TextView) findViewById(R.id.detectionText);

            SpannableString s1 = new SpannableString("Rice Ear-bug\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("Statistics\n");
            SpannableString s3 = new SpannableString("The most common species of rice bug are Leptocorisa oratorius F. and Leptocorisa acuta T., " +
                    "both commonly called ear bug. Ears bugs damage rice by sucking out the contents of developing grains from pre-flowering spikelets " +
                    "to soft dough stage, therefore causing unfilled or empty grains and discoloration. Immature and adult rice bugs both feed on rice grains. " +
                    "The population of the rice bug increases at the end of the rainy season. Ear bugs are found in all rice environments. They are more " +
                    "common in rain-fed and upland rice and prefer the flowering to milky stages of the rice crop. Adults are active during the late afternoon " +
                    "and early morning. Under bright sunlight, they hide in grassy areas. They are less active during the dry season. In cooler areas, the adults " +
                    "undergo a prolonged development in grasses. They feed on wild hosts for one to two generations before migrating into the rice fields at " +
                    "the flowering stages. The nymphs are found on the rice plant where they blend with the foliage. There, they are often left unnoticed. " +
                    "When disturbed, the nymphs drop to the lower part of the plants and the adults fly within a short distance\n");
            SpannableString s4 = new SpannableString("\nSymptoms\n");
            SpannableString s5 = new SpannableString("Check the plant for feeding damage, such as small or shriveled grains, deformed or spotty grains, " +
                    "empty grains, and erect panicles. The symptoms can be confused with the damage caused by nutrient deficiency or flower thrips. To confirm " +
                    "rice bug infestation, check for presence of insects that are usually oval, shiny, and reddish brown eggs along midrib of leaf; slender " +
                    "and brown-green nymphs and adults feeding on endosperm of rice grains; and an offensive smell.");
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

            String count = String.valueOf(db.countInfo("Ear Bug"));
            String thisWeek = String.valueOf(db.countThisWeek("Ear Bug"));

            textViewDetection.setText(count + " Detections");
            detectionText.setText(thisWeek + " This Week");

        }

        public void backActivity() {
            finish();

        }

        @Override
        public void onBackPressed() {
            finish();
        }

    }
}
