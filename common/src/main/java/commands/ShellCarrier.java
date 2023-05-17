package commands;

import java.io.Serializable;

/**
 * Удерживает Носитель для передачи его на серверную сторону
 * Класс используется таким образом, чтобы использовать только один объект для всех сообщений
 * отправляется с клиента на сервер, что упрощает десериализацию
 * объект и приведите его в действие
 * Отсюда и название, оно обеспечивает оболочку для носителя
 */
public record ShellCarrier(Carrier carrier) implements Serializable {
}
