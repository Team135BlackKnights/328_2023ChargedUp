package frc.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.robotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class tankDriveS extends SubsystemBase{ 
    //motors for drive
    public DifferentialDrive tank;
    public CANSparkMax frontLeft = new CANSparkMax(robotMap.drive.FL_ID, MotorType.kBrushless);
    public CANSparkMax frontRight = new CANSparkMax(robotMap.drive.FR_ID, MotorType.kBrushless);
    public CANSparkMax backLeft = new CANSparkMax(robotMap.drive.BL_ID, MotorType.kBrushless);
    public CANSparkMax backRight = new CANSparkMax(robotMap.drive.BR_ID, MotorType.kBrushless);

    public Encoder LeftSide, RightSide; 
    //connects encoders to drive motorgroups
    public static RelativeEncoder lFront, lBack, rFront, rBack;  
    public tankDriveS(){  
    //connects encoders to drive motors
        lFront= frontLeft.getEncoder();
        lBack = backLeft.getEncoder();
        rFront= frontRight.getEncoder();
        rBack = backRight.getEncoder();

        frontLeft.enableVoltageCompensation(12);
        frontRight.enableVoltageCompensation(12);
        backLeft.enableVoltageCompensation(12);
        backRight.enableVoltageCompensation(12);

        frontLeft.setIdleMode(IdleMode.kCoast);
        frontRight.setIdleMode(IdleMode.kCoast);
        backLeft.setIdleMode(IdleMode.kCoast);
        backRight.setIdleMode(IdleMode.kCoast); 

        MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeft, backLeft); 
        MotorControllerGroup rightMotors = new MotorControllerGroup(frontRight, backRight);
    //these are the motorgroups
        
        tank = new DifferentialDrive(leftMotors, rightMotors);
    }
    public void tankDrive(double left, double right) {
        tank.tankDrive(left, right);

        
    }
    public void resetEncoders(){
        //resets encoders to 0 when code is started up
        lFront.setPosition(0);
        lBack.setPosition(0);
        rFront.setPosition(0);
        rBack.setPosition(0);
    }
}
