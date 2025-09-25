package top.wby.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneValidator  implements ConstraintValidator<Phone, String> {
    private static final String REGEX_PHONE = "^1[3456789]\\d{9}$";

    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return Pattern.matches(REGEX_PHONE,s);
    }
}
