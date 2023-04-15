package core.attributesclasses;

public class Car {
    private String marka;
    private String model;
    private String yakitTipi;
    private String vites;
    private int gunlukUcret;
    private boolean isAvailable;    //kiralanan araci pasife aliyorum tekrar kiralanmasin

    private int id;


    public Car(int id, String marka, String model, String yakitTipi, String vites, int gunlukUcret, boolean isAvailable) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.yakitTipi = yakitTipi;
        this.vites = vites;
        this.gunlukUcret = gunlukUcret;
        this.isAvailable = isAvailable;

    }

    public Car() {

    }


    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYakitTipi() {
        return yakitTipi;
    }

    public void setYakitTipi(String yakitTipi) {
        this.yakitTipi = yakitTipi;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public int getGunlukUcret() {
        return gunlukUcret;
    }

    public void setGunlukUcret(int gunlukUcret) {
        this.gunlukUcret = gunlukUcret;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
