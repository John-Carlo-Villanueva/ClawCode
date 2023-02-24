package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class ManualClawCmd extends CommandBase{
    
    //Variables
    private ClawSubsytem clawSub;
    private DoubleSupplier clawSpeed;

    //Constructor
    public ManualClawCmd(ClawSubsytem clawSub, DoubleSupplier clawSpeed){
        this.clawSub = clawSub;
        this.clawSpeed = clawSpeed;
        addRequirements(clawSub);
    }

    @Override
    public void initialize(){} //Starting action of ManualClawCmd

    @Override
    public void execute(){
        double claw = clawSpeed.getAsDouble();
        clawSub.manualTurning(claw);
    } //Middle action of ManualClawCmd 

    @Override
    public void end(boolean interrupted){
        clawSub.stopClaw();
    } //End action of ManualClawCmd

    @Override
    public boolean isFinished(){
        return false;
    } //Method to activate end method
}
