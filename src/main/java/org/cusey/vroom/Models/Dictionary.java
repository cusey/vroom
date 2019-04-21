package org.cusey.vroom.Models;

public class Dictionary {

    public String word;
    public String partOfSpeech;
    public String definition;
    public String wordUsage;

    public Dictionary(String word, String partOfSpeech, String definition, String wordUsage) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
        this.wordUsage = wordUsage;
    }

    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }

    public String getPartOfSpeech() { return partOfSpeech; }
    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }

    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }

    public String getWordUsage() { return wordUsage; }
    public void setWordUsage(String wordUsage) { this.wordUsage = wordUsage; }
}
