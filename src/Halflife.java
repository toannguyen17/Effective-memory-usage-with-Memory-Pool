import java.util.ArrayList;
public class Halflife implements Game {
	private int countBullet;
	private BulletPool bulletPool;

	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	public Halflife(){
		countBullet = 1000;
	}

	@Override
	public void fire() {
		for (int i = 0; i < countBullet; i++) {
			Bullet bullet = new Bullet();
			bullet.setPosition(1);
			bullets.add(bullet);

			StringBuilder status = new StringBuilder();
			for (int j = 0; j < bullets.size(); j++){
				status.append("-" + (j+1));
				bullet = bullets.get(j);
				int position = bullet.getPosition();

				if (position > 9){
					bullets.remove(j);
				}else
					bullet.move();
			}
			System.out.println(status.toString());
		}
	}

	@Override
	public void firePool() {
		if (bulletPool == null){
			bulletPool = new BulletPool();
		}

		for (int i = 0; i < countBullet; i++) {
			Bullet bullet = bulletPool.create();
			bullet.setPosition(1);
			bullets.add(bullet);

			StringBuilder status = new StringBuilder();
			for (int j = 0; j < bullets.size(); j++){
				status.append("-" + (j+1));
				bullet = bullets.get(j);
				int position = bullet.getPosition();

				if (position > 9){
					bulletPool.add(bullets.remove(j));
				}else
					bullet.move();
			}

			System.out.println(status.toString());
		}
	}
}
