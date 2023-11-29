package org.alignment.level.orientation;


public interface OrientationListener {

    void onOrientationChanged(Orientation orientation, float pitch, float roll, float balance);

    void onCalibrationSaved(boolean success);

    void onCalibrationReset(boolean success);
}
