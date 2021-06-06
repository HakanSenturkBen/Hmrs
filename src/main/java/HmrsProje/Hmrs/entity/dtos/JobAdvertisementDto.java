package HmrsProje.Hmrs.entity.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class JobAdvertisementDto {
	private String companyName;
	private String jopTitleName;
	private String jobDescription;
	private String city;
	private int minPay;
	private int maxPay;
	private int countOfPositions;
	private Date endDate;
	private boolean activity;
	private Date dateOfRegistration;
}
