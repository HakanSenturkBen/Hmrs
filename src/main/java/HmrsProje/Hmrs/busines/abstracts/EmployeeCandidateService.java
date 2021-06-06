package HmrsProje.Hmrs.busines.abstracts;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.EmployeeCandidate;
import HmrsProje.Hmrs.entity.dtos.EmployeeCandidateDto;


public interface EmployeeCandidateService  {
	DataResult<List<EmployeeCandidate>>getAll();
	Result add(EmployeeCandidateDto employeeCandidate);
	DataResult<EmployeeCandidate>getById(int id);

}
