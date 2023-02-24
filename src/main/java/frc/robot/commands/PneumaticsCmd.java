package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class PneumaticsCmd extends CommandBase{
    
    //Variables
    private ClawSubsytem clawSub;

    //Constructor
    public PneumaticsCmd(ClawSubsytem clawSub){
        this.clawSub = clawSub;
    }

    @Override
    public void initialize(){
        clawSub.toggle();
    } //Starting action of PneumaticsCmd

    @Override
    public void execute(){} //Middle action of PneumaticsCmd

    @Override
    public void end(boolean interrupted){} //End action of PneumaticsCmd

    @Override
    public boolean isFinished(){
        return true;
    } //Method to activate end method
}
