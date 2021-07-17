package com.bridgelabz.workshop2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main {
	
	  FoodManager foodManager = new FoodManager(); 
	  static Scanner sc = new Scanner(System.in);
	 
	  public static void main(String[] args) {
	 
	 Main main = new Main();
	 main.showUserOption();
	
	  }
	
	
	
	void showUserOption() {
		System.out.println("enter 1 to update the food items ");
		int choice = 0;
		while (choice != 10) {
			System.out.println("1. Show food item :: 2. Update food item :: 3. add food item 4. remove foodItem  5 . place the order 10. exit  ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 : 
				foodManager.print();
				break;
			case 2 : 
				updateFoodItems();
				break;
			case 3 : 
				foodManager.addFoodItem();
				break;
			case 4 : 
				foodManager.removeFoodItem();
				break;
			case 5 : 
				placeTheOrder();
				break;
			case 10 : 
				break;	
			default : 
				System.out.println(" Press correct input");
				break;
			}
		
			
		}
		
	}

	private void updateFoodItems() {
		System.out.println(" Enter the Food Item to be Update ");
	    String Item = sc.next();
	    FoodItem foodItem = foodManager.getFoodItem(Item);
	    System.out.println(foodItem);
	    int parameter = 0;
        while (parameter != 5) {
            System.out.println("Enter 1-Taste \n 2-Prep Time, \n 3-name, \n 4-category");
            parameter = sc.nextInt();
            switch (parameter) {
                case 1:
                    updateTaste(foodItem);
                    break;
                case 2:
                    updatePrepTime(foodItem);
                    break;
                case 3:
                    updateName(foodItem);
                    break;
                case 4:
                    updateCategory(foodItem);
                    break;
                default : 
    				System.out.println(" make coorect choice");
    				break;    	
            }
            System.out.println(foodItem);
        }
    }
	    
	private void updateTaste(FoodItem FoodTaste) {
		System.out.println( "To change taste ");
		System.out.println("press 1 for oily");
    	System.out.println(" enter 2 for spicy");
    	System.out.println("enter 3 for crunchy");
    	System.out.println("enter 4 for lightsugary");
    	int taste = sc.nextInt();	
    	switch (taste) {
    	case 1 :
    		FoodTaste.taste = FoodItem.Taste.spicy;
    		break;
    	case 2 :
    		FoodTaste.taste = FoodItem.Taste.salty;
    		break;
    	case 3 :
    		FoodTaste.taste = FoodItem.Taste.crunchy;
    		break;
    	case 4 : 
    		FoodTaste.taste = FoodItem.Taste.lightsugary;
    		break;
    		default : 
    			System.out.println(" Please enter correct input");

    	}			
    	foodManager.add(FoodTaste);
    	
		
		
	}
	
	private void updatePrepTime(FoodItem foodItems) {
        System.out.println("Enter the time ");
        foodItems.preparationTime = sc.nextByte();
        foodManager.add(foodItems);
        System.out.println(foodItems);
    }

    private void updateName(FoodItem foodItems) {
        System.out.println("Enter the name ");
        foodItems.name = sc.nextLine();
        foodManager.add(foodItems);
        System.out.println(foodItems);
    }

    private void updateCategory(FoodItem foodItems) {
        System.out.println("Choose from below ");
        System.out.println("1- MAINCOURSE 2-STARTERS 3-JUICES 4-DESSERT");
        int category = sc.nextInt();
        switch (category) {
            case 1:
            	foodItems.category = FoodItem.Category.MainCourse;
            	break;
            case 2:
                foodItems.category = FoodItem.Category.Starters;
                break;
            case 3:
                foodItems.category = FoodItem.Category.Juices;
                break;
            case 4:
                foodItems.category = FoodItem.Category.Dessert;
            default:
                System.out.println("Enter right Category.");
        }
        
        foodManager.add(foodItems);
        System.out.println(foodItems);
        }
    
    public void placeTheOrder() {
        Order order = new Order();
        calculateTotalPrice(order) ;
        System.out.println(" Please enter your name ");
        order.personName = sc.next();
        System.out.println(" Please enter the dilevery address ");
        order.deliveryAddress = sc.next();
        order.orderTime = java.time.LocalTime.now();
    	System.out.println("Order time is" +order.orderTime); 	
    
        String itemName = " ";
        while(!itemName.equals("quit")) {
        	System.out.println("we have this much to order:: ");
            foodManager.print();
        	System.out.println("enter what you want to buy");
        	 itemName = sc.next();
        	FoodItem foodItems = foodManager.getFoodItem(itemName);	
        	if(foodItems != null) {
                System.out.println("Enter the quantity");
                Integer quantity = sc.nextInt();
                order.map.put(foodItems , quantity);
        	}else if(!itemName.equals("quit"))  {
        		System.out.println("fooditem is not present");	
        	}		
        } 	
    } 
    
    public void calculateTotalPrice(Order order) {
    	Set entrySet = order.map.entrySet();
    	Iterator iterator  = entrySet.iterator();
    	while(iterator.hasNext()) {
    		Map.Entry me = (Map.Entry)iterator.next();
    		FoodItem foodItem = (FoodItem) me.getKey();    		
    		int quantity = (int) me.getValue();   
    		int price = (int) foodItem.price;
    		order.totalPrice += price*quantity;
    		System.out.println(order.totalPrice);
    	}
    	
    }
   
}




			

  