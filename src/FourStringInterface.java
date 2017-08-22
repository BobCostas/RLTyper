import java.util.ArrayList;

public class FourStringInterface {
    /**
     * A FourStringInterface is used to display 4 different strings
     *  It is positioned at the x and y values given in initialization,
     *  which can also be changed on the fly
     */
    public FourStringInterface(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public FourStringInterface() {
        this(0, 0);
    }

    private int positionX;
    private int positionY;
    // Strings that will be placed in the JLabels
    private String firstString;
    private String secondString;
    private String thirdString;
    private String fourthString;

    public void setPositionX(int newX) {
        this.positionX = newX;
    }

    public void setPositionY(int newY) {
        this.positionY = newY;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    /**
     *  Sets the strings that will be displayed. Typically these
     *  will be either the keys in our HashMaps (Directions) or
     *  the messages that are options to send
     * @param strings An arraylist of strings, each string will
     *                be placed in a JLabel for display
     */
    public void setStrings(ArrayList<String> strings) {

    }

    /**
     * Sets both the X and Y positions of the JFrame
     * @param newX The new X position on the screen for the JFrame
     * @param newY The new Y position on the screen for the JFrame
     */
    public void setPositions(int newX, int newY) {
        this.positionX = newX;
        this.positionY = newY;
    }
}
