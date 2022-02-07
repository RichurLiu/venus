package com.richur.venus.web.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainMethod {
    public static void main(String[] args) {
        TestMethodClassProxy proxy = new TestMethodClassProxy();
        TestMethodClass test = new TestMethodClass();
//        test.setId(10);
//        test.setName("wait");
        proxy.setTest(test);
        System.out.println(proxy.getId());
        System.out.println(proxy.getName());
    }
}

class TestMethodClassProxy {

    private TestMethodClass test;
    public int getId() {
        this.setTest(getTestMethodClassValue(this.test, "getId"));
        return this.test.getId();
    }

    public void setId(int id) {
        test.setId(id);
    }

    public String getName() {
        return test.getName();
    }

    public void setName(String name) {
        test.setName(name);
    }

    public TestMethodClass getTest() {
        return test;
    }

    public synchronized void setTest(TestMethodClass test) {
        this.test = test;
    }


    public TestMethodClass getTestMethodClassValue(TestMethodClass test, String methodName) {
        if(test == null) {
            TestMethodClass newTest = new TestMethodClass();
            newTest.setId(20);
            newTest.setName("running");
            return newTest;
        }

        try {
            Method method = TestMethodClass.class.getMethod(methodName, null);
            Object value = method.invoke(test, null);
            if(null == value) {
                TestMethodClass newTest = new TestMethodClass();
                newTest.setId(30);
                newTest.setName("success");
                return newTest;
            } else {
                return test;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        TestMethodClass newTest = new TestMethodClass();
        newTest.setId(40);
        newTest.setName("failed");
        return newTest;

    }
}

class TestMethodClass {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
