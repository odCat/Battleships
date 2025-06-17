package com.mg;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class TestField
{
    @Test
    void testIsValidField()
    {
        String[] goodTestValues = { "11", "77", "A1", "b4" };
        String[] badTestValues = { "ABC", "88", "00", "AA", "Z1" };

        for (String value : goodTestValues)
            assertTrue(Field.isValidField(value));

        for (String value : badTestValues)
            assertFalse(Field.isValidField(value));
    }

    @Test
    void testEquls()
    {
        Field fieldOne = new Field(1, 1);
        Field fieldTwo = new Field(1, 1);

        assertFalse(fieldOne.equals(fieldTwo));
    }

    @Test
    void testFieldNotEqualToNull()
    {
        Field aField = new Field(1, 1);
        Field nullField = null;

        assertFalse(aField.equals(nullField));
    }

    @Test
    void testFieldNotEqualToOtherObject()
    {
        Field aField = new Field(1, 1);
        Object anObject = new Object();

        assertFalse(aField.equals(anObject));
    }
}
