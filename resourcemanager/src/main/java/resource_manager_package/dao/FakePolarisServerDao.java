package resource_manager_package.dao;

import org.springframework.stereotype.Repository;
import resource_manager_package.model.PolarisServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Implements DAO interface
@Repository("fakeDao")
public class FakePolarisServerDao implements PolarisServerDao {

    // Temporary list Acts as if storing Data in DB
    private static List<PolarisServer> polarisServerList = new ArrayList<>();

// If the below method exists then the the the default method of the Inteface is not called when the UUID is provided

//    @Override
//    public int insertPolarisServer(PolarisServer polaris_server) {
//        polarisServerList.add(polaris_server);
//        return 1;
//    }

    @Override
    public List<PolarisServer> getAllPolarisServer() {
        return polarisServerList;
    }

    @Override
    public Optional<PolarisServer> getPolairsServer(UUID id) {
        return polarisServerList.stream()
                .filter(PolarisServer -> PolarisServer.getId().equals(id))
                .findFirst();
    }

    @Override
    public int insertPolarisServer(UUID id, PolarisServer polaris_server) {
        // instantiating a new polaris_server object before writing to fake DB
        // Adding UUID to the existing Object might have unintended consequences
        polarisServerList.add(new PolarisServer(polaris_server.getName(), id));

        // Always return 1 : Since we are a list and always succeed :)
        return 1;
    }
}
