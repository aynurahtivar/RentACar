package start.concretes;

import helpers.InputValidations;
import core.concretes.ReservationService;


public class RentACarAppMenu extends ReservationService {
    InputValidations inputValidations = new InputValidations();

    public void showMenu() {
        int select;
        do {
            System.out.println("\n\t" + "⊹".repeat(73));
            System.out.println("\t" + "1- Araclari Listele");
            System.out.println("\t" + "2- Rezervasyon Yap");
            System.out.println("\t" + "0- CIKIS");
            System.out.println("\t" + "⋅".repeat(146) + "\n");
            System.out.print("\t" + "SELECT: ");
            select = inputValidations.scan();
            switch (select) {
                case 0:
                    System.out.println("\t" + " ".repeat(31) + " Iyi gunler dileriz \uD83D\uDE14" + "\t" + " ".repeat(31));
                    break;
                case 1:
                    showAllVehicle();
                    break;
                case 2:
                    aracRezerve();
                    select = 0;
                    break;
                default:
                    System.out.println("\tHatali secim!");
                    break;
            }
        } while (select != 0);
    }

}



