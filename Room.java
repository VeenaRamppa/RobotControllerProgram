package com.veena;
import java.util.Arrays;
import java.util.Scanner;

public class Room {
    private int wide;
    private int deep;
    private int xPos;
    private int yPos;
    private char direction;
    private int roomSize[][];
    private String navCommand;
    Scanner scan = new Scanner(System.in);
    int pos1,pos2;

    public Room(int wide, int deep) {
        this.wide = wide;
        this.deep = deep;
        roomSize = new int[wide][deep];
    }

    public void setPosition(int xPos, int yPos, char direction) {
        System.out.println("x pos "+xPos);
        System.out.println("y pos "+yPos);
        System.out.println("wide "+wide);
        System.out.println("deep "+deep);
            if((xPos < wide) && (xPos >= 0)) {
                this.xPos = xPos;
            }else{
                System.out.println("Could not set first position");
            }
            if((yPos < deep) && (yPos >= 0)) {
                this.yPos = yPos;
            }else{
                System.out.println("Could not set second position");
            }
            this.direction = direction;
    }

    public void setNavCommand(String navCommand){
        this.navCommand = navCommand;
    }

    public void printRoomFields(){
        System.out.println(Arrays.deepToString(roomSize));
    }
    public void walkAroundRoom(){
        for(int x=0;x<navCommand.length();x++) {
            if (navCommand.charAt(x) == 'F') {
                boolean chkFlagVal = checkBorder(xPos, yPos, direction);
                if (chkFlagVal) {
                    moveForward();
                }
            } else {
                changeDirection(navCommand.charAt(x));
            }
        }
    }
    public boolean checkBorder(int xPos,int yPos,char direction){
        boolean chkFlag = false;
            if((direction == 'W') && (xPos == 0)){
                //System.out.println("I can't walk forward");
            }else if((direction == 'N') && (yPos == 0)){
                //System.out.println("I can't walk forward");
            }else if((direction == 'S')&&(yPos == (wide-1))){
                //System.out.println("I can't walk forward");
            }else if((direction == 'E')&&(xPos == (deep-1))){
                //System.out.println("I can't walk forward");
            }else{
                chkFlag = true;
            }
            return chkFlag;
    }
    public void moveForward(){
        if(this.direction == 'W'){
            this.xPos--;
        }else if(this.direction == 'N'){
            this.yPos--;
        }else if(this.direction == 'S'){
            this.yPos++;
        }else if(this.direction == 'E'){
            this.xPos++;
        }
    }

    public void changeDirection(char leftOrRight){
        if(leftOrRight == 'L'){
            switch(this.direction){
                case 'N':
                    this.direction = 'W';
                    break;
                case 'S':
                    this.direction = 'E';
                    break;
                case 'W':
                    this.direction = 'S';
                    break;
                case 'E':
                    this.direction = 'N';
                        break;
            }
        }else if(leftOrRight == 'R'){
            switch(this.direction){
                case 'N':
                    this.direction = 'E';
                    break;
                case 'S':
                    this.direction = 'W';
                    break;
                case 'W':
                    this.direction = 'N';
                    break;
                case 'E':
                    this.direction = 'S';
                    break;
            }
        }else{
            System.out.println("Invalid command");
        }
    }

    public String displayCurrentPos(){
        return (Integer.toString(xPos)+" "+Integer.toString(yPos)+" "+direction);
    }
}
