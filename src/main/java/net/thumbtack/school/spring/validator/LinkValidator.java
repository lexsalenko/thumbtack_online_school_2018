package net.thumbtack.school.spring.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LinkValidator implements ConstraintValidator<Link, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //expect following format: brand,model
        String[] parts = s.split("/");
        boolean res = s.contains("https:/");
        return parts.length > 2 && res;
    }

}
