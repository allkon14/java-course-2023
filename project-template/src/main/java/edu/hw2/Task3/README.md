### 3. **Удаленный сервер**

Программист Иван хочет выполнять часто используемые консольные команды на удаленном сервере из Java-программы.

В распоряжении Ивана следующий набор интерфейсов:

```
public interface Connection extends AutoCloseable {
void execute(String command);
}

public interface ConnectionManager {
Connection getConnection();
}

public class ConnectionException extends RuntimeException {}

public final class PopularCommandExecutor {
private final ConnectionManager manager;
private final int maxAttempts;

    public void updatePackages() {
	    tryExecute("apt update && apt upgrade -y");
    }

	void tryExecute(String command) { ... }
}
```
Пояснение:

1. работа с сервером происходит через Connection, у которого есть метод execute
2. чтобы получить соединение используется ConnectionManager
3. при выполнении команды может возникнуть исключение ConnectionException


**Задание**

Помогите Ивану и реализуйте:

1. 2 типа соединений: StableConnection / FaultyConnection, стабильное соединение работает всегда, проблемное соединение иногда бросает ConnectionException 
2. DefaultConnectionManager, который с некоторой вероятностью возвращает проблемное соединение 
3. FaultyConnectionManager, который всегда возвращает проблемное соединение 
4. Метод tryExecute, который должен попытаться выполнить переданную команду maxAttempts раз 
5. Если tryExecute не смог выполнить команду (превышено количество попыток), то нужно вернуть ConnectionException, при этом сохранив оригинальное исключение в параметре cause 
6. Обратите внимание, что Connection требуется закрывать (интерфейс AutoClose
