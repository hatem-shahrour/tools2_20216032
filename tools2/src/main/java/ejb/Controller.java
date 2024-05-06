package ejb;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Controller {

    @PersistenceContext(unitName = "hello")
    private EntityManager entityManager;

    @POST
    @Path("calc")
    public int calculate(Calculation calculation) {
        int result = calculation.CalculateResult();
        
        entityManager.persist(calculation);

        return result;
    }
    @GET
    @Path("getAllCalc")
    public List<Calculation>getCalculation(){
	TypedQuery<Calculation>query = entityManager.createQuery("SELECT c FROM Calculation c",Calculation.class);
	return query.getResultList();
	
}
}