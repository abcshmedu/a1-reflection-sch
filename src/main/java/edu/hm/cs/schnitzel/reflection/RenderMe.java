package edu.hm.cs.schnitzel.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author nicfel
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {

    /**
     * This method makes it possible to have a param added to annotation, which
     * can be read with this method. The parameter is a class which should
     * render the annotated variable/method.
     * @return The path to the render class.
     */
    String with() default "edu.hm.cs.schnitzel.reflection.Renderer";

}
