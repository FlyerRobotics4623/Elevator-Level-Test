



package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class EleRetractCommand extends Command{
private final ElevatorSubsystem elevatorSubsystem;
public EleRetractCommand(ElevatorSubsystem elevatorSubsystem){
    this.elevatorSubsystem = elevatorSubsystem;
    addRequirements(elevatorSubsystem);
}

@Override
public void initialize(){}

@Override
public void execute(){
    elevatorSubsystem.setMotor(-.1);
}

@Override
public void end(boolean interrupted){
    elevatorSubsystem.setMotor(0);
}
@Override
public boolean isFinished(){
    return false;
}
}
