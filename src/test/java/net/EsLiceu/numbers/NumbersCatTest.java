package net.EsLiceu.numbers;

import net.esliceu.numbers.NumbersCat;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumbersCatTest {

    @Test
    public void donat_0() {
        assertEquals("Zero", NumbersCat.say(0));
    }

    @Test
    public void donat_1() {
        assertEquals("Un", NumbersCat.say(1));
    }

    @Test
    public void donat_menys3() {
        assertEquals("Donat -3 ens torna Menys Tres", "Menys tres", NumbersCat.say(-3));
    }

    @Test
    public void donat_20() {
        assertEquals("Vint", NumbersCat.say(20));
        assertEquals("Vint-i-dos", NumbersCat.say(22));
    }

    @Test
    public void decenas() {
        assertEquals("Trenta", NumbersCat.say(30));
        assertEquals("Quaranta", NumbersCat.say(40));
        assertEquals("Cinquanta", NumbersCat.say(50));
        assertEquals("Seixanta", NumbersCat.say(60));
        assertEquals("Setanta", NumbersCat.say(70));
        assertEquals("Vuitanta", NumbersCat.say(80));
        assertEquals("Noranta", NumbersCat.say(90));
    }


    @Test
    public void donat_100() {
        assertEquals("Cent", NumbersCat.say(100));
    }

    @Test
    public void donat_centenars() {
        assertEquals("Cent cinc", NumbersCat.say(105));
        assertEquals("Cent vint-i-cinc", NumbersCat.say(125));
        assertEquals("Cent noranta-nou", NumbersCat.say(199));
        assertEquals("Dos-cents", NumbersCat.say(200));
        assertEquals("Dos-cents cinquanta-sis", NumbersCat.say(256));
        assertEquals("Quatre-cents vint-i-dos", NumbersCat.say(422));
        assertEquals("Sis-cents seixanta-sis", NumbersCat.say(666));
        assertEquals("Nou-cents noranta-nou", NumbersCat.say(999));
    }

    @Test
    public void donat_1000() {
        assertEquals("Mil", NumbersCat.say(1000));
    }

    @Test
    public void donat_milers() {
        assertEquals("Mil vint-i-cinc", NumbersCat.say(1025));
        assertEquals("Vint-i-un mil vint-i-cinc", NumbersCat.say(21025));
        assertEquals("Vuit-cents cinquanta-un mil set-cents vint-i-cinc", NumbersCat.say(851725));
        assertEquals("Nou-cents noranta-nou mil nou-cents noranta-nou", NumbersCat.say(999999));
    }

    @Test
    public void donat_851725() {
        assertEquals("Vuit-cents cinquanta-un mil set-cents vint-i-cinc", NumbersCat.say(851725));
    }
}

