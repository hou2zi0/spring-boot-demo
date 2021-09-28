package io.hou2zi0.springbootdemo.vocabulary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    @Autowired
    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    // CREATE
    public Optional<Vocabulary> addNewVocabulary(Vocabulary vocabulary) {
        Optional<Vocabulary> vocabularyOptional = vocabularyRepository.findVocabularyBySimplified(vocabulary.getSimplified());
        if(vocabularyOptional.isPresent()){
            //throw new IllegalStateException("Item already in database.");
            return vocabularyOptional;
        } else {
            System.out.println(vocabulary);
            vocabularyRepository.save(vocabulary);
            return vocabularyOptional;
        }
    }

    // READ
    public List<Vocabulary> getVocabulary(){
        return vocabularyRepository.findAll();     
    }

    public Vocabulary getVocabulary(Long vocabularyId){
        Optional<Vocabulary> vocabularyOptional = vocabularyRepository.findById(vocabularyId);
        if(vocabularyOptional.isPresent()){  
            return vocabularyOptional.get();
        }  else {
            throw new IllegalStateException("Item does not exist in database.");
        }
    }

    // UPDATE
    @Transactional
    public Optional<Vocabulary> updateVocabulary(Vocabulary payload) {
        Optional<Vocabulary> vocabularyOptional = vocabularyRepository.findById(payload.getIdentifier());
        if(vocabularyOptional.isPresent()){
            Vocabulary vocabItem = vocabularyOptional.get();
            if(payload.getSimplified() != null){
                vocabItem.setSimplified(payload.getSimplified());
            }
            if(payload.getTraditional() != null){
                vocabItem.setTraditional(payload.getTraditional());
            }
            if(payload.getPinyin() != null){
                vocabItem.setPinyin(payload.getPinyin());
            }
            if(payload.getTranslations() != null){
                vocabItem.setTranslations(payload.getTranslations());
            }
            if(payload.getWiktionary() != null){
                vocabItem.setWiktionary(payload.getWiktionary());
            }
        } else {
            throw new IllegalStateException("Item does not exist in database.");
        }
        return vocabularyOptional;
    }

    // DELETE
    public Optional<Vocabulary> deleteVocabulary(Long vocabularyId) {
        System.out.println(vocabularyId);
        Optional <Vocabulary> vocabularyOptional = vocabularyRepository.findById(vocabularyId);
        if (vocabularyOptional.isPresent()) {
            System.out.println(vocabularyOptional.get());
            vocabularyRepository.deleteById(vocabularyId);
            return vocabularyOptional;
        } else {
            //throw new IllegalStateException("Item does not exist in database.");
            return vocabularyOptional;
        }
    }

    // OTHER
    public void printVocabularyPayload(Vocabulary vocabulary) {
        System.out.println(vocabulary);
    }
}