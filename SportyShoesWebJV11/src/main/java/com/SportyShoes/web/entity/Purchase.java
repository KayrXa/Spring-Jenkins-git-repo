package com.SportyShoes.web.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="purchase")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pcid;
	private String pcemail;
	private LocalDate pcdate;
	private int totalprice;
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pcid")	
	private List<PurchasedShoes> shoes;
	
	public Purchase() {	
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Purchase(int pcid, String pcemail, LocalDate pcdate, List<PurchasedShoes> items, int totalprice, String status) {
		super();
		this.pcid = pcid;
		this.pcemail = pcemail;
		this.pcdate = pcdate;
		this.totalprice = totalprice;
		this.status = status;
	}
	
	public int getPcid() {
		return pcid;
	}
	
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
	
	public String getPcemail() {
		return pcemail;
	}
	
	public void setPcemail(String pcemail) {
		this.pcemail = pcemail;
	}
	
	public LocalDate getPcdate() {
		return pcdate;
	}
	
	public void setPcdate(LocalDate pcdate) {
		this.pcdate = pcdate;
	}
	
	public List<PurchasedShoes> getShoes() {
		return shoes;
	}
	
	public void setShoes(List<PurchasedShoes> shoes) {
		this.shoes = shoes;
	}
	
	public int getTotalprice() {
		return totalprice;
	}
	
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}