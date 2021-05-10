package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.GeneraljoptitleService;
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
	public List<Generaljobtitle> getAll() {
		return generaljobtitleDao.findAll();
	}
	

}
