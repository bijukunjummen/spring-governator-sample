package sample.gov;

import com.netflix.config.ConfigurationManager;
import com.netflix.governator.configuration.ArchaiusConfigurationProvider;
import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.governator.guice.BootstrapModule;

import java.io.IOException;

public class SampleBootstrapModule implements BootstrapModule {

    @Override
    public void configure(BootstrapBinder binder) {
        try {
            ConfigurationManager
                    .loadCascadedPropertiesFromResources("sample");
            binder.bindConfigurationProvider().to(ArchaiusConfigurationProvider.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
