package com.soebes.jsftest.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.soebes.jsftest.domain.Version;


public class VersionValidator implements Validator {

    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        if (value == null) {
            return;
        }
        String input = (String) value;
        try {
            @SuppressWarnings("unused")
            Version v = new Version(input);
        } catch (IllegalArgumentException e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
    }

}
