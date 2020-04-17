package coronavairusapi.repositories;

import coronavairusapi.models.Case;
import coronavairusapi.models.CasesStatistics;
import coronavairusapi.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case,Long> {


    @Query("SELECT new coronavairusapi.models.CasesStatistics(c.created, COUNT(c)) FROM Case c WHERE c.status = :status GROUP BY c.created ORDER BY c.created")
    List<CasesStatistics> getStatistics(@Param("status") Status status);

}
