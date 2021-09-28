package io.hou2zi0.springbootdemo.vocabulary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Vocabulary {
//
// Attributes 
//
    // ID
    @Id
    @SequenceGenerator(
        name = "vocabulary_sequence",
        sequenceName = "vocabulary_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "vocabulary_sequence"
    )
    private Long identifier;
    // simplified
    private String simplified;
    // traditional
    private String traditional;
    // pinyin
    private String pinyin;
    // translation
    private String translations;
    // wiktionary
    private String wiktionary;

//
// Constructors
//
    // Keep defaults
    public Vocabulary(){
        super();
    }
 
    // Main constructor
    public Vocabulary(Long identifier, 
                    String simplified, 
                    String traditional, 
                    String pinyin, 
                    String translations,
                    String wiktionary) {
        this.identifier = identifier;
        this.simplified = simplified;
        this.traditional = traditional;
        this.pinyin = pinyin;
        this.translations = translations;
        this.wiktionary = wiktionary;
    }

    // Constructor sans Identifier 
    public Vocabulary(String simplified, 
                    String traditional, 
                    String pinyin, 
                    String translations, 
                    String wiktionary) {
        this.simplified = simplified;
        this.traditional = traditional;
        this.pinyin = pinyin;
        this.translations = translations;
        this.wiktionary = wiktionary;
    }


//
// Getters & Setters 
//    
    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public String getSimplified() {
        return simplified;
    }

    public void setSimplified(String simplified) {
        this.simplified = simplified;
    }

    public String getTraditional() {
        return traditional;
    }

    public void setTraditional(String traditional) {
        this.traditional = traditional;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getTranslations() {
        return translations;
    }

    public void setTranslations(String translations) {
        this.translations = translations;
    }

    public String getWiktionary() {
        return wiktionary;
    }

    public void setWiktionary(String wiktionary) {
        this.wiktionary = wiktionary;
    }

    @Override
    public String toString() {
        return "Vocabulary [ pinyin=" + pinyin + ", simplified=" + simplified
                + ", traditional=" + traditional + ", translations=" + translations + ", wiktionary=" + wiktionary
                + "]";
    }
    

    
}