package pl.kupujswiadomie.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(unique = true)
	@Size(min = 3, max = 50)
	private String name;
	
	@NotBlank
	@Size(min = 30, max = 700)
	private String description;
	
//	private image logo;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Subcategory subcategory;
	
	private boolean producingInPL;
	
	private boolean comingFromPL;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Valid
	private Producer producer;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Store> stores;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private User createdBy;
	
	private Date created;
	
	public Product() {
		super();
		this.created = new Date();
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
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

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
