package coronavairusapi.corona.controllers;

import coronavairusapi.corona.models.Case;
import coronavairusapi.corona.models.CaseRequest;
import coronavairusapi.corona.services.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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




}
