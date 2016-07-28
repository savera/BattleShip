import javax.swing.JOptionPane;

public class BattleShip {

	public static void main(String[] args) {

		Board board = new Board();

		board.printBoard();

		board.placeShipsRandomly();

		while (board.isGameOver() == false) {
			
			String userShootingRow = JOptionPane.showInputDialog("Pick a row");

			String userShootingCol = JOptionPane.showInputDialog("Pick a col");

			int rowShotAt = Integer.parseInt(userShootingRow);

			int colShotAt = Integer.parseInt(userShootingCol);

			try{
			
			board.shootAt(rowShotAt, colShotAt);
			
			}catch(ArrayIndexOutOfBoundsException e){
				
				JOptionPane.showMessageDialog(null, "off the board");
				
			}

			System.out.println("\n");

			board.printBoard();

		}

	}
}
