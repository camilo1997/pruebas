package users.put;

import com.intuit.karate.junit5.Karate;

public class UserPutRunner {
    @Karate.Test
    Karate UserPutRunner(){
        return Karate.run().relativeTo(getClass());
    }
}
