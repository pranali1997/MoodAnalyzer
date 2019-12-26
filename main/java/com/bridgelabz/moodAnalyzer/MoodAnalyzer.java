package com.bridgelabz.moodAnalyzer;

public class MoodAnalyzer {
    public String analyse(String message) throws MoodAnalysisException {
        try {

            if (message.length()==0){
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please, enter a valid message");
            }
            if (message.contains("Sad") || message.contains("sad")) {
                return "Sad";
            } else {
                return "Happy";
            }
        } catch (Exception e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please, enter a valid message");
        }
    }
}
