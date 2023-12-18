/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedbeans;

import config.Constantes;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Persona;
import services.interfaces.AppServices;

/**
 *
 * @author Erick Bedón
 */
@ViewScoped
@Named
public class PersonasMB implements Serializable{

    private static final Logger LOG = Logger.getLogger(PersonasMB.class.getName());
    
    
    @Inject
    private AppServices appServices;
    
    private List<Persona> personas;
    
    @PostConstruct
    public void init(){
        try {
            LOG.info("init");
                    
            personas = appServices.methodListGet(Constantes.appUrl+"personas", Persona[].class);
            LOG.info("personas"+personas.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    
}
