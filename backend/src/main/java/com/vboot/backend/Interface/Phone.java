package com.vboot.backend.Interface;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import com.vboot.backend.util.PhoneNumberValidator;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
  String locale() default "";

  String message() default "Invalid phone number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}