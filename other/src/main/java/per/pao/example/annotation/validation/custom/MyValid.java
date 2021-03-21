package per.pao.example.annotation.validation.custom;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {MyValid.MyConstraintValidator.class})
public @interface MyValid {

    int min() default 3;

    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class MyConstraintValidator implements ConstraintValidator<MyValid, Object> {

        private int min;

        @Override
        public void initialize(MyValid constraintAnnotation) {
            min = constraintAnnotation.min();
            System.out.println("Exception: " + min);
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            if (value.toString().length() > min) {
                return true;
            }
            return false;
        }
    }
}