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
import model.Proceso;
import services.interfaces.AppServices;

/**
 *
 * @author Erick Bedón
 */
@ViewScoped
@Named
public class ProcesosMB implements Serializable {

    @Inject
    private AppServices appServices;
    private List<Proceso> procesos;

    @PostConstruct
    public void init() {
        try {
            procesos = appServices.methodListGet(Constantes.appUrl + "procesos", Proceso[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

}
