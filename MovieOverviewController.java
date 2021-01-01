package app.address.view;

import app.address.model.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import app.address.MainApp;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;

public class MovieOverviewController {

    @FXML
    private TableView<Movie> movieTable;

    @FXML
    private TableColumn<Movie, String> movieNameColumn;

    @FXML
    private Label titleLabel;

    @FXML
    private Label directorLabel;

    @FXML
    private Label producerLabel;

    @FXML
    private Label releaseDateLabel;

    @FXML
    private Label ticketPriceLabel;

    // fakes are made to hide empty labels on start; other solution is to initialize them and set visibility to false
    // I decided to just cover them with other layer AnchorPane and Label
    @FXML
    private AnchorPane fakeWelcomeScreen;

    @FXML
    private Label fakeWelcomeMessage;

    @FXML
    private Label movieDescription;

    @FXML
    private ImageView movieImage;

    private MainApp mainApp;

    public MovieOverviewController() {}

    @FXML
    private void initialize() throws IOException {
        movieNameColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

        showMovieDetails(null);

        movieTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMovieDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        movieTable.setItems(mainApp.getMovies());
    }

    public void showMovieDetails(Movie movie) {

        if (movie != null) {
            titleLabel.setText(movie.getTitle());
            directorLabel.setText(movie.getDirector());
            producerLabel.setText(movie.getProducer());
            releaseDateLabel.setText(movie.getReleaseDate());
            ticketPriceLabel.setText(movie.getTicketPrice() + " EUR");
            movieImage.setImage(movie.getMovieImage());
            movieDescription.setText(movie.getMovieDescription());
            fakeWelcomeScreen.setVisible(false);
            fakeWelcomeMessage.setVisible(false);

        } else {
            titleLabel.setText("");
            directorLabel.setText("");
            producerLabel.setText("");
            releaseDateLabel.setText("");
            ticketPriceLabel.setText("");
            movieImage.setImage(null);
            movieDescription.setText("");
            fakeWelcomeScreen.setVisible(true);
            fakeWelcomeMessage.setVisible(true);
        }
    }

    @FXML
    private void handlePrintClicked() {
        Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();

        boolean printClicked = mainApp.showPrintTicketDialogWindow(selectedMovie);
        if (printClicked) {
            mainApp.showPrintTicketDialogWindow(selectedMovie);
            showMovieDetails(selectedMovie);
        }
    }
}


