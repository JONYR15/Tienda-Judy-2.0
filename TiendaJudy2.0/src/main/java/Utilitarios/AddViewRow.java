/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import model.DetalleFactura;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "addViewRow")
@ViewScoped
public class AddViewRow implements Serializable {

    /**
     * Creates a new instance of AddViewRow
     */
    public AddViewRow() {
    }

    /*private List<DetalleFactura> cars1;

    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {
        cars1 = service.createCars(15);
    }

    public List<Car> getCars1() {
        return cars1;
    }

    public List<String> getBrands() {
        return service.getBrands();
    }

    public List<String> getColors() {
        return service.getColors();
    }

    public void setService(CarService service) {
        this.service = service;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new car to the table:
        Car car2Add = service.createCars(1).get(0);
        cars1.add(car2Add);
        FacesMessage msg = new FacesMessage("New Car added", car2Add.getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }*/

}


