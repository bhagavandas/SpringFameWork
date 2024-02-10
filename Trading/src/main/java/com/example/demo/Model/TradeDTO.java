package com.example.demo.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TradeDTO {

	private String id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy HH:mm:ss")
	private Date lastTradeTime;
	private String QuotationLot;
	private String TradedQty;
	private String OpenInterest;   
	private String Open;
	private String High;
	private String Low;
	private String Close;
	public TradeDTO(String id, Date lastTradeTime, String quotationLot, String tradedQty, String openInterest,
			String open, String high, String low, String close) {
		super();
		this.id = id;
		this.lastTradeTime = lastTradeTime;
		QuotationLot = quotationLot;
		TradedQty = tradedQty;
		OpenInterest = openInterest;
		Open = open;
		High = high;
		Low = low;
		Close = close;
	}
	public TradeDTO() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getLastTradeTime() {
		return lastTradeTime;
	}
	public void setLastTradeTime(Date lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}
	public String getQuotationLot() {
		return QuotationLot;
	}
	public void setQuotationLot(String quotationLot) {
		QuotationLot = quotationLot;
	}
	public String getTradedQty() {
		return TradedQty;
	}
	public void setTradedQty(String tradedQty) {
		TradedQty = tradedQty;
	}
	public String getOpenInterest() {
		return OpenInterest;
	}
	public void setOpenInterest(String openInterest) {
		OpenInterest = openInterest;
	}
	public String getOpen() {
		return Open;
	}
	public void setOpen(String open) {
		Open = open;
	}
	public String getHigh() {
		return High;
	}
	public void setHigh(String high) {
		High = high;
	}
	public String getLow() {
		return Low;
	}
	public void setLow(String low) {
		Low = low;
	}
	public String getClose() {
		return Close;
	}
	public void setClose(String close) {
		Close = close;
	}
	
	

	
	
}
