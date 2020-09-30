package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "Test Program")
public class TeleOpTest extends LinearOpMode {
    private DcMotor motorFrontLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;

    @Override
    public void runOpMode() throws InterruptedException {
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); motorFrontLeft.setDirection(DcMotor.Direction.FORWARD);
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft"); motorBackLeft.setDirection(DcMotor.Direction.FORWARD);
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); motorBackRight.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()){
            motorFrontLeft.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x);
            motorBackLeft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x);
            motorFrontRight.setPower(gamepad1.right_stick_y + gamepad1.right_stick_x);
            motorBackRight.setPower(gamepad1.right_stick_y - gamepad1.right_stick_x);
            idle();
        }
    }
}
