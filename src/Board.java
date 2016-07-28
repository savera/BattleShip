import java.util.ArrayList;
import java.util.Random;

public class Board {

	Tile[][] tiles = new Tile[10][10];

	boolean[][] tileIsHit = new boolean[10][10];

	int shotFired;

	int hitCount;

	int shipsSunk;

	Board() {

		for (int i = 0; i < tiles.length; i++) {

			for (int j = 0; j < tiles.length; j++) {

				tiles[i][j] = new Water();
			}

		}

	}

	public void printBoard() {

		for (int i = 0; i < tiles.length; i++) {

			for (int j = 0; j < tiles.length; j++) {

				if (tileIsHit[i][j] == true) {

					System.out.print(tiles[i][j].toString());
					
				} else {

					System.out.print(". ");

				}
			}

			System.out.print("\n");

		}

	}

	public boolean isOccupied(int i, int j) {

		Tile t = tiles[i][j];

		if (t instanceof Ship) {

			return true;

		} else {

			return false;

		}

	}

	public void shootAt(int i, int j) {

		Tile t = tiles[i][j];

		if (isOccupied(i, j)) {

			Ship s = (Ship) t;

			s.shootAt(i, j);

			hitCount += 1;

			if (s.isSunck()) {

				shipsSunk += 1;

			}
		}

		shotFired += 1;

		tileIsHit[i][j] = true;

	}

	public int getShotsFired() {

		return shotFired;

	}

	public int getHitCount() {

		return hitCount;

	}

	public int getShipsSunk() {

		return shipsSunk;

	}

	public boolean isGameOver() {

		if (getShipsSunk() == 10) {

			return true;

		} else {

			return false;
		}

	}

	public void placeShipsRandomly() {

		ArrayList<Ship> ships = new ArrayList<Ship>();

		ships.add(new BattleShipShip());

		ships.add(new Cruiser());
		ships.add(new Cruiser());

		ships.add(new Destroyer());
		ships.add(new Destroyer());
		ships.add(new Destroyer());

		ships.add(new Submarine());
		ships.add(new Submarine());
		ships.add(new Submarine());
		ships.add(new Submarine());

		Random random = new Random();

		for (int i = 0; i < ships.size(); i++) {

			int row = random.nextInt(10);

			int col = random.nextInt(10);

			boolean isHorizontal = random.nextBoolean();

			if (ships.get(i).okToPlaceShipAtLoc(row, col, isHorizontal, this)) {

				ships.get(i).placeShipAtLoc(row, col, isHorizontal, this);

			} else {

				i--;

			}

		}

	}

}
