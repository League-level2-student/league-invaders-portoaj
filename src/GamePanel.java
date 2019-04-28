import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	GameObject obj;
	Font titleFont;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Rocketship rs;
	public GamePanel()
	{
		timer = new Timer(1000/60, this);
		obj = new GameObject(10, 10, 100, 100);
		titleFont = new Font("Arial",Font.PLAIN, 48);
		rs = new Rocketship(250, 700, 50, 50);
	}
	void startGame()
	{
		timer.start();
	}
	void updateMenuState()
	{
		
	}
	void updateGameState()
	{
		
	}
	void updateEndState()
	{
		
	}
	void drawMenuState(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("League Invaders", 50, 80);
	}
	void drawGameState(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
	}
	void drawEndState(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over :(", 50, 80);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		obj.update();
		repaint();
		if(currentState == MENU_STATE)
		{
			updateMenuState();
		}
		else if(currentState == GAME_STATE)
		{
			updateGameState();
		}
		else if(currentState == END_STATE)
		{
			updateEndState();
		}
	}
	@Override
	public void paintComponent(Graphics g)
	{
		obj.draw(g);
		if(currentState == MENU_STATE)
		{
			drawMenuState(g);
		}
		else if(currentState == GAME_STATE)
		{
			drawGameState(g);
		}
		else if(currentState == END_STATE)
		{
			drawEndState(g);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10)
		{
			currentState++;
			if(currentState > 2)
			{
				currentState = MENU_STATE;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
	}
}
