package frc.robot.commands.Macros;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class gyro extends CommandBase {
    public tankDriveS drive;
    boolean isFinished = false;
    double currentAngle = 0.0;
    double desired;
    double speed;
    double gyroError;
    double correction;

    public gyro(tankDriveS subsystem, double desiredAngle) {
        drive = subsystem;
        desired = desiredAngle;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        System.out.print("initializing Balancer");
        isFinished=false;
    }

    @Override
    public void execute() {
        System.out.print("executing Balancer");
        SmartDashboard.putNumber("autoRoll",drive.navx.getRoll());
         if (drive.navx.getRoll()<1 && drive.navx.getRoll() > -1){
            drive.tankDrive(0, 0);
            isFinished=true;
         }
        else{
            speed = drive.navx.getRoll() * .02;
            drive.tankDrive(-speed, speed);
        }
    }

    @Override
    public boolean isFinished(){
        return isFinished;
    }

}
