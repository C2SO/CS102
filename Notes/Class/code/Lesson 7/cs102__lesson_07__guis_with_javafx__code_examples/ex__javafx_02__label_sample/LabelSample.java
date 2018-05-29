


import javafx.scene.Group;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.EventHandler;

// ...
public class LabelSample extends Application {
   
   private final Label label3 = new Label( "A label that needs to be wrapped" ); // Constant label.

   // Main method to enable JavaFX support in all IDEs.
   public static void main( String[] args ) {
      launch(args);
   }
   
   // Main entry point for JavaFX applications.
   @Override
   public void start( Stage stage ) {
      Scene scene = new Scene( new Group() ); // Scene created using a Group node as root.
      Image image = new Image( "labels.jpg" ); // Create an icon for label1.
      // Configure label1.
      Label label1 = new Label( "Search" );
      label1.setGraphic( new ImageView( image ) );
      label1.setFont( new Font( "Arial", 30 ) );
      label1.setTextFill( Color.web( "#0076a3" ) ); // Color as a hex web value, implicit alpha (transparency).
      label1.setTextAlignment( TextAlignment.JUSTIFY );
      // Configure label2.
      Label label2 = new Label( "Values" );
      label2.setFont( Font.font( "Cambria", 32 ) );
      label2.setRotate( 270 );
      label2.setTranslateY( 5 );
      // Configure label3.
      label3.setWrapText( true );
      label3.setTranslateY( 50 );
      label3.setPrefWidth( 100 );
      //label3.setOnMouseEntered( ( MouseEvent e ) -> { label3.setScaleX( 1.5 ); label3.setScaleY( 1.5 ); } ); // Lambda expression (Java 8).
      label3.setOnMouseEntered( new EventHandler<MouseEvent>() { @Override public void handle( MouseEvent e ) { label3.setScaleX( 1.5 ); label3.setScaleY( 1.5 ); } } );
      //label3.setOnMouseExited( ( MouseEvent e ) -> { label3.setScaleX( 1 ); label3.setScaleY( 1 ); } ); // Lambda expression (Java 8).
      label3.setOnMouseExited( new EventHandler<MouseEvent>() { @Override public void handle( MouseEvent e ) { label3.setScaleX( 1 ); label3.setScaleY( 1 ); } } );
      // Configure layout.
      HBox hbox = new HBox();
      hbox.setSpacing( 10 );
      hbox.getChildren().add( label1 );
      hbox.getChildren().add( label2 );
      hbox.getChildren().add( label3 );
      // Add the horizontal box layout as child of the scene graph root.
      ( (Group) scene.getRoot() ).getChildren().add( hbox );
      // Configure primary stage.
      stage.setTitle( "Label Sample" );
      stage.setWidth( 420 );
      stage.setHeight( 180 );
      stage.setScene( scene );
      stage.show();
   }
   
}


