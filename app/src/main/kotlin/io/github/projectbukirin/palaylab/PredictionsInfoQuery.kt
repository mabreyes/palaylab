package io.github.projectbukirin.palaylab

class PredictionsInfoQuery {
    private var qUuid: String? = null
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

    fun getUuid(): String? {
        return qUuid
    }

    fun setUuid(uuid: String?) {
        qUuid = uuid
    }

    fun getDetectionName(): String? {
        return qDetectionName
    }

    fun setDetectionName(detectionName: String?) {
        qDetectionName = detectionName
    }

    fun getDetectionDate(): String? {
        return qDetectionDate
    }

    fun setDetectionDate(detectionDate: String?) {
        qDetectionDate = detectionDate
    }

    fun getDetectionTimestamp(): Long? {
        return qDetectionTimestamp
    }

    fun setDetectionTimestamp(detectionTimestamp: Long?) {
        qDetectionTimestamp = detectionTimestamp
    }

    fun getDetectionConfidence(): Float? {
        return qDetectionConfidence
    }

    fun setDetectionConfidence(detectionConfidence: Float?) {
        qDetectionConfidence = detectionConfidence
    }
}