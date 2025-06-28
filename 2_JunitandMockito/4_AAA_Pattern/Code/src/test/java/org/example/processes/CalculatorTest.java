package org.example.processes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    // Setup: runs before each test
    @Before
    public void setUp() {
        calculator = new Calculator();  // Arrange
        System.out.println("Setup: Calculator instance created");
    }

    // Teardown: runs after each test
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator instance set to null");
    }

    @Test
    public void testAddition() {
        // Arrange (already done in setUp)

        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange (already done in setUp)

        // Act
        int result = calculator.subtract(10, 3);

        // Assert
        assertEquals(7, result);
    }
}
