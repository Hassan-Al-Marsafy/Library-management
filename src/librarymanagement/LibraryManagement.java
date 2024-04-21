package librarymanagement;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class LibraryManagement extends Application {
    
    public static void main(String[] args) {
        Library.readers.add(new Reader(777,"pass","omar","kamel","maadi",1152998828,"omar@omar.com"));
        Library.readers.add(new Reader(122,"pass","mohamed","kamal","nasrcity",1199887766,"mohamed@mohamed.com"));
        Library.readers.add(new Reader(666,"pass","ahmed","awad","sharabya",1010101010,"ahmed@ahmed.com"));
        
        Library.librarians.add(new Librarian(123,"admin","ahmed","awad","sharabya",1010101010,"ahmed@ahmed.com"));
        Library.librarians.add(new Librarian(456,"admin","omar","kamel","maadi",1152998828,"omar@omar.com"));
        
        Library.books.add(new Book("Harry Potter and The Deathly Hallows"));
        Library.books.add(new Book("Java from A to Z"));
        Library.books.add(new Book("Rich dad Poor Dad"));
        Library.books.add(new Book("The idiot Brain"));
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Library Management");
            stage.show();                        
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
