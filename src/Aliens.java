import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Aliens extends GameObject{
	Random rand;

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
		x += rand.nextInt(21) - 10;
		y += rand.nextInt(2);
	}
	void draw(Graphics g)
	{
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}

}
