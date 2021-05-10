package HmrsProje.Hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HmrsProje.Hmrs.busines.abstracts.GeneraljoptitleService;
import HmrsProje.Hmrs.entity.concretes.Generaljobtitle;

@RestController
@RequestMapping("api/generaljoptitles")
public class GeneraljoptitlesController {
	GeneraljoptitleService generaljoptitleService;
	@Autowired
	public GeneraljoptitlesController(GeneraljoptitleService generaljoptitleService) {
		super();
		this.generaljoptitleService = generaljoptitleService;
	}
	@GetMapping("getall")
	public List<Generaljobtitle> getAll(){
		return generaljoptitleService.getAll();
	}
	

}
