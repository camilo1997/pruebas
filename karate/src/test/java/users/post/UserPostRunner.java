package users.post;

import com.intuit.karate.junit5.Karate;

public class UserPostRunner {
        @Karate.Test
        Karate UserPostRunner(){
            return Karate.run().relativeTo(getClass());
        }
}
