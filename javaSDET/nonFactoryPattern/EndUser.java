package nonFactoryPattern;

public class EndUser {
    public static void main(String[] args){
        // Tới hãng Honda để xem, đặt xe và lái thử
        HondaHead honda = new HondaHead();
        honda.viewCar();
        honda.bookCar();
        honda.driverCar();

        // Tới hãng Ford
        FordHead ford = new FordHead();
        ford.viewCar();
        ford.bookCar();
        ford.driverCar();

        // Tới hãng HuynDai
        HuyndaiHead huyndai = new HuyndaiHead();
        huyndai.viewCar();
        huyndai.bookCar();
        huyndai.driverCar();
    }
}
