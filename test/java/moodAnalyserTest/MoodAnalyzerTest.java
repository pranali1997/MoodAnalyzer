package moodAnalyserTest;

import com.bridgelabz.moodAnalyzer.MoodAnalyserFactory;
import com.bridgelabz.moodAnalyzer.MoodAnalysisException;
import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    @Test
    public void givenMoodAnalyserClass_whenProper_shouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.CreateMoodAnalyser("Please, enter a valid message");
        String mood = moodAnalyzer.analyse();
        Assert.assertEquals("Happy",mood);

    }

    @Test
    public void whenGivenMoodAnalyser_whenProper_shouldReturnObject() {
        Constructor<?> constructor=null;

        try {
            constructor = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
         Object myObj= constructor.newInstance("i'm happy right now");
         MoodAnalyzer moodAnalyzer=(MoodAnalyzer) myObj;
         try {

             String mood = moodAnalyzer.analyse();
             Assert.assertEquals("Happy", mood);
         } catch (MoodAnalysisException e) {
             e.printStackTrace();
         }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace(); }
    }

    @Test
    public void givenMoodAnalyzerClass_whenProperMessage_shouldReturnTrue() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("i'm happy right now");
        MoodAnalyzer moodAnalyzer1 = MoodAnalyserFactory.CreateMoodAnalyser("i'm happy right now");
        Assert.assertEquals(true,moodAnalyzer1.equals(moodAnalyzer));
    }

    @Test
    public void whenGivenSad_shouldReturnSad() {
        MoodAnalyzer analyser = new MoodAnalyzer("Sad");
        String message=analyser.analyse();
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whenGivenHappyMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("happy");
        String message=moodAnalyzer.analyse();
        Assert.assertEquals("Happy",message);
    }

    @Test
    public void whenGivenSadMessageWithAlphabetCapital_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("Sad");
        String message=moodAnalyzer.analyse();
        Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenNullMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            moodAnalyzer.analyse();
        }
        catch (MoodAnalysisException e){
           Assert.assertEquals("Please, enter a valid message", e.getMessage());
        }
    }
}
