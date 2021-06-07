package com.zhaoyang.restaurant.domain;


/**
 * 
 * @author Shi Zhaoyang
 *
 */
public class DinningTable {
	
	static public final int EMPTY=0;
	static public final int BOOKED=1;
	
	private Integer id;
	private Integer state;
	private Integer userId;
	
	public DinningTable() {}

	public DinningTable(Integer id, Integer state, Integer userId) {
		super();
		this.id = id;
		this.state = state;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return id+"\t\t\t"+state;
	}
	
	
}
