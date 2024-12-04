package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {

    private FinanceReport report;

    @BeforeEach
    void setUp(){
        Payment[] payments = new Payment[]{
                new Payment("Иванов Иван Иванович", 15, 11, 2024, 12345),
                new Payment("Петров Петр Петрович", 16, 11, 2024, 98765),
                new Payment("Сидоров Сергей Сергеевич", 17, 11, 2024, 54321)
        };
        report = new FinanceReport("Александров Александр Александрович", "27.11.2024", payments);

    }

    @Test
    void filterSurname() {
        String expected = """
                Автор: Александров Александр Александрович, дата: 27.11.2024, Платежи: [
                 Плательщик: 'Иванов Иван Иванович', дата: 15.11.2024, сумма: 12345 коп.
                ]""";
        FinanceReport filterSurname = FinanceReportProcessor.filterSurname(report,'И');
        assertEquals(expected,filterSurname.toString());

    }

    @Test
    void filterSum() {
        String expected = """
                Автор: Александров Александр Александрович, дата: 27.11.2024, Платежи: [
                 Плательщик: 'Иванов Иван Иванович', дата: 15.11.2024, сумма: 12345 коп.
                 Плательщик: 'Сидоров Сергей Сергеевич', дата: 17.11.2024, сумма: 54321 коп.
                ]""";

        FinanceReport filterSum = FinanceReportProcessor.filterSum(report,60000);
        assertEquals(expected,filterSum.toString());


        String expected1 = "Нет платежей меньших 60";
        assertNotEquals(expected1,filterSum.toString());
    }
}