package moodAnalyserTest;

import com.bridgelabz.moodAnalyzer.MoodAnalysisException;
import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

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
