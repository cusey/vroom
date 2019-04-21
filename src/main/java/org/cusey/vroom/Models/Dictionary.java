package org.cusey.vroom.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="t_dictionary")
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String word;
    private String partOfSpeech;
    private String definition;
    private String wordUsage;

    public Dictionary(){}

    public Dictionary(int id, String word, String partOfSpeech, String definition, String wordUsage) {
        this.id = id;
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
        this.wordUsage = wordUsage;
    }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }

    public String getPartOfSpeech() { return partOfSpeech; }
    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }

    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }

    public String getWordUsage() { return wordUsage; }
    public void setWordUsage(String wordUsage) { this.wordUsage = wordUsage; }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                ", definition='" + definition + '\'' +
                ", wordUsage='" + wordUsage + '\'' +
                '}';
    }
}

