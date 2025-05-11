package br.com.alura.projetos.conversorDeMoedas.models;

public record ExchangeRateData(String baseCode ,
                               String targetCode ,
                               float conversionRate ,
                               float conversionResult) {
}
