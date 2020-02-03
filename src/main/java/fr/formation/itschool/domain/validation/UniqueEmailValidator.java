package fr.formation.itschool.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.itschool.domain.services.ContactService;

public class UniqueEmailValidator
	implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private ContactService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
	if (null == email || email.isEmpty())
	    return true;
	return userService.emailUnique(email);
    }
}
