package frc.robot.commands.Autos;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class encoderDriveC extends CommandBase {
    //Variable declaration
    private final tankDriveS drive;
    double inches, encAvg, desired, CPR;
    PIDController piController = new PIDController(.008, .004, 0);
    
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
        System.out.print("Initializing encDriveC...");
        drive.resetEncoders();
        CPR = 1/42;
//the encoders only go 42 revolutions for some reason (this is false)
        isFinished = false;
        drive.resetEncoders();
    }
    public void execute() {
        // finds average of degree measures
        final double gearRatio = 8.46;
        final double wheelDiameter = 6*Math.PI;
        encAvg = (tankDriveS.lFront.getPosition() + tankDriveS.lBack.getPosition() - tankDriveS.rFront.getPosition() - tankDriveS.rBack.getPosition())/4;
        double ratioEnc = encAvg*gearRatio*CPR;
        SmartDashboard.putNumber("encoder average", encAvg);
        System.out.print("executing encDriveC...");
        double finishedEncValue = ratioEnc*wheelDiameter;
        drive.tankDrive(-piController.calculate(finishedEncValue, desired),piController.calculate(finishedEncValue, desired));
        
        if (Math.abs(piController.getPositionError()) < 1) { 
            isFinished = true;
        }}
    @Override
    public void end(boolean interrupted) {
        drive.tankDrive(0, 0);
    }
  
    @Override
    public boolean isFinished() {
      return isFinished;
    }
}
