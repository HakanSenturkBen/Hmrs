package HmrsProje.Hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HmrsProje.Hmrs.busines.abstracts.candidate.CandidateCvService;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.entity.concretes.candidate.CandidateCv;
import HmrsProje.Hmrs.entity.dtos.CvDto;

@RestController
@RequestMapping("api/candidateCv")
public class CandidateCvController {
	CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	} 
	
	@GetMapping("/getCvByPersonId")
	public CvDto getCvByPersonId(int personId) {
		return candidateCvService.getFullCvById(personId);
	}
	@PostMapping("/add")
	public Result add(CandidateCv candidateCv) {
		return candidateCvService.add(candidateCv);
		
	}

}
