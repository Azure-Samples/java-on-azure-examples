package jms2springdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends CrudRepository<HelloWorld, String> {   
}
