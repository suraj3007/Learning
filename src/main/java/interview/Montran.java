package main.java.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Montran {

    private static final String COMMA_SEPARATED = ",";
    private static final String FILE_PATH = "src/main/resources/montran.csv";

    public static void main(String[] args) throws ParseException{
        fetchRecordsFromCsv();
    }

    private static void fetchRecordsFromCsv() throws  ParseException{
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_SEPARATED);
                records.add(Arrays.asList(values));
            }

            Map<Long, TreeSet<Transaction>> recordsMap= getRecords(records);
            for (TreeSet<Transaction> transaction: recordsMap.values()) {
                System.out.println(transaction);
            }
        }

        catch (IOException e) {
            System.out.println(e);
        }
    }

    private static Map<Long, TreeSet<Transaction>> getRecords(List<List<String>> records) throws ParseException {
        List<Transaction> transactions = new ArrayList<>();
        records = records.stream().skip(1).collect(Collectors.toList());
        for (List<String> record : records) {
            Transaction transaction = Transaction.transactionBuilder()
                    .transactionId(record.get(0))
                    .transactionDate(new SimpleDateFormat("dd/MM/yyyy").parse(record.get(1)))
                    .transactionType(record.get(2))
                    .accountId(Long.valueOf(record.get(3)))
                    .amount(Double.valueOf(record.get(4)))
                    .build();
            transactions.add(transaction);
        }
        return getPassbook(transactions);
    }

    private static Map<Long, TreeSet<Transaction>> getPassbook(List<Transaction> transactions) {
        Map<Long, TreeSet<Transaction>> map = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (map.containsKey(transaction.getAccountId())) {
                map.get(transaction.getAccountId()).add(transaction);
            } else {
                TreeSet<Transaction> treeSet = new TreeSet<>(new TransactionComparator());
                treeSet.add(transaction);
                map.put(transaction.getAccountId(), treeSet);
            }
        }
        return map;
    }
}

class TransactionComparator implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {
        if (o1.getTransactionDate().equals(o2.getTransactionDate())) {
            return o2.getTransactionType().compareTo(o1.getTransactionType());
        } else {
            return o1.getTransactionDate().compareTo(o2.getTransactionDate());
        }
    }
}
