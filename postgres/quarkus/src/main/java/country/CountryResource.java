package country;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;

import org.jboss.logging.Logger;


@Path("countries")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CountryResource {

    private static final Logger LOGGER = Logger.getLogger(CountryResource.class.getName());

    @Inject
    EntityManager entityManager;

    @GET
    public List<Country> get() {
        return entityManager.createQuery("SELECT object(c) FROM Country AS c", Country.class).getResultList();
    }

    @GET
    @Path("{id}")
    public Country getCountry(Integer id) {
        Country country = entityManager.find(Country.class, id);
        if (country == null) {
            throw new WebApplicationException("Country with id of " + id + " does not exist.", 404);
        }
        return country;
    }
}
