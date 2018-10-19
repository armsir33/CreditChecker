package cn.credit.checker.CreditChecker.config;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CreditCheckerConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CreditCheckerConfig.class);

    private static final String PROPERTY_FILE_PATH = "application.properties";

    private final ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder;

    public CreditCheckerConfig(final ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder) {
        this.builder = builder;
    }

    public static CreditCheckerConfig create() {
        LOG.debug("create CreditChecker");
        Parameters params = new Parameters();
        File propertiesFile = new File(PROPERTY_FILE_PATH);

        ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder =
                new ReloadingFileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                        .configure(params.fileBased()
                                .setFile(propertiesFile));
        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                null, 1, TimeUnit.SECONDS);
        trigger.start();
        return new CreditCheckerConfig(builder);
    }

    public String getConfigProperty(String key) {
        try {
            return this.builder.getConfiguration().getString(key, "");
        } catch (ConfigurationException e) {
            throw new RuntimeException("FAILED to fetch configuration", e);
        }
    }

}
