# Домашняя работа №2
## 1. **Калькулятор выражений**
Напишите иерархию классов для вычисления математических выражений

1. **Базовый абстрактный класс.**

```
public sealed interface Expr {
    double evaluate();

    public record Constant implements Expr {}
    public record Negate implements Expr {}
    public record Exponent implements Expr {}
    public record Addition implements Expr {}
    public record Multiplication implements Expr {}
}
```

Разбор строковых представлений выражений не требуется, достаточно чтобы работал код вида

```
    var two = new Constant(2);
    var four = new Constant(4);
    var negOne = new Negate(new Constant(1));
    var sumTwoFour = new Addition(two, four);
    var mult = new Multiplication(sumTwoFour, negOne);
    var exp = new Exponent(mult, 2);
    var res = new Addition(exp, new Constant(1));

    System.out.println(res + " = " + res.evaluate());
```
