package librarymanagement;

import java.util.ArrayList;

public class Librarian extends Person{
    
    public Librarian(int ID, String password, String Fname, String Lname, String Address, long CellPhone, String Email) {
        super(ID, password, Fname, Lname, Address, CellPhone, Email);
    }
    
    public void AddBook(Book newBook, ArrayList<Book> books){
        books.add(newBook);
    }
    
    public void RemoveBook(int index, ArrayList<Book> books){
        books.remove(index);
    }
    
    public void AddReader(Reader newReader, ArrayList<Reader> readers){
        readers.add(newReader);
    }
    
    public void RemoveReader(int index, ArrayList<Reader> readers){
        readers.remove(index);
    }
    
    public void BlockUser(int index, ArrayList<Reader> readers){
        readers.get(index).setIsBlocked(true);
    }

    @Override
    public void RentBook(int index, ArrayList<Book> books) {
        books.get(index).setIsRented(true);
    }
    
    public void AddToOrderList(int index, ArrayList<Book> books, Reader reader) {
        ArrayList<Reader> CopyOrderList = new ArrayList<Reader>();
        CopyOrderList = books.get(index).getOrderList();
        CopyOrderList.add(reader);
        books.get(index).setOrderList(CopyOrderList);
    }
    
    public void RemoveFromOrderList(int index, ArrayList<Book> books, Reader reader){
        ArrayList<Reader> CopyOrderList = new ArrayList<Reader>();
        CopyOrderList = books.get(index).getOrderList();
        int IndexInOrderList = super.SearchUser(books.get(index).getOrderList(),
                                                 reader.getFirstname(), 
                                                 reader.getLastname());
        CopyOrderList.remove(IndexInOrderList);
        books.get(index).setOrderList(CopyOrderList);
    }
}
