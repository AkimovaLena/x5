package config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.function.Supplier;

public class WebDriverProvider  {

    private WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }


    public void   webConfig() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browser = config.getBrowser().name();
        Configuration.browserVersion = config.getBrowserVersion();
        String baseUrl = config.getBaseUrl().toString();
        Configuration.baseUrl = baseUrl;

        if (config.isRemote()) {

            Configuration.remote = config.getRemoteUrl().toString();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }

    }



}
