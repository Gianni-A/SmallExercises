package com.exercises;

public class ChristmasTree {
	StringBuilder tree_drawed = new StringBuilder("");

	public StringBuilder tree(int numLevels) {
		int cont_spaces_star = numLevels - 1;
		int secuence = 1;
		
		//Draw spaces
		for(int i = 1; i<= numLevels; i++) {
			//Draw *
			addSpace(cont_spaces_star);
			addSymbol(secuence);
			cont_spaces_star--;
			secuence++;
			tree_drawed.append("\n");
		}
		return tree_drawed;
	}
	
	
	public void addSpace(int spaces) {
		for(int i = 1; i<=spaces; i++) {
			tree_drawed.append(" ");
		}
	}
	
	public void addSymbol(int secuences) {
		for(int i=1; i <= secuences; i++) {
			tree_drawed.append(" ");
			tree_drawed.append("*");
		}
	}
}
