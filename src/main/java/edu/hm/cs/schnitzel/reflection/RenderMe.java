package edu.hm.cs.schnitzel.reflection;

/**
 *
 * @author nicfel
 */
public @interface RenderMe {

    public String with() default "edu.hm.cs.schnitzel.reflection.Renderer";
    
}
