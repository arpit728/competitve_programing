import com.duotech.cp.WarmHoles;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bugkiller on 27/01/18.
 */

public class WarmHoleTest {

    @Test
    public void floorTest(){
        int v[] = {1, 3, 7, 9, 13};
        assertEquals(13, WarmHoles.floor(v, 0, 4, 15));
        assertEquals(13, WarmHoles.floor(v, 0, 4, 20));
        assertEquals(-1, WarmHoles.floor(v, 0, 4, 0));
        assertEquals(1, WarmHoles.floor(v, 0, 4, 2));
        assertEquals(9, WarmHoles.floor(v, 0, 4, 10));

    }
    @Test
    public void ceilTest(){
        int w[] = {3, 7, 9, 13, 15};
        assertEquals(15, WarmHoles.ceil(w, 0, 4, 15));
        assertEquals(3, WarmHoles.ceil(w, 0, 4, 0));
        assertEquals(3, WarmHoles.ceil(w, 0, 4, 1));
        assertEquals(3, WarmHoles.ceil(w, 0, 4, 2));
        assertEquals(13, WarmHoles.ceil(w, 0, 4, 13));
        assertEquals(3, WarmHoles.ceil(w, 0, 4, -1));

    }

}
