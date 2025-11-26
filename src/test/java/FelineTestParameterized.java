import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FelineTestParameterized {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "10, 10",
            "0, 0",
            "-1, -1"
    })

    public void getKittensReturnsCorrectCount(int kittensCount, int expected) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(expected, actual);
    }
}
