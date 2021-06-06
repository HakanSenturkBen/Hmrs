package HmrsProje.Hmrs.busines.concretes.candidate;

import java.util.List;

import HmrsProje.Hmrs.busines.abstracts.candidate.WorkPlaceService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.WorkPlaceDao;
import HmrsProje.Hmrs.entity.concretes.candidate.WorkPlace;

public class WorkPlaceManager implements WorkPlaceService{
	WorkPlaceDao workPlaceDao;

	public WorkPlaceManager(WorkPlaceDao workPlaceDao) {
		super();
		this.workPlaceDao = workPlaceDao;
	}

	@Override
	public DataResult<List<WorkPlace>> getByCandideId(int id) {
		return new SuccessDataResult<List<WorkPlace>>(workPlaceDao.getByemployeeCandidateId(id));
	}

	@Override
	public Result add(WorkPlace workPlace) {
		workPlaceDao.save(workPlace);
		return new SuccessResult("eklendi");
	}
	

}
