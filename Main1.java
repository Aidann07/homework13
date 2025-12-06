import java.util.*;

class TicketMachine {

    interface State {
        void selectTicket();
        void insertMoney(double amount);
        void cancel();
        void dispenseTicket();
    }

    private State idleState = new IdleState();
    private State waitingForMoneyState = new WaitingForMoneyState();
    private State moneyReceivedState = new MoneyReceivedState();
    private State ticketDispensedState = new TicketDispensedState();
    private State transactionCanceledState = new TransactionCanceledState();

    private State currentState = idleState;
    private double ticketPrice;
    private double currentAmount = 0;

    public TicketMachine(double ticketPrice) { this.ticketPrice = ticketPrice; }

    public void selectTicket() { currentState.selectTicket(); }
    public void insertMoney(double amount) { currentState.insertMoney(amount); }
    public void cancel() { currentState.cancel(); }
    public void dispenseTicket() { currentState.dispenseTicket(); }

    private class IdleState implements State {
        public void selectTicket() {
            System.out.println("Билет выбран, ожидаем внесения денег.");
            currentState = waitingForMoneyState;
        }
        public void insertMoney(double amount) { System.out.println("Сначала выберите билет."); }
        public void cancel() { System.out.println("Нет активной транзакции для отмены."); }
        public void dispenseTicket() { System.out.println("Нет билета для выдачи."); }
    }

    private class WaitingForMoneyState implements State {
        public void selectTicket() { System.out.println("Билет уже выбран."); }
        public void insertMoney(double amount) {
            currentAmount += amount;
            System.out.println("Внесено: " + currentAmount);
            if (currentAmount >= ticketPrice) currentState = moneyReceivedState;
        }
        public void cancel() {
            System.out.println("Транзакция отменена.");
            currentAmount = 0;
            currentState = transactionCanceledState;
        }
        public void dispenseTicket() { System.out.println("Сначала внесите деньги."); }
    }

    private class MoneyReceivedState implements State {
        public void selectTicket() { System.out.println("Билет уже выбран."); }
        public void insertMoney(double amount) {
            currentAmount += amount;
            System.out.println("Дополнительно внесено: " + amount);
        }
        public void cancel() {
            System.out.println("Транзакция отменена.");
            currentAmount = 0;
            currentState = transactionCanceledState;
        }
        public void dispenseTicket() {
            System.out.println("Билет выдан!");
            currentAmount = 0;
            currentState = ticketDispensedState;
        }
    }

    private class TicketDispensedState implements State {
        public void selectTicket() {
            currentState = idleState;
            selectTicket();
        }
        public void insertMoney(double amount) { System.out.println("Начните новую транзакцию."); }
        public void cancel() { System.out.println("Невозможно отменить, билет уже выдан."); }
        public void dispenseTicket() { System.out.println("Билет уже выдан."); }
    }

    private class TransactionCanceledState implements State {
        public void selectTicket() { currentState = idleState; selectTicket(); }
        public void insertMoney(double amount) { System.out.println("Начните новую транзакцию."); }
        public void cancel() { System.out.println("Транзакция уже отменена."); }
        public void dispenseTicket() { System.out.println("Невозможно выдать билет, транзакция отменена."); }
    }

    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine(50);

        machine.selectTicket();
        machine.insertMoney(20);
        machine.insertMoney(30);
        machine.dispenseTicket();

        machine.selectTicket();
        machine.cancel();
    }
}
