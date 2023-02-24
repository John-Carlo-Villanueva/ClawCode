package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class RotateClawTo0DegCmd extends CommandBase{

    //Variables
    private ClawSubsytem clawSub;
    
    //Constructor
    public RotateClawTo0DegCmd(ClawSubsytem clawSub){
        this.clawSub = clawSub;
        addRequirements(clawSub);
    }

    @Override
    public void initialize(){} //Starting action of RotateClawTo0DegCmd

    @Override
    public void execute(){
        clawSub.rotateTo0Deg();
    } //Middle action of RotateClawTo0DegCmd

    @Override
    public void end(boolean interrupted){
        clawSub.stopClaw();
    } //End action of RotateClawTo0DegCmd

    @Override
    public boolean isFinished(){
        return clawSub.getClawEnc() == 0;
    } //Method to activate end method
}
