package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.FileUtils.getAbsolutePath;

public class EmulationMobileDriver implements WebDriverProvider {

    public static MobConfig mobConfig = ConfigFactory.create(MobConfig.class);

    String pathToApp = mobConfig.pathToApp();
    static String remoteUrl = mobConfig.remoteUrl();

    public static URL getEmulationDeviceUrl() {
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "Pixel_3_API_30");
        //desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("version", "11.0");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app",
                getAbsolutePath(pathToApp));

        return new AndroidDriver(getEmulationDeviceUrl(), desiredCapabilities);
    }


}
