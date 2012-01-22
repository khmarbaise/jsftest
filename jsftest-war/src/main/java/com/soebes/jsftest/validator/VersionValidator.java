package com.soebes.jsftest.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.soebes.jsftest.domain.Version;

@FacesValidator("versionValidator")
public class VersionValidator implements Validator {

    private static final Version SMALLEST_VERSION = new Version(1, 0, 0, false);

    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        if (value == null) {
            return;
        }

        if (!(value instanceof Version)) {
            return;
        }

        Version v = (Version) value;
        if (v.isLE(SMALLEST_VERSION)) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("The given version is less or equals 1.0.0");
            context.addMessage("userForm:version", message);
            throw new ValidatorException(message);
        }
    }

}
