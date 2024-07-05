package dynamicLocator;

import java.io.File;

public class SystemInformation {
    public static void main(String[] args){
        String osName = System.getProperty("os.Name");
        System.out.println(osName);

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        String devImagePath = projectPath + File.separator+ "uploadFiles" + File.separator+ "dev.png";
        System.out.println(devImagePath);

    }
}
