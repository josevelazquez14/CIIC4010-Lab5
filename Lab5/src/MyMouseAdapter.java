import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private int numberFlags =0;

public void mineGenerator()
{
	
}
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		
		
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			
			
			myPanel.repaint();
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
										
			myPanel.repaint();
			
			break;
		
		
		case 3:		//Right mouse button
			Component comp = e.getComponent();
			while (!(comp instanceof JFrame)) {
				comp = comp.getParent();
				if (comp == null) {
					return;
				}
			}
			JFrame frame = (JFrame) comp;
			MyPanel panel = (MyPanel) frame.getContentPane().getComponent(0);
			Insets insets = frame.getInsets();
			int x2 = insets.right;
			int y2 = insets.top;
			e.translatePoint(-x2, -y2);
			int a = e.getX();
			int b = e.getY();
			panel.x = a;
			panel.y = b;
			panel.mouseDownGridX = panel.getGridX(a, b);
			panel.mouseDownGridY = panel.getGridY(a, b);
			panel.repaint();
			break;
		
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	
	
	public void mouseReleased(MouseEvent e) {	

		
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			
			
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							//On the left column and on the top row... do nothing
						} else {
							//On the grid other than on the left column and on the top row:
						
							
							
							for(int i=0; i<10; i++)
								
							{
								for(int j=0; j<10; j++)
								{
									if(position[i][j] == "bomb")
									{
										System.out.println("Bomb 1 at position [j++][i++]");
									}
								}
							}
							
							
							if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.WHITE))
							{
								
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.GRAY;
								if((myPanel.mouseDownGridX)<9)
								{
									if(myPanel.colorArray[myPanel.mouseDownGridX+1][myPanel.mouseDownGridY].equals(Color.BLACK)) 								
									{ 
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									}
								}
								
								if(myPanel.colorArray[myPanel.mouseDownGridX-1][myPanel.mouseDownGridY].equals(Color.BLACK)) 								
								{
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									
								}
								
								if((myPanel.mouseDownGridX)<9)
								{	
									if(myPanel.colorArray[myPanel.mouseDownGridX+1][myPanel.mouseDownGridY+1].equals(Color.BLACK))
									{ 
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									}
								}
								
								if(myPanel.colorArray[myPanel.mouseDownGridX-1][myPanel.mouseDownGridY+1].equals(Color.BLACK))
								{
									
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									
								}
								
								if(myPanel.colorArray[myPanel.mouseDownGridX-1][myPanel.mouseDownGridY-1].equals(Color.BLACK)) 								
								{
									
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									
								}
							if((myPanel.mouseDownGridX)<9)
								{	
									if(myPanel.colorArray[myPanel.mouseDownGridX+1][myPanel.mouseDownGridY-1].equals(Color.BLACK)) 								
									{ //bug in the last col
									
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									}
								}	
								
								if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY+1].equals(Color.BLACK)) 								
								{
									if((myPanel.mouseDownGridX+1)<10)
									{
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									}
								}
								
								if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY-1].equals(Color.BLACK)) 								
								{	
									if((myPanel.mouseDownGridX+1)<=9)
									{
										myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.YELLOW;
									}
								}
							}
							
							
					
						
							myPanel.repaint();
						}
					}
				}
			}
			myPanel.repaint();
			break;
		
			
		case 3:		//Right mouse button
			
			Component comp = e.getComponent();
			while (!(comp instanceof JFrame)) 
			{
				comp = comp.getParent();
				if (comp == null) {
					//return;
					}
			}
				JFrame frame = (JFrame)comp;
				MyPanel panel = (MyPanel) frame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
				Insets insets = frame.getInsets();
				int x2 = insets.right;
				int y2 = insets.top;
				e.translatePoint(-x2, -y2);
				int a = e.getX();
				int b = e.getY();
				panel.x = a;
				panel.y = b;
				int gridX1 = panel.getGridX(a, b);
				int gridY1 = panel.getGridY(a, b);
				
				
				if ((panel.mouseDownGridX == -1) || (panel.mouseDownGridY == -1)) {
					//Had pressed outside
					//Do nothing
					
				} else {
					if ((gridX1 == -1) || (gridY1 == -1)) {
						//Is releasing outside
						//Do nothing
						
					} else {
						if ((panel.mouseDownGridX != gridX1) || (panel.mouseDownGridY != gridY1)) {
							//Released the mouse button on a different cell where it was pressed
							//Do nothing
							
						} else {
							//Released the mouse button on the same cell where it was pressed
							if ((gridX1 == 0) || (gridY1 == 0)) {
								//On the left column and on the top row... do nothing
								
							} else {
								//On the grid other than on the left column and on the top row:
																
								if((panel.colorArray[panel.mouseDownGridX][panel.mouseDownGridY].equals(Color.WHITE)) && (numberFlags<10))
								{
																		
									panel.colorArray[panel.mouseDownGridX][panel.mouseDownGridY] = Color.RED;	
																		
										numberFlags++;
										System.out.println(numberFlags);
																	
								}
								
								else{
									if(panel.colorArray[panel.mouseDownGridX][panel.mouseDownGridY].equals(Color.RED)){
										panel.colorArray[panel.mouseDownGridX][panel.mouseDownGridY] = Color.WHITE;
										numberFlags-=1;
										System.out.println(numberFlags);
										}
									}
								
								panel.repaint();
																
							}
						}
					}
				}
			
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}