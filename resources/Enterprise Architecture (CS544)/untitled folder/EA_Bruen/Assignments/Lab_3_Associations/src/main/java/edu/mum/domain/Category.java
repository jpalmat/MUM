package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")
	private Long id = null;

	@Version
	@Column(name = "OBJ_VERSION")
	private int version = 0;

	@Column(name = "CATEGORY_NAME", length = 255, nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "categories")
	private List<Item> items = new ArrayList<Item>();

	@Transient
	private List<Category> childCategories = new ArrayList<Category>(); // A bag with SQL ORDER BY

	@Transient
	private Category parentCategory;

	@Transient
	private Map<Item, User> itemsAndUser = new HashMap<Item, User>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED", nullable = false, updatable = false)
	private Date created = new Date();

	/**
	 * No-arg constructor for JavaBean tools
	 */
	public Category() {
	}

	/**
	 * Simple constructors
	 */
	public Category(String name) {
		this.name = name;
	}

	public Category(String name, Category parentCategory) {
		this.name = name;
		this.parentCategory = parentCategory;
	}

	// ********************** Accessor Methods ********************** //

	public Long getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getChildCategories() {
		return childCategories;
	}

	public void addChildCategory(Category childCategory) {
		if (childCategory == null)
			throw new IllegalArgumentException("Null child category!");
		if (childCategory.getParentCategory() != null)
			childCategory.getParentCategory().getChildCategories().remove(childCategory);
		childCategory.setParentCategory(parentCategory);
		childCategories.add(childCategory);
	}

	public void removeChildCategory(Category childCategory) {
		if (childCategory == null)
			throw new IllegalArgumentException("Null child category!");
		childCategory.setParentCategory(null);
		childCategories.remove(childCategory);
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	private void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	// Regular many-to-many
	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		if (item == null)
			throw new IllegalArgumentException("Null item!");
		items.add(item);
		item.getCategories().add(this);
	}

	public void removeItem(Item item) {
		if (item == null)
			throw new IllegalArgumentException("Null item!");
		items.remove(item);
		item.getCategories().remove(this);
	}

	public Date getCreated() {
		return created;
	}

	// ********************** Common Methods ********************** //

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Category category = (Category) o;

		if (!created.equals(category.created))
			return false;
		if (!name.equals(category.name))
			return false;
		return !(parentCategory != null ? !parentCategory.equals(category.parentCategory)
				: category.parentCategory != null);

	}

	public int hashCode() {
		int result;
		result = name.hashCode();
		result = 29 * result + (parentCategory != null ? parentCategory.hashCode() : 0);
		result = 29 * result + created.hashCode();
		return result;
	}

	public int compareTo(Object o) {
		if (o instanceof Category) {
			return this.getName().compareTo(((Category) o).getName());
		}
		return 0;
	}

	public String toString() {
		return "(" + getId() + ") Name: '" + getName();
	}

	// ********************** Business Methods ********************** //

}