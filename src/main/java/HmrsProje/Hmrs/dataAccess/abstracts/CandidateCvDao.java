package HmrsProje.Hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.candidate.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv,Integer>{
	CandidateCv getByemployeeCandidateId(int id);

}
