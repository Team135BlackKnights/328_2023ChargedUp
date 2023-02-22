package frc.robot.commands.Autos;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class encoderTurnC extends CommandBase {
    //Variable declaration
    private final tankDriveS drive;
    double inches, encAvg, desiredDist, CPR, leftEncAvg,rightEncAvg, desiredAng;
    PIDController piController = new PIDController(.008, .004, 0);
    
    //checks to see if command is run all the way through before being called again, prevents being called 3 trillion times
    public boolean isFinished;
//new encoder drive
    public encoderTurnC(tankDriveS subsystem, double angle) {
        drive = subsystem;
        desiredAng = angle;
        addRequirements(drive);
    }
    @Override
    public void initialize() {
        System.out.print("Initializing encTurnC...");
        drive.resetEncoders();
        CPR = 1/42;
//the encoders only go 42 revolutions for some reason (this is false)
        isFinished = false;
        drive.resetEncoders();
    }
    @Override
    public void execute() {
        // finds average of degree measures
        final double gearRatio = 8.46;
        final double wheelCircum = 6*Math.PI;
        final double robotCircum = 21.5*Math.PI;
        leftEncAvg =  (tankDriveS.lFront.getPosition() + tankDriveS.lBack.getPosition())/2;
        rightEncAvg = (tankDriveS.rFront.getPosition() + tankDriveS.rBack.getPosition())/2;
        double rightRatioEnc = rightEncAvg*gearRatio*CPR;
        double leftRatioEnc = leftEncAvg*gearRatio*CPR;
        SmartDashboard.putNumber("Left encoder average", leftEncAvg);
        SmartDashboard.putNumber("Right encoder average", rightEncAvg);
        System.out.print("executing encTurnC...");
        double rightFinishedEncValue = rightRatioEnc*wheelCircum;
        double leftFinishedEncValue = leftRatioEnc*wheelCircum;
        desiredDist = robotCircum*desiredAng/360;
        drive.tankDrive((piController.calculate(leftFinishedEncValue, desiredDist)),piController.calculate(rightFinishedEncValue, -desiredDist));
        
        if (Math.abs(piController.getPositionError()) < 1) { 
            drive.runStop();
            isFinished = true;
        }}
    @Override
    public void end(boolean interrupted) {
        drive.tankDrive(0, 0);
        drive.runStop();
    }
  
    @Override
    public boolean isFinished() {
      return isFinished;
    }
}
