package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    

    @Test
    public void konstr() {
        varasto = new Varasto(-1);
        varasto = new Varasto(0);
        varasto = new Varasto(1,1);
        varasto = new Varasto(1,2);
        varasto = new Varasto(-1,2);
        varasto = new Varasto(-1,-1);
        varasto.toString();
    }

    /**
     * Test of getSaldo method, of class Varasto.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        Varasto instance = new Varasto(2,1);
        double expResult = 1.0;
        double result = instance.getSaldo();
        assertEquals(expResult, result, 1.0);
    }

    /**
     * Test of getTilavuus method, of class Varasto.
     */
    @Test
    public void testGetTilavuus() {
        System.out.println("getTilavuus");
        Varasto instance = new Varasto(8);
        double expResult = 8.0;
        double result = instance.getTilavuus();
        assertEquals(expResult, result, 8.0);
    }

    /**
     * Test of paljonkoMahtuu method, of class Varasto.
     */
    @Test
    public void testPaljonkoMahtuu() {
        System.out.println("paljonkoMahtuu");
        Varasto instance = new Varasto(8);
        double expResult = 8.0;
        double result = instance.paljonkoMahtuu();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of lisaaVarastoon method, of class Varasto.
     */
    @Test
    public void testLisaaVarastoon() {
        System.out.println("lisaaVarastoon");
        double maara = 2;
        Varasto instance = new Varasto(8,2);
        instance.lisaaVarastoon(maara);
    }

    /**
     * Test of otaVarastosta method, of class Varasto.
     */
    @Test
    public void testOtaVarastosta() {
        System.out.println("otaVarastosta");
        double maara = 2.0;
        Varasto instance = new Varasto(8,2);
        double expResult = 2.0;
        double result = instance.otaVarastosta(maara);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testOtaMiinus(){
        double maara = -1.0;
        Varasto instance = new Varasto(8,2);
        double expResult = 0.0;
        double result = instance.otaVarastosta(maara);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testOtaLiikaa(){
        double maara = 7.0;
        Varasto instance = new Varasto(8,2);
        double expResult = 2.0;  
        double result = instance.otaVarastosta(maara);
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testLisaaMiinus(){
        double maara = -1.0;
        Varasto instance = new Varasto(8,2);
        double expResult = 2.0;
        instance.lisaaVarastoon(maara);
        assertEquals(expResult, instance.getSaldo(), 0.0);
    }
    @Test
    public void testLisaaLiikaa(){
        double maara = 7.0;
        Varasto instance = new Varasto(8,2);
        double expResult = 8.0;
        instance.lisaaVarastoon(maara);
        assertEquals(expResult, instance.getSaldo(), 0.0);
    }
    
    /**
     * Test of toString method, of class Varasto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Varasto instance = new Varasto(8,2);
        String expResult = "saldo = 2.0, vielä tilaa 6.0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}