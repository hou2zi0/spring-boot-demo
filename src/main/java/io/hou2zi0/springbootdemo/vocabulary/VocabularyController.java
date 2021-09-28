package io.hou2zi0.springbootdemo.vocabulary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin
@RestController
@RequestMapping(path = "/")
public class VocabularyController {

    private final VocabularyService vocabularyService;
 
    
    @Autowired
    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    // CREATE
    @PostMapping("api/v1/mandarin")
    public void addNewVocabulary(@RequestBody Vocabulary vocabulary) {
        vocabularyService.addNewVocabulary(vocabulary);
    }

    // CREATE JSP Views
    @PostMapping("add")
    public RedirectView add(@ModelAttribute("vocab") Vocabulary vocab, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/add", true);
        Optional<Vocabulary> savedVocab = vocabularyService.addNewVocabulary(vocab);
        if(savedVocab.isPresent()){
            redirectAttributes.addFlashAttribute("savedVocab", savedVocab.get());
            redirectAttributes.addFlashAttribute("addVocabFailure", true);
        } else {
            redirectAttributes.addFlashAttribute("savedVocab", vocab);
            redirectAttributes.addFlashAttribute("addVocabSuccess", true);
        }
        
        return redirectView;
    } 

    // READ
    @GetMapping("api/v1/mandarin")
    public List<Vocabulary> getVocabulary(){
        return vocabularyService.getVocabulary();
    }

    @GetMapping("api/v1/mandarin/{vocabId}")
    public Vocabulary getVocabulary(@PathVariable("vocabId") Long vocabularyId){
        return vocabularyService.getVocabulary(vocabularyId);
    }

    // READ JSP Views
    @GetMapping("vocab")
    public ModelAndView main(){
        ModelAndView mv = new ModelAndView("view-main");
        mv.addObject("vocab", vocabularyService.getVocabulary());
        return mv;
        }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView("view-add");
        mv.addObject("vocab", new Vocabulary());
        return mv;
        }

    @GetMapping("update/{vocabId}")
        public ModelAndView update(@PathVariable("vocabId") Long vocabularyId){
            ModelAndView mv = new ModelAndView("view-update");
            mv.addObject("vocab", vocabularyService.getVocabulary(vocabularyId));
            return mv;
        }

    @GetMapping("mandarin/{vocabId}")
        public ModelAndView single(@PathVariable("vocabId") Long vocabularyId){
            ModelAndView mv = new ModelAndView("view-single");
            mv.addObject("vocab", vocabularyService.getVocabulary(vocabularyId));
            return mv;
        }
    
    // UPDATE
    @PutMapping("api/v1/mandarin/{vocabId}")
    public void updateVocabulary(@RequestBody Vocabulary vocabulary) {
        vocabularyService.updateVocabulary(vocabulary);
    }

    @PutMapping("update")
    public RedirectView update(@ModelAttribute("vocab") Vocabulary vocab, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/vocab", true);
        vocabularyService.updateVocabulary(vocab);
        return redirectView;
    } 

    // DELETE
    @DeleteMapping("api/v1/mandarin/{vocabId}")
    public void deleteVocabulary(@PathVariable("vocabId") Long vocabularyId) {
        vocabularyService.deleteVocabulary(vocabularyId);
    }

    @DeleteMapping("mandarin/delete/{vocabId}")
    public String delete(@PathVariable("vocabId") Long vocabularyId) {
        vocabularyService.deleteVocabulary(vocabularyId);    
        return "redirect:vocab";
    } 

    // OTHER
    @PostMapping("api/v1/mandarin/print")
    public void printVocabularyPayload(@RequestBody Vocabulary vocabulary) {
        vocabularyService.printVocabularyPayload(vocabulary);
    }
}
