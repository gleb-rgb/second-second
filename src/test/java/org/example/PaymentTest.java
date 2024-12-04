package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    private Payment payment;

    @BeforeEach
    void setUp() {
        payment = new Payment("Иванов Иван Иванович", 15, 11, 2024, 12345);
    }

    @Test
    void getFullName() {
        assertEquals("Иванов Иван Иванович", payment.getFullName());
    }

    @Test
    void setFullName() {
        payment.setFullName("Петров Петр Петрович");
        assertEquals("Петров Петр Петрович", payment.getFullName());
    }

    @Test
    void getDay() {
        assertEquals(15, payment.getDay());
    }

    @Test
    void setDay() {
        payment.setDay(16);
        assertEquals(16, payment.getDay());
    }

    @Test
    void getMonth() {
        assertEquals(11, payment.getMonth());
    }

    @Test
    void setMonth() {
        payment.setMonth(12);
        assertEquals(12, payment.getMonth());
    }

    @Test
    void getYear() {
        assertEquals(2024, payment.getYear());
    }

    @Test
    void setYear() {
        payment.setYear(2025);
        assertEquals(2025, payment.getYear());
    }

    @Test
    void getSum() {
        assertEquals(12345, payment.getSum());
    }

    @Test
    void setSum() {
        payment.setSum(123456);
        assertEquals(123456, payment.getSum());
    }

    @Test
    void testEquals() {
        Payment payment2 = new Payment("Иванов Иван Иванович", 15, 11, 2024, 12345);
        Payment payment3 = new Payment("Петров Петр Петрович", 16, 11, 2024, 98765);

        assertEquals(payment, payment2);
        assertNotEquals(payment, payment3);

    }


    @Test
    void testHashCode() {
        Payment payment2 = new Payment("Иванов Иван Иванович", 15, 11, 2024, 12345);
        Payment payment3 = new Payment("Петров Петр Петрович", 16, 11, 2024, 98765);

        assertEquals(payment, payment2);
        assertNotEquals(payment, payment3);
    }

    @Test
    void testToString() {
        String d = "Плательщик: 'Иванов Иван Иванович', дата: 15.11.2024, сумма: 12345 коп.";
        assertEquals(d, payment.toString());
    }
}