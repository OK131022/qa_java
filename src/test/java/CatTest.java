import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline felineMock;


    @Test
    public void checkGetSoundTest(){
        Cat cat = new Cat(felineMock);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        assertEquals(expectedSound,actualSound);

    }

    @Test
    public void checkGetFoodTest() throws Exception{
        Cat cat = new Cat(felineMock);
        List<String> expectedResult = List.of("Животные","Птицы","Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные","Птицы","Рыба"));
        List<String> actualResult = cat.getFood();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
