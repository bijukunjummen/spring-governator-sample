package sample.spring;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class PathMatchingResourcePatternResolverTest {

    @Test
    public void testPattern() throws Exception {
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath*:/sample/**/*.class");

        for (Resource r: resources) {
            System.out.println("r = " + r);
        }
    }
}
