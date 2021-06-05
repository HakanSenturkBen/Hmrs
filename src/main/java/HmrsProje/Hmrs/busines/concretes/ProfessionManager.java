package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.ProfessionService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.ProfessionDao;
import HmrsProje.Hmrs.entity.concretes.Profession;
@Service
public class ProfessionManager implements ProfessionService {
	ProfessionDao professionDao;

	@Autowired
	public ProfessionManager(ProfessionDao professionDao) {
		super();
		this.professionDao = professionDao;
	}

	@Override
	public DataResult<List<Profession>> getAll() {
		return new SuccessDataResult<List<Profession>>(professionDao.findAll(),"Listelendi");
	}

	@Override
	public Result add(Profession profession) {
		professionDao.save(profession);
		return new SuccessResult("Eklendi");
	}

}
