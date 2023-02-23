package frc.robot.commands.Autos;
import javax.swing.text.Position;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.liftS;


public class flipDown extends CommandBase {
    
    public final liftS Drop;

    public flipDown(liftS subsystem){
        Drop = subsystem;
        addRequirements(subsystem);
    }   
    @Override
    public void initialize() {
        System.out.println("initializing flipDown");
    }
    public void execute() {
        System.out.println("running TurnAuto");
        if(Drop.flipMotorEncoder.getPosition() == 300 ) {
            Drop.moveLift(0.5);
        }
        else{
            end();
        }
    } 
    public void end() {
        Drop.moveLift(0.0);
    }
}

