package sample.spring.multi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MultipleImplTest {

    @Autowired
    private MarketPlaceUser marketPlaceUser;

    @Test
    public void testGetAnImpl() {
        assertThat(marketPlaceUser.showMarketPlace(), equalTo("apple"));
    }

    @Configuration
    static class SpringConfig {

        @Bean
        @Android
        public GoogleMarketPlace androidMarketPlace() {
            return new GoogleMarketPlace();
        }

        @Bean
        @Ios
        public AppleMarketPlace appleMarketPlace() {
            return new AppleMarketPlace();
        }

        @Bean
        public MarketPlaceUser marketPlaceUser() {
            return new MarketPlaceUser();
        }
    }
}

class MarketPlaceUser {
    @Autowired
    @Ios
    private MarketPlace marketPlace;

    public MarketPlaceUser() {
    }

    public String showMarketPlace() {
        return this.marketPlace.toString();
    }

}

interface MarketPlace {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Qualifier
@interface Android {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Qualifier
@interface Ios {

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