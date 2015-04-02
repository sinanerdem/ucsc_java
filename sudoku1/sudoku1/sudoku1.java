package sudoku1;

import java.util.HashSet;
import java.util.Scanner;

public class sudoku1 {

	public static void main(String[] args) {
		
		int size = 0;
		int way = 0;
		int board[][];
		System.out.println("****** SUDOKU ******");
		System.out.println("Enter game size");
		System.out.println("1) 4x4");
		System.out.println("2) 9x9");
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
		    if(!scanner.hasNextInt() ) { 
		        System.out.println("please only enter 1 or 2: "); 
		        scanner.next(); // discard
		        continue;
		    } 
		    size=scanner.nextInt();
		    if( size!=2 && size!=1)
		    {
		        System.out.print("please only enter 1 or 2: ");
		        continue;
		    }
		    break;
		}
		size = (size == 1) ? 4 : 9;
		
		board = new int[size][size];
		
		System.out.println("Enter data by");
		System.out.println("1) Row");
		System.out.println("2) Column");
		
		while(true) {
		    if(!scanner.hasNextInt() ) { 
		        System.out.println("please only enter 1 or 2: "); 
		        scanner.next(); // discard
		        continue;
		    } 
		    way=scanner.nextInt();
		    if( way!=2 && way!=1)
		    {
		        System.out.print("please only enter 1 or 2: ");
		        continue;
		    }
		    break;
		}
		
		
		// this block gets data from user for each row or col, and validates
		for (int i=1;i<=size;i++){
	        while(true){
	        	System.out.println("Enter data for "+i);
		        String line;
		        String[] arrStr;
		        int[] arrInt = new int[size];
				line = scanner.next();
		        arrStr = line.split(",");
		        if(arrStr.length!=size){
		        	System.out.println("Please enter exactly "+size+" numbers per each input");
		        	i--;
		        	break;
		        }
		        int a;
		        int br = 0;
		        
		        // validation for each data entry
				for(int j=0;j<arrStr.length;j++){
					try{
						a=Integer.parseInt(arrStr[j]);
						arrInt[j]=a;
					}catch(NumberFormatException e){
						br = 0;
						System.out.println("Please enter data as x,y,z,... format and use integers");
						break;
					}
					if (a>0 && a<=size){
						br = 1;
						continue;
					} else{
						br = 0;
						System.out.println("Please use numbers less than or equal to board size");
						break;
					}
				}
				
				if (br == 1){
					if(way == 1){
						board[i-1]=arrInt;
					}else{
						for(int k=0;k<i;k++){
							board[k][i-1]=arrInt[k];
						}
					}
					
					// Output the current state of the board
					System.out.println("Your board:");
					for (int x=0;x<size;x++){
						for(int y=0;y<size;y++){
							System.out.print(board[x][y]);
						}
						System.out.println("");
					}
					
					break;
				}
				
			}
		}
		
		//Check if row numbers are unique
		int sudoku = 1;
		outerloop:
		for(int i=0;i<size;i++){
			HashSet<Integer> set = new HashSet<Integer>();
			for(int j=0;j<size;j++){
			    if(set.contains(board[i][j])) {
			    	sudoku = 0;
			    	break outerloop;
			    };
			    set.add(board[i][j]);
			    
			}
		}
		
		//Check if column numbers are unique
		outerloop2:
			for(int i=0;i<size;i++){
				HashSet<Integer> set = new HashSet<Integer>();
				for(int j=0;j<size;j++){
				    if(set.contains(board[j][i])) {
				    	sudoku = 0;
				    	break outerloop2;
				    };
				    set.add(board[j][i]);
				    
				}
			}
		
		//Print the verdict
		if (sudoku !=0){
			System.out.println("SUDOKU!");
		} else{
			System.out.println("No SUDOKU!");
		}
		
	}
}
