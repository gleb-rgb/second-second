package org.example;

public class Main {
    public static void main(String[] args) {
        Payment payment1 = new Payment("Иванов Иван Иванович", 15, 11, 2024, 12345);
        Payment payment2 = new Payment("Петров Петр Петрович", 16, 11, 2024, 98765);
        Payment payment3 = new Payment("Сидоров Сергей Сергеевич", 17, 11, 2024, 54321);

        Payment[] payments = {payment1, payment2, payment3};

        FinanceReport report = new FinanceReport("Александров Александр Александрович", "27.11.2024", payments);

        System.out.println("Исходный отчет:");
        System.out.println(report);

        System.out.println("\nФильтр по фамилии (И):");
        FinanceReport filteredSurname = FinanceReportProcessor.filterSurname(report, 'И');
        System.out.println(filteredSurname);

        System.out.println("\nФильтр по сумме <60000 коп:");
        FinanceReport filteredSum = FinanceReportProcessor.filterSum(report, 60000);
        System.out.println(filteredSum);
    }
}
