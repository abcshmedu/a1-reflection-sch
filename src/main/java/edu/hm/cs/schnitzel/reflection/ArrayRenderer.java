package edu.hm.cs.schnitzel.reflection;

/**
 *
 * @author nicfel
 */
public class ArrayRenderer {

    public String render(int[] ints) {
    	String result = "[";
    	for (final int i : ints) {
    		result += (i + ", ");
    	}
    	result += "]";
    	return result;
    }
}
