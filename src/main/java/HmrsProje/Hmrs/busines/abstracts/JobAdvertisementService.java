package HmrsProje.Hmrs.busines.abstracts;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.JobAdvertisement;
import HmrsProje.Hmrs.entity.dtos.JobAdvertisementDto;


public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>>getAll();
	DataResult<List<JobAdvertisement>>getAllOrderByEndDate();
	DataResult<List<JobAdvertisement>>getByNameAndActivity(String companyName, boolean activity );
	Result add(JobAdvertisementDto jobAdvertisementDto);

	
}
