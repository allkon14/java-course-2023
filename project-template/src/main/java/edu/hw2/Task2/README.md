# Домашняя работа №2
## 2. **Квадрат и прямоугольник**
Напишите иерархию классов для вычисления математических выражений
Что может быть проще наследования... Думают все начинающие программисты.

На практике оказывается, что применение наследования очень ограничено и в реальности почти всегда лучше использовать композицию или относительно "глупые" sealed-интерфейсы (ADT).

Чтобы продемонстрировать утверждение выше, попробуем разрешить классический парадокс прямоугольника и квадрата.

Допустим, у вас есть классы Rectangle и Square с методами setWidth, setHeight и area:
```
public class Rectangle {  
    private int width;  
    private int height;  
  
    void setWidth(int width) {  
        this.width = width;  
    }  
  
    void setHeight(int height) {  
        this.height = height;  
    }  
  
    double area() {  
        return width * height;  
    }  
}  
  
public class Square extends Rectangle {  
    @Override  
    void setWidth(int width) {  
        super.setHeight(width);  
        super.setWidth(width);  
    }  
  
    @Override  
    void setHeight(int height) {  
        super.setHeight(height);  
        super.setWidth(height);  
    }  
}
```
И есть следующий тест:
```
static Arguments[] rectangles() {  
    return new Arguments[]{
        Arguments.of(new Rectangle()), 
        Arguments.of(new Square())
    };  
}  
  
@ParameterizedTest  
@MethodSource("rectangles")  
void rectangleArea(Rectangle rect) {  
    rect.setWidth(20);  
    rect.setHeight(10);  
  
    assertThat(rect.area()).isEqualTo(200.0);  
}
```
Если вы запустите этот код, то вы увидите, что один из тестов падает.

Проблема этого кода заключается в нарушении принципа подстановки Лисков:

если можно написать хоть какой-то осмысленный код, в котором замена объекта базового класса на объекта класса потомка, его сломает, то тогда не стоит их друг от друга-то наследовать.


Мы должны расширять поведение базового класса в потомках, а не существенным образом изменять его. Функции, которые используют базовый класс, должны иметь возможность использовать объекты подклассов, не зная об этом.

К сожалению проблемы с LSP встречаются постоянно даже в крупных проектах, например, в JDK:

```
static Arguments[] lists() {  
    return new Arguments[]{  
            Arguments.of(new ArrayList<Integer>()),  
            Arguments.of(Collections.unmodifiableList(new ArrayList<Integer>()))  
    };  
}  
  
@ParameterizedTest  
@MethodSource("lists")  
void addElement(List<Integer> list) {  
    list.add(1);  
  
    assertThat(list).hasSize(1).containsExactly(1);  
}

```
**Задание**

Найдите решение проблемы, удовлетворяющее следующим ограничениям:

1. Не нарушается математическая логика, то есть квадрат является прямоугольником с точки зрения типизации
2. При этом не нарушается принцип подстановки
3. Все так же присутствует понятие высоты и ширины, а также операция вычисления площади
4. Реализация класса Rectangle не должна предполагать существование класса Square, иными словами, не нарушен принцип открытости-закрытости


Если всё-таки не получится придумать решение самостоятельно, то воспользуйтесь подсказками ниже:

подсказка 1: методы setWidth/setHeight могут что-то возвращать

подсказка 2: может пригодиться ключевое слово final
