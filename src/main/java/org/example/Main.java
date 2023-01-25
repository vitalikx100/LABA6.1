package org.example;

import org.example.functions.InappropriateFunctionPointException;
import org.example.GI.FXMLMainFormController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import org.example.GI.*;
import org.example.GI.TabulatedFunctionDoc;

public class Main extends Application{
    public static TabulatedFunctionDoc tabFDoc;

    public static void main(String[] args) throws InappropriateFunctionPointException, IndexOutOfBoundsException, IOException, ClassNotFoundException, CloneNotSupportedException {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        tabFDoc = new TabulatedFunctionDoc();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GI/FXMLMainForm.fxml"));
        Parent root = loader.load();
        FXMLMainFormController ctrl = loader.getController();
        ctrl.setStage(stage);
        tabFDoc.registerRedrawFunctionController(ctrl);
        Scene scene = new Scene(root);
        stage.setTitle("Tabulated function");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
