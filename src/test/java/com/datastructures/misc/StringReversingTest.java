package com.datastructures.misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReversingTest {

    @Test
    public void testReverseString() {

        String str = "This is junit framework";
        String actualString = StringReversing.reverseString(str);
        assertEquals("framework junit is This", actualString.trim());
    }

    @Test
    public void testReverseString_WhenStringIsEmpty() {
        String str = StringReversing.reverseString("");
        assertEquals("", str.trim());
    }

    @Test
    public void testReverseStringUsingSplit() {
        String str = "I am having fun programming";
        String actualString = StringReversing.reverseStringUsingSplit(str);
        assertEquals("programming fun having am I", actualString.trim());
    }

    @Test
    public void testReverseStringUsingSplit_WhenStringIsEmpty() {
        String str = StringReversing.reverseString("");
        assertEquals("", str.trim());
    }

    @Test
    public void testReverseStringMoreManualWay() {
        String str = "Junit is awesome unit testing framework";
        String actualString = StringReversing.reverseStringUsingSplit(str);
        assertEquals("framewro", actualString.trim());
    }

    @Test
    public void testReverseStringMoreManualWay_WhenStringIsEmpty() {
        String str = StringReversing.reverseString("");
        assertEquals("", str.trim());
    }

}