package pl.coderslab.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = CategoryLimiterValidator.class)
public @interface CategoryLimiter {

    int value();
    String message() default "{categoryLimiter.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
