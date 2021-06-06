package HmrsProje.Hmrs.busines.abstracts;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.Employer;
import HmrsProje.Hmrs.entity.dtos.EmployerDto;


public interface EmployerService {
	DataResult<List<Employer>>getAll();
	Result add(EmployerDto employer);
	DataResult<Employer>getBycompanyName(String name);

}
