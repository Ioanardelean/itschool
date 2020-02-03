package fr.formation.itschool.domain.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsAdultValidator
	implements ConstraintValidator<IsAdult, LocalDate> {

    int majority;

    @Override
    public void initialize(final IsAdult isAdult) {
	majority = isAdult.majority();
    }

    @Override
    public boolean isValid(LocalDate birthDate,
	    ConstraintValidatorContext context) {
	LocalDate testDate = LocalDate.now().minusYears(majority);
	return birthDate.isBefore(testDate);
    }
}
