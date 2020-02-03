package fr.formation.itschool.domain.validation;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = IsAdultValidator.class)
/**
 * @author Administrateur
 */
public @interface IsAdult {

    String message() default "{E_NOT_UNIQUE}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * @return size the element must be higher or equal to
     */
    int majority() default 18;
}
