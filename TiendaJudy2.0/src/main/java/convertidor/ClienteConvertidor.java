/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidor;

import Dao.ClienteDAO;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Cliente;

/**
 *
 * @author toursys
 */
@FacesConverter("clienteConvertidor")
public class ClienteConvertidor implements Converter{
     
    @EJB
    private ClienteDAO clienteDAO;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value == null || "".equals(value)) {
            return null;
        }
        
        return clienteDAO.find(Integer.parseInt(value));
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objValue) {
        
        if (objValue == null || "".equals(objValue)) {
            return "";
        }
        
        if (!(objValue instanceof Cliente)) {
            // handle error
        }
        
        Cliente cliente = (Cliente) objValue;
        return String.valueOf(cliente.getIdCliente());
    }
}
