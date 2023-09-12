package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Card {
	 public static List<Items> list;
	 double num;
	 Items item;
	public Card() {
		list=new ArrayList<>(); 
	}
	
	public void addItem(Items item) {
		
		list.add(item);
		
	}
	
	public void removeItems(int id) {
		Iterator<Items> iterator = list.iterator();
		while (iterator.hasNext()) {
		    Items items = iterator.next();
		    if (items.getPro().getProID() == id) {
		        iterator.remove();
		    }
		}	
	}
	public boolean checkItem(int id) {
		for (Items items : list) {
			if(items.getPro().getProID()==id) {
				return true;
			}
		}
		return false;
	}
	
	public void minus(int id) {
		for (Items items : list) {
			if(items.getPro().getProID()==id) {	
				items.setQuantity(items.getQuantity()-1);
				
			}
		}
	}
	
	public void plus(int id) {
		for (Items items : list) {
			if(items.getPro().getProID()==id) {
				items.setQuantity(items.getQuantity()+1);;
			}
		}
	}
	
	public double gettotal() {
		num=0;
		for (Items items : list) {
			num+=(items.getPro().getPrice()*items.getQuantity());
		}
		return num;
	}
	


}
