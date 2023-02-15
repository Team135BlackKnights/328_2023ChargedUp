// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.tankDriveS;


  public class driveAuto extends SequentialCommandGroup {
  public driveAuto(tankDriveS drive){
    System.out.print("Initializing driveAuto...");
    addCommands(
   new basicAuto(drive, 4.328, .4)

   //new encoderDriveC(drive, 10.0)
   );

  }
}


