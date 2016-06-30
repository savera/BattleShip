
public class Water extends Tile {

	public boolean isHit(int c, int r) {

		if(startCol == c && startRow == r){
			
			return true; 
		}
		
		return false; 
		
	}
	
}
