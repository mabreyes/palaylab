package io.github.projectbukirin.palaylab;


import android.graphics.Bitmap;

import org.apache.commons.lang3.text.WordUtils;

import java.util.List;


public interface Classifier {

    List<Recognition> recognizeImage(Bitmap bitmap);

    void close();

    class Recognition {
        /**
         * A unique identifier for what has been recognized. Specific to the class, not the instance of
         * the object.
         */
        private final String id;

        /**
         * Display name for the recognition.
         */
        private final String title;

        /**
         * A sortable score for how good the recognition is relative to others. Higher should be better.
         */
        private final Float confidence;

        public Recognition(
                final String id, final String title, final Float confidence) {
            this.id = id;
            this.title = title;
            this.confidence = confidence;
        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public Float getConfidence() {
            return confidence;
        }

        @Override
        public String toString() {
            String resultString = "";

            if (title != null) {
                resultString += WordUtils.capitalizeFully(title) + ",";
            }

            if (confidence != null) {
                resultString += String.format("%.2f%%", confidence * 100.0f);
            }

            return resultString.trim();
        }
    }
}