import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
		int x;
		int y;
		int width;
		int height;
		
		Rocketship(int _x, int _y, int _width, int _height) {
			super(_x, _y, _width, _height);
			x = _x;
			y = _y;
			width = _width;
			height = _height;
		}
		void update()
		{
			
		}
		void draw(Graphics g)
		{
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}