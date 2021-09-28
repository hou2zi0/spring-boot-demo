package io.hou2zi0.springbootdemo.vocabulary;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class VocabularyConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(VocabularyRepository vocabularyRepository){
        return args -> {
            // Mock-Datensätze
            Vocabulary beizi = new Vocabulary(
                        "杯子", 
                        "杯子", 
                        "bēizi", 
                        "die Tasse", 
                        "https://en.wiktionary.org/wiki/%E6%9D%AF%E5%AD%90#Chinese"
                        );
            Vocabulary ai = new Vocabulary(
                        "爱", 
                        "愛", 
                        "ài", 
                        "lieben; die Liebe", 
                        "https://en.wiktionary.org/wiki/%E6%84%9B#Chinese"
                        );
            Vocabulary beijing = new Vocabulary(
                        "北京", 
                        "北京", 
                        "běijīng", 
                        "Peking", 
                        "https://en.wiktionary.org/wiki/%E5%8C%97%E4%BA%AC#Chinese"
                        );
            Vocabulary ben = new Vocabulary(
                        "本", 
                        "本", 
                        "běn", 
                        "Zählwort für Bücher; die Wurzel", 
                        "https://en.wiktionary.org/wiki/%E6%9C%AC#Chinese"
                        );
            Vocabulary baba = new Vocabulary(
                        "爸爸", 
                        "爸爸", 
                        "bàba", 
                        "Papa", 
                        "https://en.wiktionary.org/wiki/%E7%88%B8%E7%88%B8#Chinese"
                        );
            Vocabulary ba = new Vocabulary(
                        "八", 
                        "八", 
                        "bā", 
                        "acht", 
                        "https://en.wiktionary.org/wiki/%E5%85%AB#Chinese"
                        );
            // Mock-Datensätze in Datenbank speichern
            vocabularyRepository.saveAll(
                List.of(beizi, ai, beijing, ben, baba, ba)
            );
        };
    }
}
