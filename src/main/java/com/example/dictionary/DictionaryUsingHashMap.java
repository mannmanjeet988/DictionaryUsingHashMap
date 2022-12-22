package com.example.dictionary;

import java.util.HashMap;

public class DictionaryUsingHashMap {

    HashMap<String, String> dictionary;

    public DictionaryUsingHashMap() {
        this.dictionary = new HashMap<>();
        addWordList();
    }
    public boolean addWord(String word, String meaning){
        try{
            dictionary.put(word,meaning);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getMeaning(String word){
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        else{
            return "Word does not exist in dictionary!";
        }
    }

    private void addWordList(){
       addWord("hello", "greeting");
        addWord("whole", "complete");
        addWord("grow", "increase in size");
        addWord("Holy", "Pious");
        addWord("complex", "difficult");
        addWord("shubh", "Auspicious");
        addWord("phase", "a stage in the development of something");
        addWord("project", "an individual or collaborative enterprise that is carefully planned to achieve a particular aim");
        addWord("start", "beginning");
        addWord("depreciating assets ", "Whose value decreases with time");
    }
}
