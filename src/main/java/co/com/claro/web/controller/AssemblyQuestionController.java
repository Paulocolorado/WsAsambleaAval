package co.com.claro.web.controller;

import co.com.claro.entity.AssemblyQuestions;
import co.com.claro.service.AssemblyQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/AssemblyQuestion")
@Slf4j
public class AssemblyQuestionController {
    private final AssemblyQuestionService assemblyQuestionService;
    
    @Autowired
    public AssemblyQuestionController(AssemblyQuestionService assemblyQuestionService) {
        this.assemblyQuestionService = assemblyQuestionService;
    }

    @GetMapping("")
    public List<AssemblyQuestions> getAssemblyQuestions() {
        log.info("process=get-AssemblyQuestions");
        return assemblyQuestionService.getAllAssemblyQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssemblyQuestions> getAssemblyQuestionById( @PathVariable Long id) {
        log.info("process=get-AssemblyQuestions, AssemblyQuestions_num={}", id);
        Optional<AssemblyQuestions> assemblyQuestions = assemblyQuestionService.getAssemblyQuestionsById(id);
        return assemblyQuestions.map( u -> ResponseEntity.ok(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public AssemblyQuestions createAssemblyQuestion(@RequestBody AssemblyQuestions questions) {
        log.info("process=create-AssemblyQuestions, AssemblyQuestions_correo={}", questions.getPregunta());
        return this.assemblyQuestionService.createAssemblyQuestions(questions);
    }

    @PutMapping("/{id}")
    public AssemblyQuestions updateAssemblyQuestion(@PathVariable Long id,
                                            @RequestBody AssemblyQuestions questions) {
        log.info("process=updatete-AssemblyQuestions, AssemblyQuestions_correo={}", questions.getPregunta());
        questions.setId(id);
        return this.assemblyQuestionService.updateAssemblyQuestions(questions);
    }
}
