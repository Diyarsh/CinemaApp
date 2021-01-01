package app.address.view;

import app.address.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PrintTicketDialogWindowController {

    int min = 1;
    int max = 100;
    int random_seat = (int) (Math.random() * (max - min + 1) + min);
    private int someSeat = random_seat;

    @FXML
    private Label titleLabel;

    @FXML
    private Label seatNumber;

    @FXML
    private Label timeLabel;

    private Stage dialogStage;
    private boolean printClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMovie(Movie movie) {

        titleLabel.setText(movie.getTitle());
        seatNumber.setText(String.valueOf(someSeat));
        timeLabel.setText("18:35"); // clarify meaning of this field "time"
    }

    public boolean isPrintclicked() {
        return printClicked;
    }

    public PrintTicketDialogWindowController() {}
}
