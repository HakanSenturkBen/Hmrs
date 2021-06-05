package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.WorkerService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.WorkerDao;
import HmrsProje.Hmrs.entity.concretes.Worker;

@Service
public class WorkerManager implements WorkerService {
	WorkerDao workerDao;

	@Autowired
	public WorkerManager(WorkerDao workerDao) {
		super();
		this.workerDao = workerDao;
	}

	@Override
	public DataResult<List<Worker>> getAll() {
		return new SuccessDataResult<List<Worker>>(workerDao.findAll());
	}

	@Override
	public Result add(Worker worker) {
		workerDao.save(worker);
		return new SuccessResult("eklendi");
	}

}
