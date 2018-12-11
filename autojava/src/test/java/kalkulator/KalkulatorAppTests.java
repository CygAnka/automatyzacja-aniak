package kalkulator;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by ANKRAWCZ on 2018-12-11.
 */
public class KalkulatorAppTests {

    @Test
    public void addTwoPositiveDoubles() {

        //given
        KalkulatorApp kalkulatorek = new KalkulatorApp();

        //when
        int suma = kalkulatorek.add(3, 5);

        //then
        assertEquals(8, suma);


    }

    @Test
    public void addTwoPositiveIntegers() {

        //given
        KalkulatorApp kalkulatorek = new KalkulatorApp();

        //when
        double suma = kalkulatorek.add(1.2, 2.4);

        //then - sprawdzenie dwoch wartosci z deltą, akceptuje wynik, ktory nie rozni sie o wiecej niz
        assertEquals(3.6, suma, 0.0000001);

    }

    @Test
    public void divideTwoPositive() {
        //given
        KalkulatorApp kalkulatorek = new KalkulatorApp();

        //when
        double divide = kalkulatorek.divide(2, 3);

        //then - sprawdzenie dwoch wartosci z deltą, akceptuje wynik, ktory nie rozni sie o wiecej niz
        assertEquals(0.666, divide, 0.001);

    }
}