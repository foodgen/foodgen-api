package com.genfood.foodgenback;

import com.genfood.foodgenback.service.ClassTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClass {
        @Test
        public void incorrectWeight() {
            ClassTest test = new ClassTest();
            assertThrows(IllegalStateException.class, () -> test.calculateShippingFee(-1));
        }

        @Test
        public void firstRangeWeight() {
            ClassTest test = new ClassTest();
            assertEquals(5, test.calculateShippingFee(1));
        }

        @Test
        public void secondRangeWeight() {
            ClassTest test = new ClassTest();
            assertEquals(10, test.calculateShippingFee(4));
        }

        @Test
        public void lastRangeWeight() {
            ClassTest test = new ClassTest();
            assertEquals(15, test.calculateShippingFee(10));
        }
}
