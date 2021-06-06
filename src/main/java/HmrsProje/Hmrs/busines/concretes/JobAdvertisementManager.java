package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import HmrsProje.Hmrs.busines.abstracts.EmployerService;
import HmrsProje.Hmrs.busines.abstracts.GeneraljoptitleService;
import HmrsProje.Hmrs.busines.abstracts.JobAdvertisementService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.JobAdvertisementDao;
import HmrsProje.Hmrs.entity.concretes.Employer;
import HmrsProje.Hmrs.entity.concretes.Generaljobtitle;
import HmrsProje.Hmrs.entity.concretes.JobAdvertisement;
import HmrsProje.Hmrs.entity.dtos.JobAdvertisementDto;

public class JobAdvertisementManager implements JobAdvertisementService{
	JobAdvertisementDao jobAdvertisementDao;
	
	GeneraljoptitleService generaljoptitleService; 
	EmployerService employerService;  
		

	

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,
			GeneraljoptitleService generaljoptitleService, EmployerService employerService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.generaljoptitleService = generaljoptitleService;
		this.employerService = employerService;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
		//return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(Sort.by(Sort.Direction.ASC,"endDate")));
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllOrderByEndDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(Sort.by(Sort.Direction.ASC,"endDate")));
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByNameAndActivity(String companyName, boolean activity) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByNameAndActivity(companyName, activity)); 
	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		Generaljobtitle generaljobtitle=generaljoptitleService.getByjopTitleName(jobAdvertisementDto.getJopTitleName()).getData();
		Employer employer=employerService.getBycompanyName(jobAdvertisementDto.getCompanyName()).getData();
		JobAdvertisement jobAdvertisement =new JobAdvertisement(0,
				employer.getAddressId(),generaljobtitle.getId(),
				jobAdvertisementDto.getJobDescription(),
				jobAdvertisementDto.getCity(),
				jobAdvertisementDto.getMinPay(),
				jobAdvertisementDto.getMaxPay(),
				jobAdvertisementDto.getCountOfPositions(),
				jobAdvertisementDto.getEndDate(),
				jobAdvertisementDto.isActivity(),
				jobAdvertisementDto.getDateOfRegistration());
				
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("eklendi");
	}

	
}
