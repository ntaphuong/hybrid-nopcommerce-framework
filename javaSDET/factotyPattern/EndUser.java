package factotyPattern;

import org.bouncycastle.oer.Switch;

public class EndUser {
    public static CarFactory carFactory;
    public static void main(String[] args){
        // EndUser muốn xem và lái xe Honda
        carFactory = getCar("Huyndai");

        carFactory.viewCar();
        carFactory.bookCar();
        carFactory.driverCar();

    }
    public static CarFactory getCar (String carName){
        carFactory= null;
        System.out.println(carName.toUpperCase());
        CarList carList = CarList.valueOf(carName.toUpperCase());
        switch (carList){
            case HONDA:
                carFactory = new HondaHead();
            case HUYNDAI:
                carFactory = new HuyndaiHead();
            case FORD:
                carFactory = new FordHead();
            default:
                new RuntimeException("Car name is notvalid");

        }
        System.out.println(carFactory.toString());
        return carFactory;
    }
}
