package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1, "name1", 20, "Manufacturer1");

    @Test
    public void shouldResultMatchIfEmptySearch() {

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultPartMatchInName() {

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "name2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultMatchIfAbsolutelyDifferentInName() {

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "pvc");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchInOneLetterInName() {

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "m");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchInTwoLettersInName() {

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "me");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfFullMatchInName() {

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "name1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchThereIsUppercaseInName() {

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "Name1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultPartMatchInManufacturer() {

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "Manufacturer2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultMatchIfAbsolutelyDifferentInManufacturer() {

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "pvc");

        assertEquals(expected, actual);
    }


    @Test
    public void shouldDoIfMatchInOneLetterInManufacturer() {

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "t");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchInTwoLettersInManufacturer() {

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "tu");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfFullMatchInManufacturer() {

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "Manufacturer1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchNoUppercaseInManufacturer() {

        boolean expected = false;
        boolean actual = smartphone.matches(smartphone, "manufacturer1");

        assertEquals(expected, actual);
    }
}

