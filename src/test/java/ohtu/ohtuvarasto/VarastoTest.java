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

    @Before
    public void setUp() {
        varasto = new Varasto(10);
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
    public void lisaysLisaaSaldoaLiikaa() {
        varasto.lisaaVarastoon(18);

        // saldon pitäisi olla sama kuin tilavuus eli 10
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
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
        // pitää saada 2
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
    public void ottaminenNegatiivinen() {
        varasto.lisaaVarastoon(8);

        double saatu= varasto.otaVarastosta(-2);

        // ei pitäisi saada mitään kun pyyntö negatiivinen
        assertEquals(0.0, saatu, vertailuTarkkuus);
    }
    
    
    @Test
    public void ottaminenLiikaa() {
        varasto.lisaaVarastoon(8);

        double saatu =varasto.otaVarastosta(12);

        // pitäisi saada mitä varastossa on
        assertEquals(8, saatu, vertailuTarkkuus);
    }
    
    @Test
    public void lisääNegatiivinen() {
        varasto.lisaaVarastoon(-8);

        
        // varastossa pitäisi olla tilaa 10 eli mitään ei laitettu
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    
    
    
    @Test
    public void negatiivinenVarasto() {
        Varasto lato = new Varasto(-20.0);
        // käyttökelvoton varasto
        assertEquals(0.0, lato.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenVarastoSaldolla() {
        Varasto lato = new Varasto(-20.0,10.0);
        // käyttökelvoton varasto
        assertEquals(0.0, lato.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toimivaVarastoSaldolla() {
        Varasto lato = new Varasto(20.0,10.0);
        // tilavuus eka luku
        assertEquals(20.0, lato.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toimivaVarastoStringiksi() {
        Varasto lato = new Varasto(20.0,10.0);
        // Stringin tulostusasu
        assertEquals("saldo = 10.0, vielä tilaa 10.0", lato.toString());
    }
    
    @Test
    public void toimivaVarastoNegatiivinenSaldo() {
        Varasto lato = new Varasto(20.0,-10.0);
        // tilavuus ok, mutta saldo pitäisi olla 0
        assertEquals(0.0, lato.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void toimivaVarastoLiikaaAlkusaldo() {
        Varasto lato = new Varasto(10.0,20.0);
        // ylimääräiset hukkaan eli saldo eka luku
        assertEquals(10.0, lato.getSaldo(), vertailuTarkkuus);
    }

}