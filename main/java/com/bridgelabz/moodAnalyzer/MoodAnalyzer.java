package com.bridgelabz.moodAnalyzer;

import java.util.Objects;

public class MoodAnalyzer {
    private String message;
    public MoodAnalyzer(String message) {
        this.message=message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    public MoodAnalyzer() {

    }

    public String analyse() throws MoodAnalysisException {
        try {
            if (message.length()==0){
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please, enter a valid message");
            }
            if (message.contains("Sad") || message.contains("sad")) {
                return "Sad";
            } else {
                return "Happy";
            }
        }
        catch (Exception e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please, enter a valid message");
        }
    }
}
