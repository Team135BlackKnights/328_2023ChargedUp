package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
public class resetEncoders extends CommandBase {
        tankDriveS drive;
    public resetEncoders(tankDriveS subsystem){
        drive = subsystem;
        
    }
    @Override
    public void initialize() {
        drive.resetEncoders();
        addRequirements(drive);
    }

}
