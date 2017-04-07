package edu.hm.cs.schnitzel.reflection;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/**
 * The test class for the Renderer class.
 * @author nicfel, konopac
 */
@RunWith(Parameterized.class)
public class RendererTest {

    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int THREE = 3;

    /**
     * The parameters for test method testRendering.
     *
     * @return The parameters as an ArrayList.
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:"
                + "\nfoo (Type int): 5\narray (Type int[]): "
                + "[1, 2, 3, ]\ndate (Type java.util.Date): "
                + "Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 "
                + "(Type int): 2\nexampleMethod3 (Type int[]): "
                + "[1, 2, 3, ]\n", new ExampleClass(FIVE)},
            {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:"
                + "\nfoo (Type int): 4\narray (Type int[]): "
                + "[1, 2, 3, ]\ndate (Type java.util.Date): "
                + "Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 "
                + "(Type int): 2\nexampleMethod3 (Type int[]): "
                + "[1, 2, 3, ]\n", new ExampleClass(FOUR)},
            {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:"
                + "\nfoo (Type int): 3\narray (Type int[]): "
                + "[1, 2, 3, ]\ndate (Type java.util.Date): "
                + "Fri Jan 02 11:17:36 CET 1970\nexampleMethod2 "
                + "(Type int): 2\nexampleMethod3 (Type int[]): "
                + "[1, 2, 3, ]\n", new ExampleClass(THREE)},
            {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:"
                + "\nfoo (Type int): 2\narray (Type int[]): [1, 2, 3, ]"
                + "\ndate (Type java.util.Date): Fri Jan 02 "
                + "11:17:36 CET 1970\nexampleMethod2 (Type int): "
                + "2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n",
                new ExampleClass(2)},
            {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:"
                + "\nfoo (Type int): 1\narray (Type int[]): [1, 2, 3, ]"
                + "\ndate (Type java.util.Date): Fri Jan 02 "
                + "11:17:36 CET 1970\nexampleMethod2 (Type int): "
                + "2\nexampleMethod3 (Type int[]): [1, 2, 3, ]\n",
                new ExampleClass(1)},
            {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\n"
                + "foo (Type int): 0\narray (Type int[]): [1, 2, 3, ]\n"
                + "date (Type java.util.Date): Fri Jan 02 11:17:36 CET "
                + "1970\nexampleMethod2 (Type int): 2\nexampleMethod3 "
                + "(Type int[]): [1, 2, 3, ]\n", new ExampleClass(0)},
            {"Instance of edu.hm.cs.schnitzel.reflection.ExampleClass:\nfoo "
                + "(Type int): 0\narray (Type int[]): [1, 2, 3, ]\ndate "
                + "(Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"
                + "exampleMethod2 (Type int): 2\nexampleMethod3 "
                + "(Type int[]): [1, 2, 3, ]\n", new ExampleClass(0)}
        });
    }

    private final Renderer renderer;
    private final String expected;

    /**
     * Constructor for preparing this class for a parameterized test.
     *
     * @param expectedString The expected strings.
     * @param toRender The class to render and compare to the expected strings.
     */
    public RendererTest(final String expectedString,
            final ExampleClass toRender) {
        this.renderer = new Renderer(toRender);
        this.expected = expectedString;
    }

    /**
     * This test will be executed for a couple of times (as defined in
     * parameters).
     *
     * @throws Exception The exception.
     */
    @Test
    public final void testRendering() throws Exception {
        assertEquals(expected, renderer.render());
    }

}
