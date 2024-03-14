package com.example.assignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private final String imageFolder = "images";
    private String css = getClass().getResource("style.css").toExternalForm().toString();
    private String[] imageRoots = {
            "/com/example/assignment/images/thumbnail1.jpg",
            "/com/example/assignment/images/thumbnail2.jpg",
            "/com/example/assignment/images/thumbnail3.jpg",
            "/com/example/assignment/images/thumbnail4.jpg",
            "/com/example/assignment/images/thumbnail5.jpg",
            "/com/example/assignment/images/thumbnail6.jpg",
            "/com/example/assignment/images/thumbnail7.jpg",
            "/com/example/assignment/images/thumbnail8.jpg"
    };
    private int currentIndex = 0;

    public void start(Stage stage)  {
        
        Label title =new Label("............................................................THUMBNAIL IMAGES..........................................................................");

        BorderPane pane=new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(15);
        gridPane.setPadding(new Insets(12));
        pane.setTop(title);
        pane.setCenter(gridPane);


        ImageView imageView1 = new ImageView(new Image(getClass().getResource(imageRoots[0]).toExternalForm()));
        imageView1.setFitWidth(180);
        imageView1.setFitHeight(150);
        imageView1.setOnMouseClicked(event -> display(imageRoots[0]));
        gridPane.add(imageView1, 0, 0);

        ImageView imageView2 = new ImageView(new Image(getClass().getResource(imageRoots[1]).toExternalForm()));
        imageView2.setFitWidth(180);
        imageView2.setFitHeight(150);
        imageView2.setOnMouseClicked(event -> display(imageRoots[1]));
        gridPane.add(imageView2, 1, 0);

        ImageView imageView3 = new ImageView(new Image(getClass().getResource(imageRoots[2]).toExternalForm()));
        imageView3.setFitWidth(180);
        imageView3.setFitHeight(150);
        imageView3.setOnMouseClicked(event -> display(imageRoots[2]));
        gridPane.add(imageView3, 2, 0);

        ImageView imageView4 = new ImageView(new Image(getClass().getResource(imageRoots[3]).toExternalForm()));
        imageView4.setFitWidth(180);
        imageView4.setFitHeight(150);
        imageView4.setOnMouseClicked(event -> display(imageRoots[3]));
        gridPane.add(imageView4, 3, 0);

        ImageView imageView5 = new ImageView(new Image(getClass().getResource(imageRoots[4]).toExternalForm()));
        imageView5.setFitWidth(180);
        imageView5.setFitHeight(150);
        imageView5.setOnMouseClicked(event -> display(imageRoots[4]));
        gridPane.add(imageView5, 0, 1);

        ImageView imageView6 = new ImageView(new Image(getClass().getResource(imageRoots[5]).toExternalForm()));
        imageView6.setFitWidth(180);
        imageView6.setFitHeight(150);
        imageView6.setOnMouseClicked(event -> display(imageRoots[5]));
        gridPane.add(imageView6, 1, 1);

        ImageView imageView7 = new ImageView(new Image(getClass().getResource(imageRoots[6]).toExternalForm()));
        imageView7.setFitWidth(180);
        imageView7.setFitHeight(150);
        imageView7.setOnMouseClicked(event -> display(imageRoots[6]));
        gridPane.add(imageView7, 2, 1);

        ImageView imageView8 = new ImageView(new Image(getClass().getResource(imageRoots[7]).toExternalForm()));
        imageView8.setFitWidth(180);
        imageView8.setFitHeight(150);
        imageView8.setOnMouseClicked(event -> display(imageRoots[7]));
        gridPane.add(imageView8, 3, 1);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> stage.close());

        pane.setBottom(exitButton);

        Scene scene = new Scene(pane,780,430);
        scene.getStylesheets().add(css);
        System.out.println(css);
        stage.setTitle("Thumbnail Image gallery");
        stage.setScene(scene);
        stage.show();

    }
    private void display(String imageRoot) {
        Stage fullImageStage = new Stage();
        ImageView newImage = new ImageView(new Image(getClass().getResource(imageRoot).toExternalForm()));
        newImage.setFitWidth(400);
        newImage.setFitHeight(300);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            currentIndex = (currentIndex - 1 + imageRoots.length) % imageRoots.length;
            newImage.setImage(new Image(getClass().getResource(imageRoots[currentIndex]).toExternalForm()));
        });

        Button nextButton = new Button("Next");
        nextButton.setOnAction(event -> {
            currentIndex = (currentIndex + 1) % imageRoots.length;
            newImage.setImage(new Image(getClass().getResource(imageRoots[currentIndex]).toExternalForm()));
        });

        Button thumbnailButton = new Button("Thumbnail Images");
        thumbnailButton.setOnAction(event -> {
            fullImageStage.close();
            start(new Stage());
        });


        HBox hbox = new HBox(10);
        hbox.getChildren().addAll( backButton, nextButton, thumbnailButton);
        hbox.setPadding(new Insets(10));

        VBox vBox=new VBox();
        vBox.getChildren().addAll(newImage,hbox);

        Scene fullImageScene = new Scene(vBox);
        fullImageScene.getStylesheets().add(css);
        fullImageStage.setScene(fullImageScene);
        fullImageStage.setTitle("Full Image View");
        fullImageStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}