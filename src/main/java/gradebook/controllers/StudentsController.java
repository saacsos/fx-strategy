package gradebook.controllers;

import gradebook.fxcomponents.PrettyListView;
import gradebook.strategy.ScoreGreaterThanFiftySearcher;
import gradebook.strategy.ScoreGreaterThanSearcher;
import gradebook.strategy.Searcher;
import gradebook.models.Student;
import gradebook.models.StudentList;
import gradebook.services.StudentDataSource;
import gradebook.services.StudentHardcodeDataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class StudentsController {

    @FXML private Pane pane;
    @FXML private ChoiceBox<String> searchOptions;
    @FXML private Label searchLabel;
    @FXML private TextField searchText;

    private PrettyListView<Student> listView;
    private StudentDataSource dataSource;
    private StudentList studentList;

    private Searcher searcher;

    @FXML
    public void initialize() {
        dataSource = new StudentHardcodeDataSource();
        studentList = dataSource.getStudentsData();

        listView = new PrettyListView<>();
        listView.setMinWidth(332);


        updateListView(studentList.toList());

        pane.getChildren().add(listView);

        initSearchOption();
        optionClear();
    }

    private void initSearchOption() {
        String[] options = {
                "Score > 50",
                "Score greater than",
                "By Matched ID",
                "By Partial Name",
                "--Clear--"
        };

        for (int i = 0; i < options.length; i++) {
            searchOptions.getItems().add(options[i]);
        }

        searchOptions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            if (newValue.equals(options[0])) {
                optionScoreGreaterThanFifty();
            } else if (newValue.equals(options[1])) {
                optionScoreGreaterThan();
            } else if (newValue.equals(options[options.length - 1])) {
                optionClear();
            }
        });
    }

    private void optionScoreGreaterThanFifty() {
        searcher = new ScoreGreaterThanFiftySearcher();
        searchLabel.setText("Score Greater Than 50");
        searchText.setDisable(true);
    }

    private void optionScoreGreaterThan() {
        searcher = new ScoreGreaterThanSearcher();
        searchText.setDisable(false);
        searchLabel.setText("Score Greater Than ...");
        searchText.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                double threshold = Double.parseDouble(newValue);
                searchLabel.setText("Score Greater Than " + newValue);
                ((ScoreGreaterThanSearcher) searcher).setThreshold(threshold);
            } catch (NumberFormatException e) {
                searchLabel.setText("Score should be number format");
            }

        });

    }

    private void optionClear() {
        searchLabel.setText("Select from choice box");
        searchText.setDisable(true);
        searchText.clear();
        searcher = null;
    }

    private void updateListView(ArrayList<Student> list) {
        listView.getItems().clear();
        for (Student student: list) {
            listView.getItems().add(student);
        }
    }

    @FXML
    public void handleUpdateButton(ActionEvent event) {
        if (searcher != null) {
            updateListView(studentList.search(searcher));
        } else {
            updateListView(studentList.toList());
        }
    }
}
