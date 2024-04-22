package factotyPattern;

public abstract class CarFactory {
    //  Hàm abstract (có tên hàm, ko có phần thân)
    // những class mà kê thừa nó sẽ cần implement lại
    // Khung để cho các class khác follow  theo đúng structure / business

    public abstract void viewCar();
    public abstract void bookCar();
    public abstract void driverCar();
}
