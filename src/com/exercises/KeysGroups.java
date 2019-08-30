package com.exercises;

public class KeysGroups {
	
	public static void problem() {
		String palabra = "{}"; // 1
		//String palabra = "{{{}}}"; // 1 + 2 + 3 = 6
		//String palabra = "{{},{}}"; //1 + 2 + 2 = 5
		//String palabra = "{{{},{},{{}}}}"; //1 + 2 + 3 + 3 + 3 + 4 = 16
		//String palabra = "{<{},{},{{}}>}"; // 1
		//String palabra = "{{<ab>},{<ab>},{<ab>},{<ab>}}"; // 1 + 2 + 2 + 2 + 2 = 9
		//String palabra = "{{<a>},{<a>},{<a>},{<a>}}"; 1 + 2 + 2 + 2 + 2 = 9
		//String palabra = "{{<!>},{<!>},{<!>},{<a>}}"; 1 + 2 = 3
		//String palabra = "{{!!},{!!},{!!},{!!}}"; // 1 + 2 + 2 + 2 + 2
		//String palabra = "{{<a!>},{<a!>},{<a!>},{<ab>}}"; // 1 + 2 = 3
		
		
		int[] arreglo = new int[20];
		
		boolean captura = true;
		boolean signo_encontrado = false;
		
		int nivel = 1;
		char viejo = '{',nuevo = '0';
	    char[] caracteres = palabra.toCharArray();
	    int mayor_level = 0;
	    int sum_levels = 0;
	    
	    String cadena = "";
	    
	    arreglo[nivel]++;
	    
	    for (int i = 0; i < caracteres.length-1; i++) {
	    	if(captura) {
	    		if(viejo == '{' && nuevo == '}') {
		    		arreglo[nivel]++;
		    	} else if(viejo == '{' && nuevo == '{') {
		    		nivel++;
		    	} else if(viejo == '}' && nuevo == '}') {
		    		nivel--;
		    		arreglo[nivel]++;
		    	}	
	    	}
	    	
	    	if(nuevo == '<')
	    		captura = false;
	    	else if(nuevo == '>')
	    		captura = true;
	    		
	    	if(captura) {
	    		if(nuevo == '{' || nuevo == '}' || nuevo == ',')
		    		viejo = i > 0 ? nuevo : '{';	
	    	}
	    	
	    	if(i >= caracteres.length-1) break;
	    	
	    	nuevo = caracteres[i+1];
	    	
	    	if(nuevo == '!') {
	    		if(!signo_encontrado) {
	    			arreglo[nivel]--;
	    			signo_encontrado = true;
	    		} else if(nuevo == '!' && signo_encontrado == true) {
	    			arreglo[nivel]++;
	    			signo_encontrado = false;
	    		}
	    	} else {
	    		signo_encontrado = false;
	    	}
	    	
		    if(mayor_level < nivel)
		    	mayor_level = nivel;
	    }
	    
	    for(int j = 1; j<=mayor_level; j++) {
	    	for (int x = 1; x <= arreglo[j]; x++) {
	    		if(j == 1)
	    			cadena = Integer.toString(j);
	    		else
	    			cadena += " + " + Integer.toString(j);
	    		sum_levels+= j;
	    	}
	    }
	    
	    System.out.println(cadena + " = " + sum_levels);
	}
}