package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    public boolean isAbundantNumber(int number){
        if(number<0){
            throw new IllegalArgumentException("Number must be positive: "+number);
        }
        if(number<2){
            return false;
        }
        Set<Integer> dividers=dividers(number);
        return sumOfNumbers(dividers)>number;
    }

    private int sumOfNumbers(Set<Integer> numbers) {
        return numbers.stream().mapToInt(x->x.intValue()).sum();
    }

    private Set<Integer> dividers(int number) {
        Set<Integer> output=new HashSet<>();
        output.add(1);
        for (int i = 2; i <Math.sqrt(number); i++) {
            if(number%i==0){
                output.add(i);
                output.add(number/i);
            }
        }
        return output;
    }
}
