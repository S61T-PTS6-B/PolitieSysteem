/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandlersImpl;

import HandlersInterface.PolitieHandler;
import Model.CarTracker;
import Model.PolitieAccount;
import Model.PolitieGroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author casva
 */
@Stateless
public class PolitieHanlderImpl implements PolitieHandler{
    @PersistenceContext(unitName = "com.mycompany_PolitieSysteem_war_1.0-SNAPSHOTPU")
    private EntityManager entityManager;

    @Override
    public void addPolitie(PolitieAccount account) {
        PolitieGroup group = entityManager.find(PolitieGroup.class, "politie");
        entityManager.persist(account);
    }
    
    @Override
    public void addCarTrackker(CarTracker car) {
        try{
        entityManager.persist(car);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Override
    public List<CarTracker> getStolenCars() {
         Query query = entityManager.createQuery(
                    "SELECT u FROM CarTracker u");
        return (List<CarTracker>) query.getResultList();     
    }
    
    
    
}
