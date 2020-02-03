package fr.formation.itschool.domain.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.itschool.domain.services.PersonService;

public class UniqueSecNumberValidator
	implements ConstraintValidator<UniqueSecNumber, String> {

    @Autowired
    private PersonService personService;

    @Override
    public boolean isValid(String socialSecNumber,
	    ConstraintValidatorContext context) {
	if (null == socialSecNumber || socialSecNumber.isEmpty())
	    return true;
	return personService.SecNumberUnique(socialSecNumber);
    }
}
