package resource_manager_package.dao;

import resource_manager_package.model.PolarisServer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Contract to implement the interface
public interface PolarisServerDao {
    int insertPolarisServer(UUID id, PolarisServer polaris_server);

    default int insertPolarisServer(PolarisServer polaris_server){
    UUID id = UUID.randomUUID();
    return insertPolarisServer(id,polaris_server);
    }

    List<PolarisServer> getAllPolarisServer();

    Optional<PolarisServer> getPolairsServer(UUID id);
}
