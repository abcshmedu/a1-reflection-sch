package edu.hm.cs.schnitzel.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author nicfel
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {

    public String with() default "edu.hm.cs.schnitzel.reflection.Renderer";
    
}
