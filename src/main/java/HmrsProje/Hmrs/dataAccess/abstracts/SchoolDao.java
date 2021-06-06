package HmrsProje.Hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.candidate.School;

public interface SchoolDao extends JpaRepository<School,Integer>{
	List<School> getByemployeeCandidateId(int id);

}
