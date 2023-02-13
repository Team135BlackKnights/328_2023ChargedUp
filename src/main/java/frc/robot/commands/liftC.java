package frc.robot.commands;
import frc.robot.subsystems.liftS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotContainer;
public class liftC extends CommandBase {
    public final liftS lift;
    public liftC(liftS subsystem){
        lift = subsystem;
    addRequirements(subsystem);
}
public void initialize() {
    
}
public void execute(){

    if (robotContainer.ManipControl.getAButtonPressed() && liftS.tooFarOut.get()) {
        liftS.flipMotor.set(-.4);
        
    }
    else if (robotContainer.ManipControl.getYButtonPressed() && liftS.tooFarIn.get()) {
        liftS.flipMotor.set(.4);
    }
    SmartDashboard.putNumber("liftEncPos", liftS.flipMotorEncoder.getPosition());
}
}
