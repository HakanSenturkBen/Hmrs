package HmrsProje.Hmrs.busines.abstracts.candidate;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.candidate.WorkPlace;

public interface WorkPlaceService {
	DataResult<List<WorkPlace>>getByCandideId(int id);
	Result add(WorkPlace workPlace);
}
