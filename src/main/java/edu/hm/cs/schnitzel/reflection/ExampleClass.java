package edu.hm.cs.schnitzel.reflection;

import java.util.Date;

/**
 *
 * @author nicfel
 */
public class ExampleClass {

    private static final int THREE = 3;
    @RenderMe
    private final int foo;
    @RenderMe(with = "edu.hm.cs.schnitzel.reflection.ArrayRenderer")
    final int[] array = {1, 2, THREE, };
    @RenderMe
    private final Date date = new Date(123456789);

    /**
     * Method to test implementation of rendering Method results.
     */
    @RenderMe
    public void exampleMethod1() {
    }

    /**
     * Method to test implementation of rendering Method results.
     *
     * @return Returns int 2.
     */
    @RenderMe
    private int exampleMethod2() {
        return 1 + 1;
    }

    /**
     * Method to test implementation of rendering Method results.
     *
     * @return Returns an array.
     */
    @RenderMe(with = "edu.hm.cs.schnitzel.reflection.ArrayRenderer")
    private int[] exampleMethod3() {
        return new int[]{1, 2, THREE};
    }

    /**
     * Constructor for this class.
     *
     * @param foo Sets the object variable foo for testing.
     */
    @RenderMe
    public ExampleClass(int foo) {
        this.foo = foo;
    }

}
