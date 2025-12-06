```mermaid
graph TD
  direction LR

  %% Актерлерді анықтау
  actor[Читатель] as Reader
  actor[Библиотекарь] as Librarian
  actor[Администратор] as Admin

  %% Актерлер арасындағы иерархия (Mermaid-те : : generalization сияқты қатынас әдісі қолданылады)
  Librarian --|> Reader
  Admin --|> Librarian

  %% Қолдану жағдайларын анықтау
  subgraph Система управления сетью библиотек
    (Регистрация пользователя) as UC_Register
    (Просмотр книг) as UC_View
    (Поиск книг) as UC_Search
    (Бронирование книги) as UC_Book
    (Отмена бронирования) as UC_Cancel
    (История бронирований) as UC_History

    (Управление книгами) as UC_BookManage
    (Добавление книги) as UC_Add
    (Удаление книги) as UC_Delete
    (Учет выдачи/возврата) as UC_Issue
    (Просмотр активных бронирований) as UC_Active

    (Управление филиалами) as UC_Branch
    (Управление учетными записями) as UC_Users
    (Просмотр аналитики) as UC_Analytics
  end

  %% Қатынастар
  %% Оқырман
  Reader --> UC_Register
  Reader --> UC_View
  Reader --> UC_Search
  Reader --> UC_Book
  Reader --> UC_Cancel
  Reader --> UC_History

  %% Кітапханашы
  Librarian --> UC_BookManage
  Librarian --> UC_Issue
  Librarian --> UC_Active

  %% Әкімші
  Admin --> UC_Branch
  Admin --> UC_Users
  Admin --> UC_Analytics

  %% Include/Extend
  UC_Search ..> UC_View : <<include>>
  UC_Book ..> UC_View : <<include>>
  UC_Cancel ..> UC_Book : <<extend>>

  UC_BookManage ..> UC_Add : <<include>>
  UC_BookManage ..> UC_Delete : <<include>>
```
