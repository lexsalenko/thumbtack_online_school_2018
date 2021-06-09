package net.thumbtack.school.spring.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LinkValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Link {
    String message() default "Invalid audio/video link";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}