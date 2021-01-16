package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * clasa main a proiectului
 *
 * @author Lazar Sebastian
 */
public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);

    }
    public void start(Stage primaryStage) {

        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(this.getClass().getResource("/view/MainPage.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.setTitle("Tema2-IP-WeatherAPP");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
