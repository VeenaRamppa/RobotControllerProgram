package com.veena;
/*
Author - Veena R
Date - 12/28/2019
Name - Main.java
Robot programming is implemented as console application . Main.java is the main class/start of the application.
This class accepts the width and depth variable values from user and assign them to the Room class variables wide and deep respectively.
User will be prompted to enter the initial position of the robot in the room and direction it is facing.
 */
import java.util.Scanner;

public class Main {
/*
Initial position of the robot are accepted as pos1 & pos2 and direction is accepted dir variable.And these variables are passed to
setPosition(pos1,pos2,dir) to set the initial position of the robot.
Instruction shown to user to give navigation commands to robot
Through Room class object robot can walk in around room using walkAroundRoom() method
After completing all the navigation commands robot can report which field it is in and direction it is facing through displayCurrentPos()
function of Room class
 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pos1,pos2,wide,deep;
        char dir;
        boolean flag = false;
        String navCommand = "";
        System.out.println("Enter the size of the room ...");
        System.out.println("Enter the width");
        wide = scan.nextInt();
        System.out.println("Enter the depth");
        deep = scan.nextInt();
        Room room = new Room(wide,deep);
        System.out.println("Enter the position of the Robot");
        System.out.println("Enter the first coordinate");
        pos1 = scan.nextInt();
        while(pos1<0){
            System.out.println("Enter the first coordinate");
            pos1 = scan.nextInt();
        }
        System.out.println("Enter the second coordinate");
        pos2 = scan.nextInt();
        while(pos2<0) {
            System.out.println("Enter the second coordinate");
            pos2 = scan.nextInt();
        }
        System.out.println("Enter the direction as (N or S or W or E) robot is facing");
        dir = scan.next().charAt(0);
        while(flag == false) {
            switch(dir){
                case 'N':
                case 'S':
                case 'E':
                case 'W':
                    flag = true;
                    break;
                default:
                    System.out.println("Enter the correct direction ");
                    dir = scan.next().charAt(0);
                  break;
            }
        }
        room.setPosition(pos1,pos2,dir);

        System.out.println("There are 3 navigation commands you can assign to robot as below"+
                "\nL Turn left\nR Turn right\nF Walk forward\n\nEnter the navigation commands:");
        navCommand = scan.next();
        room.setNavCommand(navCommand);
        room.walkAroundRoom();
        System.out.println("Report: "+room.displayCurrentPos());
    }
}
