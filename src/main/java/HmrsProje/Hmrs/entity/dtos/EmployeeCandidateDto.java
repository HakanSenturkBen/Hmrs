package HmrsProje.Hmrs.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCandidateDto {
	private String firstName;
	private String surName;
	private String citizenshipIdentity;
	private int bornedYear;
	private String email;
	private String password;
	private String passwordAgain;
	private String professionName;
	private String streetName;
	private String districtName;
	private String cityName;
	private String countryName;
	private String phoneType;
	private String phoneNumber;

}
