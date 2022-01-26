package com.cit360.week05;

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
        assertEquals(3, output);
    }

    //Test 2. AssertFalse methods checks if the output is false.
    @org.junit.jupiter.api.Test
    void evenNumber() {
        junitTest test = new junitTest();
        assertFalse(test.evenNumber(455));
    }

    //Test 3. AssertTrue checks if the output is true
    @org.junit.jupiter.api.Test
    void oddNumber() {
        junitTest test = new junitTest();
        assertTrue(test.oddNumber(456));
    }

    //Test 4. AssertNotNull checks if an object is notNull
    @org.junit.jupiter.api.Test
    void getListValue() {
        junitTest test = new junitTest();
        assertNotNull(test.getListValue(2));
    }

    //Test 5. AssertNull checks if an object is Null
    @org.junit.jupiter.api.Test
    void getListValueForNull () {
        junitTest test = new junitTest();
        assertNull(test.getListValue(3));
    }

    //Test 6. AssertSame checks that two objects refer to the same object.
    @org.junit.jupiter.api.Test
    void getListValueForSame() {
        junitTest test = new junitTest();
        assertSame(test.getListValue(0), test.getListValue(4));
    }

    //Test 7. AssertNotSame checks that two objects do not refer to the same object.
    @org.junit.jupiter.api.Test
    void testSameState () {
        junitTest test = new junitTest();
        String []  arr = test.sameState();
        assertNotSame(arr[0], arr[1]);
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

    //Test 9.
    @org.junit.jupiter.api.Test
    void arrayOfNames() {
        junitTest test = new junitTest();
        String [] names1 = test.arrayOfNames().get(0);
        String [] names2 = test.arrayOfNames().get(1);

        assertArrayEquals(names1, names2);

    }

}