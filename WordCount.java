import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        Map<String, Integer> freq = new LinkedHashMap<>(); //chainhashmap is not working
        //scan input for words using all non letters as delimiters

        System.out.println("Put in some words");
        Scanner docs = new Scanner(System.in); ///.useDelimiter("[^a-zA-Z]+");
        String doc = docs.nextLine();

        for (int i = 0; i < doc.length(); i++) {
            char word = doc.toLowerCase().charAt(i);
            String words = String.valueOf(word);
            Integer count = freq.get(words);
            if (count == null) {
                count = 0;
                freq.put(words, 1+count);
            }
            else {
                freq.put(words, 1+count);
            }

        }
/*        while (doc.hasNext()) {
            String word = doc.next().toLowerCase(); //convert the next word to lowercase
            Integer count = freq.get(word); //get the previous count for this word
            if (count == null) {
                count = 0; //make the count go from null to zero. This means that if it hasn't seen the word it will be null first
                freq.put(word, 1+count); //add one to the word
            }
        }*/


        int maxCount =0;
        String maxWord = "no word";
        for (Map.Entry<String, Integer> ent: freq.entrySet()) { //this is to find the max count of words in the map
            if (ent.getValue() > maxCount) {
                maxWord = ent.getKey();
                maxCount = ent.getValue();

            }
        }
        System.out.println("The most frequent word is " + maxWord);
        System.out.println("with " + maxCount+ " occurrences.");


    }
}
