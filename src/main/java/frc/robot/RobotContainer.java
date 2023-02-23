package frc.robot;

import frc.robot.subsystems.ClawSubsytem;
import frc.robot.commands.ManualClawCmd;
import frc.robot.commands.PneumaticsCmd;
import frc.robot.commands.RotateClawTo0DegCmd;
import frc.robot.commands.RotateClawTo90DegCmd;
import frc.robot.commands.RotateClawTo180DegCmd;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  
  private ClawSubsytem clawSubsytem = new ClawSubsytem();
  private XboxController xController = new XboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(xController, 1).onTrue(new PneumaticsCmd(clawSubsytem));
    new JoystickButton(xController, 2).onTrue(new RotateClawTo0DegCmd(clawSubsytem));
    new JoystickButton(xController, 3).onTrue(new RotateClawTo90DegCmd(clawSubsytem));
    new JoystickButton(xController, 4).onTrue(new RotateClawTo180DegCmd(clawSubsytem));
    new JoystickButton(xController, 5).toggleOnTrue(new ManualClawCmd(clawSubsytem, () -> xController.getLeftY()));
  }
  public Command getAutonomousCommand() {
    return null;
  }
}
