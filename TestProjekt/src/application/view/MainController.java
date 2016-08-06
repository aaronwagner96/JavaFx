package application.view;

import application.Main;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class MainController {

    @FXML
    private Button btn_fakeProgress;
    
    @FXML
    private ProgressBar progressBar;
    
    @FXML
    private DatePicker datePicker;
    
    @FXML
    private TextField tf_datePicker;
    
    @FXML
    private ProgressIndicator progressIndicator;
    
    @FXML
    private ToggleButton btn_toggleProgress;
    
    @FXML
    private Slider slider;

    // Reference to the main application.
    private Main mainApp;

    public MainController() {}

    @FXML
    private void initialize() {
    	
    }

    // Methoden
    
    @FXML
    private void startFakeProgress() {
    	progressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
    }
    
    @FXML
    private void setDatePickerDate() {
    	tf_datePicker.setText(datePicker.getValue().toString());
    }
    
    @FXML
    private void toggleProgress() {
    	progressIndicator.setProgress(progressIndicator.isIndeterminate() ? 0 : ProgressBar.INDETERMINATE_PROGRESS);
    }
    
    @FXML
    private void slideProgress() {
    	progressIndicator.setProgress(slider.getValue());
    }
    
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
//        personTable.setItems(mainApp.getPersonData());
    }
}