package ex3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsCounter {
    private ArrayList <String> wordsToList() {
        ArrayList <String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
    private ArrayList <String> uniqueWords() {
        Set <String> set = new HashSet<>(wordsToList());
        return new ArrayList<>(set);
    }
    private ArrayList<Element> elementArrayList() {
        ArrayList<Element> elementArrayList = new ArrayList<>();
        ArrayList <String> words = wordsToList();
        ArrayList<String> uniqueWords = uniqueWords();
        for (String uw : uniqueWords) {
            Element element = new Element(uw);
            int elementCounter = 0;
            for (String word : words) {
                if (word.equals(uw)) {elementCounter++;}
            }
            element.setCount(elementCounter);
            elementArrayList.add(element);
        }
        Collections.sort(elementArrayList);
        return elementArrayList;
    }
    @Override
    public String toString() {
        ArrayList<Element> elements =  elementArrayList();
        StringBuilder result = new StringBuilder();
        for (Element e : elements) {
            result.append(e.getWord()).append(" ").append(e.getCount()).append("\n");
        }
        return new String(result);
    }
}
