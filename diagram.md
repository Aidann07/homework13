```mermaid
%% Use Case диаграммасы
%% left to right бағытында
%% Актерлер және олардың байланыстары
%% Mermaid синтаксисі үшін actor және usecase атаулар қарапайым түрде беріледі

%% Актерлер
actor Reader as "Читатель"
actor Librarian as "Библиотекарь"
actor Admin as "Администратор"

%% Актерлер арасындағы мұрагерлік қатынас
Librarian --|> Reader
Admin --|> Librarian

%% Use Case-тер
UC_Register["Регистрация пользователя"]
UC_View["Просмотр книг"]
UC_Search["Поиск книг"]
UC_Book["Бронирование книги"]
UC_Cancel["Отмена бронирования"]
UC_History["История бронирований"]

UC_BookManage["Управление книгами"]
UC_Add["Добавление книги"]
UC_Delete["Удаление книги"]
UC_Issue["Учет выдачи/возврата"]
UC_Active["Просмотр активных бронирований"]

UC_Branch["Управление филиалами"]
UC_Users["Управление учетными записями"]
UC_Analytics["Просмотр аналитики"]

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
