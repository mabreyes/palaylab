package io.github.projectbukirin.palaylab;

public class StatisticsInfo {
    private int id;
    private String detectionName;
    private String detectionDate;
    private String detectionConfidence;

    public StatisticsInfo() {}

    public StatisticsInfo(String detectionName, String detectionDate, String detectionConfidence) {
        super();
        this.detectionName = detectionName;
        this.detectionDate = detectionDate;
        this.detectionConfidence = detectionConfidence;
    }

    public int getId() {
        return id;
    }

    public String getDetectionName() {
        return detectionName;
    }

    public String getDetectionDate() {
        return detectionDate;
    }

    public String getDetectionConfidence() {
        return detectionConfidence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDetectionName(String detectionName) {
        this.detectionName = detectionName;
    }

    public void setDetectionDate(String detectionDate) {
        this.detectionDate = detectionDate;
    }

    public void setDetectionConfidence(String detectionConfidence) {
        this.detectionConfidence = detectionConfidence;
    }

    @Override
    public String toString() {
        return "Info [id=" + id + ", " +
                "detectionName=" + detectionName +
                ", detectionDate=" + detectionDate +
                ", detectionConfidence=" + detectionConfidence +
                "]";
    }
}
