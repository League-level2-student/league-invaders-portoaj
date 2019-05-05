import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Aliens extends GameObject{
	Random rand;
int x;
int y;
 int width;
 int height;
	Aliens(int _x, int _y, int _width, int _height) {
		super(_x, _y, _width, _height);
		// TODO Auto-generated constructor stub
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		rand = new Random();
	}
	void update()
	{
		super.update();
		x += rand.nextInt(20) - 10;
		y += rand.nextInt(2);
	}
	void draw(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}

}
