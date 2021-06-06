package HmrsProje.Hmrs.entity.concretes.candidate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidateCv")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCv {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")private int id;
	@Column(name="employeeCandidateId")private int employeeCandidateId;
	@Column(name="lastGraduatedName")private String lastGraduatedName;
	@Column(name="workingStatus")private boolean workingStatus;
	@Column(name="foreingLanguage")private String foreingLanguage;
	@Column(name="candidatePicture")private String candidatePicture;
	@Column(name="candidateGithub")private String candidateGithub;
	@Column(name="candidateLinkedin")private String candidateLinkedin;
	@Column(name="softwareExperience")private String softwareExperience;
	@Column(name="candidateMemo")private String candidateMemo;
	

}
