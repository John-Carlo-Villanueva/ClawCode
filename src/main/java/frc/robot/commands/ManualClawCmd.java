package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class ManualClawCmd extends CommandBase{
    
    private ClawSubsytem clawSub;
    private DoubleSupplier clawSpeed;

    public ManualClawCmd(ClawSubsytem clawSub, DoubleSupplier clawSpeed){
        this.clawSub = clawSub;
        this.clawSpeed = clawSpeed;
        addRequirements(clawSub);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        double claw = clawSpeed.getAsDouble();
        clawSub.manualTurning(claw);
    }

    @Override
    public void end(boolean interrupted){
        clawSub.stopClaw();
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
