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
    @GetMapping("/statistics/")
    public ResponseEntity<List<CasesStatistics>> getByStatistics (@RequestParam Status status){
        List<CasesStatistics> response = this.caseService.getStatistics(status);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }




}
