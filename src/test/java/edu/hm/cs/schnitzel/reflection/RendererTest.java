package edu.hm.cs.schnitzel.reflection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RendererTest {

    private ExampleClass toRender;
    private Renderer renderer;

    @Before
    public void setUp() {
        toRender = new ExampleClass(5);
        renderer = new Renderer(toRender);
    }

    @Test
    public void testRendering() throws Exception {
        assertEquals("Instance of edu.hm.SomeClass:\n"
                + "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n",
                renderer.render());
    }
}
