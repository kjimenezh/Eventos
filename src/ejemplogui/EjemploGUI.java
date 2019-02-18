package ejemplogui;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class EjemploGUI extends Application {

    @Override

    public void start(Stage primaryStage) throws FileNotFoundException {
        Button bt1 = new Button("Button 1");
        Button bt2 = new Button ("Button 2");
        Label label1 = new Label ("Search");
        FileInputStream input = new FileInputStream("save1.png");
        Image  image =  new Image(input);
        Label label3 = new Label("Search",new ImageView(image));
        Button bt3 = new Button("Button 3", new ImageView(image));
        TableView table = new TableView();
        table.setEditable(true); //Si quiero que sea editable
        TableColumn firstName = new TableColumn("First Name");
        TableColumn lastName = new TableColumn("Last Name");
        TableColumn email = new TableColumn("Email");
        table.getColumns().addAll(firstName, lastName, email);

        HBox fila1 = new HBox();
        fila1.getChildren().add(bt1);
        fila1.getChildren().add(bt2);
        
        VBox vlayout = new VBox();
        
        //Vbox+HBox
        vlayout.getChildren().add(table);
        vlayout.getChildren().add(fila1);
        vlayout.getChildren().add(label3); //Ojo con mandar el mismo objeto dos veces porque hay problemas: en eventos es necesario que aparezca unicamente una vez
        vlayout.getChildren().add(bt3);
        
        //GridPane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.add(new Label("First Name:"), 0, 0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("MI:"), 0, 1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(new TextField(), 1, 2);
        
        pane.add(new Label("Cellphone:"), 3, 0);
        pane.add(new TextField(), 4, 0);
        Button btAdd = new Button("Add Name");
        pane.add(btAdd, 1, 3);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
        
        //GridPane configurando espacios columnas
        GridPane gridpane = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        gridpane.getColumnConstraints().addAll(col1,col2,col2,col1);
        Label text = new Label("Enter Address");
        gridpane.add(text, 0, 0, 4, 1); // (Columna 0, Fila 0, Expande 4 la columna, expande 1 la fila) and colspan 4
        GridPane.setHalignment(text, HPos.CENTER);
        Label direccion = new Label("Direccion");
        gridpane.add(direccion, 0, 1, 1, 1); // (Columna 0, Fila 1) and colspan 1
        GridPane.setHalignment(direccion, HPos.RIGHT);
        TextField txtDireccion = new TextField();
        gridpane.add(txtDireccion, 1, 1, 2, 1); // (Columna 0, Fila 1) and colspan 1
        Label direccion2 = new Label("Direccion");
        TextField txtDireccion2 = new TextField();
        gridpane.add(direccion2, 0, 2, 1, 2); // (Columna 0, Fila 1) and colspan 1
        gridpane.add(txtDireccion2, 1, 2, 4, 2); // (Columna 0, Fila 1) and colspan 1
        vlayout.getChildren().add(gridpane);
        
        Scene scene = new Scene(vlayout, 300, 300); //Scene contiene a button; (200, 250) tamaño de la ventana
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);//A stage le mando scene
        primaryStage.show(); } 
    
        public static void main(String[] args) {
            Application.launch(args);
        }}
