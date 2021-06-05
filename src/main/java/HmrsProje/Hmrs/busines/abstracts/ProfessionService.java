package HmrsProje.Hmrs.busines.abstracts;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.Profession;


public interface ProfessionService {
	DataResult<List<Profession>>getAll();
	Result add(Profession profession);
	

}
