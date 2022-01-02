package UserInterface;

import CustomClasses.TableViewElement;
import MainPackage.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Utils.FolderListenerUtilities;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class RunRaceController implements Initializable {

    private Thread t;
    AtomicBoolean running = new AtomicBoolean(false);

    @FXML
    Button startBtn;

    @FXML
    Button finishBtn;

    @FXML
    TableColumn<TableViewElement,String> column1;

    @FXML
    TableColumn<TableViewElement,String> column2;

    @FXML
    TableView<TableViewElement> wholeView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Label placeholderLabel = new Label("Click \"Start\" to start ");
        placeholderLabel.setStyle("-fx-text-fill: white;");
        wholeView.setPlaceholder(placeholderLabel);
        column1.setSortable(false);
        column2.setSortable(false);
        wholeView.setEditable(false);
        column1.setReorderable(false);
        column2.setReorderable(false);
        wholeView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        finishBtn.setDisable(true);
        column1.setCellValueFactory(new PropertyValueFactory<>("raceName"));
        column2.setCellValueFactory(new PropertyValueFactory<>("finish"));
        column1.prefWidthProperty().bind(wholeView.widthProperty().divide(2));
        column2.prefWidthProperty().bind(wholeView.widthProperty().divide(2));



        t = new Thread(){
            @Override
            public void run() {
                running.set(true);
                while(running.get()) {
                    String pathName = FolderListenerUtilities.newFileCreated(Main.listenerPath, running);
                    wholeView.getItems().add(new TableViewElement(pathName.substring(pathName.lastIndexOf("\\")+1)));
                }

            }
        };
    }
    @FXML
    private void clickStart () {
        startBtn.setDisable(true);
        finishBtn.setDisable(false);
        t.setDaemon(true);
        t.start();

    }


    @FXML
    private void clickFinish () {
        running.set(false);
        //
        finishBtn.setDisable(true);
        startBtn.setDisable(false);
    }

}
