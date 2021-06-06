package HmrsProje.Hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.candidate.SoftwareExperience;

public interface SoftwareExperienceDao extends JpaRepository<SoftwareExperience, Integer>{
	List<SoftwareExperience>getByemployeeCandidateId(int id);

}
