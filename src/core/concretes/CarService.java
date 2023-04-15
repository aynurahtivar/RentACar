package core.concretes;

import core.database.concretes.CarsDatabaseManager;
import core.attributesclasses.Car;
import helpers.InputValidations;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CarService {

    InputValidations inputValidations = new InputValidations();
    Scanner scan = new Scanner(System.in);
    List<Car> carList = new ArrayList<>();
    LinkedHashSet<Car> secilenCars = new LinkedHashSet<>();

    CarsDatabaseManager adb;

    public CarService() {
        adb = new CarsDatabaseManager(carList);
        adb.read();
    }


    public void showAllVehicle() {
        System.out.println("\n\t" + "⊹".repeat(73));
        System.out.println("\t" + "−".repeat(27) + "⋙   FILODAKI ARACLAR   ⋘" + "−".repeat(27));
        System.out.println("\t" + "⋅".repeat(146) + "\n");

        System.out.printf("\t%-8s %-10s %-10s %-13s %-10s %13s %10s\n", "ID", "MARKA", "MODEL", "YAKIT TIPI", "VITES", "GUNLUK UCRET", "DURUM");
        System.out.printf("\t%-8s %-10s %-10s %-13s %-10s %13s %10s\n", "-------", "-----", "-----", "----------", "-----", "------------", "-----");
        for (Car w : carList) {
            System.out.printf("\t%-8s %-10s %-10s %-13s %-10s %13s %10s\n", w.getId(), w.getMarka(), w.getModel(), w.getYakitTipi(), w.getVites(), w.getGunlukUcret(), w.isAvailable());
        }
    }

    public LinkedHashSet<Car> showFilteredVehicle(String select) {

        boolean isValid;
        do {
            int count = 0;
            for (Car w : carList) {
                if (w.getMarka().equalsIgnoreCase(select)) {
                    secilenCars.add(w);
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("\n\n\t" + "⊹".repeat(73));
                System.out.println("\t" + "−".repeat(21) + "⋙   SECTIGINIZ MARKANIN ARACLARI   ⋘" + "−".repeat(21));
                System.out.println("\t" + "⋅".repeat(152) + "\n");
                System.out.printf("\t" + "%-8s %-10s %-10s %-13s %-10s %13s %10s\n", "ID", "MARKA", "MODEL", "YAKIT TIPI", "VITES", "GUNLUK UCRET", "DURUM");
                System.out.printf("\t" + "%-8s %-10s %-10s %-13s %-10s %13s %10s\n", "-------", "-----", "-----", "----------", "-----", "------------", "-----");
                for (Car w : secilenCars) {
                    System.out.printf("\t" + "%-8s %-10s %-10s %-13s %-10s %13s %10s\n", w.getId(), w.getMarka(), w.getModel(), w.getYakitTipi(), w.getVites(), w.getGunlukUcret(), w.isAvailable());
                }
                isValid = false;
            } else {
                System.err.println("\n\tSecilen markaya ait arac bulunamadi!");
                System.err.println("\tFilomuzdaki arac listesine yonlendiriliyorsunuz.....\n");
                showAllVehicle();
                System.out.print("\n\t" + "—⋅".repeat(6) + "⇢↠ Kiralamak istediginiz aracin markasini giriniz : ");
                select = scan.nextLine();
                isValid = true;
            }
        } while (isValid);

        return secilenCars;
    }

    public Car findByIDVehicle(int id, LinkedHashSet<Car> secilenCars) {

        int counter = 0;
        boolean isValid = false;
        do {


            for (Car w : carList) {

                if ((w.getId() == id) && (w.isAvailable()) && (secilenCars.contains(w))) {
                    return w;

                } else if ((w.getId() == id) && (!w.isAvailable()) && (secilenCars.contains(w))) {
                    System.out.println("\t Secilen arac kiralanmistir..");
                    System.out.print("\n\t" + "—⋅".repeat(6) + "⇢↠ Farki bir ID numarasini giriniz: ");
                    id = inputValidations.scan();
                    isValid = true;
                } else {
                    counter++;
                }
            }
            if (counter > 0) {
                System.out.println("\tGirdiginiz ID numarasina ait arac bulunamadi!");
                System.out.print("\n\t" + "—⋅".repeat(6) + "⇢↠ Sectiginiz markaya ait ID numarasini giriniz: ");
                id = inputValidations.scan();
                isValid = true;
            }

        } while (isValid);

        return null;

    }
}