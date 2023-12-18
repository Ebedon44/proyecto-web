/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedbeans;

import config.Constantes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.interfaces.AppServices;
import model.Area;
import model.Proceso;
import model.Proyecto;

/**
 *
 * @author Erick Bedón
 */
@ViewScoped
@Named
public class ProyectoMB implements Serializable {

    @Inject
    private AppServices appServices;

    private List<Area> areas;
    private List<Proceso> procesos;
    private Proyecto proyecto;

    @PostConstruct
    public void init() {
        proyecto = new Proyecto();
        areas = appServices.methodListGet(Constantes.appUrl + "areas", Area[].class);
        procesos = appServices.methodListGet(Constantes.appUrl + "procesos", Proceso[].class);

    }

    public void guardarProyecto(Object proyecto) {
        String url = Constantes.appUrl + "proyecto";

        // Verificar si el objeto es de la clase Proyecto antes de enviarlo al método
        if (proyecto instanceof Proyecto) {
            Proyecto proyectoData = (Proyecto) proyecto;

            // Invocar el método POST con el objeto proyectoData
            appServices.methodPost(proyectoData, url, Proyecto.class);

            // Puedes agregar lógica adicional después de realizar la solicitud POST
        } else {
            System.out.println("El objeto no es de la clase Proyecto.");
        }
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

}
