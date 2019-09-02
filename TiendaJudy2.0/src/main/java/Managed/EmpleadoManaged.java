/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.EmpleadoDAO;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import model.Empleado;

@Named
@ViewScoped
public class EmpleadoManaged implements Serializable {

    @EJB
    private EmpleadoDAO empleadoDAO;

    @EJB
    private Empleado empleado;

    @EJB
    private Empleado empleadoEditar;

    private List<Empleado> empleados;

    public EmpleadoManaged() {
    }

    @PostConstruct
    public void init() {
        empleado = new Empleado();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleadoEditar() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (!StringUtils.isEmpty(id)) {
            empleadoEditar = empleadoDAO.buscarEmpleado(Integer.parseInt(id));
        }
        return empleadoEditar;
    }

    public void setEmpleadoEditar(Empleado empleadoEditar) {
        this.empleadoEditar = empleadoEditar;
    }

    public List<Empleado> getEmpleados() {
        if (empleados == null) {
            empleados = empleadoDAO.obtenerEmpleados();
        }
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void validarId() {
        if (empleado.getIdEmpleado() != null) {
            if (empleadoDAO.buscarEmpleado(empleado.getIdEmpleado()) != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ya existe un empleado con el ID: " + empleado.getIdEmpleado()));
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "ID disponible para usar"));
            }
        }
    }

    public void crearEmpleado() {
        if (empleado != null) {
            if (empleadoDAO.buscarEmpleado(empleado.getIdEmpleado()) == null) {
                empleadoDAO.createEmpleado(empleado);
                try {
                    FacesContext contex = FacesContext.getCurrentInstance();
                    contex.getExternalContext().redirect("verEmpleado.xhtml");
                } catch (Exception e) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo cargar la pagina"));
                }
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo crear el empleado"));
            }
        }
    }

    public void editarEmpleado() {
        if (empleadoEditar != null) {
            Empleado eSinEditar = empleadoDAO.buscarEmpleado(empleadoEditar.getIdEmpleado());
            
            if (eSinEditar != null) {
                if (Objects.equals(eSinEditar.getNombre(), empleadoEditar.getNombre())
                        & Objects.equals(eSinEditar.getCorreo(), empleadoEditar.getCorreo())
                        & Objects.equals(eSinEditar.getTelefono(), empleadoEditar.getTelefono())
                        & Objects.equals(eSinEditar.getSalario(), empleadoEditar.getSalario())) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "El empleado " + empleadoEditar.getNombre() + " no ha sufrido cambios"));
                } else {
                    FacesContext context = FacesContext.getCurrentInstance();
                    try {
                        empleadoDAO.editarEmpleado(empleadoEditar);
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "El empleado " + empleadoEditar.getIdEmpleado() + " editado correctamente: "));
                        context.getExternalContext().redirect("verEmpleado.xhtml");
                        empleadoEditar = new Empleado();
                    } catch (Exception e) {
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "El empleado " + empleadoEditar.getIdEmpleado() + " no se ha editado correctamente: "));
                    }
                }
            }
        }
    }

    public void eliminarEmpleado() {
        if (empleadoEditar != null) {
            try {
                Empleado empleadoEliminar = empleadoDAO.buscarEmpleado(empleadoEditar.getIdEmpleado());
                empleadoDAO.eliminarEmpleado(empleadoEliminar);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO!", "Empleado eliminado con exito"));
                context.getExternalContext().redirect("verEmpleado.xhtml"); 
            } catch (Exception e) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo cargar la pagina"));
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se pudo eliminar el empleado"));
        }
    }

}
