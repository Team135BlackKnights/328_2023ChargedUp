// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.encoderDriveC;
import frc.robot.subsystems.tankDriveS;
import frc.robot.commands.Autos.resetEncoders;


  public class driveAuto extends SequentialCommandGroup {
  public driveAuto(tankDriveS drive){
    super(
      Commands.sequence(
        new resetEncoders(drive),
        new encoderDriveC(drive, -20)
      )
    );
  }
}


