```mermaid
%% Диаграмма: Система управления сетью библиотек
%% Mermaid Use Case approximation

%% Акторлар
actor Читатель as Reader
actor Библиотекарь as Librarian
actor Администратор as Admin

%% Use Cases
usecase "Регистрация пользователя" as UC_Register
usecase "Просмотр книг" as UC_View
usecase "Поиск книг" as UC_Search
usecase "Бронирование книги" as UC_Book
usecase "Отмена бронирования" as UC_Cancel
usecase "История бронирований" as UC_History

usecase "Управление книгами" as UC_BookManage
usecase "Добавление книги" as UC_Add
usecase "Удаление книги" as UC_Delete
usecase "Учет выдачи/возврата" as UC_Issue
usecase "Просмотр активных бронирований" as UC_Active

usecase "Управление филиалами" as UC_Branch
usecase "Управление учетными записями" as UC_Users
usecase "Просмотр аналитики" as UC_Analytics

%% Связи
Reader --> UC_Register
Reader --> UC_View
Reader --> UC_Search
Reader --> UC_Book
Reader --> UC_Cancel
Reader --> UC_History

UC_Search ..> UC_View : <<include>>
UC_Book ..> UC_View : <<include>>
UC_Cancel ..> UC_Book : <<extend>>

Librarian --> UC_BookManage
Librarian --> UC_Issue
Librarian --> UC_Active

UC_BookManage ..> UC_Add : <<include>>
UC_BookManage ..> UC_Delete : <<include>>

Admin --> UC_Branch
Admin --> UC_Users
Admin --> UC_Analytics

%% Иерархия актеров (Mermaid напрямую не поддерживает, можно показать через комментарий)
%% Librarian -> Читатель
%% Admin -> Librarian
```
