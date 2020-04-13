package coronavairusapi.corona.services;

import coronavairusapi.corona.models.Case;
import coronavairusapi.corona.models.CaseRequest;
import coronavairusapi.corona.repositories.CaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    public Case create(CaseRequest caseRequest){

        Case caseAux = new Case();
        BeanUtils.copyProperties(caseRequest,caseAux);
        return caseRepository.save(caseAux);

    }


}
