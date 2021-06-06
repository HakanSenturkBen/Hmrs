package HmrsProje.Hmrs.busines.abstracts.candidate;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.candidate.School;


public interface SchoolService {
	DataResult<List<School>>getByCandideId(int id);
	Result add(School workPlace);

}
