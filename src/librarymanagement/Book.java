package librarymanagement;

import java.util.ArrayList;

public class Book {
    private String Name;
    private boolean IsRented;
    public static ArrayList<Reader> OrderList = new ArrayList<Reader>();

    public Book(String Name) {
        this.Name = Name;
    }
    
    public void setIsRented(boolean IsRented) {
        this.IsRented = IsRented;
    }

    public void setOrderList(ArrayList<Reader> OrderList) {
        this.OrderList = OrderList;
    }
    
    public boolean getIsRented() {
        return IsRented;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Reader> getOrderList() {
        return OrderList;
    }
    
    
}
