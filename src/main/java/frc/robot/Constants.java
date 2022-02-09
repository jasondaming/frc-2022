package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class Constants {
  public static final class DrivetrainConstants {
    //motors
    public static final int[] 
      motorLeftPort = new int[] { 2, 3 },
      motorRightPort = new int[] { 0, 1 };

    public static final boolean[] 
      isMotorsInverted = new boolean[] { false, true };

    //encoders
    public static final int[] 
      encoderLeftPort = new int[] { 8, 9 },
      encoderRightPort = new int[] { 6, 7 };

    public static final boolean[] 
      isEncodersInverted = new boolean[] { true, true };
    
    public static final int
      pulsesPerRotation = 500, 
			cyclesPerRevolution = pulsesPerRotation * 4;  

    //chassi
		public static final int 
      wheelRadius = 2;

    //voltageConstraint
		public static final double 
      ksVolts = 0.9877, //kS
      kvVoltSecondsPerMeter = 2.6644, //kV
      kaVoltSecondsSquaredPerMeter = 0.42031, //kA
      kTrackwidthMeters = 0.665,
      differentialDriveVoltageConstraintMaxVoltage = 7;

    public static final DifferentialDriveKinematics
      kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);

    public static final class PID {
      public static final double 
        kPDriveVelocity = 3.8537,
        kIDriveVelocity = 0,
        kDDriveVelocity = 0;   
      
    }
  }

    public static final class OIConstants {
		  public static final int
		  	driverControllerPort = 0,
		  	operatorControllerPort = 1;
	  }

    public static final class AutoConstants {
      public static final double 
        kMaxSpeedMetersPerSecond = 2,
        kMaxAccelerationMetersPerSecondSquared = 2,
        kRamseteB = 2,
        kRamseteZeta = 0.7;
    }
  
}