package io.hou2zi0.springbootdemo.vocabulary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long>{

    @Query("SELECT s FROM Vocabulary s WHERE s.simplified = ?1")
    Optional<Vocabulary> findVocabularyBySimplified(String simplified);

    @Query("SELECT s FROM Vocabulary s WHERE s.traditional = ?1")
    Optional<Vocabulary> findVocabularyByTraditional(String traditional);

    @Query("SELECT s FROM Vocabulary s WHERE s.pinyin = ?1")
    Optional<Vocabulary> findVocabularyByPinyin(String pinyin);
}
