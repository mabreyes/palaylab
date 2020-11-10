package io.github.projectbukirin.palaylab
import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class PredictionsInfo (
    var uuid: String? = "",
    var detectionName: String? = "",
    var detectionDate: String? = "",
    var detectionConfidence: Float? = 0.0f
)