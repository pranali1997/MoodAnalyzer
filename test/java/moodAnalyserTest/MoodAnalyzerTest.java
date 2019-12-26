package moodAnalyserTest;

import com.bridgelabz.moodAnalyzer.MoodAnalysisException;
import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {

    @Test
    public void whenGivenSad_shouldReturnSad() {
        MoodAnalyzer analyser = new MoodAnalyzer();
        String message=analyser.analyse("I'm sad right now");
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whenGivenHappyMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message=moodAnalyzer.analyse("I'm happy right now");
        Assert.assertEquals("Happy",message);
    }

    @Test
    public void whenGivenSadMessageWithAlphabetCapital_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message=moodAnalyzer.analyse("I'a Sad right now");
        Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenNullMessage_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            moodAnalyzer.analyse(null);
        }
        catch (MoodAnalysisException e){
           Assert.assertEquals("Please, enter a valid message", e.getMessage());
        }
    }
}
