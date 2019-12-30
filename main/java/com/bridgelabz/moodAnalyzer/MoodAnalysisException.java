package com.bridgelabz.moodAnalyzer;

public class MoodAnalysisException extends RuntimeException {



    public enum ExceptionType{
        ENTERED_NULL , ENTERED_EMPTY, NO_SUCH_CLASS_FOUND, NO_SUCH_METHOD_FOUND
    }
    ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message){
        super(message);
        this.type=type;
    }

}
