package org.example.studylifebalance;

public enum MBTI {
    ESFJ(1.0),
    ESFP(0.9),
    ESTP(0.8),
    ENFJ(0.7),
    ENFP(0.5),
    ENTP(0.4),
    ESTJ(0.3),
    ENTJ(0.2),
    ISFJ(-0.2),
    ISFP(-0.3),
    INFJ(-0.4),
    ISTP(-0.5),
    ISTJ(-0.7),
    INFP(-0.8),
    INTP(-0.9),
    INTJ(-1.0);

    private final double score;

    MBTI(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}