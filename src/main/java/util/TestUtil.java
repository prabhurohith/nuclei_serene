package util;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {


    @AllArgsConstructor
    static
    class Student implements Comparable<Student> {
        String nameOfStudent;
        int age;
        int score;


        @Override
        public int compareTo(@NotNull Student otherStudent) {
            return (this.nameOfStudent + this.score)
                    .compareTo(otherStudent.nameOfStudent + otherStudent.score);
        }
    }

    public static void main(String[] args) {

        /**
         *         Anagrams from list
         */

/*        List<String> allNos = new ArrayList<>(Arrays.asList("abc", "cbba", "bca"));
        Map<String, Integer> asciiValues = new HashMap<String, Integer>();

        //Take ascii of each and store in map
        for (String indNo : allNos) {
            int ascii_str = 0;
            for (int cntVal = 0; cntVal < indNo.length(); cntVal++) {
                ascii_str = ascii_str + indNo.charAt(cntVal);
            }
            asciiValues.put(indNo, ascii_str);
        }
        System.out.println(asciiValues.values());
        // Store in map
        // Get all values with freq more than 1
        List<Integer> anagramVals = asciiValues.values().stream().
                filter(indVal -> Collections.frequency(asciiValues.values(), indVal) > 1).collect(Collectors.toList());
        System.out.println(anagramVals);

        // Fetch from Map whose values are in anagrams
        for (Map.Entry<String, Integer> indVal : asciiValues.entrySet()) {
            if (anagramVals.contains(indVal.getValue()))
                System.out.println(indVal.getKey());
        }*/

        // See String tokenizer / joiner


        /**
         *        1,2,2,3,4,5,3,3,6,6,9,9,5,5,5 : Get odd and even no with max frequency and display it
         */

        // Sort the odd even nos  and store to map with no,freq
        // Fetch all values and take max val from it
        // Search in map with value == max

        /*List<Integer> allNos = new ArrayList<>(List.of(1, 2, 2, 3, 4, 5, 3, 3, 6, 6, 9, 9, 5, 5, 5));
        Map<Integer, Integer> freqInfoOfNos = new HashMap<>();

        //Even handling
        List<Integer> allEvenNos = allNos.stream().filter(indNo -> indNo % 2 == 0).collect(Collectors.toList());
        List<Integer> allOddNos = allNos.stream().filter(indNo -> indNo % 2 != 0).collect(Collectors.toList());
        List<List<Integer>> sortedList = new ArrayList<>(List.of(allEvenNos, allOddNos));

        for (List<Integer> desiredList : sortedList) {
            List<Integer> allDistinct = desiredList.stream().distinct().collect(Collectors.toList());
            allDistinct.forEach(indVal -> freqInfoOfNos.put(indVal, Collections.frequency(desiredList, indVal)));
            System.out.println(freqInfoOfNos);
            //Get max frequency
            int maxVal = Collections.max(freqInfoOfNos.values());
            for (Map.Entry indVal : freqInfoOfNos.entrySet()) {
                if (indVal.getValue().equals(maxVal)) {
                    System.out.println(indVal.getKey() + "--  Freq -- " + indVal.getValue());
                }
            }
        }*/

/**        - Students name , age , score ...
 Name : Alex Haley ,Age: 13 , Score : 20
 Name : Bob Marley ,Age: 12 , Score : 20
 Name : Tim Bird ,Age: 14 , Score : 19

 Sort by Name and Score
 */
// Create POJO for student
// Implement the sort logic in compare
// Do Compare

/*
        List<Student> allStuds = new ArrayList<>
                (List.of(new Student("Ram", 19, 55),
                        new Student("Ram", 20, 56),
                        new Student("Shyam", 21, 56)));
        allStuds.forEach(indStudent -> System.out.println(indStudent.nameOfStudent + " " + indStudent.age + " " + indStudent.score));
        Collections.sort(allStuds);
        System.out.println(" The sorting ");
        allStuds.forEach(indStudent -> System.out.println(indStudent.nameOfStudent + " " + indStudent.age + " " + indStudent.score));

*/

        /**
         *         - 5,2,3,6,1,9,4,8,14,7  == > 1,2,3,6,5,7,4 ... : Sort only the odd nos keeping the even no's position intact
         */

        /*List<Integer> allNos = new ArrayList<>(List.of(5, 2, 3, 6, 1, 9, 4, 8, 14, 7));
        //Sort odd and even nos in list
        List<Integer> oddNos = allNos.stream().filter(indVal -> indVal % 2 != 0).collect(Collectors.toList());
        List<Integer> allSorted = new ArrayList<>();

        // Apply sort to odd nos
        Collections.sort(oddNos);
        Iterator<Integer> oddNoIter = oddNos.iterator();

        // Take og list and replace if odd occurs with the one in odd sorted
        for (Integer indVal : allNos) {
            if (indVal % 2 == 0) {
                allSorted.add(indVal);
            } else {
                allSorted.add(oddNoIter.next());
            }

        }
        // Display the index
        //print output
        System.out.println(allSorted);*/


        /**
         * - ss,dd,ss,kk,gg,gg,jj : Find first non repetitive string
         */

        /*//Store the strinng in list
        List<String> allChars = new ArrayList<>(List.of("ss", "dd", "ss", "kk", "gg", "gg", "jj"));
        //iterate over the list and find the first element whose freq ==1
        String firstNonRep = allChars.stream().filter(indVal -> Collections.frequency(allChars, indVal) == 1)
                .collect(Collectors.toList()).stream().findFirst().get();
        //display the results
        System.out.println(firstNonRep);*/


        /**
         *  Write a Java program to calculate a Factorial of a number.
         *  e.g 5! = 5*4*3*2*1
         */

        // Take the number
        // cal fact : n(n-1)
        //Store the recursive sum into a constant

        /*int desiredNo = 5;
        int initialValue = desiredNo;
        for (int cntVal = desiredNo; cntVal > 1; cntVal--) {
            initialValue = initialValue * (cntVal - 1);
        }
        System.out.println(initialValue);*/
        /**
         * Write a Java program to calculate Fibonacci Series up to n numbers.
         * 0 1 1 2 3 5 8 13
         */
        // Logic to get fibo series : prevNo = prevNo+currentNo ,
        // Get all nos till the no is <=threshod (n)
        /*int desiredNo = 1;
        int prevNo = 0;
        List<Integer> allNos = new ArrayList<>();
        allNos.add(prevNo);
        for (int cntVal = 0; cntVal <= desiredNo; cntVal++) {
            if (allNos.size() < 2) {
                prevNo++;
            } else {
                prevNo = allNos.get(cntVal) + allNos.get(cntVal - 1);
            }
            if (prevNo > desiredNo) {
                break;
            }
            allNos.add(prevNo);
        }
        System.out.println(allNos);*/
        /**
         * Write a Java program to find out whether the given String is Palindrome or not.
         */
        // Split string into 2 remove/ignore the extra char if no is odd
        // convert all to upper or lower case
        // Get the ascii of char and compute for both strings
        // if str1==str2 the palindrom or not


       /* String desiredString = "n$tg$n";

        //Split +ignore
        String firstPart = desiredString.substring(0, Math.floorDiv(desiredString.length(), 2));
        String secondPart;
        if (desiredString.length() % 2 == 0) {
            secondPart = desiredString.substring(Math.floorDiv(desiredString.length(), 2));
        } else {
            secondPart = desiredString.substring(Math.floorDiv(desiredString.length() + 1, 2));
        }
        List<String> splitValues = new ArrayList<>(List.of(firstPart, secondPart));
        List<Integer> allValues = new ArrayList<>();

        for (int splitIndex = 0; splitIndex < 2; splitIndex++) {
            int asciiValue = 0;
            for (int cntVal = 0; cntVal < firstPart.length(); cntVal++) {
                asciiValue += splitValues.get(splitIndex).charAt(cntVal);
            }
            allValues.add(asciiValue);
        }

        System.out.println(allValues);
        if (allValues.get(0).equals(allValues.get(1))) {
            System.out.println("Its a palindrome");
        } else {
            System.out.println("its not");
        }

        //We can use str buffer + reverse as well here
        System.out.println(new StringBuffer(firstPart).toString());
        System.out.println(new StringBuffer(secondPart).reverse().toString());
        boolean isPalindrome = new StringBuffer(firstPart).toString().equalsIgnoreCase(new StringBuffer(secondPart).reverse().toString());
        System.out.println(isPalindrome);*/

    }
}
