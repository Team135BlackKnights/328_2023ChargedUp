package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.limeLightS;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class limeLightC extends CommandBase{
    private final limeLightS limeLight;
    public limeLightC(limeLightS subsystem) {
        limeLight = subsystem;
        addRequirements(subsystem);
    }
    @Override
    public void initialize(){


    }
    public void execute(){
        NetworkTable limeLightTable = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = limeLightTable.getEntry("tx");
        NetworkTableEntry ty = limeLightTable.getEntry("ty");
        NetworkTableEntry ta = limeLightTable.getEntry("ta");
         double x = tx.getDouble(0.0);
         double y = tx.getDouble(0.0);
         double a = tx.getDouble(0.0);
        SmartDashboard.putNumber("x distance", x);
        SmartDashboard.putNumber("y distance", y);
        SmartDashboard.putNumber("area", a);
        double distance = y/x; // Math.tan()
        SmartDashboard.putNumber("distance to target", distance);
    }
}
