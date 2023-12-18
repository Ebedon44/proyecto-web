package managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import config.Constantes;
import model.Area;
import services.interfaces.AppServices;

@ViewScoped
@Named
public class AreaMB implements Serializable {

    @Inject
    private AppServices appServices;
    private List<Area> areas;

    @PostConstruct
    public void init() {
        try {

            areas = appServices.methodListGet(Constantes.appUrl + "areas", Area[].class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
