package Henrik;
import java.time.*;
import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;






public class Main extends Application{
    Stage window;
    TableView tableview = new TableView<Personals>();


    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        ObservableList<Personals> setup = FXCollections.observableArrayList();
        Personals p = new Personals("test", "test", "test", "test");
        Personals q = new Personals("test", "test", "test", "test");
        Personals r = new Personals("test", "test", "test", "test");
        Personals s = new Personals("test", "test", "test", "test");
        setup.add(p);
        setup.add(q);
        setup.add(r);
        setup.add(s);
        TableColumn<Personals, String> nameColumn = new TableColumn<>("First name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Personals,String>,ObservableValue<String>>(){
        
            @Override
            public ObservableValue<String> call(CellDataFeatures<Personals, String> param) {
                return new SimpleStringProperty(param.getValue().getFirstname());
            }
        });
        tableview.setItems(setup);
        tableview.getColumns().addAll(nameColumn);



        VBox vbox = new VBox();
        vbox.getChildren().addAll(tableview);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }


    @Override
    public void stop(){
        System.exit(0);
    }
    public static void main(String[] args)throws Exception{
        //this is empty cuz reasons
        launch(args);

    }
}