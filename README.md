# Курсовая работа к модулю «Java Core»: Менеджер задач

Необходимо разработать сервер, отвечающий за менеджмент списка дел. 

# TODOs
Центральным для логики программы компонентом будет **класс Todos**. Объект этого класса должен содержать в себе набор задач, добавленных в систему. 

Каждая задача представляет собой обычное значение типа `String`. Например: `"Сходить в магазин"`, `"Пойти на пробежку"`. 

Изначально объект этого класса не должен содержать никаких задач, но должна быть возможность:
- добавить их через метод `add`;
- удалить через метод `remove`. 

Также у этого объекта должна быть возможность получить все актуальные задачи разом через метод `getAllTasks` - метод возвращает все задачи через пробел **в отсортированном лексикографическом (словарном) порядке**. Например, если мы добавили задачу "Пробежка", "Акробатика" и "Учёба", то этот метод должен вернуть строку вида `Акробатика Пробежка Учёба`.

После реализации этого класса нужно написать на него тесты на основе JUnit 5, минимум 3 штуки, тестирующие его в разных сценариях. 

# Сервер
Программа должна принимать запросы на добавление или удаление задач из списка через сервер. Сервер создаётя и запускается в **классе Main**. Необходимо написать реализацию **класса Сервер**. После старта, он должен в бесконечном цикле принимать подключения и считывать с них одну строку, в которой будет располагаться json вида:
```json
{ "type": "ADD", "task": "Название задачи" }
```
где `type` - тип операции (`ADD` или `REMOVE`), а `task` - сама задача.

Для парсинга входных данных подключения воспользуемся библиотекой GSon (`com.google.code.gson:gson:2.8.9`). Мы предполагаем, что на сервер всегда приходят корректные данные.

В ответ на запрос сервер должен присылать текущее состояние списка задач после совершения операции и в том виде, в котором его возвращает операция `getAllTasks` (т.е. без всяких json и тп).

# Клиент
Для демонстрационных целей создать **класс Client**, который пытается добавить задачу со случайным именем из ограниченного набора имён. 

