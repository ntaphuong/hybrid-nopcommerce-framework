package dynamicLocator;

public class StringFormat {
    public static void main(String[] args) {
        String DELETE_ICON_BY_FEMALE = "//td[@data-key='females' and text()='%s']/preceding-sibling::td/button[@class='qgrd-remove-row-btn']";
        String DELETE_ICON_BY_COUNTRY_MALE_TOTAL = "//td[@data-key='total' and text()='%s']/preceding-sibling::td[@data-key='males' and text()='%s']/"+
                "preceding-sibling::td[@data-key='country' and text()='%s']";
        clickToDeleteIcon(DELETE_ICON_BY_FEMALE,"384187");
        clickToDeleteIcon(DELETE_ICON_BY_COUNTRY_MALE_TOTAL,"791312","407124","Afghanistan");
    }
// tính đa hình trong java, cùng tên hàm nhưng tham số khác nhau vẫn dùng dc
//    private static void clickToDeleteIcon(String locator, String female) {
//        System.out.println("Delete to icon: " + String.format(locator,female));
//    }
//    private static void clickToDeleteIcon(String locator, String total, String males, String country) {
//        System.out.println("Delete to icon: " + String.format(locator,total,males,country));
//    }
    private static void clickToDeleteIcon(String locator, String... resParameter){
        System.out.println("Delete to icon: " + String.format(locator, (Object[]) resParameter));
    }


}
