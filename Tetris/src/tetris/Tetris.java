package tetris;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;


public class Tetris extends Application {
    public static boolean[][] isBlockFull = new boolean[10][24];
    public static final int block=25;
    public static final int xLimit=block*10;
    public static final int yLimit=block*24;    
    public static int finalscore=0;
    public static int score=0;
    public static ShapeType now ;
    public static ShapeType next ;
    public static Pane GroupAllRect = new Pane();
    public static Pane GroupNextRect = new Pane();
    public static int mins = 0;
    public static boolean stop = false;
    public static int full =0;
    public static StackPane rootPane = new StackPane();
    public static Scene startScene = new Scene(rootPane, xLimit+200, yLimit);
    public static boolean isContinue;
    public static boolean isNewRect = true;
    
    public static void main(String[] args) { launch(args);}
    @Override    
    public void start(Stage primaryStage) {        
        //Pane startPane = new Pane();           
        primaryStage.setTitle("Tetris");        
        Line line = new Line(xLimit, 0, xLimit, yLimit);        
        Line line2 = new Line(xLimit, 300, xLimit + 200, 300);        
        Text scoretext = new Text("Score: 0");
        Text timetext = new Text("Time: 0 s");
        scoretext.setY(350);
        scoretext.setX(xLimit + 25);
        timetext.setY(400);
        timetext.setX(xLimit + 25);
        GroupAllRect.getChildren().addAll(scoretext, timetext, line, line2); 
        ControlTetris Controler = new ControlTetris();
        next = Controler.Create();
        now = Controler.NEXT(next);
        isNewRect = true;
        next = Controler.Create();        
        GroupAllRect.getChildren().addAll(now.component1,now.component2,now.component3,now.component4);
        GroupNextRect.getChildren().addAll(next.component1,next.component2,next.component3,next.component4);
        rootPane.getChildren().addAll(GroupAllRect,GroupNextRect);
        //startScene = new Scene(GroupAllRect, xLimit+200, yLimit);        
        moveControl(now);
        startScene.getStylesheets().add(Tetris.class.getResource("Background.css").toExternalForm());
        
        primaryStage.setScene(startScene);
        primaryStage.show();
        
        ////////////////////
        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(isNewRect){
                            if (isGameOver()){
                                //System.out.println("loser");                                
                                full++;
                                }                                
                            else
                                isNewRect=false;
                        }
                        if(full==1){
                            finalscore = score;
                            primaryStage.hide();
                            Text gameOver = new Text("Game Over !");
                            gameOver.setFont(Font.font("Arial",60));
                            gameOver.setX(75);    gameOver.setY(200);
                            Text FscoreText = new Text("Total scores : "+finalscore);
                            FscoreText.setFont(Font.font ("Arial", 24));
                            FscoreText.setX(150);  FscoreText.setY(300);
                            Pane gameover = new Pane();
                            gameover.getChildren().addAll(FscoreText,gameOver);
                            Scene scene = new Scene(gameover,500,500);
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        }
                        if (full == 15) {
                            System.exit(0);
                        }
                        if (!stop) {
                            Controler.moveDown(now);
                        }
                        if(!stop)
                            score++;
                        scoretext.setText("Score: " + Integer.toString(score));
                    }
                });
            }
        };
        fall.schedule(task, 0, 800);      
        
        Timer time = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(!stop){
                            mins++;
                            timetext.setText("Time: " + Integer.toString(mins) + " s");
                            if (mins > 60) {
                                timetext.setText("Time: " + Integer.toString(mins / 60) + " min " + Integer.toString(mins % 60) + " s");
                            }
                        }
                    }
                });
            }
        };
        time.schedule(task2, 0, 1000);
    }    
    public static void moveControl(ShapeType st){
        ControlTetris Controler = new ControlTetris();
        startScene.setOnKeyPressed(new EventHandler<KeyEvent>(){ 
            @Override
            public void handle(KeyEvent event) {
                if(!stop)
                    switch (event.getCode()) {                       
                        case RIGHT:
                            Controler.moveRight(st);
                            break;
                        case DOWN:
                            Controler.moveDown(st);
                            break;
                        case LEFT:
                            Controler.moveLeft(st);
                            break;
                        case UP:
                            Controler.change(st);
                            break;
                        case Z:
                            stop = !stop;                            
                            break;
                        case SPACE:
                            Controler.FastDown(st);
                            break;
                    
                    }
                else
                    switch(event.getCode()){
                        case Z:
                            stop = !stop;                            
                            break;
                        default:
                            break;
                    }
            }
        });    
    }
    public static boolean isGameOver(){
        if(isBlockFull[(int) now.component1.getX() / block][(int) now.component1.getY() / block+1]
           ||isBlockFull[(int) now.component2.getX() / block][(int) now.component2.getY() / block+1]
           ||isBlockFull[(int) now.component3.getX() / block][(int) now.component3.getY() / block+1]
           ||isBlockFull[(int) now.component4.getX() / block][(int) now.component4.getY() / block+1]){
            return true;
        }
        return false;
    }
}
