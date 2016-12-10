package org.jeeouvaiouracha.bean.converter;

import com.sun.faces.el.ELContextImpl;
import org.jeeouvaiouracha.domain.User;
import org.jeeouvaiouracha.services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by laerteguedes on 09/12/16.
 */
@FacesConverter(forClass = User.class)
public class UserConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            return (User) component.getAttributes().get(value);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof User) {
            User entity = (User) o;
            if (entity != null && entity instanceof User && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }

        return null;
    }
}
