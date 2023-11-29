package org.alignment.level.orientation;


public enum Orientation {

    LANDING(1, 0),
    TOP(1, 0),
    RIGHT(1, 90),
    BOTTOM(-1, 180),
    LEFT(-1, -90);

    private int reverse;
    private int rotation;

    private Orientation(int reverse, int rotation) {
        this.reverse = reverse;
        this.rotation = rotation;
    }

    public int getReverse() {
        return reverse;
    }

    public int getRotation() {
        return rotation;
    }

    public boolean isLevel(float pitch, float roll, float balance, float sensibility) {
        if (sensibility < 0.2f) {
            //minimum sensibility for playing sound (play sound even if sensor sensibility is better)
            sensibility = 0.2f;
        }
        switch (this) {
            case BOTTOM:
            case TOP:
                return balance <= sensibility
                        && balance >= -sensibility;
            case LANDING:
                return roll <= sensibility
                        && roll >= -sensibility
                        && (Math.abs(pitch) <= sensibility
                        || Math.abs(pitch) >= 180 - sensibility);
            case LEFT:
            case RIGHT:
                return Math.abs(pitch) <= sensibility
                        || Math.abs(pitch) >= 180 - sensibility;
        }
        return false;
    }
}
