package start.main;

import core.concretes.CarService;
import core.concretes.ReservationService;
import start.concretes.RentACarAppMenu;
import helpers.InputValidations;

public class KullaniciArayuzu {
    InputValidations inputValidations = new InputValidations();
    RentACarAppMenu rentACarAppMenu = new RentACarAppMenu();


    public void showMenu() {
        int select;
        do {
            System.out.println("\n\t" + "⊹".repeat(73));
            System.out.println("\t" + "1- Arac Rezervasyon");
            System.out.println("\t" + "2- Rezervasyon Iptal");
            System.out.println("\t" + "0- CIKIS");
            System.out.println("\t" + "⋅".repeat(146) + "\n");
            System.out.print("\t" + "SELECT: ");
            select = inputValidations.scan();
            switch (select) {
                case 0:
                    System.out.println("\t" + " ".repeat(31) + " Iyi gunler dileriz \uD83D\uDE14" +"\t" + " ".repeat(31) );
                    break;
                case 1:
                    rentACarAppMenu.showMenu();
                    break;
                case 2:
                    rentACarAppMenu.cancelRezervasyon();
                    break;
                default:
                    break;
            }

        } while (select != 0);
    }


    public void girisMessage() {
        System.out.println("\n\n");
        System.out.println("\n\t" + "⊹".repeat(73));
        System.out.println("\t" + " ".repeat(38) + "♛♛♛" + " ".repeat(36));
        System.out.println("\t" + "∎".repeat(30) + " ⋙  RENT A CAR  ⋘ " + "∎".repeat(30));
        System.out.println("\t" + "−".repeat(27) + "⊳   BY AYNUR AHTIVAR ©  ⊲" + "−".repeat(27));
        System.out.println();
        System.out.println("\t" + " ".repeat(31) + "   Hosgeldiniz \uD83D\uDE42   " + " ".repeat(30));
        showMenu();
    }


}
