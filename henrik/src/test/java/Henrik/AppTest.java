package Henrik;

import org.junit.Test;
import java.time.*;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testBonusmemberexception() {
        try{
            BonusMember bm = new BasicMember(12, null, null);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPersonalsexception(){
        try{
            Personals p = new Personals(null, null, "test", "123");
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testBonusMemberException(){
        BonusMember np = new GoldMember(99948, new Personals("test", "test2", "test3", "123"), LocalDate.now(), 200);
        try{
            np.findQualificationPoints(null);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
