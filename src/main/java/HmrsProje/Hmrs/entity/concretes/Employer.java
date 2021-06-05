package HmrsProje.Hmrs.entity.concretes;

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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor

public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	private int id;
	@Column(name="userId")private int userId;
	@Column(name="membershipId")private int membershipId;
	@Column(name="addressId")private int addressId;
	@Column(name="companyName")private String companyName;
	@Column(name="domainName")private String domainName;
	@Column(name="emailSameDomain")private String emailSameDomain;
	@Column(name="taxNumber")private String taxNumber;
	@Column(name="taxOffice")private String taxOffice;

}
