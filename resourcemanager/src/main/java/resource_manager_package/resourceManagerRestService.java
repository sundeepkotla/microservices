package resource_manager_package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//This is marked as Spring boot Application : entry point of the application
@SpringBootApplication
// Simple rest controller to just test the application is up : Dont have to do this
// Component scan of spring boot uses the resource_manager_package to find all the components,services,repositories and beans
@RestController
public class resourceManagerRestService
{
    @RequestMapping("/")
    public String home() {
        return "welcome to resource manager \n";
    }

    public static void main(String[] args) {
        SpringApplication.run(resourceManagerRestService.class, args);
    }
}


