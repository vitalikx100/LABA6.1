package org.example.GI;

import org.example.functions.FunctionPoint;
import org.example.functions.InappropriateFunctionPointException;
import org.example.Main;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLMainFormController {
    private Stage stage;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    private TextField edX;

    @FXML
    private TextField edY;

    @FXML
    private Label numberPointLabel;

    @FXML
    private TableView<FunctionPoint> table;

    @FXML
    private TableColumn<FunctionPoint, Double> columnX;

    @FXML
    private TableColumn<FunctionPoint, Double> columnY;

    @FXML
    private void initialize(){
        columnX = new TableColumn<FunctionPoint, Double>("X value");
        columnY = new TableColumn<FunctionPoint, Double>("Y value");

        columnX.setCellValueFactory(new PropertyValueFactory<FunctionPoint, Double>("x"));
        columnY.setCellValueFactory(new PropertyValueFactory<FunctionPoint, Double>("y"));

        table.getColumns().add(columnX);
        table.getColumns().add(columnY);

        redraw();
    }

    @FXML
    public void redraw(){
        ObservableList<FunctionPoint> data = table.getItems();
        data.clear();
        for(int i = 0; i < Main.tabFDoc.getNumberOfPoints(); ++i) {
            data.add(new FunctionPoint(Main.tabFDoc.getPointX(i), Main.tabFDoc.getPointY(i)));
        }
        table.setItems(data);
        updatePointCount();
    }

    @FXML
    private void btnClickNewPoint(ActionEvent av) throws InappropriateFunctionPointException {
        try {
            Main.tabFDoc.addPoint(new FunctionPoint(Double.parseDouble(edX.getText()), Double.parseDouble(edY.getText())));
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to add this point!");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnClickDeletePoint(ActionEvent av) {
        try {
            Main.tabFDoc.deletePoint(table.getSelectionModel().getSelectedIndex());
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to delete this point!");
            alert.showAndWait();
        }
    }

    @FXML
    private void mouseReleasedOnTable(){
        updatePointCount();
    }

    @FXML
    private void keyReleasedOnTable(){
        updatePointCount();
    }

    @FXML
    private void  btnNewFile() throws Exception {
        ActionsDialogWindow wind = new ActionsDialogWindow();
        FXMLDialogWindow.BUTTON lstBtn = wind.showDialog(stage);
    }

    private void updatePointCount() {
        numberPointLabel.setText("Point " + Integer.toString(table.getSelectionModel().getSelectedIndex() + 1) + " of " + Integer.toString(Main.tabFDoc.getNumberOfPoints()));
    }


}
