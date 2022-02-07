package com.cit360.week05;

import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

class someJUnitTest {
    //Test 1. AssertEquals
    @org.junit.jupiter.api.Test
    void countA() {
        junitTest test = new junitTest();
        int output = test.countA("Ameliorated because of mine");
        try {
            assertEquals(3, output); //good test
            assertEquals(8, output); //bad test
        }
        catch (AssertionFailedError afe) {
            System.out.println("------ AssertEquals Test ------");
            System.err.println(afe.getMessage());
/*            System.err.println("This is wrong. Your Input: " +afe.getExpected().getStringRepresentation() +
                    " \n\tCorrect Answer (Actual): " +afe.getActual().getStringRepresentation());*/
        }

    }

    //Test 2. AssertFalse methods checks if the output is false.
    @org.junit.jupiter.api.Test
    void evenNumber() {
        junitTest test = new junitTest();
        int goodTest = 455;
        int badTest = 456;
        try {
            assertFalse(test.evenNumber(goodTest)); //good test
            assertFalse(test.evenNumber(badTest)); //bad test
        }
        catch (AssertionFailedError afe) {
            System.out.println("------ AssertFalse ------");
            System.err.println(afe.getMessage());
        }

    }

    //Test 3. AssertTrue checks if the output is true
    @org.junit.jupiter.api.Test
    void oddNumber() {
        junitTest test = new junitTest();
        int goodTest = 456;
        int badTest = 457;
        try {
            assertTrue(test.evenNumber(goodTest)); //good test
            assertTrue(test.evenNumber(badTest)); //bad test
        }
        catch (AssertionFailedError afe) {
            System.out.println("------ AssertTrue Test ------");
            System.err.println(afe.getMessage());
        }
    }


    //Test 4. AssertNotNull checks if an object is notNull
    @org.junit.jupiter.api.Test
    void getListValue() {
        junitTest test = new junitTest();
        try {
            assertNotNull(test.getListValue(2)); //good test
            assertNotNull(test.getListValue(3)); //bad test.
        }
        catch(AssertionFailedError aFe) {
            System.out.println("------ AssertNotNull Test ------");
            System.err.println("The test expected a " +
                    aFe.getMessage());
        }
    }

    //Test 5. AssertNull checks if an object is Null
    @org.junit.jupiter.api.Test
    void getListValueForNull () {
        junitTest test = new junitTest();

        try {
            assertNull(test.getListValue(4)); //bad test
            assertNull(test.getListValue(3));//good test
        }
        catch (AssertionFailedError afe) {
            System.out.println("------ AssertNull Test ------");
            System.err.println("The test expected a " +
                    afe.getExpected().getStringRepresentation() + "."+
                    " Instead it received: " +afe.getActual().getStringRepresentation());
        }
    }

    //Test 6. AssertSame checks that two objects refer to the same object.
    @org.junit.jupiter.api.Test
    void getListValueForSame() {
        junitTest test = new junitTest();
        try {
            assertSame(test.getListValue(1), test.getListValue(4)); //bad test
            assertSame(test.getListValue(0), test.getListValue(4)); //good test
        }
        catch (AssertionFailedError afe) {
            System.out.println("------- AssertSame Test -------");
            System.err.println(afe.getExpected().getStringRepresentation() + " and " +
                    afe.getActual().getStringRepresentation() + " needs to be the same or refer to the same object");
        }

    }

    //Test 7. AssertNotSame checks that two objects do not refer to the same object.
    @org.junit.jupiter.api.Test
    void testSameState () {
        junitTest test = new junitTest();
        String []  arr = test.sameState();
        try {
            assertNotSame(arr[0], arr[1]);; //good test
            assertNotSame(test.getListValue(0), test.getListValue(4)); //bad test
        }
        catch (AssertionFailedError afe) {
            System.out.println("--------- AssertNotSame Test ---------");
            System.err.println(afe.getMessage());
        }

    }

    //Test 8. This test has more features than the assertEquals. You
    //can use it to check if a value contains something or if it is equal to a value or
    //if it is a value is false.
    @org.junit.jupiter.api.Test
    void square() {
        junitTest test = new junitTest();
        int output = test.square(5);
        //assertThat(output, is(25));
        assertThat(output, isA(int.class));
    }

    //Test 9. AssertArrayEquals
    @org.junit.jupiter.api.Test
    void arrayOfNames() {
        junitTest test = new junitTest();
        String [] names1 = test.arrayOfNames().get(0);
        String [] names2 = test.arrayOfNames().get(1);
        String [] names3 = test.arrayOfNames().get(2);

        try {
            assertArrayEquals(names1, names2);
            assertArrayEquals(names1, names3);
        }
        catch (AssertionFailedError aFe) {
            System.out.println("-------- AssertArrayEquals Test --------");
            System.err.println(aFe.getMessage());
        }


    }

}