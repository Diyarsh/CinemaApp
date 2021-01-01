package app.address.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;


public class Movie {
    private final StringProperty title;
    private final StringProperty director;
    private final StringProperty producer;
    private final StringProperty releaseDate;
    private final SimpleDoubleProperty ticketPrice;
    private final StringProperty imgUrl;
    private final StringProperty movieDescription;
    private final Image movieImage;

    public Movie(String title, String director, String producer, String releaseDate, double ticketPrice, String imgUrl, String movieDescription, Image movieImage) {
        this.title = new SimpleStringProperty(title);
        this.director = new SimpleStringProperty(director);
        this.producer = new SimpleStringProperty(producer);
        this.releaseDate = new SimpleStringProperty(releaseDate);
        this.ticketPrice = new SimpleDoubleProperty(ticketPrice);
        this.imgUrl = new SimpleStringProperty(imgUrl);
        this.movieDescription = new SimpleStringProperty(movieDescription);
        this.movieImage = new Image(imgUrl);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDirector() {
        return director.get();
    }

    public String getProducer() {
        return producer.get();
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public double getTicketPrice() {
        return ticketPrice.get();
    }

    public Image getMovieImage() {
        return movieImage;
    }

    public String getMovieDescription() {
        return movieDescription.get();
    }
}