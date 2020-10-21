package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

public class AutonomousPeriodTest {
    private DcMotor motorFrontLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;

    private DcMotor armMotor;
    private Servo armServo;

    public AutonomousPeriodTest(DcMotor motorFrontLeft, DcMotor motorFrontRight, DcMotor motorBackLeft, DcMotor motorBackRight, DcMotor armMotor, Servo armServo) {
        this.motorFrontLeft = motorFrontLeft;
        this.motorFrontRight = motorFrontRight;
        this.motorBackLeft = motorBackLeft;
        this.motorBackRight = motorBackRight;
        this.armMotor = armMotor;
        this.armServo = armServo;
    }
    public void runOpMode() throws InterruptedException {
        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontLeft.setDirection(DcMotor.Direction.FORWARD);
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorBackLeft.setDirection(DcMotor.Direction.FORWARD);
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        motorBackRight.setDirection(DcMotor.Direction.REVERSE);
        armMotor = hardwareMap.dcMotor.get("armMotor");
        armMotor.setDirection(DcMotor.Direction.FORWARD);
        armServo = hardwareMap.servo.get("armServo");
    }

}
