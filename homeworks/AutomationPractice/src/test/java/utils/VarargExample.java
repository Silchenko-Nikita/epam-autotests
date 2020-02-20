package utils;

public class VarargExample {

    public int sumNumber(int ... args){
        int sum = 0;
        for(int x: args){
            sum += x;
        }
        return sum;
    }
}
