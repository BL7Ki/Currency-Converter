package com.example.services;

import java.util.Map;

public class CurrencyConverter {
    protected static final String URL_API = "https://api.exchangerate-api.com/v4/latest/";

    public static double converter(String moedaOrigem, String moedaDestino, double quantidade) throws Exception {
        // Obter dados da API
        Map<String, Object> taxasDeCambio = ApiClient.obterTaxasDeCambio(moedaOrigem);

        if (!taxasDeCambio.containsKey(moedaDestino)) {
            throw new IllegalArgumentException("Moeda de destino não suportada: " + moedaDestino);
        }

        double taxa = (double) taxasDeCambio.get(moedaDestino);
        return quantidade * taxa;
        // Como a taxa é retornada como um Object, ela é convertida para um double
    }
}
