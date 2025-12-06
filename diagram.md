```mermaid
%% Use Case диаграммасы
%% left to right бағытында
%% Актерлер және олардың байланыстары

%% Актерлер
actor Reader as "Читатель"
actor Librarian as "Библиотекарь"
actor Admin as "Администратор"

%% Мұрагерлік қатынасы
Librarian --> Reader
Admin --> Librarian

%% Use Case блоктары
%% Система управления сетью библиотек
%% Reader Use Cases
usecase UC_Register as "Регистрация пользователя"
usecase UC_View as "Просмотр книг"
usecase UC_Search as "Поиск книг"
usecase UC_Book as "Бронирование книги"
usecase UC_Cancel as "Отмена бронирования"
usecase UC_History as "История бронирований"

%% Librarian Use Cases
usecase UC_BookManage as "Управление книгами"
usecase UC_Add as "Добавление книги"
usecase UC_Delete as "Удаление книги"
usecase UC_Issue as "Учет выдачи/возврата"
usecase UC_Active as "Просмотр активных бронирований"

%% Admin Use Cases
usecase UC_Branch as "Управление филиалами"
usecase UC_Users as "Управление учетными записями"
usecase UC_Analytics as "Просмотр аналитики"

%% Актерлермен байланыс
Reader --> UC_Register
Reader --> UC_View
Reader --> UC_Search
Reader --> UC_Book
Reader --> UC_Cancel
Reader --> UC_History

Librarian --> UC_BookManage
Librarian --> UC_Issue
Librarian --> UC_Active

Admin --> UC_Branch
Admin --> UC_Users
Admin --> UC_Analytics

%% Use Case байланыстары
UC_Search --> UC_View
UC_Book --> UC_View
UC_Cancel -.-> UC_Book

UC_BookManage --> UC_Add
UC_BookManage --> UC_Delete

```
