package com.exercises;

public class AlmostIncreasingSequence {
	
	//static int[] sequence = new int[]{1, 2, 3, 4, 3, 6};
	static int[] sequence = new int[]{10, 1, 2, 3, 4, 5};

	public static boolean problem() {
		boolean valid = true;
		boolean retroceso = false;
		int sequences = 1;
		int removing = 0;
		int indexRemov = -1;
		int init_number = sequence[sequences-1];
		int ahead_number = sequence[sequences];
		for(int i = 0; i< sequence.length-1; i++) {
			if(init_number < ahead_number) {
				if((i+1) == indexRemov) {
					init_number = sequence[i+2];
					i++;
				} else {
					init_number = sequence[i+1];
				}
				
				sequences++;
				if(sequences <= sequence.length-1)
					ahead_number = sequence[sequences];
			}
			else {
				removing++;
				if(init_number == ahead_number) {
					indexRemov = i+1;
				} else {
					indexRemov = i;	
				}
				if(i > 0) {
					retroceso = true;
					init_number = sequence[i-1];
					
					sequences--;
					if(sequences <= sequence.length-1)
						ahead_number = sequence[sequences];
				}
				else {
					sequences++;
					if(sequences <= sequence.length-1)
						ahead_number = sequence[sequences];
					
					init_number = sequence[i+1];
				}
				
				
				i = i == 0 ? i-1 : i-2;
			}
			
			if(removing > 1) {
				valid = false;
				break;
			}
			
			if(retroceso == true) {
				if(sequences >= sequence.length) break;
			} else {
				if(sequences >= sequence.length-1) break;
			}
		}
		return valid;
	}
	
}
