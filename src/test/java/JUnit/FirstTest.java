package JUnit;

import org.junit.jupiter.api.Test;

public class FirstTest {

    @Test // if we don't mention @test then we don't have run button, or it will not execute  method when we execute class
    //<Access modifier> <returnType> methodName(arg1,arg2...){}
    // Junit Doesn't require access So we can ignore (It does not allow to add access modifier to mention)
    void firstMethod(){
        System.out.println("FirstTest method executed");
    }

}
