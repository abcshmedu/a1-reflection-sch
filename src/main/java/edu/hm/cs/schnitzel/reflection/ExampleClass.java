package edu.hm.cs.schnitzel.reflection;

import java.util.Date;

/**
 *
 * @author nicfel
 */
public class ExampleClass {
    
    @RenderMe private final int foo;
    @RenderMe(with = "edu.hm.cs.schnitzel.reflection.ArrayRenderer") int[] array = {1, 2, 3,};
    @RenderMe private final Date date = new Date(123456789);

    public ExampleClass(int foo) {
        this.foo = foo;
    }

}
