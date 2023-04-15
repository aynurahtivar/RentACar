package helpers;

import core.concretes.CustomerService;
import start.main.KullaniciArayuzu;

import java.util.Scanner;

public class TinyMethods {

    InputValidations inputValidations = new InputValidations();
    CustomerService customerService = new CustomerService();

    Scanner scan = new Scanner(System.in);

    public void nextOrStop() {


        boolean isValid = true;
        do {

            System.out.print("\n\tKiralama islemine devam etmek icin 1, CIKIS icin 0'a basiniz");
            int select = inputValidations.scan();
            switch (select) {
                case 0:
                    System.out.println("\n\tAna menuye yonlendiriliyorsunuz.......");

                    isValid = false;
                    break;

                case 1:
                    System.out.println("\n\t.....Musteri kayit islemlerine yonlendiriliyorsunuz.....");
                    customerService.createCustomer();
                    calculateConfirm();
                    isValid = false;
                    break;
                default:
                    System.out.println("\n\tHatali secim! ");
                    isValid = true;
                    break;
            }
        } while (isValid);
    }


    public void calculateConfirm() {
        System.out.print("\n\tRezervasyonu onaylamak icin 1,\n\tIptal etmek icin herhangi bir tusa basiniz.");
        String secim = scan.next();
        if (!secim.equals("1")) {
            System.out.println("\tAna menuye yonlendiriliyorsunuz....");
            KullaniciArayuzu kullaniciArayuzu = new KullaniciArayuzu();
            kullaniciArayuzu.showMenu();
        } else {
            System.out.println("\n\n\tRezervasyonunuz onaylanmistir. Iyi surusler dileriz..\uD83D\uDE42");


        }

    }


}


