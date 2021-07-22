package com.jee.persistence;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Qualifier
public @interface ISBN {
}
