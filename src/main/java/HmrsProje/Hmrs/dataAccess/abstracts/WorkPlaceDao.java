package HmrsProje.Hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.candidate.WorkPlace;

public interface WorkPlaceDao extends JpaRepository<WorkPlace,Integer>{
	List<WorkPlace> getByemployeeCandidateId(int id);

}
