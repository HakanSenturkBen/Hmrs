package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.PhoneService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.PhoneDao;
import HmrsProje.Hmrs.entity.concretes.Phone;

@Service
public class PhoneManager implements PhoneService {
	PhoneDao phoneDao;

	@Autowired
	public PhoneManager(PhoneDao phoneDao) {
		super();
		this.phoneDao = phoneDao;
	}

	@Override
	public DataResult<List<Phone>> getAll() {
		return new SuccessDataResult<List<Phone>>(phoneDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Phone phone) {
		phoneDao.save(phone);
		return new SuccessResult("eklendi");
	}

}
