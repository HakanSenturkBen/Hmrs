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
@Table(name="workers")
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	private int id;
	@Column(name="userId")	private int userId;
	@Column(name="addressId")	private int addressId;
	@Column(name="phoneId")	private int phoneId;
	@Column(name="departmentId")	private int departmentId;

}
