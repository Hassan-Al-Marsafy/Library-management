package librarymanagement;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    public static int libindex=0;
    public static int Readindex=0;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    //......Login Form vars...........
    @FXML
    private Label validateLabel;
            
    @FXML
    private TextField idField;
    
    @FXML
    private PasswordField passwordField;
            
    @FXML
    private RadioButton RadioLib;
    
    @FXML
    private RadioButton RadioRead;
    
    //.........Librarian Form vars...........
    @FXML
    private Label welcomeLabel;
    //.........Add User.........
    @FXML
    private TextField uid;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField fname;
    
    @FXML
    private TextField lname;
    
    @FXML
    private TextField address;
    
    @FXML
    private TextField cellPhone;
    
    @FXML
    private TextField email;
    //.......Remove User.....
    @FXML
    private TextField delfname;
    
    @FXML
    private TextField dellname;
    //......Block User.......
    @FXML
    private TextField blfname;
    
    @FXML
    private TextField bllname;
    //.....Add Book..........
    @FXML
    private TextField addBookName;
    //.....Remove Book..........
    @FXML
    private TextField removeBookName;
    //.....Order List...........
    @FXML
    private TextField olBookName;
    @FXML
    private TextField olFName;
    @FXML
    private TextField olLName;
    //......Search User......
    @FXML
    private Label FnameLabel;
    @FXML
    private Label LnameLabel;
    @FXML
    private Label AddressLabel;
    @FXML
    private Label CellPhoneLabel;
    @FXML
    private Label EmailLabel;
    @FXML
    private TextField SearchFName;
    @FXML
    private TextField SearchLName;
    @FXML
    private TextField SearchBookName;
    
    
    @FXML
    public void ChangeScene(ActionEvent e,String sc) throws IOException{
        root = FXMLLoader.load(getClass().getResource(sc));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    @FXML
    public void BacktoLibrarianForm(ActionEvent e) throws IOException{
        ChangeScene(e,"LibrarianForm.fxml");
    }
    
    @FXML
    public void BacktoReaderForm(ActionEvent e) throws IOException{
        ChangeScene(e,"ReaderForm.fxml");
    }
    
    @FXML
    public void validateUser(ActionEvent e) throws IOException{
        boolean access = false;
        
        if(RadioRead.isSelected())
        {
            for(int i=0;i<Library.readers.size();i++)
            {
                if(idField.getText().equals(Integer.toString(Library.readers.get(i).getID())) 
                        && passwordField.getText().equals(Library.readers.get(i).getPassword()))
                {
                    access = true;
                    Readindex = i;
                }
            }
        }
        else if(RadioLib.isSelected())
        {
            for(int i=0;i<Library.librarians.size();i++)
            {
                if(idField.getText().equals(Integer.toString(Library.librarians.get(i).getID())) 
                        && passwordField.getText().equals(Library.librarians.get(i).getPassword()))
                {
                    access = true;
                    libindex = i;
                }
            }
        }        
        if(access && RadioLib.isSelected())
        {
            ChangeScene(e,"LibrarianForm.fxml");            
        }
        else if(access && RadioRead.isSelected())
        {
            ChangeScene(e,"ReaderForm.fxml");           
        }
        else{
            validateLabel.setText("Please Enter valid data!");
        }
    }
    
    @FXML
    public void AddUser(ActionEvent e) throws IOException
    {
        ChangeScene(e,"LibAddUser.fxml");        
    }
    
    @FXML
    public void SubmitAddUser(ActionEvent e) throws IOException
    {        
        Reader r = new Reader(Integer.valueOf(uid.getText()),password.getText(),
                            fname.getText(),lname.getText(),address.getText(),
                         Integer.valueOf(cellPhone.getText()),email.getText());       
        Library.librarians.get(libindex).AddReader(r, Library.readers);
        ChangeScene(e,"LibrarianForm.fxml");
        
    }
    
    @FXML
    public void RemoveUser(ActionEvent e) throws IOException
    {
        ChangeScene(e,"LibRemoveUser.fxml");        
    }
    
    @FXML
    public void SubmitRemoveUser(ActionEvent e) throws IOException{
        String tempFname = delfname.getText();
        String tempLname = dellname.getText();
        int index = -1; 
        try{
            index = Library.librarians.get(libindex).SearchUser(Library.readers, tempFname, tempLname);
        }catch(Exception ex){
            System.out.println("Exception");
        }
        System.out.println(index);

        if(index == -1){
            System.out.println("User doesn't exist");
        }
        else{
            Library.librarians.get(libindex).RemoveReader(index, Library.readers);
            ChangeScene(e,"LibrarianForm.fxml");
        }
    }
    
    @FXML
    public void BlockUser(ActionEvent e) throws IOException
    {
        ChangeScene(e,"LibBlockUser.fxml");
    }
     
     public void SubmitBlockUser(ActionEvent e) throws IOException
    {
        String tempFname = blfname.getText();
        String tempLname = bllname.getText();
        int index = -1; 
        try{
            index = Library.librarians.get(libindex).SearchUser(Library.readers, tempFname, tempLname);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        if(index == -1){
            System.out.println("User doesn't exist");
        }
        else{
            Library.librarians.get(libindex).setIsBlocked(true);
            ChangeScene(e,"LibrarianForm.fxml");
        }
    }
    
    @FXML
    public void AddBook(ActionEvent e) throws IOException
    {
        ChangeScene(e,"LibAddBook.fxml");        
    }
    
    @FXML
    public void SubmitAddBook(ActionEvent e) throws IOException
    {        
        Book b = new Book(addBookName.getText());       
        Library.librarians.get(libindex).AddBook(b, Library.books);
        ChangeScene(e,"LibrarianForm.fxml");        
    }
    
    @FXML
    public void RemoveBook(ActionEvent e) throws IOException
    {
        ChangeScene(e,"LibRemoveBook.fxml");
    }
    
    @FXML
    public void SubmitRemoveBook(ActionEvent e) throws IOException{
        String tempName = removeBookName.getText();        
        int index = -1; 
        try{
            index = Library.librarians.get(libindex).SearchBook(Library.books, tempName);
        }catch(Exception ex){
            System.out.println("Exception");
        }
        System.out.println(index);
        if(index == -1){
            System.out.println("Book doesn't exist");
        }
        else{
            Library.librarians.get(libindex).RemoveBook(index,Library.books);
            ChangeScene(e,"LibrarianForm.fxml");
        }
    }

    @FXML
    public void AddToOrderList(ActionEvent e) throws IOException
    {
        ChangeScene(e,"LibAddOrderList.fxml");
    }
    
    @FXML
    public void SubmitAddToOrderList(ActionEvent e) throws IOException
    {
        int ReaderIndex = -1;
        int BookIndex = -1;
        ReaderIndex = Library.librarians.get(libindex).SearchUser(Library.readers,olFName.getText(),olLName.getText());
        BookIndex = Library.librarians.get(libindex).SearchBook(Library.books,olBookName.getText());
        if(ReaderIndex >= 0 && BookIndex >= 0){
            //Library.books.get(BookIndex).OrderList.add(Library.readers.get(ReaderIndex));
            ChangeScene(e,"LibrarianForm.fxml");
            System.out.println("Done");
            
        }
        else{
            System.out.println("Enter Valid Data");
        }
    }
    
    @FXML
    public void RemoveFromOrderList(ActionEvent e) throws IOException
    {
        ChangeScene(e,"LibRemoveOrderList.fxml");
    }
    
    @FXML
    public void SubmitRemoveFromOrderList(ActionEvent e) throws IOException
    {
        int ReaderIndex = -1;
        int BookIndex = -1;
        ReaderIndex = Library.librarians.get(libindex).SearchUser(Library.readers,olFName.getText(),olLName.getText());
        BookIndex = Library.librarians.get(libindex).SearchBook(Library.books,olBookName.getText());
        if(ReaderIndex >= 0 && BookIndex >= 0){
            //Library.librarians.get(libindex).RemoveFromOrderList(BookIndex,Library.books,Library.readers.get(ReaderIndex));
            ChangeScene(e,"LibrarianForm.fxml");
            System.out.println("Done");
        }
        else{
            System.out.println("Enter Valid Data");
        }
    }
    
    @FXML
    public void SearchReader(ActionEvent e) throws IOException{
        ChangeScene(e,"LibSearchUser.fxml");
    }
    
    @FXML
    public void SubmitSearchReader(ActionEvent e) throws IOException{      
        String tempFname = SearchFName.getText();
        String tempLname = SearchLName.getText();
        int index = -1; 
        try{
            index = Library.librarians.get(libindex).SearchUser(Library.readers, tempFname, tempLname);
        }catch(Exception ex){
            System.out.println("Exception");
        }
        if(index == -1){
            System.out.println("User doesn't exist");
        }
        else{
            System.out.println(Library.readers.get(index).getFirstname());
            System.out.println(Library.readers.get(index).getLastname());
            System.out.println(Library.readers.get(index).getAddress());
            System.out.println(Library.readers.get(index).getCellPhone());
            System.out.println(Library.readers.get(index).getEmail());
        }
        
    }
    
    @FXML
    public void SearchBook(ActionEvent e) throws IOException{
        ChangeScene(e,"LibSearchBook.fxml");
    }
    
    @FXML
    public void SubmitSearchBook(ActionEvent e){
        String tempname = SearchBookName.getText();
        int index = -1; 
        try{
            index = Library.librarians.get(libindex).SearchBook(Library.books, tempname);
        }catch(Exception ex){
            System.out.println("Exception");
        }
        if(index == -1){
            System.out.println("User doesn't exist");
        }
        else{
            System.out.println(Library.books.get(index).getName());
            System.out.println(Library.books.get(index).getIsRented());
        }
    }
    
    public void RentBook(ActionEvent e) throws IOException{
        ChangeScene(e,"LibRentBook.fxml");
    }
    
    public void SubmitRentBook(ActionEvent e) throws IOException{
        String tempname = SearchBookName.getText();
        int index = -1; 
        try{
            index = Library.librarians.get(libindex).SearchBook(Library.books, tempname);
        }catch(Exception ex){
            System.out.println("Exception");
        }
        if(index == -1){
            System.out.println("Book doesn't exist");
        }
        else{
            Library.books.get(index).setIsRented(true);
            BacktoLibrarianForm(e);
            System.out.println(Library.books.get(index).getIsRented());
        }
    }
    
    public void ReadRentBook(ActionEvent e) throws IOException{
        ChangeScene(e,"ReadRentBook.fxml");
    }
    
    public void SubmitReadRentBook(ActionEvent e) throws IOException{
        String tempname = SearchBookName.getText();
        int index = -1; 
        try{
            index = Library.librarians.get(libindex).SearchBook(Library.books, tempname);
        }catch(Exception ex){
            System.out.println("Exception");
        }
        if(index == -1){
            System.out.println("Book doesn't exist");
        }
        else{
            Library.books.get(index).setIsRented(true);
            ChangeScene(e,"ReaderForm.fxml");
            System.out.println(Library.books.get(index).getIsRented());
        }
    }
    
    @FXML
    public void ReadSearchReader(ActionEvent e) throws IOException{
        ChangeScene(e,"ReadSearchUser.fxml");
    }
    
    @FXML
    public void ReadSearchBook(ActionEvent e) throws IOException{
        ChangeScene(e,"ReadSearchBook.fxml");
    }
    
    @FXML
    public void AddSelfOrderList(ActionEvent e) throws IOException
    {
        ChangeScene(e,"ReadAddOrderList.fxml");
    }
    
    @FXML
    public void SubmitAddSelfOrderList(ActionEvent e) throws IOException
    {
        int BookIndex = -1;        
        BookIndex = Library.librarians.get(libindex).SearchBook(Library.books,olBookName.getText());
        if(BookIndex >= 0){
            //Library.books.get(BookIndex).OrderList.add(Library.readers.get(ReaderIndex));
            ChangeScene(e,"ReaderForm.fxml");
            System.out.println("Done");    
        }
        else{
            System.out.println("Enter Valid Data");
        }
    }
}
