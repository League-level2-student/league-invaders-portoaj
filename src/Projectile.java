import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int x;
	int y;
	int width;
	int height;
	int ySpeed;
	Projectile(int _x, int _y, int _width, int _height) {
		super(_x, _y, _width, _height);
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		ySpeed = 10;
	}
	void update()
	{
		super.update();
		y -= ySpeed;
		if(y < 0)
			isAlive = false;
	}
	void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
}
