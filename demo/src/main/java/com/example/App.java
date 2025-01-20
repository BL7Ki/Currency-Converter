package com.example;

import com.example.services.CurrencyConverter;

public class App 
{
    public static void main(String[] args) {
        String fromCurrency = "USD";
        String toCurrency = "BRL";
        double amount = 100.0;

        try {
            double convertedAmount = CurrencyConverter.converter(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s é equivalente a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (Exception e) {
            System.err.println("Erro ao converter moedas: " + e.getMessage());
        }
    }
}
