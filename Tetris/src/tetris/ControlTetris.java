package tetris;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class ControlTetris {

    public static int xLimit = Tetris.xLimit;
    public static int yLimit = Tetris.yLimit;
    public static int block = Tetris.block;
    public static boolean[][] isBlockFull = Tetris.isBlockFull;
    public static ShapeType next = Tetris.next;
    public static ShapeType now = Tetris.now;
    public static Pane GroupAllRect = Tetris.GroupAllRect;

    public static ShapeType Create() {
        Rectangle component1 = new Rectangle(block, block);
        Rectangle component2 = new Rectangle(block, block);
        Rectangle component3 = new Rectangle(block, block);
        Rectangle component4 = new Rectangle(block, block);
        int random = (int) (Math.random() * 49);
        if (random < 7) {//I
            component1.setX(xLimit + 100 - block);
            component2.setX(xLimit + 100);
            component3.setX(xLimit + 100 + block);
            component4.setX(xLimit + 100 + block+block);
            return new ShapeType(component1, component2, component3, component4, "I");
        } else if (random >= 7 && random < 14) {//L
            component1.setX(xLimit + 100);
            component2.setX(xLimit + 100);
            component2.setY(block);
            component3.setX(xLimit + 100 - block);
            component3.setY(block);
            component4.setX(xLimit + 100 - block - block);
            component4.setY(block);
            return new ShapeType(component1, component2, component3, component4, "L");
        } else if (random >= 14 && random < 21) {//J
            component1.setX(xLimit + 100);
            component2.setX(xLimit + 100);
            component2.setY(block);
            component3.setX(xLimit + 100 + block);
            component3.setY(block);
            component4.setX(xLimit + 100 + block + block);
            component4.setY(block);
            return new ShapeType(component1, component2, component3, component4, "J");
        } else if (random >= 21 && random < 28) {//O
            component1.setX(xLimit + 100);
            component2.setX(xLimit + 100);
            component2.setY(block);
            component3.setX(xLimit + 100 + block);
            component4.setX(xLimit + 100 + block);
            component4.setY(block);
            return new ShapeType(component1, component2, component3, component4, "O");
        } else if (random >= 28 && random < 35) {//T
            component1.setX(xLimit + 100);
            component2.setX(xLimit + 100 + block);
            component2.setY(block);
            component3.setX(xLimit + 100 - block);
            component3.setY(block);
            component4.setX(xLimit + 100);
            component4.setY(block);
            return new ShapeType(component1, component2, component3, component4, "T");
        } else if (random >= 35 && random < 42) {//Z
            component1.setX(xLimit + 100);
            component2.setX(xLimit + 100 - block);
            component3.setX(xLimit + 100);
            component3.setY(block);
            component4.setX(xLimit + 100 + block);
            component4.setY(block);
            return new ShapeType(component1, component2, component3, component4, "Z");
        } else {//S
            component1.setX(xLimit + 100);
            component2.setX(xLimit + 100 + block);
            component3.setX(xLimit + 100);
            component3.setY(block);
            component4.setX(xLimit + 100 - block);
            component4.setY(block);
            return new ShapeType(component1, component2, component3, component4, "S");
        }
    }

    public static ShapeType NEXT(ShapeType st) {
        switch (st.name) {
            case "S":
                st.component1.setX(xLimit / 2);
                st.component2.setX(xLimit / 2 + block);
                st.component3.setX(xLimit / 2); st.component3.setY(block);
                st.component4.setX(xLimit / 2 - block); st.component4.setY(block);
                break;
            case "Z":
                st.component1.setX(xLimit / 2);
                st.component2.setX(xLimit / 2 - block);
                st.component3.setX(xLimit / 2); st.component3.setY(block);
                st.component4.setX(xLimit / 2 + block); st.component4.setY(block);
                break;
            case "T":
                st.component1.setX(xLimit / 2);
                st.component2.setX(xLimit / 2 + block);  st.component2.setY(block);
                st.component3.setX(xLimit / 2 - block); st.component3.setY(block);
                st.component4.setX(xLimit / 2); st.component4.setY(block);
                break;
            case "O":
                st.component1.setX(xLimit /2);
                st.component2.setX(xLimit /2); st.component2.setY(block);
                st.component3.setX(xLimit/2 + block);
                st.component4.setX(xLimit /2 + block); st.component4.setY(block);
                break;
            case "J":
                st.component1.setX(xLimit/2);
                st.component2.setX(xLimit /2);st.component2.setY(block);
                st.component3.setX(xLimit /2 + block);  st.component3.setY(block);
                st.component4.setX(xLimit /2 + block + block); st.component4.setY(block);
                break;
            case "L":
                st.component1.setX(xLimit /2);
                st.component2.setX(xLimit /2);  st.component2.setY(block);
                st.component3.setX(xLimit /2 - block);  st.component3.setY(block);
                st.component4.setX(xLimit /2 - block - block);  st.component4.setY(block);
                break;
            case "I":
                st.component1.setX(xLimit /2 - block);
                st.component2.setX(xLimit /2);
                st.component3.setX(xLimit /2 + block);
                st.component4.setX(xLimit /2+ block+block);
        }
        return st;
    }
    
    public static void moveRight (ShapeType st){
        ////dif
        if(st.component1.getX() + block <= xLimit -block && 
           st.component2.getX() + block <= xLimit -block&&
           st.component3.getX() + block <= xLimit -block&&
           st.component4.getX() + block <= xLimit-block){
              boolean a = isBlockFull[(int)st.component1.getX()/block+1][(int)st.component1.getY()/block];
              boolean b = isBlockFull[(int)st.component2.getX()/block+1][(int)st.component2.getY()/block];
              boolean c = isBlockFull[(int)st.component3.getX()/block+1][(int)st.component3.getY()/block];
              boolean d = isBlockFull[(int)st.component4.getX()/block+1][(int)st.component4.getY()/block];
              if(!a&&!b&&!c&&!d){
                  st.component1.setX(st.component1.getX()+block);
                  st.component2.setX(st.component2.getX()+block);
                  st.component3.setX(st.component3.getX()+block);
                  st.component4.setX(st.component4.getX()+block);
              }
        }
    }
    public static void moveLeft (ShapeType st){
        if(st.component1.getX() - block >= 0 && 
           st.component2.getX() - block >= 0 &&
           st.component3.getX() - block >= 0 &&
           st.component4.getX() - block >= 0){
              boolean a = isBlockFull[(int)st.component1.getX()/block-1][(int)st.component1.getY()/block];
              boolean b = isBlockFull[(int)st.component2.getX()/block-1][(int)st.component2.getY()/block];
              boolean c = isBlockFull[(int)st.component3.getX()/block-1][(int)st.component3.getY()/block];
              boolean d = isBlockFull[(int)st.component4.getX()/block-1][(int)st.component4.getY()/block];
              if(!a&&!b&&!c&&!d){
                  st.component1.setX(st.component1.getX()-block);
                  st.component2.setX(st.component2.getX()-block);
                  st.component3.setX(st.component3.getX()-block);
                  st.component4.setX(st.component4.getX()-block);
              }
        }
    }
    public static void moveDown (ShapeType st){
        if (st.component1.getY() == yLimit-block||
            st.component2.getY() == yLimit-block ||
            st.component3.getY() == yLimit-block||
            st.component4.getY() == yLimit-block ||
            isBlockFull[(int) st.component1.getX() / block][((int) st.component1.getY() / block)+1]
            ||isBlockFull[(int) st.component2.getX() / block][((int) st.component2.getY() / block)+1]
            ||isBlockFull[(int) st.component3.getX() / block][((int) st.component3.getY() / block)+1]
            ||isBlockFull[(int) st.component4.getX() / block][((int) st.component4.getY() / block)+1]) 
        {            
            isBlockFull[(int) st.component1.getX() / block][(int) st.component1.getY() / block] = true;
            isBlockFull[(int) st.component2.getX() / block][(int) st.component2.getY() / block] = true;
            isBlockFull[(int) st.component3.getX() / block][(int) st.component3.getY() / block] = true;
            isBlockFull[(int) st.component4.getX() / block][(int) st.component4.getY() / block] = true;
            checkDelete(GroupAllRect);            
            Tetris.now = NEXT(Tetris.next);
            Tetris.next = Create();
            Tetris.isNewRect = true;
            Tetris.GroupAllRect.getChildren().addAll(Tetris.now.component1,Tetris.now.component2,Tetris.now.component3,Tetris.now.component4);
            Tetris.GroupNextRect.getChildren().addAll(Tetris.next.component1,Tetris.next.component2,Tetris.next.component3,Tetris.next.component4);
            //Tetris.rootPane.getChildren().addAll(Tetris.GroupAllRect,Tetris.GroupNextRect);
            
            Tetris.moveControl(Tetris.now);            
        }
        if(st.component1.getY()+block<yLimit&&st.component2.getY()+block<yLimit&&st.component3.getY()+block<yLimit&&st.component4.getY()+block<yLimit){
            if (!isBlockFull[(int)st.component1.getX()/block][(int)st.component1.getY()/block+1]
               &&!isBlockFull[(int)st.component2.getX()/block][(int)st.component2.getY()/block+1]
               &&!isBlockFull[(int)st.component3.getX()/block][(int)st.component3.getY()/block+1]
               &&!isBlockFull[(int)st.component4.getX()/block][(int)st.component4.getY()/block+1]) {
                st.component1.setY(st.component1.getY()+block);
                st.component2.setY(st.component2.getY()+block);
                st.component3.setY(st.component3.getY()+block);
                st.component4.setY(st.component4.getY()+block);            
            }
        }
    }
    public static void checkDelete(Pane groupComponent){
        ArrayList<Integer> FulledLine = new ArrayList<>();
        for(int i=0,full;i<isBlockFull[0].length;i++){
            full=0;
            for(int u=0;u<isBlockFull.length;u++){
                if(isBlockFull[u][i]){
                    full++;
                }
            }            
            if(full==isBlockFull.length){
                FulledLine.add(i);
            }
        }        
        ArrayList<Node> RemovedRects = new ArrayList<>();
        ArrayList<Node> RemainedRects = new ArrayList<>();
        while(FulledLine.size()>0){
            for (Node node : groupComponent.getChildren()) {
                if (node instanceof Rectangle) {
                    RemovedRects.add(node);
                }
            }
            for(Node node :RemovedRects){
                Rectangle temp = (Rectangle) node;
                if(temp.getY()==FulledLine.get(0)*block){
                    isBlockFull[(int) temp.getX() / block][(int) temp.getY() / block] = false;
                    groupComponent.getChildren().remove(node);
                    } 
                else  
                    RemainedRects.add(node);                    
            }

            for(Node node : RemainedRects){
                Rectangle temp = (Rectangle) node;
                if(temp.getY()<FulledLine.get(0)*block){
                    isBlockFull[(int) temp.getX() / block][(int) temp.getY() / block] = false;
                    temp.setY(temp.getY()+block);
                }
            }
            FulledLine.remove(0);
            RemovedRects.clear();
            RemainedRects.clear();
            ArrayList<Node> AfterRemove = new ArrayList<>();
            for (Node node : groupComponent.getChildren()) 
                if (node instanceof Rectangle) 
                    AfterRemove.add(node);                
            
            for (Node node : AfterRemove) {
                Rectangle temp = (Rectangle) node;
                //try {
                isBlockFull[(int) temp.getX() / block][(int) temp.getY() / block] = true;
               // } catch (ArrayIndexOutOfBoundsException e) {
                //    System.out.println(e);
                //}
            }
            AfterRemove.clear();
            Tetris.score+=15;
        }   
    }
    public static void change(ShapeType st){
        switch(st.name){
            case "O": break;
            case "I":
                if(st.Type==1&&check(st.component1,1,1)&&check(st.component3,-1,-1)&&check(st.component4,-2,-2)){
                    changeRectRight(st.component1);
                    changeRectUp(st.component1);
                    changeRectLeft(st.component3);
                    changeRectDown(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==2&&check(st.component1,1,-1)&&check(st.component3,-1,1)&&check(st.component4,-2,2)){
                    changeRectRight(st.component1);
                    changeRectDown(st.component1);
                    changeRectLeft(st.component3);
                    changeRectUp(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==3&&check(st.component1,-1,-1)&&check(st.component3,1,1)&&check(st.component4,2,2)){
                    changeRectLeft(st.component1);
                    changeRectDown(st.component1);
                    changeRectRight(st.component3);
                    changeRectUp(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==4&&check(st.component1,-1,1)&&check(st.component3,1,-1)&&check(st.component4,2,-2)){
                    changeRectLeft(st.component1);
                    changeRectUp(st.component1);
                    changeRectRight(st.component3);
                    changeRectDown(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);
                    st.changeType();
                    break;
                }
                break;
            case "L":
                if(st.Type==1&&check(st.component1,1,-1)&&check(st.component3,1,1)&&check(st.component4,2,2)){
                    changeRectRight(st.component1);
                    changeRectDown(st.component1);
                    changeRectRight(st.component3);
                    changeRectUp(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==2&&check(st.component1,-1,-1)&&check(st.component3,1,-1)&&check(st.component4,2,-2)){
                    changeRectLeft(st.component1);
                    changeRectDown(st.component1);
                    changeRectRight(st.component3);
                    changeRectDown(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==3&&check(st.component1,-1,1)&&check(st.component3,-1,-1)&&check(st.component4,-2,-2)){
                    changeRectLeft(st.component1);
                    changeRectUp(st.component1);
                    changeRectLeft(st.component3);
                    changeRectDown(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==4&&check(st.component1,1,1)&&check(st.component3,-1,1)&&check(st.component4,-2,2)){
                    changeRectRight(st.component1);
                    changeRectUp(st.component1);
                    changeRectLeft(st.component3);
                    changeRectUp(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);
                    st.changeType();
                    break;
                }
                break;
            case "J":
                if(st.Type==1&&check(st.component1,1,-1)&&check(st.component3,-1,-1)&&check(st.component4,-2,-2)){
                    changeRectRight(st.component1);
                    changeRectDown(st.component1);
                    changeRectLeft(st.component3);
                    changeRectDown(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==2&&check(st.component1,-1,-1)&&check(st.component3,-1,1)&&check(st.component4,-2,2)){
                    changeRectLeft(st.component1);
                    changeRectDown(st.component1);
                    changeRectLeft(st.component3);
                    changeRectUp(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==3&&check(st.component1,-1,1)&&check(st.component3,1,1)&&check(st.component4,2,2)){
                    changeRectLeft(st.component1);
                    changeRectUp(st.component1);
                    changeRectRight(st.component3);
                    changeRectUp(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);
                    st.changeType();
                    break;
                }
                if(st.Type==4&&check(st.component1,1,1)&&check(st.component3,1,-1)&&check(st.component4,2,-2)){
                    changeRectRight(st.component1);
                    changeRectUp(st.component1);
                    changeRectRight(st.component3);
                    changeRectDown(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);
                    st.changeType();
                    break;
                }
                break;
            case "T":
                if(st.Type==1&&check(st.component1,1,-1)&&check(st.component3,1,1)&&check(st.component2,-1,-1)){
                    changeRectRight(st.component1);
                    changeRectDown(st.component1);
                    changeRectRight(st.component3);
                    changeRectUp(st.component3);
                    changeRectLeft(st.component2);
                    changeRectDown(st.component2);                    
                    st.changeType();
                    break;
                }
                if(st.Type==2&&check(st.component1,-1,-1)&&check(st.component3,1,-1)&&check(st.component2,-1,1)){
                    changeRectLeft(st.component1);
                    changeRectDown(st.component1);
                    changeRectRight(st.component3);
                    changeRectDown(st.component3);
                    changeRectLeft(st.component2);
                    changeRectUp(st.component2);                    
                    st.changeType();
                    break;
                }
                if(st.Type==3&&check(st.component1,-1,1)&&check(st.component3,-1,-1)&&check(st.component2,1,1)){
                    changeRectLeft(st.component1);
                    changeRectUp(st.component1);
                    changeRectLeft(st.component3);
                    changeRectDown(st.component3);
                    changeRectRight(st.component2);
                    changeRectUp(st.component2);                    
                    st.changeType();
                    break;
                }
                if(st.Type==4&&check(st.component1,1,1)&&check(st.component3,-1,1)&&check(st.component2,1,-1)){
                    changeRectRight(st.component1);
                    changeRectUp(st.component1);
                    changeRectLeft(st.component3);
                    changeRectUp(st.component3);
                    changeRectRight(st.component2);
                    changeRectDown(st.component2);                    
                    st.changeType();
                    break;
                }
                break;
            case "Z":
                if(st.Type==1&&check(st.component2,1,1)&&check(st.component3,-1,1)&&check(st.component4,-2,0)){
                    changeRectRight(st.component2);
                    changeRectUp(st.component2);
                    changeRectLeft(st.component3);
                    changeRectUp(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);                    
                    st.changeType();
                    break;
                }
                if(st.Type==2&&check(st.component2,1,-1)&&check(st.component3,1,1)&&check(st.component4,0,2)){
                    changeRectRight(st.component2);
                    changeRectDown(st.component2);
                    changeRectRight(st.component3);
                    changeRectUp(st.component3);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);                    
                    st.changeType();
                    break;
                }
                if(st.Type==3&&check(st.component2,-1,-1)&&check(st.component3,1,-1)&&check(st.component4,2,0)){
                    changeRectLeft(st.component2);
                    changeRectDown(st.component2);
                    changeRectRight(st.component3);
                    changeRectDown(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);                    
                    st.changeType();
                    break;
                }
                if(st.Type==4&&check(st.component2,-1,1)&&check(st.component3,-1,-1)&&check(st.component4,0,-2)){
                    changeRectLeft(st.component2);
                    changeRectUp(st.component2);
                    changeRectLeft(st.component3);
                    changeRectDown(st.component3);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);                    
                    st.changeType();
                    break;
                }
                break;
            case "S":
                if(st.Type==1&&check(st.component2,-1,-1)&&check(st.component3,-1,1)&&check(st.component4,0,2)){
                    changeRectLeft(st.component2);
                    changeRectDown(st.component2);
                    changeRectLeft(st.component3);
                    changeRectUp(st.component3);
                    changeRectUp(st.component4);
                    changeRectUp(st.component4);                    
                    st.changeType();
                    break;
                }
                if(st.Type==2&&check(st.component2,-1,1)&&check(st.component3,1,1)&&check(st.component4,2,0)){
                    changeRectLeft(st.component2);
                    changeRectUp(st.component2);
                    changeRectRight(st.component3);
                    changeRectUp(st.component3);
                    changeRectRight(st.component4);
                    changeRectRight(st.component4);                    
                    st.changeType();
                    break;
                }
                if(st.Type==3&&check(st.component2,1,1)&&check(st.component3,1,-1)&&check(st.component4,0,-2)){
                    changeRectRight(st.component2);
                    changeRectUp(st.component2);
                    changeRectRight(st.component3);
                    changeRectDown(st.component3);
                    changeRectDown(st.component4);
                    changeRectDown(st.component4);                    
                    st.changeType();
                    break;
                }
                if(st.Type==4&&check(st.component2,1,-1)&&check(st.component3,-1,-1)&&check(st.component4,-2,0)){
                    changeRectRight(st.component2);
                    changeRectDown(st.component2);
                    changeRectLeft(st.component3);
                    changeRectDown(st.component3);
                    changeRectLeft(st.component4);
                    changeRectLeft(st.component4);                    
                    st.changeType();
                    break;
                }
                break;
                
            
                
        }
    }
    public static boolean check (Rectangle rect,int Xmove,int Ymove){
        boolean CanMoveX ;
        boolean CanMoveY ;
        if (Xmove >= 0) 
            CanMoveX=rect.getX()+Xmove*block<=xLimit-block;        
        else{
            CanMoveX=rect.getX()+Xmove*block>= 0;      
            System.out.println(rect.getX()+" --  "+Xmove*block+CanMoveX);
        }
        if (Ymove >= 0) {
            CanMoveY=rect.getY()-Ymove*block> 0; 
            System.out.println(rect.getY()+" --  "+Ymove*block+CanMoveY);
        }
        else
            CanMoveY=rect.getY()+Ymove*block<yLimit;
        //System.out.println("fff"+"--"+CanMoveX);
        //System.out.println("fff"+"--"+CanMoveY);
        //System.out.println("fff"+"--"+(!isBlockFull[(int)rect.getX()/block+Xmove][(int)rect.getY()/block-Ymove]));
        //System.out.println(CanMoveX && CanMoveY && (!isBlockFull[(int)rect.getX()/block+Xmove][(int)rect.getY()/block-Ymove]));
        if(CanMoveX && CanMoveY){
            //System.out.println("return :"+!isBlockFull[(int)rect.getX()/block+Xmove][(int)rect.getY()/block-Ymove]);
            return (!isBlockFull[(int)rect.getX()/block+Xmove][(int)rect.getY()/block-Ymove]);
        }
        else
            return false;     
        
    }
    private static void changeRectRight(Rectangle r){        
        if (r.getX()+block <= xLimit-block) 
            r.setX(r.getX()+block);      
    }
    private static void changeRectLeft(Rectangle r) {
        if (r.getX()-block>= 0) 
            r.setX(r.getX()-block);
        
    }
    private static void changeRectDown(Rectangle r) {
        if (r.getY()+block < yLimit) 
            r.setY(r.getY()+block);        
    }
    private static void changeRectUp(Rectangle r) {
        if (r.getY()-block> 0) 
            r.setY(r.getY()-block);        
    }
    public static void FastDown (ShapeType st){
        int count = 1;
        while(true){
            if (st.component1.getY()+count*block<yLimit&&
                st.component2.getY()+count*block<yLimit&&
                st.component3.getY()+count*block<yLimit&&
                st.component4.getY()+count*block<yLimit&&
                !isBlockFull[(int)st.component1.getX()/block][(int)st.component1.getY()/block+count]
                &&!isBlockFull[(int)st.component2.getX()/block][(int)st.component2.getY()/block+count]
                &&!isBlockFull[(int)st.component3.getX()/block][(int)st.component3.getY()/block+count]
                &&!isBlockFull[(int)st.component4.getX()/block][(int)st.component4.getY()/block+count]){
                count++;
            }
            else break;
        }
        count-=1;
        st.component1.setY(st.component1.getY()+count*block);
        st.component2.setY(st.component2.getY()+count*block);
        st.component3.setY(st.component3.getY()+count*block);
        st.component4.setY(st.component4.getY()+count*block);
        isBlockFull[(int) st.component1.getX() / block][(int) st.component1.getY() / block] = true;
        isBlockFull[(int) st.component2.getX() / block][(int) st.component2.getY() / block] = true;
        isBlockFull[(int) st.component3.getX() / block][(int) st.component3.getY() / block] = true;
        isBlockFull[(int) st.component4.getX() / block][(int) st.component4.getY() / block] = true;
        checkDelete(GroupAllRect);            
        Tetris.now = NEXT(Tetris.next);
        Tetris.next = Create();
        Tetris.isNewRect = true;
        Tetris.GroupAllRect.getChildren().addAll(Tetris.now.component1,Tetris.now.component2,Tetris.now.component3,Tetris.now.component4);
        Tetris.GroupNextRect.getChildren().addAll(Tetris.next.component1,Tetris.next.component2,Tetris.next.component3,Tetris.next.component4);
        //Tetris.rootPane.getChildren().addAll(Tetris.GroupAllRect,Tetris.GroupNextRect);
        Tetris.moveControl(Tetris.now);        
    }
}
