package com.rubanelearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "buyer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"buyer"}, callSuper = false)
public class Order extends BaseEntity {

	private static final long serialVersionUID = -605580846371197508L;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "QTY")
	private Integer qty;

	@Column(name = "AMOUNT")
	private Double amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUYER_ID", nullable = false)
	private Buyer buyer;
}
