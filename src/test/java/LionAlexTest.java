import com.example.Feline;
import com.example.LionAlex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LionAlexTest {

    private Feline feline;

    @BeforeEach
    public void createMockFeline() {
        Feline feline = Mockito.mock(Feline.class);
    }

    @Test
    public void constructorSetsHasManeCorrect() throws Exception {
        LionAlex alex = new LionAlex(feline);
        assertTrue(alex.hasMane);
    }

    @Test
    public void getFriendsReturnsListForAlex() throws Exception {
        LionAlex alex = new LionAlex(feline);
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        List<String> actual = alex.getFriends();
        assertEquals(expected, actual);
    }

    @Test
    public void getPlaceOfLivingReturnsStringNewYorkZoo() throws Exception {
        LionAlex alex = new LionAlex(feline);
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensReturnsIntZero() throws Exception {
        LionAlex alex = new LionAlex(feline);
        int actual = alex.getKittens();
        assertEquals(0, actual);
    }
}
