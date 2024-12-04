package org.example;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {

    public static FinanceReport filterSurname(FinanceReport report, char index) {
        String fall = "Нет фамилий начинающихся на букву '" + index + "'";
        List<Payment> SortPayments = new ArrayList<>();
        char index1 = Character.toUpperCase(index);
        for (Payment payment : report.payments()) {
            String[] parts = payment.getFullName().split(" ");
            if (parts.length > 0 && parts[0].startsWith(String.valueOf(index1))) {
                SortPayments.add(payment);
            }
        }

        if (SortPayments.isEmpty()) {
            SortPayments.add(new Payment(fall));
        }
        return new FinanceReport(report.fullNameAuthor(), report.dateReport(),
                SortPayments.toArray(new Payment[0]));
    }

    public static FinanceReport filterSum(FinanceReport report, int maxSum) {
        String fall = "Нет платежей меньших '" + maxSum + "'";
        List<Payment> SortPayments = new ArrayList<>();
        for (Payment payment : report.payments()) {
            if (payment.getSum() < maxSum) {
                SortPayments.add(payment);
            }
        }

        if (SortPayments.isEmpty()) {
            SortPayments.add(new Payment(fall));
        }
        return new FinanceReport(report.fullNameAuthor(), report.dateReport(),
                SortPayments.toArray(new Payment[0]));
    }
}
