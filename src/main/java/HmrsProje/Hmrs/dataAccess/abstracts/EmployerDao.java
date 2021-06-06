package HmrsProje.Hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	Employer getBycompanyName(String name );

}
