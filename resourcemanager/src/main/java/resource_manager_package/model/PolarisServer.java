package resource_manager_package.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PolarisServer {
   private final String name ;
   private final UUID id ;

   public PolarisServer(@JsonProperty("name") String name,
                        @JsonProperty("id") UUID id)
   {
      this.name = name;
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public UUID getId() {
      return id;
   }
}
