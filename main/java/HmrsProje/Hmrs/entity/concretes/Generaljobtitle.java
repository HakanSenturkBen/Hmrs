package HmrsProje.Hmrs.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="generaljobtitles")
public class Generaljobtitle {
	@Id
	@GeneratedValue
	@Column(name="id") private int id;
	@Column(name="jopTitleName") private String jopTitleName;
	
	
	public Generaljobtitle() {
		super();
	}
	
	
	public Generaljobtitle(int id, String jopTitleName) {
		super();
		this.id = id;
		this.jopTitleName = jopTitleName;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJopTitleName() {
		return jopTitleName;
	}
	public void setJopTitleName(String jopTitleName) {
		this.jopTitleName = jopTitleName;
	}
	

}
