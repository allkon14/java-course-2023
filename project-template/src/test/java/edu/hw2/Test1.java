package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.hw2.Task1.Expr;

public class Test1 {
    @Test
    @DisplayName("Проверка всех операций")
    void checkExpr1() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        double expectedResult = 37.0;

        assertEquals(expectedResult, res.evaluate());
    }

    @Test
    @DisplayName("Проверка умножения")
    void checkExpr2() {
        double expectedResult = -24;
        var mul = new Expr.Multiplication(8, -3);

        assertEquals(expectedResult, mul.evaluate());

        expectedResult = 0;
        mul = new Expr.Multiplication(-998, 0);
        assertEquals(expectedResult, mul.evaluate());
    }

    @Test
    @DisplayName("Проверка Exponent")
    void checkExpr3() {
        double expectedResult = 81;
        var exp = new Expr.Exponent(9, 2);
        assertEquals(expectedResult, exp.evaluate());

        expectedResult = 1. / 81;
        exp = new Expr.Exponent(9, -2);
        assertEquals(expectedResult, exp.evaluate());

    }
}
