import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
    
    // Swing components to be used
    private JFrame frame;
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel thirdLabel;
    private JLabel fourthLabel;

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
        this.firstString = strings.get(0);
        this.secondString = strings.get(1); 
        this.thirdString = strings.get(2);
        this.fourthString = strings.get(3);
    }

    private void setLabelText() {
        this.firstLabel = new JLabel(this.firstString, JLabel.LEFT);
        this.secondLabel = new JLabel(this.secondString, JLabel.LEFT);
        this.thirdLabel = new JLabel(this.thirdString, JLabel.LEFT);
        this.fourthLabel = new JLabel(this.fourthString, JLabel.LEFT);
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



    /**
     * createFrame initializes the JFrame that is going to be used
     * to display the strings we are using for the RLTyper
     * It creates the frame, and populates it with labels
     * @param frameTitle title of teh Frame that we are going to populate
     */
    public void initializeFrame(String frameTitle) {
       this.frame = new JFrame(frameTitle) ;
       this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       this.frame.setBounds(this.positionX, this.positionY, 20, 20);
       frame.setLayout(new GridLayout(4, 1));
       this.setLabelText();
       frame.add(firstLabel);
       frame.add(secondLabel);
       frame.add(thirdLabel);
       frame.add(fourthLabel);
       frame.pack();

    }

    public void showFrame() {
        this.frame.setVisible(true);
    }
    public void hideFrame() {this.frame.setVisible(false);}
}
