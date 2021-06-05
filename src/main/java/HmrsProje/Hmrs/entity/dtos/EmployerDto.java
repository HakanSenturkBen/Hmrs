package HmrsProje.Hmrs.entity.dtos;

import lombok.Data;

@Data
public class EmployerDto {
	private String firstName;
	private String surName;
	private String email;
	private String password;
	private String passwordAgain;
	private String streetName;
	private String districtName;
	private String cityName;
	private String countryName;
	private String companyName;
	private String domainName;
	private String emailSameDomain;
	private String taxNumber;
	private String taxOffice;

}
