package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.GeneraljoptitleService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.ErrorResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.GeneraljoptitleDao;
import HmrsProje.Hmrs.entity.concretes.Generaljobtitle;

@Service
public class GeneraljoptitleManager implements GeneraljoptitleService{
	GeneraljoptitleDao generaljobtitleDao;
	
	@Autowired
	public GeneraljoptitleManager(GeneraljoptitleDao generaljobtitleDao) {
		super();
		this.generaljobtitleDao = generaljobtitleDao;
	}

	@Override
	public DataResult<List<Generaljobtitle>> getAll() {
		return new SuccessDataResult<List<Generaljobtitle>>(this.generaljobtitleDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Generaljobtitle joptitle) {
		var result=getByjopTitleName(joptitle.getJopTitleName());
		if(result!=null) return new ErrorResult("Aynı isimde bir iş kolu sistemde kayıtlıdır");
		generaljobtitleDao.save(joptitle);
		return new SuccessResult("eklendi");
	}

	
	public DataResult<Generaljobtitle> getByjopTitleName(String jopTitleName) {
		return new SuccessDataResult<Generaljobtitle>(generaljobtitleDao.getByjopTitleName(jopTitleName));
	}


}
