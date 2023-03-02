// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos.driveAuto;
import frc.robot.commands.tankDriveC;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.intakeC;
import frc.robot.subsystems.intakeS;
import frc.robot.subsystems.liftS;
import frc.robot.commands.liftC;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Autos.balanceScoreAuto;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class robotContainer {
  // The robot's subsystems and commands are defined here...
  public static tankDriveS tankDriveS = new tankDriveS();
  public static intakeS _intakeS = new intakeS(); 
  public static liftS _liftS = new liftS();
  public static driveAuto driveOutOfCommunity = new driveAuto(tankDriveS, _intakeS, _liftS);
  public static balanceScoreAuto balanceScoreAuto = new balanceScoreAuto(tankDriveS, _intakeS, _liftS);
  public static XboxController ManipControl = new XboxController(1); 
  public static XboxController DriveControl = new XboxController(0);

 
  
  SendableChooser<Command> autoChooser = new SendableChooser<>();

  // Replace with CommandPS4Controller or CommandJoystick if needed
   //private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public robotContainer() {

   // SmartDashboard.putData(autoChooser);
   autoChooser.addOption("Balancing", balanceScoreAuto); 
   autoChooser.setDefaultOption("Move out of community", driveOutOfCommunity);
   SmartDashboard.putData(autoChooser);
       _intakeS.setDefaultCommand(new intakeC(_intakeS));
    tankDriveS.setDefaultCommand(new tankDriveC(tankDriveS));
    _liftS.setDefaultCommand(new liftC(_liftS));    
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    System.out.print("autonomous obtained");
    return autoChooser.getSelected();
  }

}
