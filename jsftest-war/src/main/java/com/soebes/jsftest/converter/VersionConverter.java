package com.soebes.jsftest.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.soebes.jsftest.domain.Version;


public class VersionConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        Version v = new Version(value);
        return v;
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {

        String result = null;
        if (value instanceof Version) {
            result = ((Version) value).toString();
        } else {
            //
        }
        return result;
    }

}
