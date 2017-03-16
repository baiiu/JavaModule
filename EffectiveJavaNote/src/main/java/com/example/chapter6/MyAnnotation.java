package com.example.chapter6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * auther: baiiu
 * time: 17/3/16 16 21:45
 * description:
 */
//@Target(value = {})
//无@Target注解时，可以修饰任何
@Retention(value = RetentionPolicy.SOURCE)
public @interface MyAnnotation {
    //Integer id() default 1;
    int id();
    String value() default "";

}
