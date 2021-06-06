package HmrsProje.Hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.candidate.ForeingLanguage;

public interface ForeingLanguageDao extends JpaRepository<ForeingLanguage,Integer>{
	List<ForeingLanguage> getByemployeeCandidateId(int id);

}
