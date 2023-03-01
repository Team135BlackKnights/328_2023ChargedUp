// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.tankDriveS;
import frc.robot.subsystems.intakeS;
import frc.robot.subsystems.liftS;
import frc.robot.subsystems.intakeS;


  public class driveAuto extends SequentialCommandGroup {
<<<<<<< Updated upstream
  public driveAuto(tankDriveS drive, intakeS intake){
    System.out.print("Initializing driveAuto...");
    addCommands(
    new shootOutC(drive,intake, 2, .5)
  // new basicAuto(drive, 5.328 , .4)
   //new otherAuto(drive, 10, .4)
   //new encoderDriveC(drive, 10.0)
   );
=======
  public driveAuto(tankDriveS drive, intakeS intake, liftS lift){
    basicAuto basicAutoL = new basicAuto(drive, 5.328 , .4);
    
   // otherAuto otherAutoL = new otherAuto(drive, 10, .4);
 //   encoderDriveC encoderDriveL = new encoderDriveC(drive, 10.0);
    shootOutC shootOutL = new shootOutC(drive,intake,2,.5);
    encoderTurnC encoderTurnL = new encoderTurnC(drive,180);
    flipDown flipDownL = new flipDown(lift, intake, 3, .7);
    System.out.print("Initializing driveAuto...");
    addCommands(flipDownL, shootOutL,basicAutoL);
>>>>>>> Stashed changes
   //addCommands(new basicAuto(drive,5.328,.4));
 
  }
}


