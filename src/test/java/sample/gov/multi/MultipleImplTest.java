package sample.gov.multi;

import com.google.inject.*;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MultipleImplTest {
    @Test
    public void testGetAnImpl() {
        Injector injector = Guice.createInjector(new MultipleInstancesModule());
        MarketPlaceUser marketPlaceUser = injector.getInstance(MarketPlaceUser.class);
        assertThat(marketPlaceUser.showMarketPlace(), equalTo("apple"));
    }
}

class MultipleInstancesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MarketPlace.class).annotatedWith(Ios.class).to(AppleMarketPlace.class).in(Scopes.SINGLETON);
        bind(MarketPlace.class).annotatedWith(Android.class).to(GoogleMarketPlace.class).in(Scopes.SINGLETON);
        bind(MarketPlaceUser.class).in(Scopes.SINGLETON);
    }
}

class MarketPlaceUser {
    private final MarketPlace marketPlace;
    @Inject
    public MarketPlaceUser(@Ios MarketPlace marketPlace) {
        System.out.println("MarketPlaceUser constructor called..");
        this.marketPlace = marketPlace;
    }

    public String showMarketPlace() {
        return this.marketPlace.toString();
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@BindingAnnotation
@interface Android {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@BindingAnnotation
@interface Ios {

}

interface MarketPlace {
}

class AppleMarketPlace implements MarketPlace {

    @Override
    public String toString() {
        return "apple";
    }
}

class GoogleMarketPlace implements MarketPlace {

    @Override
    public String toString() {
        return "android";
    }
}