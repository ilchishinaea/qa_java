import com.example.Animal;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AnimalTest {

    @Test
    public void getFamilyReturnsFamilyTypes() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsHerbivoreFoodList() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsPredatorFoodList() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = animal.getFood("Хищник");
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodReturnsException() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Непонятный вид");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}
