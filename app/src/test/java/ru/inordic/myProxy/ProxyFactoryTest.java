package ru.inordic.myProxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class  ProxyFactoryTest {

    @Test
    void test() {
        ResultHolder resultHolder = new ResultHolder();
        resultHolder.setResult("привет");
        MyInterface myInterface = ProxyFactory.createProxy(MyInterface.class);
        Assertions.assertEquals("привет", myInterface.extractResult(resultHolder));
    }

}






//    static class ResultHolder {
//        private String result;
//
//        public void setResult(String result) {
//            this.result = result;
//        }
//    }

//    interface MyExtractor {
//        Object extractResult(Object o);
//
//        Object extractField2(Object o);
//    }




//        Assertions.assertThrows(Exception.class, () -> myInterface.extractField2(resultHolder));
