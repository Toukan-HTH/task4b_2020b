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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import java.util.logging.*;
import java.io.*;
import java.io.File;





public class Main extends Application{
    Stage window;
    TableView tableview = new TableView<BonusMember>();
    MemberArchive memberArchive = new MemberArchive();
    ObservableList<BonusMember> setup = FXCollections.observableArrayList();
    Log logger;



    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        try{
            this.logger = new Log("App.log");
        }catch(Exception e){
            e.printStackTrace();
        }
        window = primaryStage;
        //TESTDATA
        Personals p = new Personals("test", "test2", "test", "test");
        Personals q = new Personals("test1", "test3", "test", "test");
        Personals r = new Personals("test2", "test5", "test", "test");
        Personals s = new Personals("test3", "test6", "test", "test");
        setup.add(new SilverMember(99995, p, LocalDate.of(2020, 02, 11), 900000));
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
        temp.add(new SilverMember(99995, p, LocalDate.of(2020, 02, 11), 900000));
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

        //BUTTONS
        vbox.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;");
        Button button = new Button("Add New Member");
        button.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;");
        Button button2 = new Button("Delete Selected Member");
        button2.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;");
        Button button3 = new Button("Upgrade Valid Members");
        button3.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;");
        Button button4 = new Button("Show Details");
        button4.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;");
        tableview.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;-fx-accent:#282a2d;");
        Rectangle rectangle = new Rectangle(20,50,175,205);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.DARKGRAY);
        //BUTTONS
        vbox.getChildren().addAll(tableview,rectangle,button,button2,button3,button4);
        vbox.setSpacing(25);
        vbox.setMargin(button, new Insets(-255,10,0,20));
        vbox.setMargin(button2, new Insets(0,0,0,20));
        vbox.setMargin(button3, new Insets(0,0,0,20));
        vbox.setMargin(button4, new Insets(0,0,10,20));
        vbox.setMargin(rectangle, new Insets(0,0,40,10));
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();


        //Button eventhandling
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                TextField firstnameField = new TextField();
                Label firstNameLabel = new Label("First Name");
                TextField lastnameField = new TextField();
                Label lastnameLabel = new Label("Last Name");
                TextField emailField = new TextField();
                Label emailLabel = new Label("Email");
                TextField passwordField = new TextField();
                Label passwordLabel = new Label("Password");
                VBox addmemberVbox = new VBox();
                Button buttonAccept = new Button("Accept");
                buttonAccept.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;");
                Button cancelButton = new Button("Cancel");
                cancelButton.setStyle("-fx-border-color:#282a2d;-fx-focus-color:#282a2d;");
                addmemberVbox.getChildren().addAll(firstNameLabel,firstnameField,lastnameLabel,lastnameField,emailLabel,emailField,passwordLabel,passwordField,buttonAccept,cancelButton);
                addmemberVbox.setMargin(cancelButton, new Insets(-27, 0, 5, 100));
                Stage newWindow = new Stage();
                Scene newScene = new Scene(addmemberVbox);
                newWindow.setScene(newScene);
                newWindow.show();

                buttonAccept.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        if(firstnameField.getText().equals("")||firstnameField.getText().equals(null)||lastnameField.getText().equals("")||lastnameField.getText().equals(null)||emailField.getText().equals("")||emailField.getText().equals(null)||passwordField.getText().equals("")||passwordField.getText().equals(null)){
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Error Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("None of the fields can be empty or a null value");
                            alert.showAndWait();
                        }else{
                            try{
                                memberArchive.newMember(new Personals(lastnameField.getText(), firstnameField.getText(),emailField.getText(), passwordField.getText()), LocalDate.now());
                                logger.logNewInfo("New Member Created");
                                newWindow.close();
                                updateObservableList(memberArchive.getArray());
                                tableview.refresh();
                            }catch(IllegalArgumentException e){
                                logger.logNewWarning("The input values somehow was empty or a null value");
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                });

                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event){
                        newWindow.close();
                    }
                });
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                int index = tableview.getSelectionModel().getFocusedIndex();
                logger.logNewWarning("Deleted Member," + " ID nr : " + memberArchive.getArray().get(index).getMemberNo());
                setup.remove(index);
                tableview.refresh();;
                memberArchive.removeMember(index);
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                memberArchive.checkMembers();
                logger.logNewInfo("Upgrading Members");
                updateObservableList(memberArchive.getArray());
                tableview.refresh();
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                int index = tableview.getSelectionModel().getFocusedIndex();
                logger.logNewInfo("Showing Details for Member nr : " + memberArchive.getArray().get(index).getMemberNo());
                Alert detailsAlert = new Alert(AlertType.INFORMATION);
                detailsAlert.setTitle("Details");
                TextArea textarea = new TextArea("First Name: " + memberArchive.getArray().get(index).getPersonals().getFirstname());
                textarea.appendText("\n");
                textarea.appendText("Last Name: " + memberArchive.getArray().get(index).getPersonals().getSurname());
                textarea.appendText("\n");
                textarea.appendText("Email: " + memberArchive.getArray().get(index).getPersonals().getEPostadr());
                textarea.appendText("\n");
                textarea.appendText("Password: " + memberArchive.getArray().get(index).getPersonals().getPassword());
                textarea.appendText("\n");
                textarea.appendText("Rank: " + memberArchive.getArray().get(index).getMemberStatus());
                textarea.appendText("\n");
                textarea.appendText("Points: " + memberArchive.getArray().get(index).getPoints());
                textarea.appendText("\n");
                textarea.appendText("Member ID: " + memberArchive.getArray().get(index).getMemberNo());
                textarea.appendText("\n");
                textarea.appendText("Enrollment Date: " + memberArchive.getArray().get(index).getEnrolledDate());
                GridPane content = new GridPane();
                content.add(textarea, 0, 0);
                detailsAlert.getDialogPane().setContent(content);
                detailsAlert.showAndWait();
            }
        });
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
        TableColumn<BonusMember, Integer> memberPointsColumn = new TableColumn<>("Points");
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

    /*
    public class ButtonHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==Start.button)
            //System.out.println(tableview.getSelectionModel().getFocusedIndex());
            //System.out.println(tableview.getSelectionModel().getSelectedItem());
            //setup.remove(tableview.getSelectionModel().getFocusedIndex());
            //tableview.refresh();

        }

    }*/

    public void updateObservableList(ArrayList<BonusMember> newList){
        this.setup=FXCollections.observableArrayList(newList);
        tableview.setItems(setup);
        tableview.refresh();
    }
}