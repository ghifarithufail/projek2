/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Asus
 */
@SpringBootTest
public class LearningSpringBootTests {

    class Calculator {

        int sum(int x, int y) {
            return x + y;
        }
        
        int minus(int x, int y) {
            return x - y;
        }
        
        int divide(int x, int y) {
            return x / y;
        }
        
        int multiply(int x, int y){
            return x * y;
        }
    }

    Calculator calc = new Calculator();

    @Test
    void itShouldTwenty() {
        int x = 10;
        int y = 10;

        int result = calc.sum(x, y);

        Assertions.assertThat(result).isEqualTo(20);
    }

    @Test
    void itShouldBiggerThanThirty() {
        int x = 50;
        int y = 10;

        int result = calc.sum(x, y);

        assert result > 30;
    }
}
