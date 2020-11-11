package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Forward", group="Linear Opmode")
//Disabled

public class Forward extends Movement {
    private ElapsedTime runtime = new ElapsedTime();


    @Override public void runOpModeImpl() {

        waitForStart();
        runtime.reset();



        strafeRight(0.5, 500);

        //drive backward
        goBackward(0.5, 1800);



        //stop motors
        stopWithSleep("motors stopped",300);

        //drive forward
        goForward(0.5,2250);



        //stop motors
        stopWithSleep("motors stopped",300);

        goForward(1,10);


        //strafe to the left (maybe park under the bridge)
        strafeLeft(1,2250);

        telemetry.addData("Status", "Stop Program");
        telemetry.update();



    }
}
