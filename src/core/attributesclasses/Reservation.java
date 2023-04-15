package core.attributesclasses;


import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private String alinacakSehir;
    private LocalDate alinacakGun;
    private LocalTime alinacakSaat;
    private LocalDate teslimGun;
    private LocalTime teslimSaat;
    private int id;

    public Reservation(int id, String alinacakSehir, LocalDate alinacakGun, LocalTime alinacakSaat, LocalDate teslimGun, LocalTime teslimSaat) {
        this.id = id;
        this.alinacakSehir = alinacakSehir;
        this.alinacakGun = alinacakGun;
        this.alinacakSaat = alinacakSaat;
        this.teslimGun = teslimGun;
        this.teslimSaat = teslimSaat;


    }


    public String getAlinacakSehir() {
        return alinacakSehir;
    }

    public void setAlinacakSehir(String alinacakSehir) {
        this.alinacakSehir = alinacakSehir;
    }

    public LocalDate getAlinacakGun() {
        return alinacakGun;
    }

    public void setAlinacakGun(LocalDate alinacakGun) {
        this.alinacakGun = alinacakGun;
    }

    public LocalTime getAlinacakSaat() {
        return alinacakSaat;
    }

    public void setAlinacakSaat(LocalTime alinacakSaat) {
        this.alinacakSaat = alinacakSaat;
    }

    public LocalDate getTeslimGun() {
        return teslimGun;
    }

    public void setTeslimGun(LocalDate teslimGun) {
        this.teslimGun = teslimGun;
    }


    public LocalTime getTeslimSaat() {
        return teslimSaat;
    }

    public void setTeslimSaat(LocalTime teslimSaat) {
        this.teslimSaat = teslimSaat;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
