package org.example.prcoesses;

import org.example.processes.Assertionstest;
import org.junit.Assert;
import org.junit.Test;

public class AssertionsTestCases {
    @Test
    public void assertiontests(){
        // Assert true
        Assert.assertTrue(5 > 3);
        // Assert false
        Assert.assertFalse(5 < 3);
        // Assert null
        Assert.assertNull(null);
        // Assert not null
        Assert.assertNotNull(new Assertionstest());
    }
}
