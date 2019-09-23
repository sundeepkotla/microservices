package enviornament_provisioner_package;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class environmentProvisionerRestService
{
    static final String taf_rest_endpoint="";

    @RequestMapping("/status")
    public String welcome_message(){
        return " Welcome to Env Manager";
    }

    @RequestMapping("/tafStatus")
    public String home() throws IOException {
        String command = "curl http://submitjob.auto.mobileiron.com:9000/stafService/tafStatus?staxid=531772";
        Process process = Runtime.getRuntime().exec(command);
        System.out.println(process.getOutputStream());

        return "welcome to Env manager";

    }

    public static void main(String[] args) {
        SpringApplication.run(environmentProvisionerRestService.class, args);
    }
}


