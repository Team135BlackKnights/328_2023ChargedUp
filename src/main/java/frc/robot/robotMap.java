package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;

public interface robotMap {
    public interface drive {
        public final static int 
           FL_ID = 10,
           FR_ID = 11,
           BL_ID = 12,
           BR_ID = 13;
    }

        public interface intake {
            public final static int
          INTL_ID = 22,
          INTR_ID = 21,
          INTU_ID = 20;  
    }
    public interface lift {
            public final static int
            flipMotor_ID = 3;
    }
    public interface navX {
        public SPI.Port navXPort = SPI.Port.kMXP;
    }
}

