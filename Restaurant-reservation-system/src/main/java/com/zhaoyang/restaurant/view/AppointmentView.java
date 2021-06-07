package com.zhaoyang.restaurant.view;

import com.zhaoyang.restaurant.dao.DinningTableDAO;
import com.zhaoyang.restaurant.domain.DinningTable;
import com.zhaoyang.restaurant.domain.User;
import com.zhaoyang.restaurant.service.DinningTableService;
import com.zhaoyang.restaurant.service.UserService;
import com.zhaoyang.restaurant.utils.Utility;
import java.util.List;

/**
 * Main menu of appointment
 * @author Shi Zhaoyang
 *
 */
public class AppointmentView {
	
	private boolean loop=true;
	private UserService userService=new UserService();
	private DinningTableService dinningTableService=new DinningTableService();
	private User u=null;
	public void mainMenu() {
		int key;
		while(loop) {
			System.out.println("=============Appoint Menu=============");
			System.out.println("\t\t 1 log in");
			System.out.println("\t\t 2 exit");
			
			
			System.out.print("Please input your choice: ");
			key=Utility.readInt();
			mainMenuChoice(key);
		}
		System.out.println("Exit appointment system.");
	}
	
	private void mainMenuChoice(int choice) {

		switch (choice) {
		case 1:
			System.out.print("Please enter user number: ");
			String userId=Utility.readString(50);
			System.out.print("Please enter password: ");
			String pwd=Utility.readString(50);
			
			u= userService.getUserByIdAndPwd(userId, pwd);
			if(u!=null) {
				System.out.println(u);
				secondMenu(); 
			} else {
				System.out.println("Fail to log in");
			}
			break;
		case 2:
			loop=false;
			break;
		default:
			System.out.println("Input error, please input again");
		}
	}
	
	public void secondMenu() {
		int key;
		while(loop) {
			System.out.println("=============Welcome=============");
			System.out.println("\t\t 1 show tables status");
			System.out.println("\t\t 2 book a table");
			System.out.println("\t\t 3 show all meal");
			System.out.println("\t\t 4 order meal");
			System.out.println("\t\t 5 check your order");
			System.out.println("\t\t 6 checkout");
			System.out.println("\t\t 9 exit");
			

			System.out.print("Please input your choice: ");
			key=Utility.readInt();
			secondMenuChoice(key);
		}
	}
	
	public void secondMenuChoice(int key) {

		switch (key) {
		case 1:
			List<DinningTable> list=dinningTableService.tablesStatus();
			System.out.println("\nTable No\tTable State");
			for (DinningTable dinningTable : list) {
				System.out.println(dinningTable);
			}
			break;
		case 2:
			orderDinningTable();
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 9:
			loop=false;
			break;
		default:
			System.out.println("Input error. Please input again!");	
		}
	}
	
	private void orderDinningTable() {
		System.out.println("=============Book a table=============");
		System.out.print("Please select a table:");
		int tableId=Utility.readInt();
		if(tableId==0) {
			System.out.println("=============cancel booking=============");
			return;
		}
		
		DinningTable dinningTable=dinningTableService.getDinningTableById(tableId);
		if(dinningTable==null) {
			System.out.println("=============table does not exist=============");
			return;
		}
		if(dinningTable.getState()!=dinningTable.EMPTY) {
			System.out.println("=============the table is unavailable=============");
		} else if(dinningTableService.orderDinningTable(tableId, u.getId())) {
			System.out.println("=============book successful=============");
		} else {
			System.out.println("=============book failed, please try again=============");
		}
		
		
		
	}
	
	public static void main(String[] args){
		new AppointmentView().mainMenu();
	}
}
