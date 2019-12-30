package com.bridgelabz.moodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserReflector {


    public static MoodAnalyzer CreateMoodAnalyser(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObj = moodConstructor.newInstance(message);

            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Constructor<?> getConstructor(Class<?>... stringClass) {
        Constructor<?> constructor = null;
        try {
            Class<?> aClass = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer");
            constructor = aClass.getConstructor(stringClass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }


    public static Object getObject(Constructor<?> constructor, String... message) {
        Object moodObject = null;
        try {
            moodObject = constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return moodObject;
    }

    public static Method getMethod(String methodName)  {
        try {
            Constructor<?> constructor = getConstructor(String.class);
            Object object = getObject(constructor, "sad");
            Method analyze = object.getClass().getDeclaredMethod(methodName);
            return analyze;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND,"Please enter the valid method name");
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        return null;
    }
}
