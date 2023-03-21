package frc.robot.commands;
import frc.robot.subsystems.liftS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.robotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class liftC extends CommandBase {
    public final liftS lift;
    public liftC(liftS subsystem){
        lift = subsystem;
    addRequirements(subsystem);
}
public void initialize() {
}
int POV_UP = 0;
int POV_RIGHT = 90;
int POV_DOWN = 180;
int POV_LEFT = 270;
boolean change =false;
public void execute(){
SmartDashboard.putNumber("lift encoder value", lift.flipMotorEncoder.getPosition());
if (robotContainer.ManipControl.getPOV() == POV_UP)  {
    //if (lift.flipMotorEncoder.getPosition()>5-lift.changer) { 
        lift.moveLiftUp(-0.75);
   // }
}
else if (robotContainer.ManipControl.getPOV() == POV_DOWN) {
 // while (lift.flipMotorEncoder.getPosition()<95+lift.changer) { 
    lift.moveLiftDown(0.75);
     /*}
    
     change=true;
     if (change==true){
        lift.changer = 20;
     }
     */

    // while (robotContainer.ManipControl.getXButton() == true){
    }
//  }
else if (robotContainer.ManipControl.getPOV() == POV_LEFT){
    lift.moveLiftDown(0.35);
}
else if (robotContainer.ManipControl.getPOV() == POV_RIGHT){
    lift.moveLiftUp(-0.35);
}
//else if (robotContainer.ManipControl.getRightTriggerAxis() >= 10)
else{
        lift.stopLift();
    }
    
}
}