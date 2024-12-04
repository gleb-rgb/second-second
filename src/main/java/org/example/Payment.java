package org.example;

import java.util.Objects;

public class Payment {
    private String fullName;
    private int day;
    private int month;
    private int year;
    private int sum;
    final private boolean M;


    public Payment(String fullName, int day, int month, int year, int sum) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sum = sum;
        this.M = false;
    }

    public Payment(String fullName){
        this.fullName = fullName;
        this.M = true;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && month == payment.month && year == payment.year && sum == payment.sum && Objects.equals(fullName, payment.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, sum);
    }

    @Override
    public String toString() {
        if(M){
            return fullName;
        }
        else {
            int kopecks = sum;
            return String.format("Плательщик: '%s', дата: %02d.%02d.%04d, сумма: %02d коп.",
                    fullName, day, month, year, kopecks);
        }
    }
}

