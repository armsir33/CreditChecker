package cn.credit.checker.CreditChecker.config;

import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.tags.Param;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CreditCheckerConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CreditCheckerConfig.class);

    private static final String PROPERTY_FILE_PATH = "application.properties";

    private final PeriodicReloadingTrigger trigger;

    public CreditCheckerConfig(final ReloadingFileBasedConfigurationBuilder<FileBasedConfiguration> builder, final PeriodicReloadingTrigger trigger) {
        this.trigger = trigger;
    }

    public void start() {
        Parameters params = new Parameters();
        File propertiesFile = new File(PROPERTY_FILE_PATH);

        ReloadingFileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new ReloadingFileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.fileBased()
                                .setFile(propertiesFile));
        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                null, 1, TimeUnit.MINUTES);
        this.trigger.start();
//        check();
    }

    public void check() {
        ;
//        while (true) {
            /**
             * 需要重新从 builder 中获取 Configuration 才会得到重新加载的配置项
             */
//            FileBasedConfiguration configuration = builder.getConfiguration();
//            System.out.println(configuration.getProperty("key1"));
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                LOG.warn("FAILED to sleep");
//                new RuntimeException("FAILED to sleep", e);
//            }
//        }
    }

    public void stop() {
        this.trigger.stop();
    }


}
