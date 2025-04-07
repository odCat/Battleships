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
}
