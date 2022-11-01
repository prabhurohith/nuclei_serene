package util;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

public class TestSample {
    /**
     * Str = abcd ==> dcba
     *
     * @param
     */

    public static String reverseString(String inputString) {
        String outputString = "";
        if (inputString != null) {
            for (int cntVal = inputString.length() - 1; cntVal >= 0; cntVal--) {
                outputString += "" + inputString.charAt(cntVal);
            }
        }
        return outputString;
    }

    public static void main(String[] args) {


//        System.out.println(reverseString("Charlie"));
//        System.out.println(reverseString("Char$"));
//        System.out.println(reverseString(" Char"));
//        System.out.println(reverseString("Char -lie"));
//        System.out.println(reverseString("   "));
//        System.out.println(reverseString("192.13.45.6"));
        System.out.println(reverseString(null));


        //Char$
        // Char
        //Char -lie
        //
        //192.13.45.6

    }
}
