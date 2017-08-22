import java.awt.*;
import java.awt.event.KeyEvent;

import com.ivan.xinput.XInputDevice;
import com.ivan.xinput.XInputDevice14;
import com.ivan.xinput.exceptions.XInputNotLoadedException;



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
     *
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


public class ControllerInterface  {
    /**
     * ControllerInterface uses JInput in order to find a valid controller,
     * and listens for D-pad input in order to send strings
     */

    // The rate at which JInput will listen for inputs
    private int pollingRate;
    private StringSender ss = new StringSender();
    private int currentLevel = 0;


    // Set polling rate, if not specified default is 200ms
    public ControllerInterface(int POLLING_RATE) throws AWTException {
        this.pollingRate = POLLING_RATE;
    }

    public ControllerInterface() throws AWTException {
        this.pollingRate = 200;
    }

    // Getter for POLLING_RATE
    public int getPollingRate() {
        return this.pollingRate;
    }

    public void setPollingRate(int newPollingRate) {
        this.pollingRate = newPollingRate;
    }

    public void type(String messageToType) throws AWTException {
        ss.typeString(messageToType);
    }

    /**
     *
     * @return The XInput device found by JXInput
     * @throws XInputNotLoadedException
     */
    public XInputDevice getController() throws XInputNotLoadedException {
        return XInputDevice.getDeviceFor(0);
    }

    /**
     *
     * @param controller A controller device found by getController
     * @return The current state of the DPAD
     * @throws XInputNotLoadedException
     */
    public int getDpadState(XInputDevice controller) throws XInputNotLoadedException {
        return controller.getComponents().getAxes().dpad;
    }

    /**
     * The currentLevel determines whether or not the DPad has been pressed,
     * e.g. if the level is less than 4, you need to choose which Category you are
     * going to send a string from. If it's more than 4, you are choosing which
     * string to send from that category
     * @return The current level of the controller's DPad state
     */
    public int getCurentLevel() {
        return this.currentLevel;
    }

    public void setCurrentLevel (int newLevel) {
       this.currentLevel = newLevel;
    }

    /**
     *
     * @param level an integer denoting the current level of the DPad,
     *             if it's up, you send the first string, right, second, etc
     * @return the index of the string to send
     */
    public int calculateStringToSend(int level) {
        switch (level) {
            // up
            case 1:
                return 0;
            // right
            case 3:
                return 1;
            // down
            case 5:
                return 2;
            // left
            case 7:
                return 3;
            default:
                return 9;

        }
    }

}
