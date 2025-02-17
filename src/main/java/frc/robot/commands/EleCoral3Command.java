



package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.Robot;

public class EleCoral3Command extends Command{

    private final ElevatorSubsystem elevatorSubsystem;
    private final double desiredTicks3 = 126;
    double eleGo = Robot.elevatorSubsystem.eleTravel();

    public EleCoral3Command(ElevatorSubsystem elevatorSubsystem){
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(elevatorSubsystem);
    }


    
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        if(eleGo <= desiredTicks3){
            elevatorSubsystem.setMotor(.05);
         }
         else{
            elevatorSubsystem.setMotor(0);
         }
        
    }

    @Override
    public void end(boolean interrupted){
        elevatorSubsystem.setMotor(0);
    }

    @Override
    public boolean isFinished(){
        if(eleGo >= desiredTicks3){
            elevatorSubsystem.setMotor(0);
            return true;
        }
        else{
        return false;
        }
    }
}
