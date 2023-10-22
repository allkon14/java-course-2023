package edu.hw2.Task1;

public sealed interface Expr{
    double evaluate();
    public record Addition(double digit1, double digit2) implements Expr {
        public Addition(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        @Override
        public double evaluate() {
            return digit1 + digit2;
        }
        @Override
        public String toString() {
            return this.digit1 + " + " + this.digit2 + " = " + this.evaluate();
        }


    }
    public record Constant(double digit) implements Expr {
        @Override
        public double evaluate() {
            return digit;
        }
    }
    public record Exponent(double digit, int pow) implements Expr {
        public Exponent(Expr expr, int pow) {
            this(expr.evaluate(), pow);
        }

        @Override
        public double evaluate() {
            double res = 1;
            if (pow > 0) {
                for (int i = 1; i <= pow; i++) {
                    res *= digit;
                }
            } else {
                for (int i = 0; i > pow; i--) {
                    res /= digit;
                }
            }
            return res;
        }
    }
    public record Multiplication(double digit1, double digit2) implements Expr {
        public Multiplication(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        @Override
        public double evaluate() {
            return digit1 * digit2;
        }
        @Override
        public String toString() {
            return this.digit1 + " * " + this.digit2 + " = " + this.evaluate();
        }
    }
    public record Negate(double digit) implements Expr {
        public Negate(Expr expr) {
            this(expr.evaluate());
        }

        @Override
        public double evaluate() {
            return -digit;
        }
    }

}
