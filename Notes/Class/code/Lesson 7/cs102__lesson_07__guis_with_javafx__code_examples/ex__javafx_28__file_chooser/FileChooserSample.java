


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// ...
public final class FileChooserSample extends Application {

   private final Desktop desktop = Desktop.getDesktop(); // ...

   // ...
   @Override
   public void start( final Stage stage ) {
      stage.setTitle( "File Chooser Sample" );
      final FileChooser fileChooser = new FileChooser();
      final Button openButton = new Button( "Open a Picture..." );
      final Button openMultipleButton = new Button( "Open Pictures..." );
      openButton.setOnAction( 
         ( final ActionEvent e ) -> {
            configureFileChooser( fileChooser );
            File file = fileChooser.showOpenDialog( stage );
            if( file != null ) { openFile( file ); } } );
      openMultipleButton.setOnAction(
         ( final ActionEvent e ) -> {
            configureFileChooser( fileChooser );
            List<File> list = fileChooser.showOpenMultipleDialog( stage );
            if( list != null ) { list.stream().forEach( ( file ) -> { openFile( file ); } ); } } );
      final GridPane inputGridPane = new GridPane();
      GridPane.setConstraints( openButton, 0, 1 );
      GridPane.setConstraints( openMultipleButton, 1, 1 );
      inputGridPane.setHgap( 6 );
      inputGridPane.setVgap( 6 );
      inputGridPane.getChildren().addAll( openButton, openMultipleButton );
      final Pane rootGroup = new VBox( 12 );
      rootGroup.getChildren().addAll( inputGridPane );
      rootGroup.setPadding( new Insets( 12, 12, 12, 12 ) );
      stage.setScene( new Scene( rootGroup ) );
      stage.show();
   }
   
   // ...
   public static void main( String[] args ) { Application.launch( args ); }

   // ...
   private static void configureFileChooser( final FileChooser fileChooser ) {
      fileChooser.setTitle( "View Pictures" );
      fileChooser.setInitialDirectory( new File( System.getProperty( "user.home" ) ) );
      fileChooser.getExtensionFilters().addAll(
         new FileChooser.ExtensionFilter( "All Images", "*.*" ),
         new FileChooser.ExtensionFilter( "JPG", "*.jpg" ),
         new FileChooser.ExtensionFilter( "PNG", "*.png" ) );
   }
   
   // ...
   private void openFile( File file ) {
      try { desktop.open( file ); }
      catch( IOException e ) {
         Logger.getLogger( FileChooserSample.class.getName() ).log( Level.SEVERE, null, e ); }
   }
   
}


