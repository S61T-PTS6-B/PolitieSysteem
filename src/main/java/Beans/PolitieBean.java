/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import HandlersInterface.PolitieHandler;
import Model.CarTracker;
import java.security.Principal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author casva
 */
@ManagedBean(name = "politieBean")
@SessionScoped
public class PolitieBean {

    /**
     * Creates a new instance of PolitieBean
     */
    private String loggedinuser;
    
    private String registername;
    
    private String registerpassword;
    
    private String BrandCar ;
    
    private String ModelCar;
    
    private String licensePlate;
    
    private double priceCatagory;
    
    private String StolenCars;
    
    private List<CarTracker> cars;
    
    
    @EJB
    private PolitieHandler handler;
    
    public PolitieBean() {
    }
    
    public void init(){
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        this.setLoggedinuser(principal.getName());
    }
    
    public void addCar(ActionEvent event){
        CarTracker car = new CarTracker();
        car.setBrandCar(this.BrandCar);
        car.setGestolen(true);
        car.setLicensePlate(this.licensePlate);
        car.setPriceCategory(this.priceCatagory);
        car.setModelCar(this.ModelCar);
        handler.addCarTrackker(car);
        setNull();
    }

    public String getLoggedinuser() {
        return loggedinuser;
    }

    public void setLoggedinuser(String loggedinuser) {
        this.loggedinuser = loggedinuser;
    }

    public String getRegistername() {
        return registername;
    }

    public void setRegistername(String registername) {
        this.registername = registername;
    }

    public String getRegisterpassword() {
        return registerpassword;
    }

    public void setRegisterpassword(String registerpassword) {
        this.registerpassword = registerpassword;
    }

    public String getBrandCar() {
        return this.BrandCar;
    }

    public void setBrandCar(String BrandCar) {
        this.BrandCar = BrandCar;
    }

    public String getModelCar() {
        return ModelCar;
    }

    public void setModelCar(String ModelCar) {
        this.ModelCar = ModelCar;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getPriceCatagory() {
        return priceCatagory;
    }

    public void setPriceCatagory(double priceCatagory) {
        this.priceCatagory = priceCatagory;
    }

    public PolitieHandler getHandler() {
        return handler;
    }

    public void setHandler(PolitieHandler handler) {
        this.handler = handler;
    }
    
    public void setNull(){
        this.ModelCar = "";
        this.BrandCar = "";
        this.priceCatagory = 0.0;
        this.licensePlate="";
    }

    public String getStolenCars() {
        
        cars = handler.getStolenCars();
         JSONArray array = new JSONArray();
         JSONObject object;
         for(CarTracker car : cars){
             object = new JSONObject();
             object.put("brand", car.getBrandCar());
             object.put("model",car.getModelCar());
             object.put("license", car.getLicensePlate());
             object.put("price", car.getPriceCategory());
             array.put(object);
         }
        return array.toString();
    }


    public void setStolenCars(String getStolenCars) {
        this.StolenCars = getStolenCars;
    }
}
    
    

