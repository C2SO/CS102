


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ScrollBarSample extends Application {
 
    final ScrollBar sc = new ScrollBar();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    DropShadow shadow = new DropShadow();
 
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 300+30, 428); // Image size: width 300, height 428.
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Scrollbar");
        root.getChildren().addAll(vb, sc);
 
        shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
 
        vb.setLayoutX(5);
        vb.setSpacing(10);
 
        sc.setLayoutX(scene.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        //sc.setPrefHeight(180);
        sc.setPrefHeight(428);
        //sc.setMax(360);
        sc.setMax(428*(5-1));
 
        for (int i = 0; i < 5; i++) {
            final Image image = images[i] =
                //new Image( getClass().getResourceAsStream( "fw" + (i+1) + ".jpg" ) ); // TURINI
                new Image( getClass().getResourceAsStream( (i+1) + ".jpg" ) ); // TURINI
            final ImageView pic = pics[i] =
                new ImageView(images[i]);
            pic.setEffect(shadow);
            vb.getChildren().add(pics[i]);
        }
 
        sc.valueProperty().addListener((ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) -> {
                vb.setLayoutY(-new_val.doubleValue());
        });  
 
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}

