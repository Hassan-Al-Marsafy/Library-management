package librarymanagement;

import java.util.ArrayList;

public class Reader extends Person{
    
    public Reader(int ID, String password, String Fname, String Lname, String Address, long CellPhone, String Email) {
        super(ID, password, Fname, Lname, Address, CellPhone, Email);
    }

    
    @Override
    public void RentBook(int index, ArrayList<Book> books) {
        books.get(index).setIsRented(true);
    }
    
    @Override
    public void AddToOrderList(int index, ArrayList<Book> books) {
        ArrayList<Reader> CopyOrderList = new ArrayList<Reader>();
        CopyOrderList = books.get(index).getOrderList();
        CopyOrderList.add(this);
        books.get(index).setOrderList(CopyOrderList);
    }
    
}
