package app.address;

import app.address.model.Movie;
import app.address.view.MovieOverviewController;
import app.address.view.PrintTicketDialogWindowController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public Stage primaryStage;
    public BorderPane rootLayout;

    private ObservableList<Movie> movies = FXCollections.observableArrayList();

    public MainApp() {

        // probably redundant work creating urls
        String boratTwoUrl = "pics/borat2.jpg";
        String mulanUrl = "pics/mulan.jpg";
        String totallyUrl = "pics/totally.jpg";
        String fortyUrl = "pics/forty.jpg";
        String socialUrl = "pics/social.jpg";
        String paramedicUrl = "pics/paramedic.jpg";
        String spencerUrl = "pics/spenser.jpg";

        Image boratTwoImage = new Image(boratTwoUrl);
        Image mulanImage = new Image(mulanUrl);
        Image totallyImage = new Image(totallyUrl);
        Image fortyImage = new Image(fortyUrl);
        Image socialImage = new Image(socialUrl);
        Image paramedicImage = new Image(paramedicUrl);
        Image spencerImage = new Image(spencerUrl);

        String boratTwoDescription = "Follow-up film to the 2006 comedy centering on the real-life adventures of a fictional Kazakh television journalist named Borat.";
        String mulanDescription = "To save her father from death in the army, a young maiden secretly goes in his place and becomes one of China's greatest heroines in the process.";
        String totallyDescription = "An in-depth look at how the United States government handled the response to the COVID-19 outbreak during the early months of the pandemic.";
        String fortyDescription = "Radha is a down-on-her-luck NY playwright, who is desperate for a breakthrough before 40. She vacillates between the worlds of Hip Hop and theater in order to find her true voice.";
        String socialDescription = "Explores the dangerous human impact of social networking, with tech experts sounding the alarm on their own creations.";
        String paramedicDescription = "Angel works in an ambulance service. After a tragic accident, his personal life begins to deteriorate as he becomes more and more suspicious of his partner Vane.";
        String spenserDescription = "When two Boston police officers are murdered, ex-cop Spenser teams up with his no-nonsense roommate, Hawk, to take down criminals.";

        Movie boratTwo = new Movie("Borat 2", "Jason Woliner", "Sacha Baron Cohen", "October 23, 2020", 10.5, boratTwoUrl, boratTwoDescription, boratTwoImage);
        Movie mulan = new Movie("Mulan", "Niki Caro", "Chris Bender", "March 9, 2020", 9.75, mulanUrl, mulanDescription, mulanImage);
        Movie totallyUnderControl = new Movie("Totally Under Control", "Alex Gibney", "Alex Gibney", "October 13, 2020", 8, totallyUrl, totallyDescription, totallyImage);
        Movie fortyYearOld = new Movie("The 40-Year-Old Version", "Radha Blank", "Lena Waithe", "January 25, 2020", 11.5, fortyUrl, fortyDescription, fortyImage);
        Movie socialDilemma = new Movie("The Social Dilemma", "Jeff Orlowski", "Larissa Rhodes", "January 26, 2020", 8.9, socialUrl, socialDescription, socialImage);
        Movie paramedic = new Movie("The Paramedic", "Carles Torras", "Rebeca Arnal", "September 16, 2020", 9.5, paramedicUrl, paramedicDescription, paramedicImage);
        Movie spenser = new Movie("Spenser Confidential", "Peter Berg", "Neal H. Moritz", "March 6, 2020", 9.9, spencerUrl, spenserDescription, spencerImage);

        movies.addAll(boratTwo, mulan, totallyUnderControl, fortyYearOld, socialDilemma, paramedic, spenser);
    }

    // return movie list
    public ObservableList<Movie> getMovies(){
        return movies;
    }

    // creating Stage and Scene, first encloses scene
    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CinemaApp");
        this.primaryStage.setResizable(false);
        this.primaryStage.setHeight(600);

        initRootLayout();
        showMovieOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // putting Scene inside Stage
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMovieOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MovieOverview.fxml"));
            BorderPane movieOverview = loader.load();

            rootLayout.setCenter(movieOverview);

            // including controller
            MovieOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPrintTicketDialogWindow(Movie movie) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PrintTicketDialogWindow.fxml"));
            DialogPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ticket information");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PrintTicketDialogWindowController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMovie(movie);

            dialogStage.showAndWait();

            return controller.isPrintclicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // MainApp launch
    public static void main(String[] args) {
        launch(args);
    }
}
