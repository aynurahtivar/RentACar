package helpers;

import java.util.Scanner;

public class InputValidations {

    // int degeri her seferinde exception atmasin diye int validations

    public int scan() {
        int result = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);

        do {
            while (!scanner.hasNextInt()) {
                System.out.print("\tLutfen numara giriniz!\n\tTekrar deneyiniz : ");
                scanner.next();
            }
            result = scanner.nextInt();
        } while (result == Integer.MIN_VALUE);
        return result;
    }
}
