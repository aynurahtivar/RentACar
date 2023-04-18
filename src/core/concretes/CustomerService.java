package core.concretes;


import core.attributesclasses.Customer;
import helpers.DateTimeValidations;
import helpers.PersonInfoValidations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService extends CarService {
    PersonInfoValidations personInfoValidations = new PersonInfoValidations();
    DateTimeValidations dateTimeValidations = new DateTimeValidations();
    List<Customer> customerList = new ArrayList<>();
    Customer customer;

    public void createCustomer() {
        String name = personInfoValidations.nameValidate(scan);
        String tc = personInfoValidations.tcValidations(scan);
        System.out.print("\n\tDogum tarihi: ");
        scan.nextLine();
        LocalDate bDate = dateTimeValidations.dateValidation();
        String licenceNum = personInfoValidations.licenceValidation(scan);

        customer = new Customer(this.customerList.isEmpty() ? 1 : this.customerList.get(this.customerList.size() - 1).getId() + 1, name, tc, bDate, licenceNum);

        System.out.println("\n\n\t" + "⋅".repeat(146));
        System.out.println("\t" + " ".repeat(10) + "   Kayit islemi basarili bir sekilde yapilmistir ✅   ");
        System.out.println("\t" + "⋅".repeat(146) + "\n");
        printCustomerInfo(customer);

    }


    public void printCustomerInfo(Customer customer) {
        System.out.println("\t" + "−".repeat(26) + "⋙   Musteri Bilgileri   ⋘" + "−".repeat(27));
        System.out.printf("\t%-20s %-15s %-20s %-10s\n", "ADI-SOYADI ", "TC", "DOGUM TARIHI", "LICENCE NUMBER");
        System.out.printf("\t%-20s %-15s %-20s %-10s\n", "----------", "-----------", "--------------", "---------------");
        System.out.printf("\t%-20s %-15s %-20s %-10s\n", customer.getNameSurname(), customer.getTcNum(), customer.getBirthDate(), customer.getDrivingLicenceNumber());
    }




}
