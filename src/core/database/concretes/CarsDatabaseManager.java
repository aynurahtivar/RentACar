package core.database.concretes;

import core.attributesclasses.Car;

import java.io.*;
import java.util.List;

public class CarsDatabaseManager {
    List<Car> carList;

    public CarsDatabaseManager(List<Car> carList) {
        this.carList = carList;


    }

    public void read() {
        try {
            File file = new File("C:\\Users\\Aynur\\IdeaProjects\\RentACar\\src\\core\\database\\databaseDepo\\Cars");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String cars = null;
            while ((cars = br.readLine()) != null) {
                String[] arr = cars.split(" ");
                Car car = new Car(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5]), Boolean.parseBoolean(arr[6]));
                carList.add(car);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}


