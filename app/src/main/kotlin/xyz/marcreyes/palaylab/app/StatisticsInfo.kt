package xyz.marcreyes.palaylab.app

class StatisticsInfo {
    var id = 0
    var detectionName: String? = null
    var detectionDate: String? = null
    var detectionConfidence: String? = null

    constructor()
    constructor(detectionName: String?, detectionDate: String?, detectionConfidence: String?) : super() {
        this.detectionName = detectionName
        this.detectionDate = detectionDate
        this.detectionConfidence = detectionConfidence
    }

    override fun toString(): String {
        return "Info [id=" + id + ", " +
                "detectionName=" + detectionName +
                ", detectionDate=" + detectionDate +
                ", detectionConfidence=" + detectionConfidence +
                "]"
    }
}