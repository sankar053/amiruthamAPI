package com.iii.amirutham.model.order;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.amirutham.model.Address;
import com.iii.amirutham.model.BaseEntity;
import com.iii.amirutham.model.MerchantStore;
import com.iii.amirutham.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orders")
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ORDER_STATUS")
	@Enumerated(value = EnumType.STRING)
	private OrderStatus orderStatus = OrderStatus.ORDERED;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED")
	private Date lastModified;

	@Column(name = "ORDER_RECEIVER_NAME")
	private String receiverName;

	@Column(name = "ORDER_RECEIVER_PHONE_NUMBER")
	private String receiverPhoneNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PURCHASED")
	private Date datePurchased;

	@Column(name = "ORDER_GROSS_TOTAL")
	private BigDecimal grossTotal;

	@Column(name = "ORDER_GST_TOTAL")
	private BigDecimal gstTotal;

	@Column(name = "ORDER_NET_TOTAL")
	private BigDecimal netTotal;

	@Column(name = "ORDER_CODE", nullable = true)
	private String orderCode;
	
	@Column(name = "ORDER_Tracking_Url", nullable = true)
	private String orderTrackingUrl;

	@Column(name = "CART_CODE", nullable = true)
	private String shoppingCartCode;

	@Column(name = "CHANNEL")
	@Enumerated(value = EnumType.STRING)
	private OrderChannel channel = OrderChannel.OFFLINE;

	@Column(name = "ORDER_TYPE")
	@Enumerated(value = EnumType.STRING)
	private OrderType orderType = OrderType.ORDER;

	@Column(name = "PAYMENT_TYPE")
	@Enumerated(value = EnumType.STRING)
	private PaymentType paymentType = PaymentType.UNPAIED;
	
	@Column(name = "PAYMENT_DATE")
	private LocalDateTime paymentOn;
	
	@Column(name = "ORDER_REFUND_DATE")
	private LocalDateTime refundOn;

	@Column(name = "PAYMENT_TRANS_REF_NO")
	private String razorPayTransReference;
	
	@Column(name = "PAYMENT_ORDER_REF_NO")
	private String razorPayOrderReference;
	
	@Column(name = "PAYMENT_TRANS_REFUND_REF_NO")
	private String razorPayRefundReference;
	
	@Column(name = "PAYMENT_ORDER_STATUS")
	private String orderPaymentStatus;
	
	@Column(name = "ORDER_CURRENCY")
	private String currency = "INR";
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderProduct> orderProducts = new LinkedHashSet<OrderProduct>();

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "orderid", referencedColumnName = "id")
	private MerchantStore merchantStore;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "addressId", referencedColumnName = "id")
	private Address address;
	
	@Transient
	private String razorPayKey;

}
