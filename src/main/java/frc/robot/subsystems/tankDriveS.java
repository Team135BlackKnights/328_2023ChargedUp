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
import com.kauailabs.navx.frc.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class tankDriveS extends SubsystemBase{ 
 Encoder encoder = new Encoder(0, 1);
   //// public AHRS navx = new AHRS();
    //motors for drive
    public DifferentialDrive tank;
    public AHRS navx = new AHRS(robotMap.navX.navXPort);
    public CANSparkMax frontLeft = new CANSparkMax(robotMap.drive.FL_ID, MotorType.kBrushless);
    public CANSparkMax frontRight = new CANSparkMax(robotMap.drive.FR_ID, MotorType.kBrushless);
    public CANSparkMax backLeft = new CANSparkMax(robotMap.drive.BL_ID, MotorType.kBrushless);
    public CANSparkMax backRight = new CANSparkMax(robotMap.drive.BR_ID, MotorType.kBrushless);
    public MotorControllerGroup autoMotors;
    public Encoder LeftSide, RightSide; 
    public static NetworkTable limelightNetworkTable;
    //connects encoders to drive motorgroups
    public static RelativeEncoder lFront, lBack, rFront, rBack;  
    public tankDriveS(){  
        limelightNetworkTable = NetworkTableInstance.getDefault().getTable("limelight-turret");
    //connects encoders to drive motors
        lFront= frontLeft.getEncoder();
        lBack = backLeft.getEncoder();
        rFront= frontRight.getEncoder();
        rBack = backRight.getEncoder();
    //Enables voltage compensation to not use too much battery
        frontLeft.enableVoltageCompensation(12);
        frontRight.enableVoltageCompensation(12);
        backLeft.enableVoltageCompensation(12);
        backRight.enableVoltageCompensation(12);
    //This turns the motor to "idle mode" which stops using the motor when not needed
        frontLeft.setIdleMode(IdleMode.kBrake);
        frontRight.setIdleMode(IdleMode.kBrake);
        backLeft.setIdleMode(IdleMode.kBrake);
        backRight.setIdleMode(IdleMode.kBrake); 
    //Sets voltage compensation limit (hopefully)
        frontLeft.setSmartCurrentLimit(30,80);
        frontRight.setSmartCurrentLimit(30,80);
        backLeft.setSmartCurrentLimit(30,80);
        backRight.setSmartCurrentLimit(30,80);
    //writes the settings to flashdrives
        frontLeft.burnFlash();
        frontRight.burnFlash();
        backLeft.burnFlash();
        backLeft.burnFlash();
    //Groups motorcontrollergroups left and right
        MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeft, backLeft); 
        MotorControllerGroup rightMotors = new MotorControllerGroup(frontRight, backRight);
        autoMotors = new MotorControllerGroup(frontLeft,backLeft,frontRight,backRight);
        navx.reset();
        tank = new DifferentialDrive(leftMotors, rightMotors);
    }
    
    public void tankDrive(double left, double right) {
    //Sets motor control groups to tankdrive
        tank.tankDrive(left, right);

        
    }

    public void resetEncoders(){
        //resets encoders to 0 when code is started up
        lFront.setPosition(0);
        lBack.setPosition(0);
        rFront.setPosition(0);
        rBack.setPosition(0);
    }

    public void runStop() {
    //Sets motors to stop when not in use
        frontLeft.setIdleMode(IdleMode.kBrake);
        frontRight.setIdleMode(IdleMode.kBrake);
        backLeft.setIdleMode(IdleMode.kBrake);
        backRight.setIdleMode(IdleMode.kBrake); 
    //Writes the settings to flashdrives
        frontLeft.burnFlash();
        frontRight.burnFlash();
        backLeft.burnFlash();
        backRight.burnFlash();
    }

    public void resetNavX(){
        navx.reset();
        navx.zeroYaw();
        navx.calibrate();
    }
}
