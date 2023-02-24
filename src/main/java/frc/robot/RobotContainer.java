package frc.robot;

import frc.robot.subsystems.ClawSubsytem;
import frc.robot.commands.ManualClawCmd;
import frc.robot.commands.PneumaticsCmd;
import frc.robot.commands.RotateClawTo0DegCmd;
import frc.robot.commands.RotateClawTo90DegCmd;
import frc.robot.commands.RotateClawTo180DegCmd;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  
  //Variables
  private ClawSubsytem clawSubsytem = new ClawSubsytem();
  private XboxController xController = new XboxController(0);

  //Constructor
  public RobotContainer() {
    configureBindings();
  }

  //Buttons
  private void configureBindings() {
    new JoystickButton(xController, 1).onTrue(new PneumaticsCmd(clawSubsytem)); //Activates PneumaticsCmd when button 1 is pressed
    new JoystickButton(xController, 2).onTrue(new RotateClawTo0DegCmd(clawSubsytem)); //Rotates claw to 0 degrees, or default position, counter clockwise when button 2 pressed
    new JoystickButton(xController, 3).onTrue(new RotateClawTo90DegCmd(clawSubsytem)); //Rotates claw to 90 degrees when button 3 pressed
    new JoystickButton(xController, 4).onTrue(new RotateClawTo180DegCmd(clawSubsytem)); //Rotates claw to 180 degrees clockwise when button 4 pressed
    new JoystickButton(xController, 5).toggleOnTrue(new ManualClawCmd(clawSubsytem, () -> xController.getLeftY())); //Able to manually move claw with the Y axis of left joystick when button 5 pressed
    new JoystickButton(xController, 6).onTrue(new InstantCommand(() -> clawSubsytem.resetClawEnc())); //Reset ClawEnc when button 6 pressed
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
