


import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javafx.stage.FileChooser;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;

// ...
public class MenuSample extends Application {

   // ...
   final PageData[] pages = new PageData[] { new PageData( "Apple", 
                                                           "The apple is the pomaceous fruit of the apple tree, species Malus " + 
                                                           "domestica in the rose family (Rosaceae). It is one of the most " + 
                                                           "widely cultivated tree fruits, and the most widely known of " + 
                                                           "the many members of genus Malus that are used by humans. " + 
                                                           "The tree originated in Western Asia, where its wild ancestor, " + 
                                                           "the Alma, is still found today.", 
                                                           "Malus domestica" ), 
                                             new PageData( "Hawthorn",
                                                           "The hawthorn is a large genus of shrubs and trees in the rose family," + 
                                                           "Rosaceae, native to temperate regions of the Northern Hemisphere " + 
                                                           "in Europe, Asia and North America. The name hawthorn was " + 
                                                           "originally applied to the species native to northern Europe, " + 
                                                           "especially the Common Hawthorn C. monogyna, and the unmodified " + 
                                                           "name is often so used in Britain and Ireland.", 
                                                           "Crataegus monogyna" ),
                                             new PageData( "Ivy", 
                                                           "The ivy is a flowering plant in the grape family (Vitaceae) native to" + 
                                                           " eastern Asia in Japan, Korea, and northern and eastern China. " + 
                                                           "It is a deciduous woody vine growing to 30 m tall or more given " + 
                                                           "suitable support, attaching itself by means of numerous small " + 
                                                           "branched tendrils tipped with sticky disks.", 
                                                           "Parthenocissus tricuspidata" ),
                                             new PageData( "Quince", 
                                                           "The quince is the sole member of the genus Cydonia and is native to " + 
                                                           "warm-temperate southwest Asia in the Caucasus region. The " + 
                                                           "immature fruit is green with dense grey-white pubescence, most " + 
                                                           "of which rubs off before maturity in late autumn when the fruit " + 
                                                           "changes color to yellow with hard, strongly perfumed flesh.", 
                                                           "Cydonia oblonga" ) };

   // ...
   final String[] viewOptions = new String[] { "Title", "Binomial name", "Picture", "Description" };
   
   // An array of map entries (key-value pairs) for the visual effects to affect the picture.
   final Entry< String, Effect >[] effects = new Entry[] { new SimpleEntry<>( "Sepia Tone", new SepiaTone() ), 
                                                           new SimpleEntry<>( "Glow", new Glow() ), 
                                                           new SimpleEntry<>( "Shadow", new DropShadow() ) };
                                                           
   final ImageView pic = new ImageView();
   final Label name = new Label();
   final Label binName = new Label();
   final Label description = new Label();
   private int currentIndex = -1;

   // ...
   public static void main( String[] args ) { launch( args ); }
   
   // ...
   @Override
   public void start( Stage stage ) {
      stage.setTitle( "Menu Sample" );
      // Create a scene graph with a vertical box layout as the root node.
      Scene scene = new Scene( new VBox(), 400, 350 );
      scene.setFill( Color.OLDLACE );
      // Set fonts for image title and subtitle.
      name.setFont( new Font( "Verdana Bold", 22 ) );
      binName.setFont( new Font( "Arial Italic", 10 ) );
      // Configure picture settings.
      pic.setFitHeight( 150 );
      pic.setPreserveRatio( true );
      // Configure description settings.
      description.setWrapText( true );
      description.setTextAlignment( TextAlignment.JUSTIFY );
      // Randomly select another picture updating: title, subtitle, and description.
      shuffle();
      // Create a new menu bar.
      MenuBar menuBar = new MenuBar();
      // GRAPHICAL ELEMENTS
      // Arrange title, subtitle, picture, and description in a vertical box.
      final VBox vbox = new VBox();
      vbox.setAlignment( Pos.CENTER );
      vbox.setSpacing( 10 );
      vbox.setPadding( new Insets( 0, 10, 0, 10 ) );
      vbox.getChildren().addAll( name, binName, pic, description );
      // MENU FILE
      // Create a new menu "File" including items: "Shuffle", "Clear", and "Exit".
      Menu menuFile = new Menu( "File" );
      MenuItem add = new MenuItem( "Shuffle", new ImageView( new Image( "new.png", 16.0, 16.0, true, true ) ) );
      add.setOnAction( ( ActionEvent t ) -> { shuffle(); vbox.setVisible( true ); } ); // Show content.
      MenuItem clear = new MenuItem( "Clear" );
      clear.setAccelerator( KeyCombination.keyCombination( "Ctrl+X" ) );
      clear.setOnAction( ( ActionEvent t ) -> { vbox.setVisible( false ); } ); // Hide content.
      MenuItem exit = new MenuItem( "Exit" );
      exit.setOnAction( ( ActionEvent t ) -> { System.exit( 0 ); } ); // Exit application.
      menuFile.getItems().addAll( add, clear, new SeparatorMenuItem(), exit ); // Add all items to menu "File".
      // MENU EDIT
      // Create a new menu "Edit" including items: "Picture Effect" (submenu), and "No Effects".
      Menu menuEdit = new Menu( "Edit" );
      Menu menuEffect = new Menu( "Picture Effect" );
      final ToggleGroup groupEffect = new ToggleGroup(); // Note: only a single Toggle within a ToggleGroup may be selected at any one time.
      // Create a radio menu item for each visual effect in "effects".
      for( Entry< String, Effect > effect : effects ) {
         RadioMenuItem itemEffect = new RadioMenuItem( effect.getKey() );
         itemEffect.setUserData( effect.getValue() );
         itemEffect.setToggleGroup( groupEffect );
         menuEffect.getItems().add( itemEffect ); }
      // Create and initialize the menu item "No Effects".
      final MenuItem noEffects = new MenuItem( "No Effects" );
      noEffects.setDisable( true );
      // If "No Effects" is clicked disable any visual effect in the toggle group.
      noEffects.setOnAction( 
         ( ActionEvent t ) -> { 
            pic.setEffect( null );
            groupEffect.getSelectedToggle().setSelected( false );
            noEffects.setDisable( true ); } );
      // Enable "No Effects" as soon as a visual effect has been activated in the toggle group.
      groupEffect.selectedToggleProperty().addListener(
         ( ObservableValue<? extends Toggle > ov, Toggle old_toggle, Toggle new_toggle ) -> {
            if( groupEffect.getSelectedToggle() != null ) {
               Effect effect = (Effect) groupEffect.getSelectedToggle().getUserData();
               pic.setEffect( effect );
               noEffects.setDisable( false ); }
            else { noEffects.setDisable( true ); } } );
      // Add the submenu "Picture Effects" and the menu item "No Effects" to the menu "Edit".
      menuEdit.getItems().addAll( menuEffect, noEffects );
      // MENU VIEW
      // Create a new menu "View" including items: "Title", "Binomial Name", "Picture", and "Description".
      Menu menuView = new Menu( "View" );
      // Configure check menu items to link its selection to scene graph nodes visibility.
      CheckMenuItem titleView = createMenuItem( "Title", name );
      CheckMenuItem binNameView = createMenuItem( "Binomial Name", binName );
      CheckMenuItem picView = createMenuItem( "Picture", pic );
      CheckMenuItem descriptionView = createMenuItem( "Description", description );
      // Add all the menu items to the menu "View".
      menuView.getItems().addAll( titleView, binNameView, picView, descriptionView );
      // Add all the menus to the menu bar.
      menuBar.getMenus().addAll( menuFile, menuEdit, menuView );
      // CONTEXT MENU
      // Create a new context menu including only one menu item: "Copy Image".
      final ContextMenu cm = new ContextMenu();
      MenuItem cmItem1 = new MenuItem( "Copy Image" );
      cmItem1.setOnAction( 
         ( ActionEvent e ) -> {
            Clipboard clipboard = Clipboard.getSystemClipboard(); // Represents OS clipboard, on which data may be placed during: cut, copy, and paste.
            ClipboardContent content = new ClipboardContent(); // Data container for Clipboard data. It can hold multiple data in several data formats.
            content.putImage( pic.getImage() );
            clipboard.setContent( content ); } );
      
      MenuItem cmItem2 = new MenuItem( "Save Image" );
      cmItem2.setOnAction( 
         ( ActionEvent e ) -> {
            FileChooser fileChooser1 = new FileChooser();
            fileChooser1.setTitle( "Save Image" );
            System.out.println( pic.getId() );
            File file = fileChooser1.showSaveDialog( stage );
            if( file != null ) {
               try { ImageIO.write( SwingFXUtils.fromFXImage( pic.getImage(), null ), "png", file ); }
               catch( IOException exc ) { System.out.println( exc.getMessage() ); } } } );
      
      //cm.getItems().add( cmItem1 ); // Add "Copy Image" menu item to the context menu.
      cm.getItems().addAll( cmItem1, cmItem2 ); // Add "Copy Image" and "Save Image" menu items to the context menu.

      // Enable context menu only on the picture!
      pic.addEventHandler( MouseEvent.MOUSE_CLICKED, 
                           ( MouseEvent e ) -> {
                              if( e.getButton() == MouseButton.SECONDARY ) { cm.show( pic, e.getScreenX(), e.getScreenY() ); } } );
      // Add the menu bar and the content (arranged in a vertical box layout) to the scene graph root node.
      ( (VBox) scene.getRoot() ).getChildren().addAll( menuBar, vbox );
      stage.setScene( scene );
      stage.show();
   }
   
   // Randomly select another picture updating: title, subtitle, and description.
   private void shuffle() {
      int i = currentIndex;
      while( i == currentIndex ) { i = (int) ( Math.random() * pages.length ); }
      pic.setImage( pages[i].image );
      name.setText( pages[i].name );
      binName.setText( "(" + pages[i].binNames + ")" );
      description.setText( pages[i].description );
      currentIndex = i;
   }
   
   // Configure a check menu item to link its selection to a scene graph node visibility.
   private static CheckMenuItem createMenuItem( String title, final Node node ) {
      CheckMenuItem cmi = new CheckMenuItem( title );
      cmi.setSelected( true );
      cmi.selectedProperty().addListener(
         ( ObservableValue<? extends Boolean > ov, Boolean old_val, Boolean new_val ) -> {
            node.setVisible( new_val ); } );
      return cmi;
   }
   
   // Class to store together the data of a page: title string, subtitle string, picture image, and description string.
   private class PageData {
      public String name;
      public String description;
      public String binNames;
      public Image image;
      public PageData( String name, String description, String binNames ) {
         this.name = name;
         this.description = description;
         this.binNames = binNames;
         image = new Image( name + ".jpg" );
      }
   }
}


