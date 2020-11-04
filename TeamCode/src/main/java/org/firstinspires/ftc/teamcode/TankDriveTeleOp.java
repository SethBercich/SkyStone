package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TankDrive")
public class TankDriveTeleOp extends LinearOpMode {
    private DcMotor motorFrontLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;

    private DcMotor motorLaunch;
    private DcMotor motorIntake;

    private DcMotor armMotor;
    private Servo armServo;

    @Override
    public void runOpMode() throws InterruptedException {
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); motorFrontLeft.setDirection(DcMotor.Direction.FORWARD);
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft"); motorBackLeft.setDirection(DcMotor.Direction.FORWARD);
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); motorBackRight.setDirection(DcMotor.Direction.REVERSE);

        armMotor = hardwareMap.dcMotor.get("armMotor"); armMotor.setDirection(DcMotor.Direction.FORWARD);
        armServo = hardwareMap.servo.get("armServo");

        motorLaunch = hardwareMap.dcMotor.get("motorLaunch"); motorLaunch.setDirection(DcMotor.Direction.FORWARD);
        motorIntake = hardwareMap.dcMotor.get("motorIntake"); motorIntake.setDirection(DcMotor.Direction.FORWARD);

        armServo.setPosition(0);

        waitForStart();

        while(opModeIsActive()){
            motorFrontLeft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
            motorBackLeft.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x);
            motorFrontRight.setPower(gamepad1.right_stick_y - gamepad1.right_stick_x);
            motorBackRight.setPower(gamepad1.right_stick_y + gamepad1.right_stick_x);

            //Arm Stuff
            double motorValue = (gamepad2.left_stick_y*0.5);
            armMotor.setPower(motorValue);


            if(gamepad2.a) {
                armServo.setPosition(1);
            } else if(gamepad2.b) {
                armServo.setPosition(0);
            }

            //Shooter Stuff
            motorLaunch.setPower(gamepad2.right_trigger);
            motorIntake.setPower(gamepad2.right_stick_y);

            idle();
        }
    }
}
