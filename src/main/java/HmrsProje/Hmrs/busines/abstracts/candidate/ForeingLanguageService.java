package HmrsProje.Hmrs.busines.abstracts.candidate;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.candidate.ForeingLanguage;

public interface ForeingLanguageService {
	DataResult<List<ForeingLanguage>>getByCandideId(int id);
	Result add(ForeingLanguage workPlace);
}
