import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	static final  int width = 500;
	static final int height = 800;
	GamePanel gp;
	LeagueInvaders()
	{
		frame = new JFrame();
		gp = new GamePanel();
	}
	void setup()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(gp);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		frame.addKeyListener(gp);
		
		gp.startGame();
	}
	public static void main(String [] args)
	{
		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
}
