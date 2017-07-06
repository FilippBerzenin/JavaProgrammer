package Lesson_6.Frame_1.adapter.math.v2.calc;


import Lesson_6.Frame_1.adapter.math.Arifmetika;
import Lesson_6.Frame_1.adapter.math.v1.calc.*;

public class adapter implements Lesson_6.Frame_1.adapter.math.v2.calc.Calculator {

    @Override
    	public int multiply(int a, int b) {
        		int summ = 0;
        		for(int i = 0; i<b; i++) {
            			summ += Arifmetika.summa(new int[] {summ,a});
            		}
        		return summ;
        	}

            	@Override
    	public int summa(int a, int b) {
        		return Arifmetika.summa(new int[] {a,b});
        	}
}
