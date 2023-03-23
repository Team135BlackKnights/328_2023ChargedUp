package frc.robot.commands.Macros;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;

public class encoderDriveF extends CommandBase{
    private static final int kEncoderCountsPerRevolution = 42; // adjust this to match your encoder
    private static final double kWheelDiameterInches = 6;
 
    double distance;
    double speed;
    private final RelativeEncoder m_leftEncoder;
    private final RelativeEncoder m_rightEncoder;
    private final MotorControllerGroup m_drive;
    public tankDriveS drive;
    boolean isFinished;
    public encoderDriveF(tankDriveS tankDrive, double distanceInches, double speedInchesPerSecond) {
        drive = tankDrive;
        m_leftEncoder =drive.lFront;
        m_rightEncoder = drive.rFront;
        m_drive = drive.autoMotors;
        speed = speedInchesPerSecond;
        distance=distanceInches;
        addRequirements(drive);


        
    }
    @Override
    public void initialize(){
        isFinished = false;
        drive.runStop();
        driveDistance(distance,speed);
    }

    public void driveDistance(double distanceInches, double speedInchesPerSecond) {
        double distancePerRevolution = Math.PI * kWheelDiameterInches;
        double revolutions = distanceInches / distancePerRevolution;
        int targetCounts = (int)(revolutions * kEncoderCountsPerRevolution);
        m_leftEncoder.setPosition(0);
        m_rightEncoder.setPosition(0);
        System.out.println("Second Auto Start");

        while (m_leftEncoder.getPosition() < targetCounts && m_rightEncoder.getPosition() < targetCounts) {
            double speed = Math.min(speedInchesPerSecond, (targetCounts + m_leftEncoder.getPosition()) / kEncoderCountsPerRevolution);
            drive.tankDrive((speed*.5), (-speed*.5)); 
        }
        m_drive.stopMotor();//replace with actual stop tank.
        System.out.println("Second Auto End");
        isFinished = true;
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}