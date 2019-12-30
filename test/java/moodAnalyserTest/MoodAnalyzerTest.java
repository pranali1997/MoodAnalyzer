package moodAnalyserTest;

import com.bridgelabz.moodAnalyzer.MoodAnalyserReflector;
import com.bridgelabz.moodAnalyzer.MoodAnalysisException;
import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerTest {

    @Test
    public void whenGivenFieldNameImproper_shouldReturnException() throws ClassNotFoundException {
        try {
            Class<?> aClass = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer");
            Field field = aClass.getField("messages");
            Assert.assertEquals(field, "messages");
        } catch (NoSuchFieldException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD_FOUND, "Please enter valid message");

            }catch (MoodAnalysisException ee){
                ee.printStackTrace();

            }
        }

    }

    @Test
    public void whenGivenMethodNameImproper_shouldReturnException() throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = MoodAnalyserReflector.getMethod("analysd");
            String mood = (String) method.invoke(new MoodAnalyzer("i am happy"));
            Assert.assertEquals("Happy", mood);
        }catch (MoodAnalysisException ex){
            ex.printStackTrace();
        }
    }



    @Test
  public void whenGivenMethod_shouldInvokeReturnObject() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
      Method method = MoodAnalyserReflector.getMethod("i am happy");
      String mood = (String) method.invoke(new MoodAnalyzer("i am happy"));
      Assert.assertEquals("Happy",mood);
  }
    @Test
    public void whenGivenMethod_shouldInvokeAndReturnObject() {
        try {
            Class<?> aClass = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer");
            Constructor moodAnalyzerConstructor= MoodAnalyserReflector.getConstructor(String.class);
            Object moodObject=moodAnalyzerConstructor.newInstance("i am Happy");
            Method methodObj=aClass.getDeclaredMethod("analyse");
            Object result = methodObj.invoke(moodObject);
            Assert.assertEquals("Happy",result.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenGivenConstructorWithNoParameter_shouldReturnObject() {
        Constructor moodAnalyzerConstructor= MoodAnalyserReflector.getConstructor();
        Object object= MoodAnalyserReflector.getObject(moodAnalyzerConstructor);
        MoodAnalyzer object1 = (MoodAnalyzer) object;
        Assert.assertEquals(true,object1.equals(new MoodAnalyzer()));
    }

    @Test
    public void whenGivenConstructorWithParameter_shouldReturnObject() {
        Constructor moodAnalyzerConstructor = MoodAnalyserReflector.getConstructor(String.class);

            Object object = MoodAnalyserReflector.getObject(moodAnalyzerConstructor, "i am Happy");
            MoodAnalyzer objectAnalyzer1 = (MoodAnalyzer) object;
            Assert.assertEquals(true,objectAnalyzer1.equals(new MoodAnalyzer("i am Happy")));

    }

    @Test
    public void givenMoodAnalyserMethodName_whenNotProper_shouldReturnException() {
        try {
            Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer").getConstructor(Character.class);
        }
        catch (NoSuchMethodException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND, "Please enter the valid method name");
            }
            catch (MoodAnalysisException ex) {
                ex.printStackTrace();
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_whenNotProper_shouldReturnException() throws MoodAnalysisException {
        try {
            Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzers").getConstructor(String.class);
        }
        catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD_FOUND,"Please, enter the valid method name");
        }
        catch (ClassNotFoundException e) {
            try {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS_FOUND, "Please, enter valid class name");
            }
            catch (MoodAnalysisException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void givenMoodAnalyserClassName_whenProper_shouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyserReflector.CreateMoodAnalyser("Please, enter a valid message");
        String mood = moodAnalyzer.analyse();
        Assert.assertEquals("Happy",mood);

    }

    @Test
    public void whenGivenMoodAnalyser_whenProper_shouldReturnObject() {
        Constructor<?> constructor=null;

        try {
            constructor = Class.forName("com.bridgelabz.moodAnalyzer.MoodAnalyzer").getConstructor(String.class);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Object myObj= constructor.newInstance("i'm happy right now");
            MoodAnalyzer moodAnalyzer=(MoodAnalyzer) myObj;
            try {
                String mood = moodAnalyzer.analyse();
                Assert.assertEquals("Happy", mood);
            }
            catch (MoodAnalysisException e) {
                e.printStackTrace();
            }
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_whenProperMessage_shouldReturnTrue() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("i'm happy right now");
        MoodAnalyzer moodAnalyzer1 = MoodAnalyserReflector.CreateMoodAnalyser("i'm happy right now");
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
