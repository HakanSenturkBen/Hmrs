package HmrsProje.Hmrs.entity.concretes;

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
@Table(name="jobAdvertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")int id;
	@Column(name="employerId")private int employerId;
	@Column(name="generalJobTitleId")private int generalJobTitleId;
	@Column(name="jobDescription")private String jobDescription;
	@Column(name="city")private String city;
	@Column(name="minPay")private int minPay;
	@Column(name="maxPay")private int maxPay;
	@Column(name="countOfPositions")private int countOfPositions;
	@Column(name="endDate")private Date endDate;
	@Column(name="activity")private boolean activity;
	@Column(name="dateOfRegistration")private Date dateOfRegistration;
	
}
