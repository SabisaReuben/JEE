package com.jee.persistence;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier()
@Documented
@Target(value = {ElementType.FIELD,ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.METHOD})
public @interface Bk {
}
