package org.example.processes;

import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    @Test
    public void multiplytest(){
        Testmul t = new Testmul();
        int measured = t.multiply(5,6);
        int expected  = 30;
        Assert.assertEquals(expected,measured);
    }

    @Test
    public void multiplytest2(){
        Testmul t = new Testmul();
        int measured = t.multiply(7,10);
        int expected = 70;
        Assert.assertEquals(expected,measured);
    }
}
