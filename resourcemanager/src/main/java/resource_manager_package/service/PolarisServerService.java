package resource_manager_package.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import resource_manager_package.dao.PolarisServerDao;
import resource_manager_package.model.PolarisServer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Marked as Service can be marked as component as well
@Service
public class PolarisServerService {

    private final PolarisServerDao polarisServerDao;

    // Autowired constructor this means that an instance of the PolarisServers in Injected when PolarisServerSerivce is created
    // Qualifier : this acts as an hint on which implementation of the polaris server DAO has to tbe picked.

    @Autowired
    public PolarisServerService(@Qualifier("fakeDao") PolarisServerDao polarisServerDao) {
        this.polarisServerDao = polarisServerDao;
    }

    // Business Logic to add polaris server

    public int addPolarisServer(PolarisServer polarisServer)
    {
        return this.polarisServerDao.insertPolarisServer(polarisServer);
    }

    public Optional<PolarisServer> getPolarisServer(UUID id)
    {
        return this.polarisServerDao.getPolairsServer(id);
    }


    public List<PolarisServer> getAllPolarisServer()
    {
        return this.polarisServerDao.getAllPolarisServer();
    }
}
