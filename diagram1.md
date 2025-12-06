```mermaid
stateDiagram-v2
    [*] --> Idle

    Idle --> WaitingForMoney: Выбор билета
    WaitingForMoney --> MoneyReceived: Внесение денег
    MoneyReceived --> TicketDispensed: Выдача билета

    WaitingForMoney --> TransactionCanceled: Отмена
    MoneyReceived --> TransactionCanceled: Отмена

    TicketDispensed --> Idle: Завершение
    TransactionCanceled --> Idle: Завершение
```
