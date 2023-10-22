# Домашняя работа №2
## 4. **Кто вызвал функцию?**
Напишите статическую функцию **callingInfo**, которая возвращает
```
public record CallingInfo(String className, String methodName) {}
```
Для получения доступа к стеку вызова используйте метод **Throwable#getStackTrace**.
