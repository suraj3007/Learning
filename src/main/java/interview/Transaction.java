package main.java.interview;

import java.util.Date;

public class Transaction {

    private final String transactionId;
    private final Date transactionDate;
    private final String transactionType;
    private final long accountId;
    private final double amount;

    private Transaction(TransactionBuilder builder) {
        this.transactionId = builder.transactionId;
        this.transactionDate = builder.transactionDate;
        this.transactionType = builder.transactionType;
        this.accountId = builder.accountId;
        this.amount = builder.amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionType='" + transactionType + '\'' +
                ", accountId=" + accountId +
                ", amount=" + amount +
                '}';
    }

    public String getTransactionType() {
        return transactionType;
    }

    public long getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    public static TransactionBuilder transactionBuilder() {
        return new TransactionBuilder();
    }

    public static class TransactionBuilder {
        private String transactionId;
        private Date transactionDate;
        private String transactionType;
        private long accountId;
        private double amount;

        private TransactionBuilder() {}

        public TransactionBuilder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public TransactionBuilder transactionDate(Date transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public TransactionBuilder transactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public TransactionBuilder accountId(Long accountId) {
            this.accountId = accountId;
            return this;
        }

        public TransactionBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
