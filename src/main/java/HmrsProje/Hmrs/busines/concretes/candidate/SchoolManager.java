package HmrsProje.Hmrs.busines.concretes.candidate;

import java.util.List;

import HmrsProje.Hmrs.busines.abstracts.candidate.SchoolService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.SchoolDao;
import HmrsProje.Hmrs.entity.concretes.candidate.School;

public class SchoolManager implements SchoolService{
	SchoolDao schoolDao;

	@Override
	public DataResult<List<School>> getByCandideId(int id) {
		return new SuccessDataResult<List<School>>(schoolDao.getByemployeeCandidateId(id));
		
	}

	@Override
	public Result add(School school) {
		schoolDao.save(school);
		return new SuccessResult("eklendi");
	}

}
