package com.gmail.at.ivanehreshi.jee.survey.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator{
    public static final String INVALID_LENGTH =
            "Username length should be at least 3 characters";
    public static final String INVALID_CHARACTERS =
            "Username contains invalid characters";

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String sValue = (String) value;

        if(sValue.length() < 3) {
            throw new ValidatorException(new FacesMessage(INVALID_LENGTH));
        }

        if(!Character.isJavaIdentifierStart(sValue.charAt(0))) {
            throw new ValidatorException(new FacesMessage(INVALID_CHARACTERS));
        }

        for (int i = 1; i < sValue.length(); i++) {
            if(!Character.isJavaIdentifierPart(sValue.charAt(i))) {
                throw new ValidatorException(new FacesMessage(INVALID_CHARACTERS));
            }
        }
    }
}
