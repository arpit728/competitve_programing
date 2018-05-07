package com.duotech.cp;

import org.junit.Test;

import static com.duotech.cp.FibonacciSum.fib;
import static org.testng.AssertJUnit.assertEquals;

public class FibonacciSumTest {

    @Test
    public void fibTest() {
        assertEquals(1,fib(1));
    }
}