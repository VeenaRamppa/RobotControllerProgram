package com.veena;
/*
Author - Veena R
Date - 12/28/2019
Name - Room.java
This java class contains the class variables wide,deep,xPos,yPos and direction. Parameterized constructor is used to set the values
of wide and deep variables. Purpose of this class is to hold size of the room,provides function to set the position of the robot,
function to walk in around the room & display the current position of the robot
 */

public class Room {
    private int wide;
    private int deep;
    private int xPos;
    private int yPos;
    private char direction;
    private String navCommand;

    public Room(int wide, int deep) {
        this.wide = wide;
        this.deep = deep;
    }
/*
setPosition() - is used to set the initial position & direction of the robot. This function gets the values from the Main.java
xPos & yPos values are checked in the range of (0 to width or deep of the room size) and if the values are not in range a message
will be showed as "Could not set first/second position"
 */
    public void setPosition(int xPos, int yPos, char direction) {
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
/*
setNavcommand() - this method is used to set the navigation commands entered by the user to the class variable navCommand
 */
    public void setNavCommand(String navCommand){
        this.navCommand = navCommand;
    }
/*
walkAroundRoom() - this method is used to make robot move around the room based of navigation commands
Before moving forward every time it is checked whether the robot is in border or not using checkBorder() method
and direction is changed according to the command using changeDirection() method
 */
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
/*
checkBorder() - this method is used to check the position of the robot @ the border.
Input parameters are xPos,yPos & direction.
If the robot is at the position (0,0),facing towards 'W' or 'N' AND position (width,deep), facing 'S' or 'E' it is not possible for
the robot to move forward if the command is 'F'.
The same scenario is checked using if condition and a boolean variable chkflag will be set to to "false".
otherwise chkflag is set to boolean value "true" and the same is returned to walkAroundRoom() method */
    private boolean checkBorder(int xPos,int yPos,char direction){
        boolean chkFlag = true;
            if((direction == 'W') && (xPos == 0)){
                chkFlag = false;
            }else if((direction == 'N') && (yPos == 0)){
                chkFlag = false;
            }else if((direction == 'S')&&(yPos == (wide-1))){
                chkFlag = false;
            }else if((direction == 'E')&&(xPos == (deep-1))){
                chkFlag = false;
            }
            return chkFlag;
    }
/*
moveForward() - this method is called when the command is 'F' and it main purpose is to keep track of the position of the robot
when it walk in around the room. This method is called by walkAroundRoom() method.
 */
    private void moveForward(){
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
/*
changeDirection() - this method is called by walkAroundRoom() method.Main purpose of this method is to change the direction of the
robot when it turns to left or right when the command is 'L' or 'R'.
Input parameter is a character 'L' or 'R'
 */
    private void changeDirection(char leftOrRight){
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
/*
displayCurrentPos - this method is used to display the current position of the robot after following the navigation commands
this method is invoked in Main.java to report the position and direction of the robot in string format
 */
    public String displayCurrentPos(){
        return (Integer.toString(xPos)+" "+Integer.toString(yPos)+" "+direction);
    }
}
