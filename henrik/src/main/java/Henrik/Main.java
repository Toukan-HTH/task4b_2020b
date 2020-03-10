package Henrik;
import java.time.*;
import java.util.*;

import javax.swing.JButton;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;






public class Main extends Application{
    Stage window;
    TableView tableview = new TableView<BonusMember>();
    MemberArchive memberArchive = new MemberArchive();
    ObservableList<BonusMember> setup = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        window = primaryStage;
        //TESTDATA
        Personals p = new Personals("test", "test2", "test", "test");
        Personals q = new Personals("test1", "test3", "test", "test");
        Personals r = new Personals("test2", "test5", "test", "test");
        Personals s = new Personals("test3", "test6", "test", "test");
        setup.add(new SilverMember(99995, p, LocalDate.now(), 200));
        setup.add(new SilverMember(99994, q, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        setup.add(new SilverMember(99993, r, LocalDate.now(), 200));
        ArrayList<BonusMember> temp = new ArrayList<BonusMember>();
        temp.add(new SilverMember(99995, p, LocalDate.now(), 200));
        temp.add(new SilverMember(99994, q, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        temp.add(new SilverMember(99993, r, LocalDate.now(), 200));
        memberArchive.setArray(temp);
        //TESTDATA

        tableview.setItems(setup);
        tableview.getColumns().addAll(getMemberStatusColumn(),getMemberIDColumn(),getMemberPointsColumn(),getMemberSignupTimeColumn());

        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        Button button = new Button("Add New Member");
        button.setOnAction(new ButtonHandler());
        Button button2 = new Button("Delete Selected Member");
        button2.setOnAction(new ButtonHandler());
        Button button3 = new Button("Upgrade Valid Members");
        button3.setOnAction(new ButtonHandler());
        Button button4 = new Button("Show Details");
        button4.setOnAction(new ButtonHandler());
        vbox.getChildren().addAll(tableview,button,button2,button3,button4);
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }
    private TableColumn<BonusMember, String> getFirstNameColumn(){
        TableColumn<BonusMember, String> nameColumn = new TableColumn<>("First Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,String>,ObservableValue<String>>(){
        
            @Override
            public ObservableValue<String> call(CellDataFeatures<BonusMember, String> param) {
                return new SimpleStringProperty(param.getValue().getPersonals().getFirstname());
            }
        });
        return nameColumn;
    }


    private TableColumn<BonusMember, String> getLastNameColumn(){
        TableColumn<BonusMember, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setMinWidth(200);
        lastNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,String>,ObservableValue<String>>(){
        
            @Override
            public ObservableValue<String> call(CellDataFeatures<BonusMember, String> param) {
                return new SimpleStringProperty(param.getValue().getPersonals().getSurname());
            }
        });
        return lastNameColumn;
    }


    private TableColumn<BonusMember, String> getEmailColumn(){
        TableColumn<BonusMember, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setMinWidth(200);
        emailColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,String>,ObservableValue<String>>(){
        
            @Override
            public ObservableValue<String> call(CellDataFeatures<BonusMember, String> param) {
                return new SimpleStringProperty(param.getValue().getPersonals().getEPostadr());
            }
        });
        return emailColumn;
    }


    private TableColumn<BonusMember, String> getPasswordColumn(){
        TableColumn<BonusMember, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setMinWidth(200);
        passwordColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,String>,ObservableValue<String>>(){
        
            @Override
            public ObservableValue<String> call(CellDataFeatures<BonusMember, String> param) {
                return new SimpleStringProperty(param.getValue().getPersonals().getPassword());
            }
        });
        return passwordColumn;
    }


    private TableColumn<BonusMember, String> getMemberStatusColumn(){
        TableColumn<BonusMember, String> statusColumn = new TableColumn<>("Member Rank");
        statusColumn.setMinWidth(200);
        statusColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,String>,ObservableValue<String>>(){
        
            @Override
            public ObservableValue<String> call(CellDataFeatures<BonusMember, String> param) {
                return new SimpleStringProperty(param.getValue().getMemberStatus());
            }
        });
        return statusColumn;
    }


    private TableColumn<BonusMember, Integer> getMemberIDColumn(){
        TableColumn<BonusMember, Integer> memberIDColumn = new TableColumn<>("Member ID");
        memberIDColumn.setMinWidth(200);
        memberIDColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,Integer>,ObservableValue<Integer>>(){
        
            @Override
            public ObservableValue<Integer> call(CellDataFeatures<BonusMember, Integer> param) {
                ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(param.getValue().getMemberNo());
                return obsInt;
            }
        });
        return memberIDColumn;
    }


    private TableColumn<BonusMember, Integer> getMemberPointsColumn(){
        TableColumn<BonusMember, Integer> memberPointsColumn = new TableColumn<>("Member ID");
        memberPointsColumn.setMinWidth(200);
        memberPointsColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,Integer>,ObservableValue<Integer>>(){
        
            @Override
            public ObservableValue<Integer> call(CellDataFeatures<BonusMember, Integer> param) {
                ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(param.getValue().getPoints());
                return obsInt;
            }
        });
        return memberPointsColumn;
    }


    private TableColumn<BonusMember, LocalDate> getMemberSignupTimeColumn(){
        TableColumn<BonusMember, LocalDate> memberRegisterColumn = new TableColumn<>("Date Registered");
        memberRegisterColumn.setMinWidth(200);
        memberRegisterColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BonusMember,LocalDate>,ObservableValue<LocalDate>>(){
        
            @Override
            public ObjectProperty<LocalDate> call(CellDataFeatures<BonusMember, LocalDate> param) {
                ObjectProperty<LocalDate> obsInt = new ReadOnlyObjectWrapper<>(param.getValue().getEnrolledDate());
                return obsInt;
            }
        });
        return memberRegisterColumn;
    }


    @Override
    public void stop(){
        System.exit(0);
    }
    public static void main(String[] args)throws Exception{
        //this is empty cuz reasons
        launch(args);

    }


    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            //System.out.println(tableview.getSelectionModel().getFocusedIndex());
            //System.out.println(tableview.getSelectionModel().getSelectedItem());
            //setup.remove(tableview.getSelectionModel().getFocusedIndex());
            //tableview.refresh();

        }

    }

    public void updateObservableList(ArrayList<BonusMember> newList){
        this.setup=FXCollections.observableArrayList(newList);
        tableview.refresh();
    }
}