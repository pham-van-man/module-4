package org.example.bai_tap_1.validate;

import org.example.bai_tap_1.model.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

@Component
public class UserValidate implements Validator {
    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        User user = (User) target;
        String birthDate = user.getBirthDate();
        LocalDate birth = LocalDate.parse(birthDate);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "birthDate.required", "Date of birth cannot be left blank");
        if (!(Period.between(birth, LocalDate.now()).getYears() >= 18)) {
            errors.rejectValue("birthDate", "birthDate.invalid", "User must be at least 18 years old");
        }
    }
}
