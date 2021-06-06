package HmrsProje.Hmrs.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import HmrsProje.Hmrs.entity.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
	JobAdvertisement getByemployerId(int employerId);
	
	@Query("from JobAdvertisement where companyName=:companyName and activity=:activity")
	List<JobAdvertisement> getByNameAndActivity(String companyName, boolean activity );

}
