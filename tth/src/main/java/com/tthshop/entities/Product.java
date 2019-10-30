package com.tthshop.entities;
// default package
// Generated Jun 29, 2017 8:24:48 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 129666795222060860L;
	
	private Integer id;
	private Category category;
	private String name;
	private long price;
	private int quantity;
	private String image;
	private int views;
	private String description;
	private String blog;
	private String title;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private Set<OrderDetail> orderDetails_1 = new HashSet<OrderDetail>(0);

	public Product() {
	}

	public Product(Category category, String name, long price, int quantity, String image, int views,
			String description) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.views = views;
		this.description = description;
	}

	public Product(Category category, String name, long price, int quantity, String image, int views,
			String description, Set<OrderDetail> orderDetails, Set<OrderDetail> orderDetails_1) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.views = views;
		this.description = description;
		this.orderDetails = orderDetails;
		this.orderDetails_1 = orderDetails_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cate_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false)
	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "image", nullable = false)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "views", nullable = false)
	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "blog", nullable = false)
	public String getBlog() {
		return this.blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<OrderDetail> getOrderDetails_1() {
		return this.orderDetails_1;
	}

	public void setOrderDetails_1(Set<OrderDetail> orderDetails_1) {
		this.orderDetails_1 = orderDetails_1;
	}

}
