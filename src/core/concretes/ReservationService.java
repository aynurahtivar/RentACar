package core.concretes;

import core.attributesclasses.Car;
import core.attributesclasses.Reservation;
import helpers.TinyMethods;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ReservationService extends CustomerService {
    TinyMethods tinyMethods = new TinyMethods();
    List<Reservation> reservationList = new ArrayList<>();
    String marka;
    int id;
    Car car;


    public void aracRezerve() {

        System.out.print("\n\t" + "—⋅".repeat(6) + "⇢↠ Kiralamak istediginiz aracin markasini giriniz : ");
        marka = scan.nextLine();
        LinkedHashSet<Car> secilenCars = showFilteredVehicle(marka);
        System.out.print("\n\t" + "—⋅".repeat(6) + "⇢↠ Kiralamak istediginiz aracin ID numarasini giriniz: ");
        id = inputValidations.scan();
        car = findByIDVehicle(id, secilenCars);

        if (car != null && car.isAvailable()) {
            System.out.print("\t" + "—⋅".repeat(6) + "⇢↠ Araci alacaginiz sehri giriniz: ");
            String sehir = scan.next();
            System.out.print("\t" + "—⋅".repeat(6) + "⇢↠ Kiralayacaginiz tarihi giriniz (gun/ay/yil): ");
            scan.nextLine();
            LocalDate alinacakGun = dateTimeValidations.dateValidation();
            alinacakGun = dateTimeValidations.isBefore(alinacakGun);
            System.out.print("\t" + "—⋅".repeat(6) + "⇢↠ Araci teslim edeceginiz tarihi giriniz (gun/ay/yil): ");
            LocalDate teslimGunu = dateTimeValidations.dateValidation();
            teslimGunu = dateTimeValidations.isAfter(alinacakGun, teslimGunu);

            System.out.print("\t" + "—⋅".repeat(6) + "⇢↠ Araci teslim alacaginiz saati (10.00) formatinda giriniz : ");
            LocalTime alinacakSaat = dateTimeValidations.timeValidation();
            System.out.print("\t" + "—⋅".repeat(6) + "⇢↠ Araci teslim edeceginiz saati (10.00) formatinda  giriniz : ");
            LocalTime teslimSaati = dateTimeValidations.timeValidation();
            Reservation reservation = new Reservation(this.reservationList.isEmpty() ? 1 : this.reservationList.get(this.reservationList.size() - 1).getId() + 1, sehir, alinacakGun, alinacakSaat, teslimGunu, teslimSaati);

            printSelectCar(car);
            printRezervationInfo(reservation);
            calculateCost(car, reservation);
            tinyMethods.nextOrStop();

            reservationList.add(reservation);
            customerList.add(customer);
            car.setAvailable(false);


        } else {
            System.out.println("\n\tArac bulunamadi.... \n\tTekrar deneyiniz.");
            aracRezerve();
        }


    }


    public void printSelectCar(Car car) {
        System.out.println("\n\t" + "⊹".repeat(73));
        System.out.println("\t" + "−".repeat(27) + "⋙   Sectiginiz Arac   ⋘" + "−".repeat(28));
        System.out.printf("\t%-8s %-10s %-10s %-13s %-10s %13s %10s\n", "ID", "MARKA", "MODEL", "YAKIT TIPI", "VITES", "GUNLUK UCRET", "DURUM");
        System.out.printf("\t%-8s %-10s %-10s %-13s %-10s %13s %10s\n", "----", "-----", "-----", "----------", "-----", "------------", "-----");
        System.out.printf("\t%-8s %-10s %-10s %-13s %-10s %13s %10s\n", car.getId(), car.getMarka(), car.getModel(), car.getYakitTipi(), car.getVites(), car.getGunlukUcret(), car.isAvailable());

    }

    public void printRezervationInfo(Reservation reservation) {
        System.out.println("\n\t" + "⊹".repeat(73));
        System.out.println("\t" + "−".repeat(24) + "⋙   Reservations Bilgileri   ⋘" + "−".repeat(24));
        System.out.printf("\t%-4s %-16s %-15s %-14s %-14s %-14s\n", "ID", "ALINACAK SEHIR", "ALINACAK GUN", "ALIS SAATI", "TESLIM GUNU", "TESLIM SAATI");
        System.out.printf("\t%-4s %-16s %-15s %-14s %-14s %-14s \n", "----", "--------------", "------------", "----------", "-----------", "------------");
        System.out.printf("\t%-4s %-16s %-15s %-14s %-14s %-14s \n", reservation.getId(), reservation.getAlinacakSehir(), reservation.getAlinacakGun(), reservation.getAlinacakSaat(), reservation.getTeslimGun(), reservation.getTeslimSaat());
    }


    public void calculateCost(Car car, Reservation reservation) {
        try {
            long gunFarki = ChronoUnit.DAYS.between(reservation.getAlinacakGun(), reservation.getTeslimGun());
            System.out.println("\n\t" + "⊹".repeat(73));
            System.out.println("\tSecilen aracin " + gunFarki + " gunluk kirasi " + (car.getGunlukUcret() * gunFarki) + " TL'dir.");
            System.out.println("\t" + "⋅".repeat(146) + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelRezervasyon() {

        System.out.print("\n\t" + "—⋅".repeat(6) + "⇢↠ Iptal etmek istediginiz rezervasyonun ID'sini giriniz : ");
        int id = inputValidations.scan();

        for (Reservation reservation : reservationList) {
            if (reservation.getId() == id) {
                System.out.print("\n\t" + "—⋅".repeat(6) + "⇢↠ Rezervasyonunuz iptal edilecek, onayliyor musunuz? (E/H)");
                String select = scan.next().toUpperCase();
                switch (select) {
                    case "E" -> {
                        int idx = reservationList.indexOf(reservation);
                        reservationList.remove(reservation);
                        customerList.remove(idx);
                        System.out.println("\n\n\t" + " ".repeat(10) + "   Rezervasyonunuz basarili bir sekilde silinmistir. ✅   ");
                        if (reservationList.isEmpty()) {
                            reservationList.add(null);  //sonra bakilacak
                        }
                    }
                    case "H" -> System.out.println("\n\tAna menuye yonlendiriliyorsunuz.....");
                    default -> System.out.println("\n\tHatali giris!");
                }
            } else {
                System.out.println("\n\tRezervasyon bulunamadi.");
            }
        }
    }


}

