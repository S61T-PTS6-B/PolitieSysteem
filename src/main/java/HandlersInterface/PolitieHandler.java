/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandlersInterface;

import Model.CarTracker;
import Model.PolitieAccount;
import java.util.List;

/**
 *
 * @author casva
 */
public interface PolitieHandler {
    public void addPolitie(PolitieAccount account);
    public void addCarTrackker(CarTracker car);
    public List<CarTracker> getStolenCars();
}
