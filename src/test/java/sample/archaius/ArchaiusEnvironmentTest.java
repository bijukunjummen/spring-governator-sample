package sample.archaius;

import com.netflix.config.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ArchaiusEnvironmentTest {

    @Before
    public void setUp() throws Exception{
        ConfigurationManager.getConfigInstance().setProperty("@environment", "test");
//        System.setProperty("@environment", "test");
        ConfigurationManager.loadCascadedPropertiesFromResources("archsample");
    }

    @Test
    public void testBasicStringPropsInTestEnvironment() throws Exception {
        DynamicStringProperty sampleProp = DynamicPropertyFactory.getInstance().getStringProperty("sampleprop", "");
        assertThat(sampleProp.get(), equalTo("propvalue-test"));
    }
}
