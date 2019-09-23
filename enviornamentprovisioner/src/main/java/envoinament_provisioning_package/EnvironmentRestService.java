package envoinament_provisioning_package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
@RestController

public class EnvironmentRestService
{
    @RequestMapping("/")
    public String home() {
        return "Welcome to ENV manager" ;
    }

    @GetMapping("/tafstatus/{id}")
    public String tafstatus(@PathVariable String id) throws IOException {
        System.out.println();

        //curl http://localhost:8080/tafstatus/531772

        //HTTP URL connection :
        String taf_url = "http://submitjob.auto.mobileiron.com:9000/stafService/tafStatus?staxid="+id;
        URL url = new URL(taf_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        return "TAF is Humming  id : "+id+" Status :"+ response.toString()+"\n";
    }
    public static void main(String[] args) {
        SpringApplication.run(EnvironmentRestService.class, args);
    }
}



