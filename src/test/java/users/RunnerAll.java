package users;

import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class RunnerAll {
    @Test
    void testParallel(){
        Runner.path("classpath:*").tags("~@ignore");
    }

}
