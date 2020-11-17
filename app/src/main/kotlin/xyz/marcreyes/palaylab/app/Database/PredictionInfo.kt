package xyz.marcreyes.palaylab.app.Database

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class PredictionInfo(
        var uuid: String? = "",
        var detectionName: String? = "",
        var detectionDate: String? = "",
        var detectionTimeStamp: Long? = 0,
        var detectionConfidence: Float? = 0.0f
)