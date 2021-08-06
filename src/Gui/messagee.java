package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;


import game.entities.sportsman.WinterSportsman;
/**
 * created by:
 * Eden David 319082327
 * Yael Buisine 341353787
 */

/** We use this class to print a message if a competitor is injured
 **/


public class messagee {

	private JOptionPane pane;

    private JDialog dialog;

    private Timer t;
    private WinterSportsman sports;
     


     

    private ActionListener closeJDialog = new ActionListener() {

	 public void actionPerformed(ActionEvent e) {

            if (dialog.isShowing()) {
                dialog.dispose();
            }

        }

    };

    public messagee(WinterSportsman c) {
    	sports=c;
        t = new Timer(1500, closeJDialog);

        t.start();

        pane = new JOptionPane("Competitor " + sports.getNumberCount() +" " +sports.getName()+ " is injured!");

        dialog = pane.createDialog("Message");

        dialog.setVisible(true);

    }

    public static void main(String[] args) {


    }
}
