package pl.kupujswiadomie.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="producer")
public class Producer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(unique = true)
	@Size(min = 3, max = 50)
	private String name;
	
	private String description;
	
//	private image logo;
	
	private boolean producingInPL;
	
	private boolean comingFromPL;
	
	private Date created;
	
	public Producer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isProducingInPL() {
		return producingInPL;
	}

	public void setProducingInPL(boolean producingInPL) {
		this.producingInPL = producingInPL;
	}

	public boolean isComingFromPL() {
		return comingFromPL;
	}

	public void setComingFromPL(boolean comingFromPL) {
		this.comingFromPL = comingFromPL;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
