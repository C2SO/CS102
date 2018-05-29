


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// ...
public class ButtonSample extends Application {

   private static final Color color = Color.web( "#FF00FF" ); // ...
   Button button3 = new Button( "Decline" ); // ...
   DropShadow shadow = new DropShadow(); // ...
   Label label = new Label(); // ...
   
   // ...
   public static void main( String[] args ) { launch( args ); }
   
   // ...   
   @Override
   public void start( Stage stage ) {
      Scene scene = new Scene( new Group() );
      scene.getStylesheets().add( "ControlStyle.css" );
      // Configure the primary stage (part 1).
      stage.setTitle( "Button Sample" );
      stage.setWidth( 300 );
      stage.setHeight( 190 );
      // Configure label.
      label.setFont( Font.font( "Times New Roman", 22 ) );
      label.setTextFill( color );
      // Load icon images.
      Image imageDecline = new Image( "not.png" );
      Image imageAccept = new Image( "ok.png" );
      // Configure button1.
      Button button1 = new Button( "Accept", new ImageView( imageAccept ) );
      button1.getStyleClass().add( "button1" );
      button1.setOnAction( ( ActionEvent e ) -> { label.setText( "Accepted" ); } );
      // Configure button2.
      Button button2 = new Button( "Accept" );
      button2.setOnAction( ( ActionEvent e ) -> { label.setText( "Accepted" ); } );
      // Configure button3.
      button3.setOnAction( ( ActionEvent e ) -> { label.setText( "Declined" ); } );
      button3.addEventHandler( MouseEvent.MOUSE_ENTERED, ( MouseEvent e ) -> { button3.setEffect( shadow ); } );
      button3.addEventHandler( MouseEvent.MOUSE_EXITED, ( MouseEvent e ) -> { button3.setEffect( null ); } );
      // Configure a horizontal box layout.
      HBox hbox1 = new HBox();
      hbox1.getChildren().add( button2 );
      hbox1.getChildren().add( button3 );
      hbox1.getChildren().add( label );
      hbox1.setSpacing( 10 );
      hbox1.setAlignment( Pos.BOTTOM_CENTER );
      // Configure button4.
      Button button4 = new Button();
      button4.setGraphic( new ImageView( imageAccept ) );
      button4.setOnAction( ( ActionEvent e ) -> { label.setText( "Accepted" ); } );
      // Configure button 5.
      Button button5 = new Button();
      button5.setGraphic( new ImageView( imageDecline ) );
      button5.setOnAction( ( ActionEvent e ) -> { label.setText( "Declined" ); } );
      // Configure a horizontal box layout.
      HBox hbox2 = new HBox();
      hbox2.getChildren().add( button4 );
      hbox2.getChildren().add( button5 );
      hbox2.setSpacing( 25 );
      // Configure a vertical box layout.
      VBox vbox = new VBox();
      vbox.setLayoutX( 20 );
      vbox.setLayoutY( 20 );
      vbox.getChildren().add( button1 );
      vbox.getChildren().add( hbox1 );
      vbox.getChildren().add( hbox2 );
      vbox.setSpacing( 10 );
      // Set the vertical box layout as the scene graph root.
      ( (Group) scene.getRoot() ).getChildren().add( vbox );
      // Configure the primary stage (part 2).
      stage.setScene( scene );
      stage.show();
   }
}


