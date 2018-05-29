


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// A sample JavaFX application to show how to use simple table views and observable collections.
public class CustomTableViewSample extends Application
{
	private boolean showTableViewCar = true; // Boolean flag to hide/show the proper table view (for cars or fuel events).
	
	private TableView<Car> tableViewCar = new TableView<>(); // Table view UI control for cars.
	private ObservableList<Car> obsListCar = FXCollections.observableArrayList(); // Observable collection for cars.
	
	private TableView<FuelEvent> tableViewFuelEvent = new TableView<>(); // Table view UI control for fuel events.
	private ObservableList<FuelEvent> obsListFuelEvent = FXCollections.observableArrayList(); // Observable collection for fuel events.

	// Entry point of the JavaFX application.
	@Override
	public void start( Stage primaryStage ) {
   
      // LOADING INPUT FILE INTO DATA STRUCTURES
		// Retrieve command line arguments.
		final Parameters params = getParameters();
      final List<String> parameters = params.getRaw();
      // Init file name.
      //final String fileName = !parameters.isEmpty() ? parameters.get(0) : ""; // Note: alternative implementation!
      String fileName;
      if( !parameters.isEmpty() ) { fileName = parameters.get(0); }
      else { fileName = ""; }
      // Load data from file.
		try {
         Scanner file = new Scanner( new File( fileName ) );
			while( file.hasNext() ) {
            String line = file.nextLine();
				Scanner parse = new Scanner( line );
				parse.useDelimiter( "/" );
            if( parse.next().equals( "CAR" ) ) { 
               String plate = parse.next();
               int year = parse.nextInt();
               String make = parse.next();
               String model = parse.next();
               int miles = parse.nextInt();
               Car newCar = new Car( plate, year, make, model, miles );
               obsListCar.add( newCar ); }
            else { 
               String plate = parse.next();
               String date = parse.next();
               int miles = parse.nextInt();
               float fuelAdded = parse.nextFloat();
               FuelEvent newFuelEvent = new FuelEvent( plate, date, miles, fuelAdded );
               obsListFuelEvent.add( newFuelEvent ); } }
			file.close(); }
		catch( FileNotFoundException e ) { System.out.println( "Could not find file!" ); }
		catch( IndexOutOfBoundsException e ) { System.out.println( "No input file name!" ); }
		catch( NoSuchElementException e ) { System.out.println( "Could not parse the input file!" ); }

		// CONFIGURATION OF THE TABLE VIEW FOR CARS
      // Configuration of car table column 1.
		TableColumn< Car, String > col1Car = new TableColumn<>( "License Plate" );
		col1Car.setMinWidth( 100 );
		col1Car.setCellValueFactory( new PropertyValueFactory<>( "plate" ) ); // Requires a getPlate() ( or isPlate() ) accessor in the Car class.
      // Configuration of car table column 2.
		TableColumn< Car, Integer > col2Car = new TableColumn<>( "Year" );
		col2Car.setMinWidth( 100 );
		col2Car.setCellValueFactory( new PropertyValueFactory<>( "year" ) ); // Requires a getYear() ( or isYear() ) accessor in the Car class.
      // Configuration of car table column 3.
		TableColumn< Car, String > col3Car = new TableColumn<>( "Brand" );
		col3Car.setMinWidth( 100 );
		col3Car.setCellValueFactory( new PropertyValueFactory<>( "brand" ) ); // Requires a getBrand() ( or isBrand() ) accessor in the Car class.
      // Configuration of car table column 4.
		TableColumn< Car, String > col4Car = new TableColumn<>( "Model" );
		col4Car.setMinWidth( 100 );
		col4Car.setCellValueFactory( new PropertyValueFactory<>( "model" ) ); // Requires a getModel() ( or isModel() ) accessor in the Car class.
      // Configuration of car table column 5.
		TableColumn< Car, String > col5Car = new TableColumn<>( "Mileage" );
		col5Car.setMinWidth( 100 );
		col5Car.setCellValueFactory( new PropertyValueFactory<>( "mileage" ) ); // Requires a getMileage() ( or isMileage() ) accessor in the Car class.
      // Configuration of car table column 6.
		TableColumn< Car, String > col6Car = new TableColumn<>( "Mpg" );
		col6Car.setMinWidth( 100 );
		col6Car.setCellValueFactory( new PropertyValueFactory<>( "mpg" ) ); // Requires a getMpg() ( or isMpg() ) accessor in the Car class.
		// Link the observable collection for cars to the relative table view, and configuration of the car table view columns.
		tableViewCar.setItems( obsListCar );
		tableViewCar.getColumns().addAll( col1Car, col2Car, col3Car, col4Car, col5Car, col6Car );
      
      // CONFIGURATION OF THE TABLE VIEW FOR FUEL EVENTS
      // Configuration of fuel event table column 1.
		TableColumn< FuelEvent, String > col1FuelEvent = new TableColumn<>( "License Plate" );
		col1FuelEvent.setMinWidth( 100 );
		col1FuelEvent.setCellValueFactory( new PropertyValueFactory<>( "plate" ) ); // Requires a getPlate() ( or isPlate() ) accessor in the FuelEvent class.
      // Configuration of fuel event table column 2.
		TableColumn< FuelEvent, String > col2FuelEvent = new TableColumn<>( "Date" );
		col2FuelEvent.setMinWidth( 100 );
		col2FuelEvent.setCellValueFactory( new PropertyValueFactory<>( "date" ) ); // Requires a getDate() ( or isDate() ) accessor in the FuelEvent class.
      // Configuration of fuel event table column 3.
		TableColumn< FuelEvent, String > col3FuelEvent = new TableColumn<>( "Mileage" );
		col3FuelEvent.setMinWidth( 100 );
		col3FuelEvent.setCellValueFactory( new PropertyValueFactory<>( "mileage" ) ); // Requires a getMileage() ( or isMileage() ) accessor in the FuelEvent class.
      // Configuration of fuel event table column 4.
		TableColumn< FuelEvent, String > col4FuelEvent = new TableColumn<>( "Fuel" );
		col4FuelEvent.setMinWidth( 100 );
		col4FuelEvent.setCellValueFactory( new PropertyValueFactory<>( "fuel" ) ); // Requires a getFuel() ( or isFuel() ) accessor in the FuelEvent class.
      // Configuration of fuel event table column 5.
		TableColumn< FuelEvent, String > col5FuelEvent = new TableColumn<>( "Mpg" );
		col5FuelEvent.setMinWidth( 100 );
		col5FuelEvent.setCellValueFactory( new PropertyValueFactory<>( "mpg" ) ); // Requires a getMpg() ( or isMpg() ) accessor in the FuelEvent class.
		// Link the observable collection for fuel events to the relative table view, and configuration of the fuel event table view columns.
		tableViewFuelEvent.setItems( obsListFuelEvent );
		tableViewFuelEvent.getColumns().addAll( col1FuelEvent, col2FuelEvent, col4FuelEvent, col5FuelEvent );
      
		// MANAGEMENT OF THE VISIBILITY OF THE TABLE VIEWS FOR CARS AND FUEL EVENTS
		tableViewCar.setVisible( showTableViewCar );
		tableViewFuelEvent.setVisible( !showTableViewCar );
      
      // CONFIGURATION OF THE BUTTON TO SHOW CARS / FUEL EVENTS
		Button buttonShowCarsFuelEvents = new Button( "Show Cars / Fuel Events" );
		buttonShowCarsFuelEvents.setOnAction( 
			new EventHandler<ActionEvent>() {
				@Override
				public void handle( ActionEvent e ) {
					// Hiding/showing the proper table view accordingly to the boolean flag.
					showTableViewCar = !showTableViewCar;
					tableViewCar.setVisible( showTableViewCar );
					tableViewFuelEvent.setVisible( !showTableViewCar );
				}
			}
		);
		
      // CONFIGURATION OF THE LABEL TO SHOW THE FILE NAME
      Label labelFileName = new Label( "File:   " + fileName );
            
		// CONFIGURATION OF THE LAYOUT AND SCENE AND STAGE
		// Title.
		primaryStage.setTitle( "CS-102: Assignment 5" );
		// Layout.
		GridPane grid = new GridPane(); // Lay out children nodes in a grid.
		grid.setAlignment( Pos.CENTER ); // Set grid alignment to centered.
		grid.setHgap( 20 );
      grid.setVgap( 20 );
		grid.setPadding( new Insets( 10, 10, 10, 10 ) ); // Padding around content area.
		grid.add( tableViewCar, 0, 0, 5, 5 );
		grid.add( tableViewFuelEvent, 0, 0, 5, 5 );
		grid.add( buttonShowCarsFuelEvents, 0, 5, 1, 1 );
      grid.add( labelFileName, 0, 7, 5, 1 );
		// Scene graph.
		Scene scene = new Scene( grid, 800, 600 );
		// Stage.
		primaryStage.setScene( scene );
		primaryStage.show();
	}
		
	// Dummy main method to integrate JavaFX in some IDEs.
	public static void main( String[] args ) { launch( args ); }

}


