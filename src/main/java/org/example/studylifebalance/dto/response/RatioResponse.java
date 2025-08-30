package main.java.org.example.studylifebalance.dto.response;

public class RatioResponse {
    public int majorCreditRatio;
    public int generalCreditRatio;
    public int studyTimeRatio;
    public int restTimeRatio;

    public RatioResponse(int majorCreditRatio, int generalCreditRatio, int studyTimeRatio, int restTimeRatio) {
        this.majorCreditRatio = majorCreditRatio;
        this.generalCreditRatio = generalCreditRatio;
        this.studyTimeRatio = studyTimeRatio;
        this.restTimeRatio = restTimeRatio;
    }
}
