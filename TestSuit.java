package com.veena;
/*
Author - Veena R
Date - 12/29/2019
Name - TestSuit.java
TestSuit.java class is a test class used to test the robot programming of Room.java class
This class contains runTest() method and different test cases are covered to test the movement of the robot towards corner,
random movements,initial position and valid position of the robot
*/
import com.veena.Room;  
public class TestSuit {
    private static Room room = new Room(5,5);
    public static void main(String args[]){
     /*
     Testing  corners - below runTest() method invocations are for corner movement of the robot
      */
        runTest(0,0,'N',"F","0 0 N","TEST_1");
        runTest(0,0,'W',"F","0 0 W","TEST_2");
        runTest(4,0,'N',"F","4 0 N","TEST_3");
        runTest(4,0,'E',"F","4 0 E","TEST_4");
        runTest(4,4,'S',"F","4 4 S","TEST_5");
        runTest(4,4,'E',"F","4 4 E","TEST_6");
        runTest(0,4,'S',"F","0 4 S","TEST_7");
        runTest(0,4,'W',"F","0 4 W","TEST_8");
       /*
       Testing random movements - below  are the statments for random movement of the robot
        */
        runTest(0,0,'E',"RFLFFLRF","3 1 E","TEST_9");

        runTest(0,0,'E',"RFLFFLRFFFFFFFFFFFF","4 1 E","TEST_10");

        runTest(0,0,'E',"RFLFFLRFFFFFFFFFFFFRR","4 1 W","TEST_11");
        /*
        Testing the initial position - below statement is for the initial position of the robot are mentioned in the range or not
         */
        runTest(100,0,'E',"RFLFFLRFFFFFFFFFFFFRR","4 1 W","TEST_12");
         /*
         Testing of valid positions of the robot
          */
         runTest(1,2,'N',"RFRFFRFRF","1 3 N","TEST_13");
         runTest(0,0,'E',"RFLFFLRF","3 1 E","TEST_14");

    }
/*
runTest() - it is a test method  to invoke the methods of Room.java class with some supplied values and expected results
 */
    public static void runTest(int xPos,int yPos,char direction,String command,String expected_str,String testName){
        room.setPosition(xPos,yPos,direction);
        room.setNavCommand(command);
        room.walkAroundRoom();
        String val = room.displayCurrentPos();
        System.out.println(val);
        if(val.compareTo(expected_str) != 0){
            System.out.println(testName+" Error: actual values differ from expected values");
        }
    }

}
