import java.awt.*;
import java.awt.event.KeyEvent;
import com.ivan.xinput.XInputDevice;
import com.ivan.xinput.XInputDevice;


class StringSender extends Robot {
    private int sleepTime;

    public StringSender(int defaultSleepTime) throws AWTException {
        super();
        this.sleepTime = defaultSleepTime;
    }

    public StringSender() throws AWTException {
        this(0);
    }

     public int getSleepTime() {
        /**
         * Returns the time the the robot sleeps between sending characters, in ms
         */
        return this.sleepTime;
    }

    /**
     * Sets the time, in ms for the the robot to sleep in between typing characters
     * @param newSleepTime The amount of time you want the the robot to sleep
     *                     in between typing characters
     */
    public void setSleepTime(int newSleepTime) {

        this.sleepTime = newSleepTime;
    }

    /**
     * Uses the robot to type a string, and sleeps a certain amount between keypresses
     *
     * @param stringToType
     * @throws AWTException
     */
    public void typeString(String stringToType) throws AWTException {

        for (char ch : stringToType.toCharArray()) {
            int charToSend = KeyEvent.getExtendedKeyCodeForChar(ch);
            if (Character.isUpperCase(ch)) {
                this.keyPress(KeyEvent.VK_SHIFT);
            }
            this.keyPress(charToSend);
            this.keyRelease(charToSend);
            this.keyRelease(KeyEvent.VK_SHIFT);
            this.delay(getSleepTime());


        }
    }
}


public class ControllerInterface {
    /**
     * ControllerInterface uses JInput in order to find a valid controller,
     * and listens for D-pad input in order to send strings
     */

    // The rate at which JInput will listen for inputs
    private final int POLLING_RATE;
    private StringSender ss = new StringSender();


    // Set polling rate, if not specified default is 200ms
    public ControllerInterface(int POLLING_RATE) throws AWTException {
        this.POLLING_RATE = POLLING_RATE;
    }

    public ControllerInterface() throws AWTException {
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

    public void type(String messageToType) throws AWTException {
        ss.typeString(messageToType);
    }

}
