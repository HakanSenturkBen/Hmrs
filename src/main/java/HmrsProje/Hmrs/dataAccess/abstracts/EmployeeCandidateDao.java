package HmrsProje.Hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.EmployeeCandidate;

public interface EmployeeCandidateDao  extends JpaRepository<EmployeeCandidate, Integer> {
	
	EmployeeCandidate getBycitizenshipIdentity(String citizenshipIdentity); 
	EmployeeCandidate getByid(int id);
	

}
