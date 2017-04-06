package edu.hm.cs.schnitzel.reflection;

import java.util.Date;

/**
 *
 * @author nicfel
 */
public class ExampleClass {

    @RenderMe
    private final int foo;
    @RenderMe(with = "edu.hm.cs.schnitzel.reflection.ArrayRenderer")
    int[] array = {1, 2, 3,};
    @RenderMe
    private final Date date = new Date(123456789);

    @RenderMe
        public void exampleMethod1() {
    }

    @RenderMe
    private int exampleMethod2() {
        return 1 + 1;
    }

    @RenderMe(with = "edu.hm.cs.schnitzel.reflection.ArrayRenderer")
    private int[] exampleMethod3() {
        return new int[] {1, 2, 3};
    }

    @RenderMe
    public ExampleClass(int foo) {
        this.foo = foo;
    }

}
