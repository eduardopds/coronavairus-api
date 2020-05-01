package coronavairusapi.controllers;

import coronavairusapi.models.Case;
import coronavairusapi.models.CaseRequest;
import coronavairusapi.models.CasesStatistics;
import coronavairusapi.models.Status;
import coronavairusapi.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cases")
@RestController
public class CaseController {

    @Autowired
    private CaseService caseService;


    @PostMapping
    public ResponseEntity<?> create (@RequestBody CaseRequest caseRequest){
        Case caseAux = this.caseService.create(caseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(caseAux);

    }
    
    @GetMapping
    public ResponseEntity<List<Case>> getAll (){
        List<Case> response = this.caseService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Case> getById (@PathVariable("id") Long id){
        Case response = this.caseService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Case> deleteById (@PathVariable("id") Long id){
        return this.caseService.deleteById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Case> updateById (@PathVariable("id") Long id, @RequestBody Case caseAux){
        return this.caseService.update(id,caseAux);
    }

    @GetMapping("/statistics/")
    public ResponseEntity<List<CasesStatistics>> getByStatistics (@RequestParam Status status){
        List<CasesStatistics> response = this.caseService.getStatistics(status);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }




}
