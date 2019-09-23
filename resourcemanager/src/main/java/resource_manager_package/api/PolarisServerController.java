package resource_manager_package.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import resource_manager_package.model.PolarisServer;
import resource_manager_package.service.PolarisServerService;

import java.util.List;
import java.util.UUID;

//All the Api's in the class repond to the below API
// This is a rest contoller class
//curl http://localhost:8081/api/v1/polaris_server
// localhost:8081/api/v1/polaris_server
// {
//	"name":"Testserver_uuid",
//	"id": "0b878352-088a-4e87-aafe-4f56b98b5489"
//}

@RequestMapping("/api/v1/polaris_server")

@RestController
public class PolarisServerController {
    private final PolarisServerService polarisServerService;

    // When the constructor is called, PolarisServerService in Injected
    @Autowired
    public PolarisServerController(PolarisServerService polarisServerService) {
        this.polarisServerService = polarisServerService;
    }

    @GetMapping
    public List<PolarisServer> getAllPolarisServers()
    {
        return this.polarisServerService.getAllPolarisServer();
    }

    @GetMapping("{id}")
    public PolarisServer getPolarisServer(@PathVariable("id") UUID id){
        return this.polarisServerService.getPolarisServer(id).orElse(null);
    }
    @PostMapping
    public void addPolarisServer(@RequestBody PolarisServer polarisServer) {
       System.out.println(polarisServer.getName());
        this.polarisServerService.addPolarisServer(polarisServer);
    }
}
