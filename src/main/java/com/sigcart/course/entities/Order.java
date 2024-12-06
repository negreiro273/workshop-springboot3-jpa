package com.sigcart.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sigcart.course.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyy-MM-dd'T'HH:mm:zz'Z'", timezone = "GNT")
	private Instant moment;
	private int orderStatus;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_Id")
	private User client;
	
	
	/* 
	 *  Id      -> Vem da Class OrderItem
	 *  order   -> vem da Class OrderItemPK
	 *  "Id.order"
	*/	
    @OneToMany(mappedBy = "Id.order")
	private Set<OrderItem> items = new HashSet<>(); 	 
	
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
    
    
	public Order () {}

	public Order(Long Id, Instant moment, User client, OrderStatus orderStatus) {
		super();
		this.Id = Id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus); 
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {		
		if(orderStatus != null){this.orderStatus = orderStatus.getCode();}		
	}

	
	public Set<OrderItem> getItems() {
		return items;
	}

	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(Id, other.Id);
	}
	
	
	

}
