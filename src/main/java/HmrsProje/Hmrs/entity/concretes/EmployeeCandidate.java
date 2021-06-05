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
@Table(name="employeeCandidates")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCandidate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")private int id;
	@Column(name="userId")private int userId;
	@Column(name="membershipId")private int membershipId;
	@Column(name="professionId")private int ProfessionId;
	@Column(name="addressId")private int AddressId;
	@Column(name="phoneId")private int phoneId;
	@Column(name="citizenshipIdentity")private String citizenshipIdentity;
	@Column(name="bornedYear")private int bornedYear;

}
