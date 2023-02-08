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
    public CANSparkMax FrontLeft = new CANSparkMax(robotMap.Drive.FL_ID, MotorType.kBrushless);
    public CANSparkMax FrontRight = new CANSparkMax(robotMap.Drive.FR_ID, MotorType.kBrushless);
    public CANSparkMax BackLeft = new CANSparkMax(robotMap.Drive.BL_ID, MotorType.kBrushless);
    public CANSparkMax BackRight = new CANSparkMax(robotMap.Drive.BR_ID, MotorType.kBrushless);

    public Encoder LeftSide, RightSide; 
    //connects encoders to drive motorgroups
    public static RelativeEncoder lFront, lBack, rFront, rBack;  
    public tankDriveS(){  
    //connects encoders to drive motors
        lFront= FrontLeft.getEncoder();
        lBack = BackLeft.getEncoder();
        rFront= FrontRight.getEncoder();
        rBack = BackRight.getEncoder();

        FrontLeft.enableVoltageCompensation(12);
        FrontRight.enableVoltageCompensation(12);
        BackLeft.enableVoltageCompensation(12);
        BackRight.enableVoltageCompensation(12);

        FrontLeft.setIdleMode(IdleMode.kCoast);
        FrontRight.setIdleMode(IdleMode.kCoast);
        BackLeft.setIdleMode(IdleMode.kCoast);
        BackRight.setIdleMode(IdleMode.kCoast); 

        MotorControllerGroup left = new MotorControllerGroup(FrontLeft, BackLeft); 
        MotorControllerGroup right = new MotorControllerGroup(FrontRight, BackRight);
    //these are the motorgroups
        
        tank = new DifferentialDrive(left, right);
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
