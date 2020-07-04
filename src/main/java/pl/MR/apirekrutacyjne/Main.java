package pl.MR.apirekrutacyjne;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Dla uproszczenia zadania można przyjąć, że obecnie serwis będzie sprawdzany jedynie dla walut:
//• Rubel rosyjski
//• Dolar amerykański
//• Euro
//        Format daty wejściowej serwisu jest dowolny.

        Scanner scanner = new Scanner(System.in);
        NBPApiParametrs parameters = new NBPApiParametrs();

        loadAndSetCurrency(scanner, parameters);

    }

    private static void loadAndSetCurrency(Scanner scanner, NBPApiParametrs parameters) {
        do {
            System.out.println("Please enter currency: [DOLLAR,EURO,RUBEL]:");
            Optional<NBPCurrency> optionalCurrency = NBPCurrency.parse(scanner.nextLine());
            if (optionalCurrency.isPresent()) {
                parameters.setCurrency(optionalCurrency.get());
            }
        } while (parameters.getCurrency() == null); // wykonaj petle, dopóki currency == null
    }








}
