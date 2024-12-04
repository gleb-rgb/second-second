package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FinanceReportTest {
    private FinanceReport financeReport;
    private Payment[] payments;


    @BeforeEach
    void setUp() {
         payments = new Payment[]{
                new Payment("Иванов Иван Иванович", 15, 11, 2024, 12345),
                new Payment("Петров Петр Петрович", 16, 11, 2024, 98765),
                new Payment("Сидоров Сергей Сергеевич", 17, 11, 2024, 54321)
        };
        financeReport = new FinanceReport("Александров Александр Александрович", "27.11.2024", payments);
    }


    @Test
    void getFullNameAuthor() {
        assertEquals("Александров Александр Александрович", financeReport.fullNameAuthor());
    }

    @Test
    void getDateReport() {
        assertEquals("27.11.2024", financeReport.dateReport());
    }

    @Test
    void getPayments() {
        assertArrayEquals(payments,financeReport.payments());
    }


    @Test
    void testToString() {
        String expected = """
                Автор: Александров Александр Александрович, дата: 27.11.2024, Платежи: [
                 Плательщик: 'Иванов Иван Иванович', дата: 15.11.2024, сумма: 12345 коп.
                 Плательщик: 'Петров Петр Петрович', дата: 16.11.2024, сумма: 98765 коп.
                 Плательщик: 'Сидоров Сергей Сергеевич', дата: 17.11.2024, сумма: 54321 коп.
                ]""";
        assertEquals(expected, financeReport.toString());
    }
}