package burda.springtest.annotations;


import burda.springtest.validators.PasswordFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordFormatValidator.class)
@Documented
public @interface PasswordRightFormat {
    String message() default "Passwords doesnt have correct format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
