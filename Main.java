package com.veena;

import java.util.Scanner;

public class Main {

    private char direction;

    public static void main(String[] args) {
	// write your code here
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
        System.out.println("Room size is : "+wide+"x"+deep);
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
        System.out.println(room.displayCurrentPos());
    }
}
