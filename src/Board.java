
public class Board {

	Tile[][] tiles = new Tile[10][10];

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
	
	public void printBoard(){
		
		for (int i = 0; i < tiles.length; i++) {

			for (int j = 0; j < tiles.length; j++) {

				System.out.print(tiles[i][j].toString() + " ");
			}
			System.out.print("\n");

		}
		
	}

}
