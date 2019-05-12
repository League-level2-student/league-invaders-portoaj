import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyListener;

public class Rocketship extends GameObject{

		
		Rocketship(int _x, int _y, int _width, int _height) {
			super(_x, _y, _width, _height);
			x = _x;
			y = _y;
			width = _width;
			height = _height;
		}
		void update(int xSpeed, int ySpeed)
		{
			super.update();
			x += xSpeed;
			y += ySpeed;
		}
		void draw(Graphics g)
		{
			g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
		}
	}