import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Minesweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 400);

		MyPanel myPanel = new MyPanel();
		myFrame.add(myPanel);

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);

		myFrame.setVisible(true);
		
		int numberMines =0;
		Random generator = new Random();
		while(numberMines<10) //create the mines
		{				
			int col = generator.nextInt(9);
			int row = generator.nextInt(9);
			if(col>0 && row>0 && numberMines<10 && myPanel.colorArray[col][row].equals(Color.WHITE))
			{
				myPanel.colorArray[col][row]=Color.BLACK;
				numberMines++;
			}
		
			System.out.println(numberMines);
		}
	}
}
