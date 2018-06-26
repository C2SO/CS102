
/*
Nicholas Rahbany
CS102
*/

import java.io.*;
import java.util.Scanner;

import TennisDatabase.TennisDatabase;
import TennisDatabase.TennisDatabaseException;
import TennisDatabase.TennisDatabaseRuntimeException;
import TennisDatabase.TennisPlayer;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT; // Static import allows unqualified access to static member: RIGHT (see line 62).
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Assignment2 extends Application {

    static TennisDatabase tdb;

    private TableView<TennisPlayer> playerTable = new TableView<>();
    private ObservableList<TennisPlayer> data = FXCollections.observableArrayList();
    private HBox hbPlayer = new HBox();
    private HBox hbImport = new HBox();

    @Override
    public void start(Stage primaryStage) {
        // GridPane grid = new GridPane(); // GridPane lays out its children within a flexible grid of rows and columns.

        // grid.setAlignment(Pos.CENTER); // The alignment of of the grid.
        // grid.setHgap(10);
        // grid.setVgap(10);
        // grid.setPadding(new Insets(25, 25, 25, 25));

        // Text scenetitle = new Text("What file would you like to import from?");
        // scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        // grid.add(scenetitle, 0, 0, 2, 1);
        // // ...
        // Label fileName = new Label("File Name:");
        // grid.add(fileName, 0, 1);
        // // ...
        // TextField fileTextField = new TextField();
        // grid.add(fileTextField, 1, 1);

        // Button btnFile = new Button("Import File");
        // HBox hbBtn = new HBox(10);
        // hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        // hbBtn.getChildren().add(btnFile);
        // grid.add(hbBtn, 1, 4);

        // final Text actiontarget = new Text();
        // grid.add(actiontarget, 0, 6);
        // grid.setColumnSpan(actiontarget, 2);
        // grid.setHalignment(actiontarget, RIGHT);
        // actiontarget.setId("actiontarget");

        // btnFile.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent e) {
        //         actiontarget.setFill(Color.FIREBRICK);
        //         tdb.loadFile(fileTextField.getText());
        //         actiontarget.setText("File Imported");
        //     }
        // });

        // Button btn = new Button();
        // btn.setText("Print All Players");
        // btn.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         tdb.printAllPlayers(); // Print All Players
        //     }
        // });
        // hbBtn.getChildren().add(btn);

        // Button btnMatches = new Button();
        // btnMatches.setText("Print All Matches");
        // btnMatches.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         tdb.printAllMatches(); // Print All Matches
        //     }
        // });
        // hbBtn.getChildren().add(btnMatches);

        // Button btnExport = new Button();
        // btnExport.setText("Export Database");
        // btnExport.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         tdb.exportFile(); // Exports Database
        //         actiontarget.setText("Database Exported!");
        //     }
        // });
        // hbBtn.getChildren().add(btnExport);

        // Button btnReset = new Button();
        // btnReset.setText("Reset Database");
        // btnReset.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         tdb.resetDatabase(); // Resets Database
        //         actiontarget.setText("Database Reset!");
        //     }
        // });
        // hbBtn.getChildren().add(btnReset);

        // Scene scene = new Scene(grid, 500, 250);
        Scene scene = new Scene( new Group());
        primaryStage.setTitle("Tennis Database");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        final Label playerLabel = new Label("Tennis Players");
        playerLabel.setFont(new Font("Arial", 20));
        playerTable.setEditable(true);

        //Table Columns Player
        TableColumn<TennisPlayer, String> playerIdCol = new TableColumn<>("Player ID");
        playerIdCol.setMinWidth(100);
        playerIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        playerIdCol.setCellFactory(TextFieldTableCell.<TennisPlayer>forTableColumn());
        playerIdCol.setOnEditCommit((CellEditEvent<TennisPlayer, String> t) -> {
              ((TennisPlayer) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                          .setId(t.getNewValue());
        });
        TableColumn<TennisPlayer, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.<TennisPlayer>forTableColumn());
        firstNameCol.setOnEditCommit((CellEditEvent<TennisPlayer, String> t) -> {
              ((TennisPlayer) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                          .setFirstName(t.getNewValue());
        });
        TableColumn<TennisPlayer, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.<TennisPlayer>forTableColumn());
        lastNameCol.setOnEditCommit((CellEditEvent<TennisPlayer, String> t) -> {
              ((TennisPlayer) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                          .setLastName(t.getNewValue());
        });
        TableColumn<TennisPlayer, String> birthYearCol = new TableColumn<>("Birth Year");
        birthYearCol.setMinWidth(100);
        birthYearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        birthYearCol.setCellFactory(TextFieldTableCell.<TennisPlayer>forTableColumn());
        birthYearCol.setOnEditCommit((CellEditEvent<TennisPlayer, String> t) -> {
              ((TennisPlayer) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                          .setBirthYear(t.getNewValue());
        });
        TableColumn<TennisPlayer, String> countryCol = new TableColumn<>("Country");
        countryCol.setMinWidth(100);
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        countryCol.setCellFactory(TextFieldTableCell.<TennisPlayer>forTableColumn());
        countryCol.setOnEditCommit((CellEditEvent<TennisPlayer, String> t) -> {
              ((TennisPlayer) t.getTableView().getItems().get(t.getTablePosition().getRow()))
                          .setCountry(t.getNewValue());
        });

        playerTable.setItems(data);
        playerTable.getColumns().addAll(playerIdCol, firstNameCol, lastNameCol, birthYearCol, countryCol);
        final TextField addId = new TextField();
        addId.setPromptText("Player ID");
        addId.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setPromptText("Last Name");
        addLastName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addBirthYear = new TextField();
        addBirthYear.setPromptText("Birth Year");
        addBirthYear.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addCountry = new TextField();
        addCountry.setPromptText("Country");
        addCountry.setMaxWidth(firstNameCol.getPrefWidth());
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
              data.add(new TennisPlayer(addId.getText(), addFirstName.getText(), addLastName.getText(), addBirthYear.getText(), addCountry.getText()));
              addId.clear();
              addFirstName.clear();
              addLastName.clear();
              addBirthYear.clear();
              addCountry.clear();
        });
        hbPlayer.getChildren().addAll(addId, addFirstName, addLastName, addBirthYear, addCountry, addButton);
        hbPlayer.setSpacing(3);

        final TextField addImport = new TextField();
        addImport.setPromptText("File Name");
        addImport.setMaxWidth(firstNameCol.getPrefWidth());
        final Button addImportButton = new Button("Add");
        addImportButton.setOnAction((ActionEvent e) -> {
            tdb.loadFile(addImport.getText());
            addImport.clear();
        });
        hbPlayer.getChildren().addAll(addImport, addImportButton);
        hbPlayer.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(playerLabel, playerTable, hbPlayer, hbImport);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Check if there are no command line arguments
        tdb = new TennisDatabase();
        // Check command and activate the relative tennis database opertations
        // runProgram();
        launch(args);
    }

    // public static void runProgram() {
    //     boolean systemRunning = true; // Tells code if program is running
    //     int option; // User input option
    //     Scanner user = new Scanner(System.in); // Scans console for user input
    //     while (systemRunning) { // While system is running, ask for the user to
    //     select an option
    //     System.out.println(
    //     "\nSelect an option my entering the option's number:\n1. Print Players\n2.
    //     Print Matches\n3. Print All Matches For A Player\n4. Add a Player\n5. Add a
    //     Match\n6. Delete a Player\n7. Export Database\n8. Import Another File\n9.
    //     Reset Database\n\n0. Exit\n");
    //     option = user.nextInt(); // Takes in user input
    //     switch (option) {
    //     case 1:
    //     tdb.printAllPlayers(); // Print All Players
    //     break;
    //     case 2:
    //     tdb.printAllMatches(); // Print All Matches
    //     break;
    //     case 3:
    //         System.out.println("Enter a Player ID");
    //         String playerId = user.next();
    //         tdb.printMatchesOfPlayer(playerId); // Print Matches of Player Inputed
    //         break;
    //     case 4: // Asks user to fill in all data to add a player
    //         System.out.println("Enter the Player ID");
    //         String id = user.next();
    //         System.out.println("Enter the Player's First Name");
    //         String firstName = user.next();
    //         System.out.println("Enter the Player's Last Name");
    //         String lastName = user.next();
    //         System.out.println("Enter the Player's Birth Year");
    //         Integer year = user.nextInt();
    //         System.out.println("Enter the Player's Country");
    //         String country = user.next();
    //         tdb.insertPlayer(id, firstName, lastName, year, country); // Adds player
    //         break;
    //     case 5: // Asks user to fill in all data to add a match
    //         System.out.println("Enter the First Player's ID");
    //         String idPlayer1 = user.next();
    //         System.out.println("Enter the Second Player's ID");
    //         String idPlayer2 = user.next();
    //         System.out.println("Enter the Day of the Match");
    //         Integer dayInput = user.nextInt();
    //         System.out.println("Enter the Month of the Match");
    //         Integer monthInput = user.nextInt();
    //         System.out.println("Enter the Year of the Match");
    //         Integer yearInput = user.nextInt();
    //         System.out.println("Enter the Name of the Tournament (Ex. Kettering_Cup)");
    //         String tournamentInput = user.next();
    //         System.out.println("Enter the Score\nExample: 6-4,5-7,6-4,6-4");
    //         String scoreInput = user.next();
    //         tdb.insertMatch(idPlayer1, idPlayer2, yearInput, monthInput, dayInput, tournamentInput, scoreInput); // Adds
    //                                                                                                              // match
    //         break;
    //     case 6: // Asks user to giver player ID to delete
    //         System.out.println("What Player ID would you like to delete?");
    //         String deletePlayerId = user.next();
    //         tdb.deletePlayer(deletePlayerId);
    //         break;
    //     case 7: // Exports Database
    //     tdb.exportFile();
    //     break;
    //     case 8: // Imports another file
    //     // tdb.loadFile();
    //     break;
    //     case 9: // Resets Database
    //         System.out.println();
    //         System.out.println("Would you like to export the database? (Y or N)");
    //         String export = user.next();
    //         if (export == "Y" || export == "y") {
    //         System.out.println("Not implemented yet");
    //         }
    //         tdb.resetDatabase();
    //         break;
    //     case 0:
    //         systemRunning = false; // Stops the program
    //         break;
    //     default:
    //         System.out.println("Please choose an option that was listed..."); // If user selected an option not
    //                                                                           // shown
    //         break;
    //     }
    // }
}
