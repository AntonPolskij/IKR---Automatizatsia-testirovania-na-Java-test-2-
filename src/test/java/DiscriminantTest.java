import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class DiscriminantTest {
    @Test
    public void twoAnswersTest() throws NotFoundAnswerException {
        MathService mathService = new MathService();
        Pair expected = new Pair(1.0, 2.0);
        Pair actual = mathService.getAnswer(1, -3, 2);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void oneAnswerTest() throws NotFoundAnswerException {
        MathService mathService = new MathService();
        Pair expected = new Pair(-1.0, -1.0);
        Pair actual = mathService.getAnswer(1, 2, 1);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void noAnswerTest() {
        MathService mathService = new MathService();
        try {
            mathService.getAnswer(1, 1, 1);
            fail("Expected NotFoundAnswerException");
        } catch (NotFoundAnswerException e) {
            assertEquals("Корни не могут быть найдены", e.getMessage());
        }
    }
}
