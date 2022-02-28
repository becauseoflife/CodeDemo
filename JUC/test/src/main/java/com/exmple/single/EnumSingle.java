package com.exmple.single;

import java.lang.reflect.Constructor;

public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws Exception {   // Cannot reflectively create enum objects
        EnumSingle enumSingle1 = EnumSingle.INSTANCE;
        EnumSingle enumSingle2 = EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle3 = declaredConstructor.newInstance();

        System.out.println(enumSingle1);
        System.out.println(enumSingle2);
        System.out.println(enumSingle3);
    }
}
