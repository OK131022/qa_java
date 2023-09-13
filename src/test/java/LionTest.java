import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline felineMock;

    @Test
    public void checkDoesHaveMane() {
        try {
            Lion lion = new Lion(felineMock, "Male");
            lion.doesHaveMane();
            Assert.fail("Некорректное значение");
        }

        catch (Exception exception) {
            String expectedTextException = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedTextException, exception.getMessage());
        }
    }

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion(felineMock, "Самка");
        int expectedCountKittens = 1;
        Mockito.when(felineMock.getKittens()).thenReturn(expectedCountKittens);
        int actualCountKittens = lion.getKittens();
        assertEquals(expectedCountKittens, actualCountKittens);
    }
    @Spy
    Feline felineNew;
    @Test
    public void checkLionGetFood() throws Exception {
        Lion lion = new Lion(felineNew, "Самец");
        List<String> actualLionFood = lion.getFood();
        Mockito.verify(felineNew).getFood("Хищник");
        List<String> expectedLionFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedLionFood, actualLionFood);
    }

}
