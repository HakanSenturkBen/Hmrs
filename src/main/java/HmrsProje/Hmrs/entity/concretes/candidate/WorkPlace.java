package HmrsProje.Hmrs.entity.concretes.candidate;

import java.util.Date;

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
@Table(name="workPlaces")
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlace {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")private int id;
	@Column(name="employeeCandidateId")private int employeeCandidateId;
	@Column(name="workPlacesName")private String workPlacesName;
	@Column(name="startDate")private Date startDate;
	@Column(name="endDate")private Date endDate;
	

}
