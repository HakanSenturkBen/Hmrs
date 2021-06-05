package HmrsProje.Hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HmrsProje.Hmrs.busines.abstracts.EmployerService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.Employer;
import HmrsProje.Hmrs.entity.dtos.EmployerDto;

@RestController
@RequestMapping("api/employers")
public class EmployersController {
	EmployerService employerService;

	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>>getAll(){
		return employerService.getAll();
	}
	
	@PutMapping("/add")
	public Result add(@RequestBody EmployerDto employer) {
		return employerService.add(employer);
	}

}
