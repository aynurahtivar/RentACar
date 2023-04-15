package helpers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeValidations {
    Scanner scan = new Scanner(System.in);

    public LocalDate dateValidation() {

        LocalDate date = null;
        boolean isValid;
        do {
            try {
                String bDate = scan.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                date = LocalDate.parse(bDate, formatter);
                isValid = false;
            } catch (Exception e) {
                isValid = true;

                System.out.println("\n\tHatali giris!!! " + e.getMessage() + "\n\tTekrar deneyiniz....");
                System.out.print("\n\tTarih (gun/ay/yil): ");
            }
        } while (isValid);

        return date;
    }

    public void isBefore(LocalDate date) {
        boolean isValid = true;
        do {

            try {
                if (ChronoUnit.DAYS.between(LocalDate.now(), date) < 0) {
                    System.err.println("\tKiralayacaginiz gun bugunden once olamaz!!!");
                    System.out.print("\n\t⇢↠ Kiralayacaginiz tarihi giriniz (gun/ay/yil): ");
                    dateValidation();
                    isValid = false;
                } else {
                    isValid = false;
                }
            } catch (Exception e) {
                System.out.println("\n\tHatali giris!!! " + e.getMessage() + "\n\tTekrar deneyiniz....");
                System.out.print("\n\t\n\t⇢↠ Kiralayacaginiz tarihi giriniz (gun/ay/yil): ");
                dateValidation();

            }

        } while (isValid);


    }


    public void isAfter(LocalDate date, LocalDate date2) {
        boolean isValid = true;
        do {

            try {
                if (ChronoUnit.DAYS.between(date, date2) < 0) {
                    System.out.println("\n\tTeslim edeceginiz gun kiraladiginiz tarihten once olamaz!");
                    System.out.println("\n\t⇢↠ Araci teslim edeceginiz tarihi giriniz (gun/ay/yil): ");
                    dateValidation();
                    isValid = false;
                } else {
                    isValid = false;
                }
            } catch (Exception e) {
                System.out.println("\n\tHatali giris!!! " + e.getMessage() + "\n\tTekrar deneyiniz....");
                System.out.println("\n\t⇢↠ Araci teslim edeceginiz tarihi giriniz (gun/ay/yil): ");
                dateValidation();
            }

        } while (isValid);


    }


    public LocalTime timeValidation() {

        LocalTime time = null;
        boolean isValid;
        do {
            String time1 = scan.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
                time = LocalTime.parse(time1, formatter);
                isValid = false;
            } catch (Exception e) {


                System.out.println("\n\tHatali giris!!! \n\tTekrar deneyiniz....");
                System.out.print("\n\tSaat: ");
                isValid = true;
            }
        } while (isValid);

        return time;
    }

}
