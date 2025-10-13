import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class LionTest {

    private Feline feline;

    @BeforeEach
    public void createMockFeline(){
        Feline feline = Mockito.mock(Feline.class);
    }

    @Test
    public void constructorSetsHasManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.hasMane);
    }

    @Test
    public void constructorSetsHasManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.hasMane);
    }

    @Test
    public void constructorThrowsException () throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Тест", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    public void getKittensReturnsValueOne() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeForMaleReturnsTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeForFemaleReturnsFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void getFoodReturnsPredatorFoodList() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> expected = feline.getFood("Хищник");
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}
