package entities;

import exceptions.BusinessException;

public class Conta {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;
    
    public Conta(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(Double amount){
             balance += amount;
    }

    public void withDraw(Double amount){
            validation(amount);
            balance -= amount;
    }

    private void validation(Double amount){
        if (amount > withDrawLimit){
            throw new BusinessException("Your withdraw exceds the value of your withdraw limit");
        }
        else if (amount > balance) {
            throw new BusinessException("You withdraw exceds the value of your balance");
        }
    }


}
