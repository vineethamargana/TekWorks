package com.bank.sys.dto;

public class TransactionDto {
    private int transactionid;
    private double amount;
    private String transactiontype;
    private String accountNum; // To link to account

    public TransactionDto() {
        super();
    }

    public TransactionDto(int transactionid, double amount, String transactiontype, String accountNum) {
        this.transactionid = transactionid;
        this.amount = amount;
        this.transactiontype = transactiontype;
        this.accountNum = accountNum;
    }

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String toString() {
        return "TransactionDto [transactionid=" + transactionid + ", amount=" + amount + ", transactiontype="
                + transactiontype + ", accountNum=" + accountNum + "]";
    }
}
