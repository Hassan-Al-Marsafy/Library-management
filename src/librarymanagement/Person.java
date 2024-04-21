package librarymanagement;

import java.util.ArrayList;

public abstract class Person{
    private int ID;
    private String password;
    private String Firstname;
    private String Lastname;
    private String Address;
    private long CellPhone;
    private String Email;
    private boolean isBlocked;

    public Person(int ID, String password, String Fname, String Lname, String Address, long CellPhone, String Email) {
        this.ID = ID;
        this.password = password;
        this.Firstname = Fname;
        this.Lastname = Lname;
        this.Address = Address;
        this.CellPhone = CellPhone;
        this.Email = Email;
    }    

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
    
    public int getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public boolean isIsBlocked() {
        return isBlocked;
    }
    
    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getAddress() {
        return Address;
    }

    public long getCellPhone() {
        return CellPhone;
    }

    public String getEmail() {
        return Email;
    }
    
    
    public int SearchBook(ArrayList<Book> books, String BookName){
        int Result = -1;
        for(int i=0;i<=books.size();i++)
        {
            if(BookName.equals(books.get(i).getName()))
            {
                Result = i;
                return Result;
            }           
        }
        return Result;
    }
    
    public int SearchUser(ArrayList<Reader> readers, String Fname,String Lname){
        int Result = -1;
        for(int i=0;i<=readers.size();i++)
        {
            if(Fname.equals(readers.get(i).getFirstname())&&
               Lname.equals(readers.get(i).getLastname())) 
            {
                Result = i;
                return Result;
            }           
        }        
        return Result;
    }
    
    public void RentBook(int index, ArrayList<Book> books){
    }
    
    public void AddToOrderList(int index, ArrayList<Book> books){
    }
    
}