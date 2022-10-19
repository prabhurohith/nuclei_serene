package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.data.ActorInfo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestData {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<ActorInfo> actorsData = objectMapper.readValue(
                    new File("./src/test/resources/data/actors/ActorInfo.json"),
                    new TypeReference<List<ActorInfo>>() {
                    });
            ActorInfo desiredActor = actorsData.stream().filter(actorInfo -> actorInfo.getName().contains("Jack")).findFirst().get();
            System.out.println(desiredActor.getDescription());


            /**
             *         Anagrams from list
             */
            // Calculate the asci of each
            // Store the str with its ascii in map
            // Take values from map and filter whose freq >1
            // Iterate over the map to filter the values == value whose freq>1

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


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
