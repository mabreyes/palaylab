package io.github.projectbukirin.palaylab;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
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

        SpannableString s1 = new SpannableString("Army Worm\n");
        SpannableString ss1 = new SpannableString("Infestation\n\n");
        SpannableString s2 = new SpannableString("About\n");
        SpannableString s3 = new SpannableString("Army worms are caterpillars that attack rice. A single army worm egg mass " +
                "contains hundreds of eggs. Each female lays 800−1000 eggs during its lifetime of about one week. Army worm " +
                "feeds on rice by cutting off leaves and young seedlings at the plant's base. They can also cut off rice panicles " +
                "from base. Adult army worms survive better and produce more eggs when the temperature is at 15°C maximum, " +
                "and when plants are naturally fertilized. Periods of drought followed by heavy rains, and the presence of " +
                "alternate hosts also sustain the development of army worms. Army worms are nocturnal. The larvae usually feed " +
                "in the upper portion of the rice canopy on cloudy days or at night; while the adult feeds, mates, and migrates " +
                "at night and rests in daytime at the base of the plant. In dry land fields, army worm pupa can be found in the soil " +
                "or at the base of the rice plants. In wetlands, they pupate on the plants or on grassy areas along the field borders.\n");
        SpannableString s4 = new SpannableString("\nSymptoms\n");
        SpannableString s5 = new SpannableString("Check for feeding damage. Army worms feed on leaf tips and along leaf margins. " +
                "When they eat whole leaves, they can remove them completely or leave only the midribs. Army worm damage can be mistaken " +
                "for cutworm feeding. The characteristic form of army worm damage is leaf removal. To confirm, check for the presence of " +
                "the insect and its egg mass.");
        SpannableString s6 = new SpannableString("\n\nManagement Strategies\n");
        SpannableString s7 = new SpannableString("A. Preventive Methods\n" +
                "▪ Flooding seedbeds is the best defense against Army Worms.\n" +
                "▪ Establish seedbeds far from large areas of weeds.\n" +
                "▪ Plow fallow land.\n" +
                "▪ Clean the field and remove weeds.\n" +
                "\n" +
                "B. Cultural Methods\n" +
                "▪ Place ashes in the trenches to make it more difficult for the caterpillars to escape.\n" +
                "▪ Place branches around fields to give Army Worms a place to congregate where they are easily collected by hand.\n" +
                "▪ Avoid killing natural enemies of Army Worms such as wasps and spiders.\n" +
                "▪ The western yellow-striped army worm is believed to limit its egg laying to broad leaf plants\n" +
                "▪ The early control of broad leaf weeds in rice fields may be important in limiting its populations.\n" +
                "\n" +
                "C. Chemical Methods\n" +
                "▪ Ambda-Cyhalothrin (Warrior II with Zeon); 1.6–2.56 fl. oz. (amount per acre), 24 hours of restricted entry interval, and 21 hours of pre-harvest interval. Highly toxic to bees; do not spray directly or allow to drift onto blooming crops or weeds where bees are foraging.\n" +
                "▪ Zeta-Cypermethrin (Mustang); 3.4–4.3 oz. (amount per acre), 12 hours of restricted entry interval, and 14 hours of pre-harvest interval. Make applications at least 7 days apart and do not release flood water within 7 days of application. Do not apply more than 1.1 pt. (0.2 lb. ai.)/acre per season.\n" +
                "▪ Carbaryl (Sevin 4F); 1-1.5 qtr. (amount per acre), 12 hours of restricted entry interval, and 14 hours of pre-harvest interval; (Sevin XLR Plus) 1-1.5 at (amount per acre), 12 restricted entry interval, and 14 hours of pre-harvest interval. Do not apply 15 days before or after application of the herbicide propanil. Highly toxic to bees; do not spray directly or allow to drift onto blooming crops or weeds where bees are foraging.");

        int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
        s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
        s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
        s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
        ss1.setSpan(new RelativeSizeSpan(1.7f), 0, ss1.length(), flag);
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

        Typeface bold = Typeface.createFromAsset(getAssets(), "gorditabold.ttf");
        Typeface medium = Typeface.createFromAsset(getAssets(), "gorditamedium.ttf");
        Typeface regular = Typeface.createFromAsset(getAssets(), "gorditaregular.ttf");

        s1.setSpan(new CustomTypefaceSpan("", bold), 0, s1.length(), flag);
        ss1.setSpan(new CustomTypefaceSpan("", medium), 0, ss1.length(), flag);
        s2.setSpan(new CustomTypefaceSpan("", bold), 0, s2.length(), flag);
        s3.setSpan(new CustomTypefaceSpan("", regular), 0, s3.length(), flag);
        s4.setSpan(new CustomTypefaceSpan("", bold), 0, s4.length(), flag);
        s5.setSpan(new CustomTypefaceSpan("", regular), 0, s5.length(), flag);
        s6.setSpan(new CustomTypefaceSpan("", bold), 0, s6.length(), flag);

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

        String count = String.valueOf(db.countInfo("Army Worm"));
        String thisWeek = String.valueOf(db.countThisWeek("Army Worm"));

        SpannableString counterDetections = SpannableString.valueOf(count + "\nTotal");
        counterDetections.setSpan(new RelativeSizeSpan(3f), 0, count.length(), flag);
        counterDetections.setSpan(new StyleSpan(Typeface.BOLD), 0, count.length(), flag);

        SpannableString counterDetectionsTW = SpannableString.valueOf(thisWeek + "\nThis Week");
        counterDetectionsTW.setSpan(new RelativeSizeSpan(3f), 0, thisWeek.length(), 0);
        counterDetectionsTW.setSpan(new StyleSpan(Typeface.BOLD), 0, thisWeek.length(), 0);

        textViewDetection.setText(counterDetections);
        detectionText.setText(counterDetectionsTW);

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

            SpannableString s1 = new SpannableString("Golden Apple Snail\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("About\n");
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
            SpannableString s6 = new SpannableString("\n\nManagement Strategies\n");
            SpannableString s7 = new SpannableString("A. Mechanical Control\n" +
                    "▪ Increase mortality by mechanical action.\n" +
                    "▪ Install screens with 5 mm mesh at water inlets. This can minimize the entry of snails into the rice fields and will also facilitate hand-collection.\n" +
                    "▪ Handpicking and crushing, staking with bamboo or other wooden stakes before and after transplanting can be practiced to facilitate egg mass collection.\n" +
                    "▪ Use of a hand-operated device to smash egg clusters between two snail egg clappers can also reduce the snail population.\n" +
                    "\n" +
                    "B. Cultural Methods\n" +
                    "▪ Planting older seedlings, planting at higher densities, or planting on ridges above the water line are advised against the golden apple snail.\n" +
                    "▪ The field can be leveled-off or hydrotiller or rototiller to prepare the land.\n" +
                    "▪ An off-season tillage to crush snails can also be employed.\n" +
                    "▪ Snails can also be exposed to sun.\n" +
                    "▪ Draining the field is also advised.\n" +
                    "▪ Crop rotation with a dryland crop and fallow periods is also recommended as control.\n" +
                    "▪ For easier drainage and collection of the golden apple snail, canalets can be constructed along bunds and inside paddy field.\n" +
                    "▪ Attractants like newspaper can be used.\n" +
                    "▪ Good water management obtained by good levelling for the first two weeks is recommended.\n" +
                    "\n" +
                    "C. Chemical Methods\n" +
                    "▪ Molluscicides such as metaldehyde is recommended\n" +
                    "\n" +
                    "D. Biological Methods\n" +
                    "▪ The use of common carp, Japanese crucian, heron, and weasels as biological control agents against the golden apple snail.\n" +
                    "▪ A firefly nymph is also an effective natural enemy of the snail.\n" +
                    "▪ Herding ducks and raising fish in the paddy are also recommended as biological control.\n" +
                    "▪ Birds prey on both eggs and neonates. Rats and snakes also feed on them");

            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
            s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
            s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
            ss1.setSpan(new RelativeSizeSpan(1.7f), 0, ss1.length(), flag);
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

            Typeface bold = Typeface.createFromAsset(getAssets(), "gorditabold.ttf");
            Typeface medium = Typeface.createFromAsset(getAssets(), "gorditamedium.ttf");
            Typeface regular = Typeface.createFromAsset(getAssets(), "gorditaregular.ttf");

            s1.setSpan(new CustomTypefaceSpan("", bold), 0, s1.length(), flag);
            ss1.setSpan(new CustomTypefaceSpan("", medium), 0, ss1.length(), flag);
            s2.setSpan(new CustomTypefaceSpan("", bold), 0, s2.length(), flag);
            s3.setSpan(new CustomTypefaceSpan("", regular), 0, s3.length(), flag);
            s4.setSpan(new CustomTypefaceSpan("", bold), 0, s4.length(), flag);
            s5.setSpan(new CustomTypefaceSpan("", regular), 0, s5.length(), flag);
            s6.setSpan(new CustomTypefaceSpan("", bold), 0, s6.length(), flag);

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

            String count = String.valueOf(db.countInfo("Golden Apple Snail"));
            String thisWeek = String.valueOf(db.countThisWeek("Golden Apple Snail"));

            SpannableString counterDetections = SpannableString.valueOf(count + "\nTotal");
            counterDetections.setSpan(new RelativeSizeSpan(3f), 0, count.length(), flag);
            counterDetections.setSpan(new StyleSpan(Typeface.BOLD), 0, count.length(), flag);

            SpannableString counterDetectionsTW = SpannableString.valueOf(thisWeek + "\nThis Week");
            counterDetectionsTW.setSpan(new RelativeSizeSpan(3f), 0, thisWeek.length(), 0);
            counterDetectionsTW.setSpan(new StyleSpan(Typeface.BOLD), 0, thisWeek.length(), 0);

            textViewDetection.setText(counterDetections);
            detectionText.setText(counterDetectionsTW);

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

            SpannableString s1 = new SpannableString("Green Leafhopper\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("About\n");
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
            SpannableString s6 = new SpannableString("\n\nManagement Strategies\n");
            SpannableString s7 = new SpannableString("A. Cultural Methods:\n" +
                    "▪ The most effective means of GLH management is to use GLH-resistant and Tungro-resistant varieties like IR 50, IR 54, IR 64, CR 1009, PY 3, Co 46 and white ponni.\n" +
                    "▪ Apply neem cake @ 12.5 kg/20 cent nursery as basal dose.\n" +
                    "▪ Transplanting older seedlings (>3 weeks) reduces viral disease susceptibility transmitted by leafhoppers.\n" +
                    "▪ Nitrogen should be applied as needed to avoid contributing to population or hindering plant recovery from plant hopper damage by applying insufficient nitrogen.\n" +
                    "▪ Good weed control in the field and on the bunds removes the preferred grassy hosts of Green leaf hopper and promotes crop vigor.\n" +
                    "▪ Crop rotation with a non-rice crop during the dry season decreases alternate hosts for diseases.\n" +
                    "▪ Upland rice intercropped with soybean reduces the incidence of leafhoppers on rice compared to rice alone\n" +
                    "\n" +
                    "B. Chemical Methods: \n" +
                    "▪ ETL: 60/25 net sweeps (or) 5/hill at vegetative stage (or) 10/hill at flowering (or) 2/hill in tungro endemic area \n" +
                    "▪ Scout the field for the presence of Tungro and Green leaf hopper. Check 20 hills while walking diagonally across a transplanted field.\n" +
                    "▪ Spray insecticides twice, 15 and 30 days after transplanting.\n" +
                    "▪ Spray any one of the following: \n" +
                    "▪ Fenitrothion 50 EC 80 ml (or) Phosphamidon 40 SL 50 ml (or) Fenthion 100 EC 40 ml (or) Quinalphos 25 EC 80 ml (or) Phosalone 35 EC 120 ml (or) Monocrotophos 36 SL 40 ml.\n" +
                    "▪ Maintain 2.5 cm of water in the nursery and broadcast anyone of the following in 20 cents Carbofuran 3 G 3.5 kg (or) Phorate 10 G 1.0 kg (or) Quinalphos 5 G 2.0 kg\n" +
                    "\n" +
                    "C. Biological Methods:\n" +
                    "▪ The major egg parasitoids are: \n" +
                    "a) Oligosita yasumatsui (Hymenoptera: Trichogrammatidae). \n" +
                    "b) Anagrus spp. (Hymenoptera: Mymaridae). \n" +
                    "c) Gonatocerus spp. (Hymenoptera: Mymaridae). \n" +
                    "▪ The most abundant predator is the green mired bug Cyrtorhinus lividipennis which predate on both eggs and nymphs. \n" +
                    "▪ Strepsipterans, small wasps, pipunculid flies, and nematodes parasitize both the nymphs and adults.\n" +
                    "▪ They are also attacked by aquatic veliid bugs, nabid bugs, empid flies, damselflies, dragonflies, and spiders. A fungal pathogen infects both the nymphs and adults of the green leafhopper.\n" +
                    "\n" +
                    "D. Natural enemies and predators: \n" +
                    "▪ Natural enemies :\n" +
                    "a) Itoplectis narangae - Ichnuemonidae Wasp\n" +
                    "b) Trichomma cnaphalocrocis - Ichnuemonidae Wasp\n" +
                    "▪ Predators:\n" +
                    "a) Release of mirid bug Cytorhinus lividipennis @ 50 – 75 egg/ m2\n" +
                    "\n" +
                    "E. Trap Methods:\n" +
                    "▪ Set up light traps to attract and kill the moths. Set up light trap one for at least 5 ha.\n" +
                    "▪ Set up bird perches (40 to 50/ha) of Insectivorous Birds at vegetative phase of crop.\n" +
                    "▪ Monitor through pheromone traps (@ 10 to 12/ha for timely control measures. Change the lure at 15-20 days intervals.");

            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
            s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
            s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
            ss1.setSpan(new RelativeSizeSpan(1.7f), 0, ss1.length(), flag);
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

            Typeface bold = Typeface.createFromAsset(getAssets(), "gorditabold.ttf");
            Typeface medium = Typeface.createFromAsset(getAssets(), "gorditamedium.ttf");
            Typeface regular = Typeface.createFromAsset(getAssets(), "gorditaregular.ttf");

            s1.setSpan(new CustomTypefaceSpan("", bold), 0, s1.length(), flag);
            ss1.setSpan(new CustomTypefaceSpan("", medium), 0, ss1.length(), flag);
            s2.setSpan(new CustomTypefaceSpan("", bold), 0, s2.length(), flag);
            s3.setSpan(new CustomTypefaceSpan("", regular), 0, s3.length(), flag);
            s4.setSpan(new CustomTypefaceSpan("", bold), 0, s4.length(), flag);
            s5.setSpan(new CustomTypefaceSpan("", regular), 0, s5.length(), flag);
            s6.setSpan(new CustomTypefaceSpan("", bold), 0, s6.length(), flag);

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

            String count = String.valueOf(db.countInfo("Green Leafhopper"));
            String thisWeek = String.valueOf(db.countThisWeek("Green Leafhopper"));

            SpannableString counterDetections = SpannableString.valueOf(count + "\nTotal");
            counterDetections.setSpan(new RelativeSizeSpan(3f), 0, count.length(), flag);
            counterDetections.setSpan(new StyleSpan(Typeface.BOLD), 0, count.length(), flag);

            SpannableString counterDetectionsTW = SpannableString.valueOf(thisWeek + "\nThis Week");
            counterDetectionsTW.setSpan(new RelativeSizeSpan(3f), 0, thisWeek.length(), 0);
            counterDetectionsTW.setSpan(new StyleSpan(Typeface.BOLD), 0, thisWeek.length(), 0);

            textViewDetection.setText(counterDetections);
            detectionText.setText(counterDetectionsTW);

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

            SpannableString s1 = new SpannableString("Rice Black Bug\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("About\n");
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
            SpannableString s6 = new SpannableString("\n\nManagement Strategies\n");
            SpannableString s7 = new SpannableString("▪ 10% damage at tillering stage or 5 bugs / hill.\n" +
                    "▪ Maintain a clean field by removing the weeds and drying the rice field during ploughing. \n" +
                    "▪ Rice varieties of the same maturity date may be planted to break the insect’s cycle. \n" +
                    "▪ Direct-seeded rice crops tend to have less tillers in one planting point and thus discourage population growth. \n" +
                    "▪ Flooding the fields can also cause higher egg mortality. \n" +
                    "▪ Set up light trap during the full moon period to attract large number of bugs and kill. \n" +
                    "▪ Conserve the predators viz Spiders, coccinellids and wasps to check the pest.\n" +
                    "▪ Ducks can be allowed in the field to pick up the bugs.\n" +
                    "▪ Spray monocrotophos @ 100 ml / ha (or) acephate 625 g / ha (or) Neem seed kernel extract 5% for effective control of black bug.");

            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
            s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
            s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
            ss1.setSpan(new RelativeSizeSpan(1.7f), 0, ss1.length(), flag);
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

            Typeface bold = Typeface.createFromAsset(getAssets(), "gorditabold.ttf");
            Typeface medium = Typeface.createFromAsset(getAssets(), "gorditamedium.ttf");
            Typeface regular = Typeface.createFromAsset(getAssets(), "gorditaregular.ttf");

            s1.setSpan(new CustomTypefaceSpan("", bold), 0, s1.length(), flag);
            ss1.setSpan(new CustomTypefaceSpan("", medium), 0, ss1.length(), flag);
            s2.setSpan(new CustomTypefaceSpan("", bold), 0, s2.length(), flag);
            s3.setSpan(new CustomTypefaceSpan("", regular), 0, s3.length(), flag);
            s4.setSpan(new CustomTypefaceSpan("", bold), 0, s4.length(), flag);
            s5.setSpan(new CustomTypefaceSpan("", regular), 0, s5.length(), flag);
            s6.setSpan(new CustomTypefaceSpan("", bold), 0, s6.length(), flag);

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

            String count = String.valueOf(db.countInfo("Black Bug"));
            String thisWeek = String.valueOf(db.countThisWeek("Black Bug"));

            SpannableString counterDetections = SpannableString.valueOf(count + "\nTotal");
            counterDetections.setSpan(new RelativeSizeSpan(3f), 0, count.length(), flag);
            counterDetections.setSpan(new StyleSpan(Typeface.BOLD), 0, count.length(), flag);

            SpannableString counterDetectionsTW = SpannableString.valueOf(thisWeek + "\nThis Week");
            counterDetectionsTW.setSpan(new RelativeSizeSpan(3f), 0, thisWeek.length(), 0);
            counterDetectionsTW.setSpan(new StyleSpan(Typeface.BOLD), 0, thisWeek.length(), 0);

            textViewDetection.setText(counterDetections);
            detectionText.setText(counterDetectionsTW);

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

            SpannableString s1 = new SpannableString("Rice Ear Bug\n");
            SpannableString ss1 = new SpannableString("Infestation\n\n");
            SpannableString s2 = new SpannableString("About\n");
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

            SpannableString s6 = new SpannableString("\n\nManagement Strategies\n");
            SpannableString s7 = new SpannableString("A. Cultural Methods:\n" +
                    "▪ Strict vigilance is necessary at milky stage.\n" +
                    "▪ Cultural control measures include the removal of alternate hosts such as grasses on bunds, early planting, and the use of late-maturing cultivars.\n" +
                    "▪ Keep the field and bunds free of weeds and grasses.\n" +
                    "▪ Netting and handpicking the bugs reduce their numbers.\n" +
                    "▪ Putting attractants such as arasan or anything with an odor like dead snails or rats can easily capture rice bugs in the field.\n" +
                    "▪ Coarse-grain and bearded cultivars may be resistant to the rice bugs\n" +
                    "\n" +
                    "B. Chemical Methods:\n" +
                    "▪ ETL: 5 bugs/100 ear heads at flowering and 16 bugs/100 ear heads from milky stage to grain maturity \n" +
                    "▪ When the bug is seen in large numbers apply one of the following insecticides at 25 kg/ha twice, the first during flowering and second a week later. \n" +
                    "▪ KKM dust formulation consists of 10% of Acorus calamus rhizome powder and 90% of fly ash. This dust formulation repels the rice earhead bug. \n" +
                    "▪ Since the occurrence of the bug coincides with the flowering stage, application of the insecticide may be done either before 9 a.m. or after 3 p.m. so that fertilization of the flowers is not adversely affected. \n" +
                    "▪ Spray any one of the following twice\n" +
                    "▪ Fenthion 100 EC @ 500 ml/ha (or) Malathion 50 EC @ 500 ml/ha \n" +
                    "\n" +
                    "C. Biological Methods:\n" +
                    "▪ Among the biological control agents, small wasps parasitize the eggs and the meadow grasshoppers prey on them.\n" +
                    "▪ Both the adults and nymphs are preys to spiders, coccinellid beetles and dragonflies.\n" +
                    "▪ A fungus infects both nymphs and adults.\n" +
                    "\n" +
                    "D. Botanical Methods:\n" +
                    "Use any one of the following:\n" +
                    "▪ Neem seed kernel extract 5%@25kg/ha\n" +
                    "▪ Notchi leaf powder extract 5%\n" +
                    "▪ Ipomoea leaf powder extract 5%\n" +
                    "▪ Prosopis leaf powder extract 5%");

            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
            s1.setSpan(new RelativeSizeSpan(2.5f), 0, s1.length(), flag);
            s1.setSpan(new ForegroundColorSpan(Color.rgb(11, 102, 35)), 0, s1.length(), flag);
            ss1.setSpan(new RelativeSizeSpan(1.7f), 0, ss1.length(), flag);
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

            Typeface bold = Typeface.createFromAsset(getAssets(), "gorditabold.ttf");
            Typeface medium = Typeface.createFromAsset(getAssets(), "gorditamedium.ttf");
            Typeface regular = Typeface.createFromAsset(getAssets(), "gorditaregular.ttf");

            s1.setSpan(new CustomTypefaceSpan("", bold), 0, s1.length(), flag);
            ss1.setSpan(new CustomTypefaceSpan("", medium), 0, ss1.length(), flag);
            s2.setSpan(new CustomTypefaceSpan("", bold), 0, s2.length(), flag);
            s3.setSpan(new CustomTypefaceSpan("", regular), 0, s3.length(), flag);
            s4.setSpan(new CustomTypefaceSpan("", bold), 0, s4.length(), flag);
            s5.setSpan(new CustomTypefaceSpan("", regular), 0, s5.length(), flag);
            s6.setSpan(new CustomTypefaceSpan("", bold), 0, s6.length(), flag);

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

            String count = String.valueOf(db.countInfo("Ear Bug"));
            String thisWeek = String.valueOf(db.countThisWeek("Ear Bug"));

            SpannableString counterDetections = SpannableString.valueOf(count + "\nTotal");
            counterDetections.setSpan(new RelativeSizeSpan(3f), 0, count.length(), flag);
            counterDetections.setSpan(new StyleSpan(Typeface.BOLD), 0, count.length(), flag);

            SpannableString counterDetectionsTW = SpannableString.valueOf(thisWeek + "\nThis Week");
            counterDetectionsTW.setSpan(new RelativeSizeSpan(3f), 0, thisWeek.length(), 0);
            counterDetectionsTW.setSpan(new StyleSpan(Typeface.BOLD), 0, thisWeek.length(), 0);

            textViewDetection.setText(counterDetections);
            detectionText.setText(counterDetectionsTW);

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
