
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

				System.out.print(tiles[i][j].toString() + " ");
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
	
	public boolean isGameOver(){
		
		if(getShipsSunk() == 10){
			
			return true; 
			
		}else{
			
			return false; 
		}
		
	}

}
