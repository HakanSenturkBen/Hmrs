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
@Table(name="foreingLanguages")
@AllArgsConstructor
@NoArgsConstructor
public class ForeingLanguage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")private int id;
	@Column(name="employeeCandidateId")private int employeeCandidateId;
	@Column(name="languageName")private String languageName;
	@Column(name="languageRating")private String languageRating;
	

}
