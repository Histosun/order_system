package com.zhaoyang.restaurant.service;

import java.util.List;

import com.zhaoyang.restaurant.dao.DinningTableDAO;
import com.zhaoyang.restaurant.domain.DinningTable;

public class DinningTableService {
	private DinningTableDAO dinningTableDAO=new DinningTableDAO();
	
	public List<DinningTable> tablesStatus(){
		return dinningTableDAO.queryMultiple(DinningTable.class,"select id, state from dinning_table");
	}
	
	public DinningTable getDinningTableById(int id) { 
		return dinningTableDAO.querySingle(DinningTable.class, "select * from dinning_table where id = ?", id);
	}
	
	public boolean orderDinningTable(int id, int userId) {
		return dinningTableDAO.update("update dinning_table set state=1, userId=? where id = ?", userId, id) > 0;
	}
}
