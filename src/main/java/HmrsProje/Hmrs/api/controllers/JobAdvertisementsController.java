package HmrsProje.Hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HmrsProje.Hmrs.busines.abstracts.JobAdvertisementService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.JobAdvertisement;
import HmrsProje.Hmrs.entity.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("api/jobAdvertisements")
public class JobAdvertisementsController {
	JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllOrderByEndDate")
	public DataResult<List<JobAdvertisement>> getAllOrderByEndDate() {
		return jobAdvertisementService.getAllOrderByEndDate();
	}
	
	@GetMapping("/getByNameAndActivity")
	public DataResult<List<JobAdvertisement>> getByNameAndActivity(String companyName, boolean activity) {
		return jobAdvertisementService.getByNameAndActivity(companyName, activity);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
		return jobAdvertisementService.add(jobAdvertisementDto);
	}
	
}
