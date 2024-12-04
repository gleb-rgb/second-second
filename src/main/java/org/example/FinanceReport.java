package org.example;

public record FinanceReport(String fullNameAuthor, String dateReport, Payment[] payments) {
    public FinanceReport(String fullNameAuthor, String dateReport, Payment[] payments) {
        this.fullNameAuthor = fullNameAuthor;
        this.dateReport = dateReport;
        this.payments = new Payment[payments.length];
        System.arraycopy(payments, 0, this.payments, 0, payments.length);
    }

    @Override
    public String toString() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(String.format("Автор: %s, дата: %s, Платежи: [\n", fullNameAuthor, dateReport));
        for (Payment payment : payments) {
            reportBuilder.append(" ").append(payment).append("\n");
        }
        reportBuilder.append("]");
        return reportBuilder.toString();
    }
}
