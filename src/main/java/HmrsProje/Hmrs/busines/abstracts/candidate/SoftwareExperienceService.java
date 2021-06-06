package HmrsProje.Hmrs.busines.abstracts.candidate;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.candidate.SoftwareExperience;


public interface SoftwareExperienceService {
	DataResult<List<SoftwareExperience>>getByCandideId(int id);
	Result add(SoftwareExperience workPlace);
}
