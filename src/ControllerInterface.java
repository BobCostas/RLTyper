import java.awt.*;
import java.awt.event.KeyEvent;

public class ControllerInterface {
    /**
     * ControllerInterface uses JInput in order to find a valid controller,
     * and listens for D-pad input in order to send strings
      */

    // The rate at which JInput will listen for inputs
    private final int POLLING_RATE;
    private int sleepTime;

    // Set polling rate, if not specified default is 200ms
    public ControllerInterface(int POLLING_RATE) {
        this.POLLING_RATE = POLLING_RATE;
    }

    public ControllerInterface() {
        this.POLLING_RATE = 200;
    }

    // Getter for POLLING_RATE
    public int getPollingRate() {
        return this.POLLING_RATE;
    }

    public String setPollingRate() {
        return "You cannot change the polling rate once it" +
                "has been set.";
    }

    public int getSleepTime() {
        /**
         * Returns the time the robot sleeps between sending characters, in ms
         */
        return this.sleepTime;
    }

    public void setSleepTime(int newSleepTime) {
        /**
         * Sets the time, in ms for the robot to sleep in between typing characters
         */
        this.sleepTime = newSleepTime;
    }

    public void typeString(String stringToType) throws AWTException{
        Robot rob = new Robot();
        for (char ch : stringToType.toCharArray()) {
            rob.keyPress(KeyEvent.VK_);
            rob.delay(getSleepTime());


        }
    }
}
