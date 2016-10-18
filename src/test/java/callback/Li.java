package callback;

import loader.FileSystemClassLoader;

import java.lang.reflect.Method;

public class Li {
    /** 
     * 相当于B类有参数为CallBack callBack的f()---->背景三
     */  
    public void executeMessage(CallBack callBack, String question){  
        System.out.println("小王问的问题--->" + question);
        //模拟小李办自己的事情需要很长时间  
        for(int i=0; i<10000;i++){ }
        String result = "答案是2";
        /** 
         * 于是就打电话告诉小王，调用小王中的方法 
         * 这就相当于B类反过来调用A的方法D 
         */  
        callBack.solve(result);
    }


    public static void main(String[] args) {
        String classDataRootPath = "D:";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "loader.Sample";
        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();
            System.out.println(class1.getClassLoader());
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}  