package coronavairusapi.services;

import coronavairusapi.models.Case;
import coronavairusapi.models.CaseRequest;
import coronavairusapi.models.CasesStatistics;
import coronavairusapi.models.Status;
import coronavairusapi.repositories.CaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    public Case create(CaseRequest caseRequest){

        Case caseAux = new Case();
        BeanUtils.copyProperties(caseRequest,caseAux);
        return this.caseRepository.save(caseAux);

    }
    public List<CasesStatistics> getStatistics(Status status){
        return this.caseRepository.getStatistics(status);
    }

    public List<Case> getAll() {

        return this.caseRepository.findAll();
    }

    public Case getById(Long id) {
        Optional<Case> caseAux = this.caseRepository.findById(id);
        if(caseAux.isPresent()){
            return caseAux.get();
        }
        return  null;

    }
    public ResponseEntity<Case> deleteById(Long id) {
        Optional<Case> caseAux = this.caseRepository.findById(id);
        if (caseAux.isPresent()) {
            this.caseRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        return null;
    }

    public ResponseEntity<Case> update(Long id, Case caseUp) {
        Optional<Case> caseToBeUpdated = this.caseRepository.findById(id);
        if (caseToBeUpdated.isPresent()) {
           Case caseAux = caseToBeUpdated.get();
           BeanUtils.copyProperties(caseUp,caseAux,"id");
           return ResponseEntity.status(HttpStatus.OK).body(this.caseRepository.save(caseAux));

        }
        return null;
    }



}
