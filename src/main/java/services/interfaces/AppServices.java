package services.interfaces;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AppServices {

    public Object methodGet(String url, Class clazz);
    public List methodListGet(String url, Class clazz);
    public Object methodPost(Object data,String url, Class clazz);
    public List methodListPost(Object data,String url, Class clazz);


}
