package cn.credit.checker.CreditChecker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:CreditChecker.properties")
@ConfigurationProperties
public class CreditCheckerConfigProperty {

    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(final String appId) {
        this.appId = appId;
    }
}
