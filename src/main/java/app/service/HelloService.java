package app.service;

import org.springframework.stereotype.Service;

/**
 * User: Bryan
 * Date: 3/13/14
 * Time: 12:47 AM
 */
@Service
public class HelloService {
    public String getMessage(){
        return "Hello to you";
    }
}
