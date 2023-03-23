package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.tankDriveS;
import frc.robot.subsystems.intakeS;
import frc.robot.subsystems.liftS;
import frc.robot.commands.Macros.*;

public class balanceAuto extends SequentialCommandGroup {
    public balanceAuto(tankDriveS tank, intakeS intake, liftS lift){
        shootOutC shootOutL = new shootOutC(tank,intake,1,.65);
        //shoots the cube out for 1 second at a speed of 65% power
        manipMove flipDownL = new manipMove(lift, intake, 3, .7);
    //moves the intake down for 3 seconds at a speed of 70% power
    encoderDriveC encoderDriveL = new encoderDriveC(tank,40,1);
    //drives 35 inches at a speed of 5 inches per second
    encoderDriveF encoderDriveForward = new encoderDriveF(tank,18.85,1.2);
        //drive
    gyro gyroL = new gyro(tank, 0);
    turnAuto turnAutoL = new turnAuto(tank,.85,.4);
    //
    addCommands(flipDownL, shootOutL,encoderDriveL,encoderDriveForward,turnAutoL);
    // 
    }
}