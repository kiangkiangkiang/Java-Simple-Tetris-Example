package tetris;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class ShapeType {
    public Rectangle component1;
    public Rectangle component2;
    public Rectangle component3;
    public Rectangle component4;
    public String name="";
    public Color color=Color.WHITE;
    public int Type =1;
    public ShapeType(Rectangle component1,Rectangle component2,Rectangle component3,Rectangle component4){
        this.component1 = component1;
        this.component2 = component2;
        this.component3 = component3;
        this.component4 = component4;
    }
    public ShapeType(Rectangle component1,Rectangle component2,Rectangle component3,Rectangle component4,String name){
        this.component1 = component1;
        this.component2 = component2;
        this.component3 = component3;
        this.component4 = component4;
        this.name = name;        
        switch(name){
            case "L": this.color = Color.BLUE;  break;
            case "I": this.color = Color.RED;  break;
            case "S": this.color = Color.BROWN;  break;
            case "Z": this.color = Color.YELLOW;  break;
            case "J": this.color = Color.PURPLE;  break;
            case "O": this.color = Color.AQUA;  break;
            case "T": this.color = Color.GREEN;  break;
            default : this.color = Color.WHITE; break;                
        }
        this.component1.setFill(this.color);
        this.component2.setFill(this.color);
        this.component3.setFill(this.color);
        this.component4.setFill(this.color);
    }
    public void changeType(){
        if(this.Type != 4) this.Type++;
        else this.Type = 1;        
    }
}
