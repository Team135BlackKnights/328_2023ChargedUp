package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeEx1S;

public class IntakeEx1C extends CommandBase{
    public final IntakeEx1S intake;
    public IntakeEx1C(IntakeEx1S subsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        intake = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {

    if (RobotContainer.ManipControl.getLeftTriggerAxis()>0) {
        intake.IntakeL.set(.7);
        intake.IntakeR.set(-.7);
    } else if (RobotContainer.ManipControl.getRightTriggerAxis()>0) {
        intake.IntakeL.set(-.7);
        intake.IntakeR.set(.7);
    } else {
        intake.IntakeL.set(0);
        intake.IntakeR.set(0);
    }

    if (RobotContainer.ManipControl.getPOV()== 0) {
      //runs if something is pressed on the dpad
        intake.IntakeUpDown.set(.3);
    } else if (RobotContainer.ManipControl.getPOV()== 180) {
        intake.IntakeUpDown.set(-.3);
    } else {
        intake.IntakeUpDown.set(0);
    }

}

}
