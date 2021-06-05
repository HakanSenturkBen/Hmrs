package HmrsProje.Hmrs.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="generaljobtitles")
@AllArgsConstructor
@NoArgsConstructor
public class Generaljobtitle {
	@Id
	@GeneratedValue
	@Column(name="id") private int id;
	@Column(name="jopTitleName") private String jopTitleName;
	
	
	

}
