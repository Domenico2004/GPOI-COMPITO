import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestEAN13 {
    
    private EAN13 ean13;

    @Before
    public void init(){
        ean13 = new EAN13();
    }

    @Test 
    public void testEanVerificaCodiceValido(){
        ean13.setCodice("3614273613422");
        assertTrue(ean13.verificaCodice());
    }

    @Test
    public void testEanVerificaCodiceNonValido(){
        ean13.setCodice("36142736136379");
        assertFalse(ean13.verificaCodice());
    }

    @Test
    public void testEanVerificaCodiceLunghezzaNonValida(){
        ean13.setCodice("3614273613");
        assertFalse(ean13.verificaCodice());
    }

    @Test
    public void testEanVerificaCodiceVuoto(){
        ean13.setCodice("");
        assertFalse(ean13.verificaCodice());
    }

}