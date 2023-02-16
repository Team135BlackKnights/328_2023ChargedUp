package frc.robot.commands.Autos;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class otherAuto extends CommandBase {
    long timeStart;
    double seconds;
    double autoSpeed;
        public final tankDriveS drive;
        Timer timeElapsed= new Timer();
        public otherAuto(tankDriveS subsystem, double desiredTime, double MotorSpeed ){
            seconds = desiredTime;
            drive = subsystem;
            autoSpeed = MotorSpeed;
            addRequirements(subsystem);
        }
        public void initialize(){
            System.out.print("Running otherAuto...");
        timeElapsed.start();
        }
        public void execute() {
    
            if (timeElapsed.get() <= 2) {
                
                drive.tankDrive(-autoSpeed*1.0375,autoSpeed);
                
            }
            else if (timeElapsed.get() <= 3) {
                
                drive.tankDrive(-autoSpeed*1.0375,-autoSpeed);
                
            }
            else if (timeElapsed.get() <= 5) {
                
                drive.tankDrive(-autoSpeed*1.0375,autoSpeed);
                
            }
            else if (timeElapsed.get() <= 7) {
                
                drive.tankDrive(autoSpeed*1.0375,autoSpeed);
                
            }
            else if (timeElapsed.get() <= 10) {
                
                drive.tankDrive(autoSpeed*1.0375,autoSpeed);
                
            }
            else {
                
                drive.tankDrive(0,0);
                
            }
            
        }
        public void end() {
            drive.tankDrive(0,0);
            drive.runStop();
        }
    }
