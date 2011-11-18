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
        
        if (!(value instanceof Version)) {
            return;
        }

//        String input = (String) value;
//        try {
//            @SuppressWarnings("unused")
//            Version v = new Version(input);
//        } catch (IllegalArgumentException e) {
//            FacesMessage message = new FacesMessage();
//            message.setSeverity(FacesMessage.SEVERITY_ERROR);
//            message.setSummary("The given version is not Ok.");
//            message.setDetail(e.getMessage());
//            context.addMessage("userForm:version", message);
//            throw new ValidatorException(message);
//        }
    }

}
