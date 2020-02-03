package fr.formation.itschool.domain.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = UniqueSecNumberValidator.class)
public @interface UniqueSecNumber {

    String message() default "{E_NOT_UNIQUE}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
