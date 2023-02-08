package frc.robot.commands;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import java.lang.Math;
public class encoderDriveC extends CommandBase {
    //Variable declaration
    tankDriveS drive;
    double inches, encAvg, desired, CPR;
    PIDController PiController;
    
    //checks to see if command is run all the way through before being called again, prevents being called 3 trillion times
    public boolean isFinished;
//new encoder drive
    public encoderDriveC(tankDriveS subsystem, double inches) {
        drive = subsystem;
        desired = inches;
        addRequirements(drive);
    }
    @Override
    public void initialize() {
        CPR = 1/42;
//the encoders only go 42 revolutions for some reason
        isFinished = false;
        drive.resetEncoders();
    }
    public void execute() {
        // finds average of degree measures
        final double gearRatio = 8.46;
        final double wheelDiameter = 6*Math.PI;
        encAvg = (tankDriveS.lFront.getPosition() + tankDriveS.lBack.getPosition() - tankDriveS.rFront.getPosition() - tankDriveS.rBack.getPosition())/4;
        double ratioEnc = encAvg*gearRatio;

        double finishedEncValue = ratioEnc*wheelDiameter;

        drive.tankDrive(PiController.calculate(finishedEncValue, desired),PiController.calculate(finishedEncValue, desired));   
        if (Math.abs(PiController.getPositionError()) < 1) { 
            isFinished = true;
        } 
    }
    @Override
    public void end(boolean interrupted) {}
  
    @Override
    public boolean isFinished() {
      return isFinished();
    }
}