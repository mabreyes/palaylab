package io.github.projectbukirin.palaylab

class PredictionsInfoQuery {
    var qUuid: String? = null
    private var qDetectionName: String? = null
    private var qDetectionDate: String? = null
    private var qDetectionTimestamp: Long? = null
    private var qDetectionConfidence: Float? = null

    fun PredictionsInfoQuery() {} // Needed for Firebase

    fun PredictionsInfoQuery(uuid: String?, detectionName: String?, detectionDate: String?, detectionTimestamp: Long?, detectionConfidence: Float?) {
        qUuid = uuid
        qDetectionName = detectionName
        qDetectionDate = detectionDate
        qDetectionTimestamp = detectionTimestamp
        qDetectionConfidence = detectionConfidence
    }
}