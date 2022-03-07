package ibf2021.springboot.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class userRepo {

    // Will be injected to the controller with @RequestHeader("authorisation") to
    // extract user email and name to add into DB
}
