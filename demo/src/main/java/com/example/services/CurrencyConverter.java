package com.example.services;

import java.util.Map;

public class CurrencyConverter {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        // Obter dados da API
        Map<String, Object> rates = ApiClient.getExchangeRates(fromCurrency);

        if (!rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Moeda de destino não suportada: " + toCurrency);
        }

        double rate = (double) rates.get(toCurrency);
        return amount * rate;
    }
}

