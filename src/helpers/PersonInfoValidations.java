package helpers;

import java.util.Scanner;

public class PersonInfoValidations {

    public String nameValidate(Scanner scan) {
        boolean isValid = true, justLetter;
        String name;
        do {
            System.out.print("\n\tIsim - Soyisim: ");
            name = scan.nextLine();
            justLetter = name.replaceAll("[a-zA-Z ]", "").length() == 0;  //harf disinda bir sey var mi kontrolu
            String[] arr = name.trim().split(" ");
            int arrLength = arr.length;

            if (name.isBlank()) {
                System.out.println("\n\tIsim ve soyisim bilgisi bos olamaz! Tekrar deneyiniz...");
                isValid = false;
            } else if (!justLetter) {
                System.out.println("\n\tIsim soyisim harf disinda karakter iceremez!");
                isValid = false;
            } else if (arrLength == 1) {
                System.out.println("\n\tIsim veya soyismi eksik girdiniz! Tekrar deneyiniz..");
                isValid = false;
            } else {
                int count = 0;
                for (String w : arr) {
                    if (w.isBlank()) {
                        System.out.println("\n\tIsim ve soyisim arasinda 1'den fazla bosluk olamaz!");
                        count++;
                        isValid = false;
                        break;
                    }
                }
                if (count == 0) {
                    isValid = true;

                }
            }
        } while (!isValid);

        return name;
    }


    public String tcValidations(Scanner scan) {
        String tcNo;
        boolean isValid = true;
        do {
            System.out.print("\n\tKimlik No : ");
            tcNo = scan.next();
            boolean result1 = tcNo.replaceAll("[0-9]", "").length() == 0;
            boolean result2 = tcNo.length() == 11;
            if (!result1) {
                System.out.println("\n\tTC sadece rakamlardan olusmalidir.");
                isValid = false;
            }
            if (!result2) {
                System.out.println("\n\tTC kimlik numarasi 11 haneli olmalidir.");
                isValid = false;
            }
            if (result1 && result2) {
                isValid = true;
            }
        } while (!isValid);

        return tcNo;
    }


    public  String licenceValidation(Scanner scan) {

        String licenceNo;
        boolean isValid = true;
        do {
            System.out.print("\n\tDriving Card Licence Number : ");
            licenceNo = scan.next();
            boolean result1 = licenceNo.replaceAll("[0-9]", "").length() == 0;
            boolean result2 = licenceNo.length() == 6;
            if (!result1) {
                System.out.println("\n\tLicence Number sadece rakamlardan olusmalidir.");
                isValid = false;
            }
            if (!result2) {
                System.out.println("\n\tLicence number 6 haneli olmalidir.");
                isValid = false;
            }
            if (result1 && result2) {
                isValid = true;
            }
        } while (!isValid);


        return licenceNo;
    }
}
