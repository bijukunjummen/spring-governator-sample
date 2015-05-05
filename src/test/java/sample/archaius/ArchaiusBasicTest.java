package sample.archaius;

import com.netflix.config.*;
import com.netflix.config.sources.URLConfigurationSource;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ArchaiusBasicTest {

    @Before
    public void setUp() throws Exception{
//        ConfigurationManager.loadCascadedPropertiesFromResources("newconfig"); //loading a file with a different name
//        System.setProperty("archaius.configurationSource.defaultFileName", "newconfig.properties"); //Another option
    }

    @Test
    public void testBasicStringProps() {
        DynamicStringProperty sampleProp = DynamicPropertyFactory.getInstance().getStringProperty("stringprop", "");
        assertThat(sampleProp.get(), equalTo("propvalue"));
    }

    @Test
    public void testBasicListProps() {
        DynamicStringListProperty listProperty = new DynamicStringListProperty("listprop", Collections.emptyList());
        assertThat(listProperty.get(), contains("value1", "value2", "value3"));
    }

    @Test
    public void testBasicMapProps() {
        DynamicStringMapProperty mapProperty = new DynamicStringMapProperty("mapprop", Collections.emptyMap());
        assertThat(mapProperty.getMap(), allOf(hasEntry("key1", "value1"), hasEntry("key2", "value2")));
    }

    @Test
    public void testBasicLongProperty() {
        DynamicLongProperty longProp = DynamicPropertyFactory.getInstance().getLongProperty("longprop", 1000);
        assertThat(longProp.get(), equalTo(100L));
    }
}
