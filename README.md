# RobotControllerProgram

This is a simple java program to help the robot to walk around the room based on navigation commands. The application usage as follows:

User is prompted to enter the size of the room width and deep(height) , the robot can know the size of the room.Then 2 digits are accepted to know the initial position of the robot inside the room and a direction(N-north,S-south,E-east,W-west) robot is facing.

Then robot receives list of navigation commands in the form of characters and the characters are:

- L --> Turn left
- R --> Turn right
- F --> Walk forward

After following list of commands robot will report its position in the room and direction it is facing.

**Example:**

Size of the room is 5x5 , initial position of the robot is 1 2 N (indicating robot is @ the position(1,2) and facing North direction)
and the navigation commands supplied are "RFRFFRFRF"

After completing the last command robot reports its position as 1 3 N

Robot controller program is tested using TestSuit.java class, and the same class is supplied with some predefined values to test the robot program.
