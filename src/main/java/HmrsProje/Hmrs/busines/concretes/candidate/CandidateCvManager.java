package HmrsProje.Hmrs.busines.concretes.candidate;

import org.springframework.beans.factory.annotation.Autowired;

import HmrsProje.Hmrs.busines.abstracts.EmployeeCandidateService;
import HmrsProje.Hmrs.busines.abstracts.UserService;
import HmrsProje.Hmrs.busines.abstracts.candidate.CandidateCvService;
import HmrsProje.Hmrs.busines.abstracts.candidate.ForeingLanguageService;
import HmrsProje.Hmrs.busines.abstracts.candidate.SchoolService;
import HmrsProje.Hmrs.busines.abstracts.candidate.SoftwareExperienceService;
import HmrsProje.Hmrs.busines.abstracts.candidate.WorkPlaceService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.CandidateCvDao;
import HmrsProje.Hmrs.entity.concretes.EmployeeCandidate;
import HmrsProje.Hmrs.entity.concretes.User;
import HmrsProje.Hmrs.entity.concretes.candidate.CandidateCv;
import HmrsProje.Hmrs.entity.dtos.CvDto;

public class CandidateCvManager implements CandidateCvService{
	CandidateCvDao candidateCvDao;
	ForeingLanguageService foreingLanguageService;
	SchoolService schoolService;
	SoftwareExperienceService softwareExperienceService;
	WorkPlaceService workPlaceService;
	UserService userService;
	EmployeeCandidateService employeeCandidateService;

	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao) {
		super();
		this.candidateCvDao = candidateCvDao;
	}

	
	public CandidateCvManager(CandidateCvDao candidateCvDao, ForeingLanguageService foreingLanguageService,
			SchoolService schoolService, SoftwareExperienceService softwareExperienceService,
			WorkPlaceService workPlaceService, UserService userService,EmployeeCandidateService employeeCandidateService) {
		super();
		this.candidateCvDao = candidateCvDao;
		this.foreingLanguageService = foreingLanguageService;
		this.schoolService = schoolService;
		this.softwareExperienceService = softwareExperienceService;
		this.workPlaceService = workPlaceService;
		this.userService = userService;
		this.employeeCandidateService=employeeCandidateService;
	}


	@Override
	public DataResult<CandidateCv> getByCandideId(int id) {
		return new SuccessDataResult<CandidateCv>(candidateCvDao.getByemployeeCandidateId(id));
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		candidateCvDao.save(candidateCv);
		return new SuccessResult("eklendi");
	}

	@Override
	public CvDto getFullCvById(int id) {
		CandidateCv cv=candidateCvDao.getByemployeeCandidateId(id);
		EmployeeCandidate candidate=employeeCandidateService.getById(id).getData();
		User user=userService.getByPersonId(candidate.getUserId()).getData();
		var getAllSchoolByCandidateId=schoolService.getByCandideId(id).getData();
		var getAllWorkplaceByCandidateId=workPlaceService.getByCandideId(id).getData();
		var getAllLanguageByCandidateId=foreingLanguageService.getByCandideId(id).getData();
		String candidatePicture=cv.getCandidatePicture();
		String candidateGithub=cv.getCandidateGithub();
		String candidateLinkedin=cv.getCandidateLinkedin();
		var getAllSoftwareExperienceByCandidateId=softwareExperienceService.getByCandideId(id).getData();
		String candidateMemo=cv.getCandidateMemo();
		
		CvDto cvDto=new CvDto((user.getFirstName()+" "+user.getSurName()),
				getAllSchoolByCandidateId,
				getAllWorkplaceByCandidateId,
				getAllLanguageByCandidateId,
				candidatePicture,
				candidateGithub,
				candidateLinkedin,
				getAllSoftwareExperienceByCandidateId,
				candidateMemo);
		return cvDto;
	}

}
