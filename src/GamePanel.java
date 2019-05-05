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
	int xSpeed;
	int ySpeed;
	Timer timer;
	GameObject obj;
	ObjectManager om;
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
		om = new ObjectManager(rs);
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
		om.update(xSpeed, ySpeed);
		om.manageEnemies();
		om.checkCollision();
		om.purgeObjects();
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
		om.draw(g);
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
		if(e.getKeyCode() == 32)
		{
			om.addProjectile(new Projectile(rs.x + 20, rs.y, 10, 10));
		}
		if(e.getKeyChar() == 'a')
			xSpeed = -5;
		if(e.getKeyChar() == 'd')
			xSpeed = 5;
		if(e.getKeyChar() == 'w')
			ySpeed = -5;
		if(e.getKeyChar() == 's')
			ySpeed = 5;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'a')
			xSpeed = 0;
		if(e.getKeyChar() == 'd')
			xSpeed = 0;
		if(e.getKeyChar() == 'w')
			ySpeed = 0;
		if(e.getKeyChar() == 's')
			ySpeed = 0;
	}
}
