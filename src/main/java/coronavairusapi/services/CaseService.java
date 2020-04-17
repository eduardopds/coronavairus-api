package coronavairusapi.services;

import coronavairusapi.models.Case;
import coronavairusapi.models.CaseRequest;
import coronavairusapi.models.CasesStatistics;
import coronavairusapi.models.Status;
import coronavairusapi.repositories.CaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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




}
