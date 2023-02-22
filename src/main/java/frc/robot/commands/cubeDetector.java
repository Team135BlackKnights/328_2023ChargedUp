package frc.robot.commands;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
public class cubeDetector {
    /* 

    private static final int CAMERA_WIDTH = 640;
    private static final int CAMERA_HEIGHT = 480;
    private static final int PURPLE_H_MIN = 110;
    private static final int PURPLE_H_MAX = 130;
    private static final int PURPLE_S_MIN = 50;
    private static final int PURPLE_S_MAX = 255;
    private static final int PURPLE_V_MIN = 50;
    private static final int PURPLE_V_MAX = 255;
    double seconds;

    public void detectCube() {
        
        // Create a new camera server instance        
        // Create a new USB camera and set its resolution
        UsbCamera camera = CameraServer.startAutomaticCapture();
        camera.setResolution(CAMERA_WIDTH, CAMERA_HEIGHT);
        
        // Create a new OpenCV video sink
        CvSink cvSink = CameraServer.getVideo();
        
        // Create a new OpenCV video source
        CvSource outputStream = CameraServer.putVideo("Cube Detector", CAMERA_WIDTH, CAMERA_HEIGHT);
        
        // Create a new Mat to hold the captured frame
        Mat mat = new Mat();
        
        // Continuously process frames from the camera
        while (!Thread.interrupted()) {
            
            // Capture a frame from the camera
            if (cvSink.grabFrame(mat) == 0) {
                // Error: no frame captured
                outputStream.notifyError(cvSink.getError());
                continue;
            }
            
            // Convert the captured frame to the HSV color space
            Mat hsvMat = new Mat();
            Imgproc.cvtColor(mat, hsvMat, Imgproc.COLOR_BGR2HSV);
            
            // Threshold the image to extract purple blobs
            Mat thresholdMat = new Mat();
            Core.inRange(hsvMat, new Scalar(PURPLE_H_MIN, PURPLE_S_MIN, PURPLE_V_MIN),
                    new Scalar(PURPLE_H_MAX, PURPLE_S_MAX, PURPLE_V_MAX), thresholdMat);
            
            // Find the contours in the thresholded image
            List<MatOfPoint> contoursMat = new List<MatOfPoint>;
            Imgproc.findContours(thresholdMat, contoursMat, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
            
            // Draw the contours on the original image
            Imgproc.drawContours(mat, contoursMat, -1, new Scalar(0, 255, 0), 2);
            
            // Update the output stream with the processed frame
            outputStream.putFrame(mat);
            
            // Check if any purple blobs were found
            if (contoursMat.size().height > 0) {
                // Purple blob detected
                SmartDashboard.putBoolean("Purple Blob Detected", true);
                moveMotors(x,y,.4);
                break; // Exit the while loop
            }
        }
        
        // Stop capturing frames from the camera
        cvSink.close();
        
        // Stop outputting frames to the video stream
        outputStream.close();
    }
    public void moveMotors(double x, double y, double maxSpeed) {
        // Calculate turn and drive speeds based on x and y values
        double turnSpeed = x / CAMERA_WIDTH * maxSpeed;
        double driveSpeed = -y / CAMERA_HEIGHT * maxSpeed;
        
        // Apply drive and turn speeds to motors
        tankDriveC.arcadeDrive(driveSpeed, turnSpeed);
    }
    */
}