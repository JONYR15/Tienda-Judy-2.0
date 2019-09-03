/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidor;

import Dao.EmpleadoDAO;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Empleado;

/**
 *
 * @author toursys
 */
@FacesConverter("empleadoConvertidor")
public class EmpleadoConvertidor implements Converter{
     
    @EJB
    private EmpleadoDAO empleadoDAO;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value == null || "".equals(value)) {
            return null;
        }
        
        return empleadoDAO.buscarEmpleado(Integer.parseInt(value));
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objValue) {
        
        if (objValue == null || "".equals(objValue)) {
            return "";
        }
        
        if (!(objValue instanceof Empleado)) {
            // handle error
        }
        
        Empleado empleado = (Empleado) objValue;
        return String.valueOf(empleado.getIdEmpleado());
    }
}
