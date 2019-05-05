import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive;
	Rectangle collisionBox;
	GameObject(int _x, int _y, int _width, int _height)
	{
		isAlive = true;
		x = _x;
		y = _y;
		width = _width;
		height = _height;
		collisionBox = new Rectangle();
	}
	void update()
	{
		collisionBox.setBounds(x, y, width, height);
	}
	void draw(Graphics g)
	{
			
	}
}