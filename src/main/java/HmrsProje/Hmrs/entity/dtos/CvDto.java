package HmrsProje.Hmrs.entity.dtos;

import java.util.List;



import HmrsProje.Hmrs.entity.concretes.candidate.ForeingLanguage;
import HmrsProje.Hmrs.entity.concretes.candidate.School;
import HmrsProje.Hmrs.entity.concretes.candidate.SoftwareExperience;
import HmrsProje.Hmrs.entity.concretes.candidate.WorkPlace;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CvDto {
	
	private String candidateName;
	private List<School>getAllSchoolByCandidateId;
	private List<WorkPlace>getAllWorkplaceByCandidateId;
	private List<ForeingLanguage>getAllLanguageByCandidateId;
	private String candidatePicture;
	private String candidateGithub;
	private String candidateLinkedin;
	private List<SoftwareExperience>getAllSoftwareExperienceByCandidateId;
	private String candidateMemo;
	

}
