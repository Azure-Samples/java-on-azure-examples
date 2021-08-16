package jms2cosmosdb;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends CosmosRepository<HelloWorld, String> {   
}
