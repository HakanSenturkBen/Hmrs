package HmrsProje.Hmrs.busines.concretes.candidate;

import java.util.List;

import HmrsProje.Hmrs.busines.abstracts.candidate.ForeingLanguageService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.ForeingLanguageDao;
import HmrsProje.Hmrs.entity.concretes.candidate.ForeingLanguage;


public class ForeingLanguageManager implements ForeingLanguageService{
	ForeingLanguageDao foreingLanguageDao;

	public ForeingLanguageManager(ForeingLanguageDao foreingLanguageDao) {
		super();
		this.foreingLanguageDao = foreingLanguageDao;
	}

	@Override
	public DataResult<List<ForeingLanguage>> getByCandideId(int id) {
		return new SuccessDataResult<List<ForeingLanguage>>(foreingLanguageDao.getByemployeeCandidateId(id));
		
	}

	@Override
	public Result add(ForeingLanguage foreingLanguage) {
		foreingLanguageDao.save(foreingLanguage);
		return new SuccessResult("eklendi");
	}
	
}
