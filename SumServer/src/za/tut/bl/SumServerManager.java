
package za.tut.bl;


public class SumServerManager implements ServerManagerInterface {

    @Override
    public Integer add(Integer num1, Integer num2) {
        Integer sum=num1+num2;
        return sum;
    }

    @Override
    public Integer substract(Integer num1, Integer num2) {
        Integer difference=num1-num2;
        return difference;
    }

    @Override
    public Integer Multiply(Integer num1, Integer num2) {
        Integer product=num1*num2;
        return product;
    }
    
}
