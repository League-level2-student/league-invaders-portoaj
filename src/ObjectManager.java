import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;

	int enemySpawnTime = 1000;
	Rocketship rs;
	ArrayList <Projectile> projectiles;
	ArrayList <Aliens> aliens;
	ObjectManager(Rocketship _rs)
	{
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Aliens>();
		rs = _rs;
	}
	void update(int xSpeed, int ySpeed)
	{
		rs.update(xSpeed, ySpeed);

		for(Projectile proj : projectiles)
		{
			proj.update();
		}
		for(Aliens alien : aliens)
		{
			alien.update();
		}
	}
	void draw(Graphics g)
	{
		rs.draw(g);
		for(Projectile proj : projectiles)
		{
			proj.draw(g);
		}
		for(Aliens alien : aliens)
		{
			alien.draw(g);
		}
	}
	public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Aliens(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

                	enemyTimer = System.currentTimeMillis();
        }
	}
	void addProjectile(Projectile proj)
	{
		projectiles.add(proj);
	}
	void addAlien(Aliens al)
	{
		aliens.add(al);
	}
	void purgeObjects()
	{
		for(int i = 0; i < projectiles.size(); i++)
		{
			if(!projectiles.get(i).isAlive)
			{
				projectiles.remove(i);
				i++;
			}
		}
		for(int i = 0; i < aliens.size(); i++)
		{
			if(!aliens.get(i).isAlive)
			{
				aliens.remove(i);
				i++;
			}
		}
		for(int i = 0; i < projectiles.size(); i++)
		{
			if(!projectiles.get(i).isAlive)
			{
				projectiles.remove(i);
				i++;
			}
		}
	}
	void checkCollision()
	{
		for(Aliens a: aliens)
		{
			if(rs.collisionBox.intersects(a.collisionBox))
			{
				rs.isAlive = false;
			}
		}
		for(Projectile p: projectiles)
		{
			for(Aliens a: aliens)
			{
				if(a.collisionBox.intersects(p.collisionBox))
				{
					a.isAlive = false;
					p.isAlive = false;
				}
			}
		}
	}
}
