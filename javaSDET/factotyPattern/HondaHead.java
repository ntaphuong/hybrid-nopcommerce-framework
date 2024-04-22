package factotyPattern;

public class HondaHead extends CarFactory {
    @Override
    public void viewCar() {
        System.out.println("View Honda Car");
    }

    @Override
    public void bookCar() {
        System.out.println("Book Honda Car");

    }

    @Override
    public void driverCar() {
        System.out.println("Driver Honda Car");

    }

}
