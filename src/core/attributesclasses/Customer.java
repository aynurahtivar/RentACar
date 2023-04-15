package core.attributesclasses;

import java.time.LocalDate;

public class Customer {
    private String nameSurname;
    private String tcNum;
    private LocalDate birthDate;
    private String drivingLicenceNumber;

    private int id;

    public Customer() {

    }

    public Customer(int id, String nameSurname, String tcNum, LocalDate birthDate, String drivingLicenceNumber) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.tcNum = tcNum;
        this.birthDate = birthDate;
        this.drivingLicenceNumber = drivingLicenceNumber;

    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getTcNum() {
        return tcNum;
    }

    public void setTcNum(String tcNum) {
        this.tcNum = tcNum;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



