package burda.springtest.validators;

import burda.springtest.annotations.PasswordRightFormat;
import burda.springtest.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordFormatValidator implements ConstraintValidator<PasswordRightFormat, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDto user = (UserDto) o;

        return validatePassword(((UserDto) o).getPassword());
    }

    /**
     * Valid format has at least one capital letter, one lowercase letter, one number and at least 8 characters
     * */
    private boolean validatePassword(String password) {
        Pattern[] patterns = new Pattern[3];

        patterns[0] = Pattern.compile(".*[A-Z].*");
        patterns[1] = Pattern.compile(".*\\d.*");
        patterns[2] = Pattern.compile(".*[a-z].*");
        if (password.length() < 8) {
            return false;
        }
        for (Pattern pattern : patterns) {
            if(!pattern.matcher(password).matches()) {
                return false;
            }
        }
        return true;
    }
}
