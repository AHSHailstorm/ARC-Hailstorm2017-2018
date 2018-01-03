package org.firstinspires.ftc.teamcode;
       import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
       import com.qualcomm.robotcore.eventloop.opmode.Disabled;
       import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
       import com.qualcomm.robotcore.hardware.DcMotor;
       import com.qualcomm.robotcore.hardware.DcMotorController;
       import com.qualcomm.robotcore.util.ElapsedTime;

/**
* Created by sprou on 12/1/2017.
*/
@Autonomous(name="basicAuto", group="Autonomous")
public class BasicAuto extends LinearOpMode {

   private DcMotorController motorControllerP4;    // Motor Controller in port 1 of Core
   private DcMotorController motorControllerP5;    // Motor Controller in port 2 of Core
   private DcMotorController motorControllerP3;

   DcMotor motorRF;
   DcMotor motorRB;
   DcMotor motorLB;
   DcMotor motorLF;


   //DcMotor motor_arm;

   @Override
   public void runOpMode() throws InterruptedException {
            /* Initializing and mapping electronics*/
       motorControllerP4 = hardwareMap.dcMotorController.get("MCP4");
       motorControllerP5 = hardwareMap.dcMotorController.get("MCP5");
       motorControllerP3 = hardwareMap.dcMotorController.get("MCP3");

       telemetry.addData("Testing", "1");

       motorRF = hardwareMap.dcMotor.get("frontR");
       motorRB = hardwareMap.dcMotor.get("frontL");
       motorLB = hardwareMap.dcMotor.get("backR");
       motorLF = hardwareMap.dcMotor.get("backL");
       // motor_arm  = hardwareMap.dcMotor.get("Arm");

       telemetry.addData("Testing", "2");
       motorRF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       motorRB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       motorLB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       motorLF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       telemetry.addData("Testing", "3");

       waitForStart();

       telemetry.addData("Testing", "4");
       DriveFowardDistance(1, 1);
       DriveBackwardDistance(1, 1);
       TurnLeftDistance(1, 10);
       TurnRightDistance(1, 10);

   }
       //we're assuming the robot's already positioned facing in the appropriate direction
     /*  CloseArmDistance(we don't yet know the distance needed);*/

   public void DriveFoward(double power) {
       motorRF.setPower(power);
       motorRB.setPower(power);
       motorLB.setPower(power);
       motorLF.setPower(power);
   }

   public void DriveBackward(double power) {
       motorRF.setPower(-power);
       motorRB.setPower(power);
       motorLB.setPower(power);
       motorLF.setPower(-power);
   }

   public void TurnLeft(double power) {
       motorRF.setPower(-power);
       motorRB.setPower(-power);
       motorLB.setPower(power);
       motorLF.setPower(power);
   }

   public void TurnRight(double power) {
       motorRF.setPower(power);
       motorRB.setPower(power);
       motorLB.setPower(-power);
       motorLF.setPower(-power);
   }

   //public void CloseArm(double power)
   //{
   //motor_arm.setPower(power);//we MAY need to make this negative
   //}
   //public void OpenArm(double power)
   //{
   //motor_arm.setPower(-power);//we MAY need to make this positive
   //}
   public void DriveFowardDistance(double power, int distance) {
       motorRF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorRB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       motorRF.setTargetPosition(distance);
       motorRB.setTargetPosition(distance);
       motorLB.setTargetPosition(distance);
       motorLF.setTargetPosition(distance);

       motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       DriveFoward(power);

       while (motorLF.isBusy() && motorRF.isBusy() && motorRB.isBusy() && motorLB.isBusy()) {

       }
   }

   public void DriveBackwardDistance(double power, int distance) {
       motorRF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorRB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       motorRF.setTargetPosition(distance);
       motorRB.setTargetPosition(distance);
       motorLB.setTargetPosition(distance);
       motorLF.setTargetPosition(distance);

       motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       DriveBackward(power);

       while (motorLF.isBusy() && motorRF.isBusy() && motorRB.isBusy() && motorLB.isBusy()) {

       }
   }

   public void TurnLeftDistance(double power, int distance) {
       motorRF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorRB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       motorRF.setTargetPosition(distance);
       motorRB.setTargetPosition(distance);
       motorLB.setTargetPosition(distance);
       motorLF.setTargetPosition(distance);

       motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       TurnLeft(power);

       while (motorLF.isBusy() && motorRF.isBusy() && motorRB.isBusy() && motorLB.isBusy()) {

       }
   }

   public void TurnRightDistance(double power, int distance) {
       motorRF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorRB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motorLF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

       motorRF.setTargetPosition(distance);
       motorRB.setTargetPosition(distance);
       motorLB.setTargetPosition(distance);
       motorLF.setTargetPosition(distance);

       motorRF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorRB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motorLF.setMode(DcMotor.RunMode.RUN_TO_POSITION);

       TurnRight(power);

       while (motorLF.isBusy() && motorRF.isBusy() && motorRB.isBusy() && motorLB.isBusy()) {

       }

   }
   //public void OpenArmDistance(double power, int distance)//take note-you should never put >=full rotation
   //{
   //motor_arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

   //motor_arm.setTargetPosition(distance);

   //motor_arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

   //OpenArm(power);

   //while(motor_arm.isBusy())
   //{

   //}
   //}
   //public void CloseArmDistance(double power, int distance)//same goes as for above method
   //{
   //motor_arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

   //motor_arm.setTargetPosition(distance);

   //motor_arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

   //CloseArm(power);

   //while(motor_arm.isBusy())
   //{

   //}
   //}
   //@Override
}
