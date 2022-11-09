package moblima.view;
import moblima.model.Seat;

public class ListingView {
	/**
	 * Prints a specific Listing.
	 * @param cinema Cinema Listing is located at.
	 * @param time Time of Listing.
	 * @param is3D Whether the Listing is 3D or not.
	 */
	public void printListing(String cinema, String time, boolean is3D, boolean isPlatinum) {
		System.out.println("Cinema: Hall " + cinema);
		if(isPlatinum)
			System.out.println("(This Cinema is a Platinum Cinema.)");
		//System.out.println("Date: " + listing.getDate());
		System.out.println("Time: " + time);
		if(is3D) {
			System.out.println("3D? Yes");
		}
		else
			System.out.println("3D? No");
		
		
		
	}
	/**
	 * Prints basic information about a Listing.
	 * @param cinema
	 * @param time
	 * @param is3D
	 * @param isPlatinum
	 */
	public void printListingBasic(String cinema, String time, boolean is3D, boolean isPlatinum) {
		
		System.out.print(time);
		if(is3D)
			System.out.print(" |3D|");
		if(isPlatinum)
			System.out.print(" |Platinum|");
		System.out.print("\n");
		
	}
	/**
	 * Prints all seats for a current listing.
	 * @param seats
	 * @param row
	 * @param col
	 */
	public void printListingSeats(Seat[][] seats, int row, int col) {
		System.out.println("            SCREEN");
		System.out.println("   1 2 3 4 5 6 7 8 9 10");
		System.out.println("  ___________   ___________");
		for(int i = 0; i < row; i++) {
			System.out.print((i+1) + " |");
			for(int j = 0; j < col; j++) {
				if(seats[i][j].getBooked()) {
					System.out.print("X|");
				}
				else
					System.out.print("_|");
				if(j == 4) {
					System.out.print("   |");
				}
			}
			System.out.println();
		}
		System.out.println("Legend: ");
		System.out.println("|_| Seat Available");
		System.out.println("|X| Seat Taken");
	}
	
	
}
