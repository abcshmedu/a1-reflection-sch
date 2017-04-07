package edu.hm.cs.schnitzel.reflection;

/**
 *
 * @author nicfel
 */
public class ArrayRenderer {

    /**
     * Method to render the content of an int array.
     *
     * @param ints The int array to render.
     * @return The string representation of the array.
     */
    public final String render(final int[] ints) {
        String result = "[";
        for (final int i : ints) {
            result += (i + ", ");
        }
        result += "]";
        return result;
    }
}
