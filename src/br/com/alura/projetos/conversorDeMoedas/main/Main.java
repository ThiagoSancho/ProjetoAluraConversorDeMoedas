package br.com.alura.projetos.conversorDeMoedas.main;

import br.com.alura.projetos.conversorDeMoedas.models.CurrencyConverter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String menu = """
                1) Dólar Americado (USD)
                2) Real Brasileiro (BRL)
                3) Peso Argentino (ARS)
                4) Peso Colombiano (COP)""";

        String separacao = "*****************************************************";

        System.out.println(separacao);
        System.out.println("Conversor de Moedas!");

        System.out.println("Escolha sua moeda base:");
        System.out.println(menu);

        Scanner sc = new Scanner(System.in);
        int resposta = sc.nextInt();
        String baseCode;
        switch (resposta){
            case 1:
                baseCode = "USD";
                break;
            case 2:
                baseCode = "BRL";
                break;
            case 3:
                baseCode = "ARS";
                break;
            case 4:
                baseCode = "COP";
                break;
            default:
                baseCode = "BRL";
        }

        System.out.println("\n\n\n");

        System.out.println("Escolha o alvo de conversão: ");
        System.out.println(menu);

        resposta = sc.nextInt();
        String targetCode;
        switch (resposta){
            case 1:
                targetCode = "USD";
                break;
            case 2:
                targetCode = "BRL";
                break;
            case 3:
                targetCode = "ARS";
                break;
            case 4:
                targetCode = "COP";
                break;
            default:
                targetCode = "USD";
        }

        System.out.println("\n\n\n");
        System.out.println("Digite a quantidade que será convertida: ");
        float amount = sc.nextFloat();
        float amountConvert = CurrencyConverter.convertCurrency(baseCode , targetCode , amount);

        System.out.println("\n\n\n");
        System.out.println("Dinheiro convertido: " + amountConvert);
        System.out.println(separacao);

    }
}
