import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamTest {
    private final String sex;
    private final boolean hashMane;

    Feline felineMock;

    public  LionParamTest (String sex, boolean hasMane){
        this.sex=sex;
        this.hashMane=hasMane;
    }
    @Parameterized.Parameters(name = "Проверка наличия гривы {0} - {1}")
   public static Object[][] params(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void checkManeTest() throws Exception{
        Lion lion = new Lion(felineMock, sex);
        Assert.assertEquals(hashMane, lion.doesHaveMane());
    }

}
