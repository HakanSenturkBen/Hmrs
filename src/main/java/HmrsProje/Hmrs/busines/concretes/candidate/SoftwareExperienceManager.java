package HmrsProje.Hmrs.busines.concretes.candidate;

import java.util.List;

import HmrsProje.Hmrs.busines.abstracts.candidate.SoftwareExperienceService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.SoftwareExperienceDao;
import HmrsProje.Hmrs.entity.concretes.candidate.SoftwareExperience;

public class SoftwareExperienceManager implements SoftwareExperienceService {
	SoftwareExperienceDao softwareExperienceDao; 

	public SoftwareExperienceManager(SoftwareExperienceDao softwareExperienceDao) {
		super();
		this.softwareExperienceDao = softwareExperienceDao;
	}

	@Override
	public DataResult<List<SoftwareExperience>> getByCandideId(int id) {
		return new SuccessDataResult<List<SoftwareExperience>>(softwareExperienceDao.getByemployeeCandidateId(id));
	}

	@Override
	public Result add(SoftwareExperience softwareExperience) {
		softwareExperienceDao.save(softwareExperience);
		return new SuccessResult("eklendi");
	}

}
