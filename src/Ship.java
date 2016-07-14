
public abstract class Ship extends Tile {

	boolean horizontal;

	public int getStartCol() {

		return startCol;

	}

	public void setStartCol(int startX) {

		startCol = startX;

	}

	public int getStarRowl() {

		return startRow;

	}

	public void setStartRow(int startY) {

		startCol = startY;

	}

	public int getLength() {

		return startCol;

	}

	public void setLength(int shipLength) {

		startCol = shipLength;

	}

	public boolean getHorizantal() {

		return horizontal;

	}

	public void setHorizantal(boolean h) {

		horizontal = h;

	}

	public abstract void shipType();

	public boolean isSunck() {

		int allHit = 0;

		for (int i = 0; i < hits.length; i++) {

			if (hits[i] == true) {

				allHit = allHit + 1;

			}
		}
		if (allHit == length) {

			return true;
		}

		return false;

	}

	public boolean shootAt(int r, int c) {

		if (horizontal) {

			if (startRow == r) {

				if ((c - startCol) <= length && (c - startCol) > 0) {

					hits[(c - startCol)] = true;

					return true;

				} else {

					return false;

				}
			}
			
		} else if (!horizontal) {

			if (startCol == c) {

				if ((r - startRow) <= length && (r - startRow) > 0) {

					hits[(r - startRow)] = true;

					return true;

				} else {

					return false;

				}
			}
		}
		
		return false;
	}

	public boolean okToPlaceShipAtLoc(int i, int j, boolean isHorizontal, Board board) {

		if (isHorizontal) {

			for (int k = 0; k < length; k++) {

				i++;

				if (board.isOccupied(i, j)) {

					return false;

				}
			}

		} else {

			for (int k = 0; k < length; k++) {

				j++;

				if (board.isOccupied(i, j)) {

					return false;

				}
			}
		}

		return true;

	}

	public void placeShipAtLoc(int i, int j, boolean isHorizontal, Board board) {

		if (isHorizontal) {

			for (int k = 0; k < length; k++) {

				i++;

				board.tiles[i][j] = this;

			}

		} else {

			for (int k = 0; k < length; k++) {

				j++;

				board.tiles[i][j] = this;

			}
		}
		
		setStartRow(i); 
		
		setStartCol(j); 
		
		setHorizantal(isHorizontal); 
		
	}
}
