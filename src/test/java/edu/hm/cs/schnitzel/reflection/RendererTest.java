package edu.hm.cs.schnitzel.reflection;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RendererTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo (Type int): 5\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 (Type int): 2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n", new ExampleClass(5) }, 
                 {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo (Type int): 4\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 (Type int): 2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n", new ExampleClass(4) }, 
                 {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo (Type int): 3\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 (Type int): 2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n", new ExampleClass(3) }, 
                 {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo (Type int): 2\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 (Type int): 2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n", new ExampleClass(2) }, 
                 {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo (Type int): 1\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 (Type int): 2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n", new ExampleClass(1) }, 
                 {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo (Type int): 0\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 (Type int): 2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n", new ExampleClass(0) },
                 {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo (Type int): 0\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 (Type int): 2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n", new ExampleClass(0) }
           });
    }
	
    private Renderer renderer;
    private String expected;

    public RendererTest(String expected, ExampleClass toRender) {
        this.renderer = new Renderer(toRender);
		this.expected = expected;
	}

    @Test
    public void testRendering() throws Exception {
        assertEquals(expected, renderer.render());
    }    
    
}
