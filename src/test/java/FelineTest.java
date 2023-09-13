import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline felineNew;
    @Test
    public void checkEatMeatTest() throws Exception{
        felineNew.eatMeat();
        Mockito.verify(felineNew).getFood("Хищник");
    }
    @Test
    public void checkGetFamilyTest(){
      String actual = felineNew.getFamily();
      String expected ="Кошачьи";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void checkGetKittensWithOutParamTest(){
        felineNew.getKittens();
        Mockito.verify(felineNew).getKittens(1);
    }
    @Test
    public void checkGetKittensWithParamTest(){
        int kittensCount = 5;
        int expectedKittenCount= felineNew.getKittens(kittensCount);
        Assert.assertEquals(expectedKittenCount, kittensCount);
    }
}
