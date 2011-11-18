package com.soebes.jsftest.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.soebes.jsftest.domain.Version;

public class VersionConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        if (value.isEmpty()) {
            return null;
        }

        Version v = null;
        try {
            v = new Version(value);
        } catch (IllegalArgumentException e) {

            FacesMessage msg = new FacesMessage("Version nicht ok.", e.getMessage());
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return v;
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {

        if (value != null) {
            return value.toString();
        } else {
            return null;
        }
    }

}
