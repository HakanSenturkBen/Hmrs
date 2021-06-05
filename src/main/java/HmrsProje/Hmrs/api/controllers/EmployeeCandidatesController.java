package HmrsProje.Hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HmrsProje.Hmrs.busines.abstracts.EmployeeCandidateService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.EmployeeCandidate;
import HmrsProje.Hmrs.entity.dtos.EmployeeCandidateDto;

@RestController
@RequestMapping("api/employeeCantidates")
public class EmployeeCandidatesController {
	EmployeeCandidateService employeeCandidateService;
	
	@Autowired
	public EmployeeCandidatesController(EmployeeCandidateService employeeCandidateService) {
		super();
		this.employeeCandidateService = employeeCandidateService;
	}
	@GetMapping("/getall")
	public DataResult<List<EmployeeCandidate>> getAll(){
		return employeeCandidateService.getAll();
	}

	@PutMapping("/add")
	public Result add(@RequestBody EmployeeCandidateDto employeeCandidate) {
		return employeeCandidateService.add(employeeCandidate);
	}

}
