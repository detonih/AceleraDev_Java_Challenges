package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> fiboSequence = new ArrayList<Integer>();

		for(int i = 0; i <= 15; i++) {
			if(i == 0) {
				fiboSequence.add(i);
			} else if (i == 1) {
				fiboSequence.add(i);
			} else {

				for(int j = 0; j < fiboSequence.size(); j++) {
					if(fiboSequence.get(j) == 377) {
						return fiboSequence;
					}
				}
				fiboSequence.add((fiboSequence.get(i - 1)) + (fiboSequence.get(i - 2)));
			}
		}

		return fiboSequence;
	}

	public static Boolean isFibonacci(Integer a) {

		try {
			List<Integer> fiboSequence = fibonacci();
			for(int i = 0; i <= fiboSequence.size(); i++) {
				System.out.println(i);
				if(fiboSequence.get(i).equals(a)) {
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}