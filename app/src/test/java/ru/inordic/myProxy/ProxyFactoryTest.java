package ru.inordic.myProxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ProxyFactoryTest {

    static class ResultHolder {
        private String result;
        private String result2;
        public void setResult(String result) {
            this.result = result;
        }
    }

    interface MyInterface {
        Object extractResult(Object o);

        Object extractResult2(Object o);

        Object extractField2(Object o);
    }

    @Test
    void test() {
        ResultHolder resultHolder = new ResultHolder();
        resultHolder.setResult("привет");
        MyInterface myInterface = ProxyFactory.createProxy(MyInterface.class);
        Assertions.assertEquals("привет", myInterface.extractResult(resultHolder));

        Assertions.assertThrows(Exception.class, () -> myInterface.extractField2(resultHolder));

    }
}


