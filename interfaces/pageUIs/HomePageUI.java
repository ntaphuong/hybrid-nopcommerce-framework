package pageUIs;

public class HomePageUI {
    // biến none static thì bắt buộc phải khởi tạo đối tượng hoặc kế thừa mới dùng được
    // private / default: khác package không dùng được
    // protected: các class bên page object ko kế thừa page UI nên ko áp dụng được
    // static: cho phép gọi trực tiếp từ class.
    // final: ngăn vệc update lại giá trị trong quá trình chạy
    // static final: để quy ước 1 biến là hằng số tong java
    // convention cho hằng số: phải viết hoa, nhiều hơn 1 từ thì phải dùng dấu _ để phân tách

    public static final String REGISTER_LINK = "//a[@class='ico-register']";


}
