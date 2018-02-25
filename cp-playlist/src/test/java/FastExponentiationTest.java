import org.junit.Test;

import static com.duotech.cp.LVADER.pow;
import static org.junit.Assert.assertEquals;

/**
 * Created by bugkiller on 16/02/18.
 */

public class FastExponentiationTest {

    @Test
    public void powTest(){
        assertEquals(1, pow(2, 0));
        assertEquals(2, pow(2, 1));
        assertEquals(4, pow(2, 2));
        assertEquals(8, pow(2, 3));
        assertEquals(16, pow(2, 4));
        assertEquals(81, pow(3, 4));
        assertEquals(4, pow(4, 1));
        assertEquals(25, pow(5, 2));
        assertEquals(125, pow(5, 3));
        assertEquals(729, pow(9, 3));
    }
}
