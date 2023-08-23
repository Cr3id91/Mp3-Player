import javafx.application.Application;
import javafx.event.ActionEvent; //Gives buttons actions
import javafx.scene.Scene; //Sets up a scene to show buttons
import javafx.scene.control.Label;
import javafx.scene.image.Image; //Import image from a file
import javafx.scene.image.ImageView; //The imported image is shown
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser; //Choose a file to open
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer; //Allows songs to be played
import javafx.scene.media.Media; //Also allows songs to be played
import javafx.scene.control.Button; //Allows user to have control of buttons
import java.io.File;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.util.Duration; //The time the fast forward and rewind buttons go

import static javafx.geometry.Pos.CENTER;

public class Music_Player_FinalProject_CST240_150_CR extends Application
{

    File file = new File("C:\\Users\\caleb\\IdeaProjects\\Java2.0");

    public static void main(String[]args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        final Label labelFile = new Label();

        File songFile[] = new File[10]; //An a array that holds all the songs and pulls downloaded songs from file they're in
        songFile[0] = new File("JustFriends.mp3");
        songFile[1] = new File("AllOfMyLove.mp3");
        songFile[2] = new File("Can'tLetGo.mp3");
        songFile[3] = new File("LadiesNight.mp3");
        songFile[4] = new File("Amen.mp3");
        songFile[5] = new File("Love.mp3");
        songFile[6] = new File("TheTruth.mp3");
        songFile[7] = new File("UKnowWhat'sUp.mp3");
        songFile[8] = new File("Walking.mp3");
        songFile[9] = new File("URemindMe.mp3");

        final Media[] media = {new Media(songFile[5].toURI().toString())}; //Songs from songFile are pulled from file and set to play
        final MediaPlayer[] player = {new MediaPlayer(media[0])};



        Button playButton = new Button("Play"); //PLay button created
        Button pauseButton = new Button("Pause"); //Pause button created
        Button stopButton = new Button("Stop"); //Stop button created
        Button FastForwardButton = new Button("Fast Forward"); //Fast forward button created
        Button RewindButton = new Button("Rewind"); //Rewind button created
        Button selector = new Button("Song Selector"); //Select song button created


        selector.setOnAction((ActionEvent e) ->{ //Select song button directs you to where songs are held
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:/Users/caleb/IdeaProjects/Java2.0")); //Opens file where songs are held
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.mp3", "*.mp3"));
            File file = fc.showOpenDialog(null);
            String path = file.getAbsolutePath();
            path = path.replace("\\", "/");
            media[0] = new Media(new File(path).toURI().toString());
            player[0] = new MediaPlayer(media[0]);

            labelFile.setText("Playing" + " " + file.getName());
            primaryStage.setTitle(labelFile.getText());
                });



        Image Play = new Image("file:playbutton2.png"); //Play button image is pulled from file and placed on play button
        ImageView playV = new ImageView(Play);
        playV.setFitHeight(15);
        playV.setPreserveRatio(true);
        playButton.setPrefSize(15,15);
        playButton.setGraphic(playV);

        Image Pause = new Image("file:pausebutton.png"); //Pause button image is pulled from file and placed on pause  button
        ImageView pauseV = new ImageView(Pause);
        pauseV.setFitHeight(15);
        pauseV.setPreserveRatio(true);
        pauseButton.setPrefSize(15,15);
        pauseButton.setGraphic(pauseV);

        Image Stop = new Image("file:stopbutton.png"); //Stop button image is pulled from file and placed on stop button
        ImageView stopV = new ImageView(Stop);
        stopV.setFitHeight(15);
        stopV.setPreserveRatio(true);
        stopButton.setPrefSize(15,15);
        stopButton.setGraphic(stopV);

        Image FastForward = new Image("file:fastforward.png"); //Fast forward button image is pulled from file and placed on fast forward button
        ImageView fastforwardV = new ImageView(FastForward);
        fastforwardV.setFitHeight(15);
        fastforwardV.setPreserveRatio(true);
        FastForwardButton.setPrefSize(15,15);
        FastForwardButton.setGraphic(fastforwardV);

        Image Rewind = new Image("file:rewindbutton.png"); //Rewind button image is pulled from file and placed on rewind button
        ImageView rewindV = new ImageView(Rewind);
        rewindV.setFitHeight(21);
        rewindV.setPreserveRatio(true);
        RewindButton.setPrefSize(15,15);
        RewindButton.setGraphic(rewindV);


        playButton.setOnAction(event ->
        {
            player[0].play(); //Gives the play button the action to play song
        });

        pauseButton.setOnAction(event ->
        {
            player[0].pause(); //Gives the pause button the action to pause song
        });

        stopButton.setOnAction(event ->
        {
            player[0].stop(); //Gives the stop button the action to stop song
        });

        RewindButton.setOnAction(event ->
        {
            double rw = player[0].getCurrentTime().toSeconds(); //Gives the rewind button the ability to rewind a song
            rw = rw - 15; //Gives rewind button the ability to rewind a song 15 seconds
            player[0].seek(new Duration(rw*1000));
        });

        FastForwardButton.setOnAction(event ->
        {
            double ff = player[0].getCurrentTime().toSeconds(); //Gives the fast forward button the ability to fast forward a song
            ff = ff + 15; //Gives fast forward button the ability to fast forward a song 15 seconds
            player[0].seek(new Duration(ff*1000));
        });
        //HBox is made to hold all the buttons
        HBox hbox = new HBox(10,playButton,pauseButton,stopButton,FastForwardButton,RewindButton,selector);
        hbox.setAlignment(CENTER); //Button are placed in center of HBox
        hbox.setPadding(new Insets(10));


        Scene scene = new Scene(hbox); //Displays HBox along with buttons
        primaryStage.setScene(scene);
        primaryStage.show(); //Displays everything above

    }
}

/*
Caleb Reid
11/29/2020
Java Programming(Final Project)
CST 240
 */