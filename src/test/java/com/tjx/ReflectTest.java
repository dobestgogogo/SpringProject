package com.tjx;

import com.tjx.bean.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {

    public static void main(String[] args) {
        /**
         * 在运行时期获取对象类型信息的操作。
         * 创建student类的实例
         *  Student student=new Student();
         * 01.先加载类中所有static修饰的内容（属性，方法，代码块，类）
         * 02.加载类中所有的代码块，顺序就是书写的顺序
         * 03.执行构造方法
         *
         * 哪怕main方法中什么都没有，执行之后，静态代码块还是要执行
         */
    }
        /**
         * 获取Student类的完整限定名==》全类名
         * 01.Class.forName(类的完整限定名)  来加载类   （常用）
         * 02.Student.class  任何类名.class都是获取了Class类
         * 03.new Student().getClass()  任何对象.getClass()都是获取了Class类
         */

        @Test
        public  void testOne(){
            try {
                /**
                 * .class其实是在java运行时就加载进去的  在Java中表示一个特定类型的类型类可以用“类型.class”的方式获得
                 * 类型类是一一对应的，父类的类型类和子类的类型类是不同的
                 * getClass()是运行程序时动态加载的 获得一个类型类(一个类型的类)，都是Class类的实例
                 *
                 * 如果你知道一个实例，那么你可以通过实例的“.getClass()”方法获得该对象的类型类 动态加载
                 * 如果你知道一个类型，那么你可以使用“.class”的方法获得该类型的类型类 静态加载
                 *
                 * new ClassName()，就是所谓的静态加载，
                 *Class.forName("ClassName")，就是所谓的动态加载。
                 *区别在于“静态加载”的类在编译的时候就要提供，而动态加载的类在源程序编译时可以缺席。
                 */
                System.out.println(Class.forName("com.tjx.bean.User"));
                System.out.println("Class："+User.class.getName());
                System.out.println("GetClass："+new User().getClass().getName());
                System.out.println(new User().getClass()==User.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        /**
         * 获取包名 类名和访问修饰符
         */
        @Test
        public void testTwo(){
            try {
                Class c = Class.forName("com.tjx.bean.User");
                System.out.println("包名："+c.getPackage().getName());
                System.out.println("全类名："+c.getName());
                System.out.println("简写类名："+c.getSimpleName());
                //获取类的访问修饰符
                int num = c.getModifiers();
                System.out.println("public访问修饰符对应的数字："+num);
                /**
                 * PUBLIC: 1
                 *PRIVATE: 2
                 *PROTECTED: 4
                 *STATIC: 8
                 *FINAL: 16
                 *SYNCHRONIZED: 32
                 *VOLATILE: 64
                 *TRANSIENT: 128
                 *NATIVE: 256
                 *INTERFACE: 512
                 *ABSTRACT: 1024
                 *STRICT: 2048
                 */
                System.out.println(Modifier.toString(num));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    /**
     * 获取类中所有的属性相关信息
     */
    @Test
    public void testThree(){
        try {
            Class c = Class.forName("com.tjx.bean.User");
            // Field[] fields = c.getFields();public修饰的字段
            //获取所有的字段
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i <fields.length ; i++) {
                System.out.println(fields[i]);
            }
            System.out.println("*******************");
            //获取所有字段的访问修饰符
            for (int i = 0; i < fields.length; i++) {
                System.out.println(Modifier.toString(fields[i].getModifiers()));
                System.out.println(fields[i].getModifiers());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类中所有的方法相关信息    不包含构造方法
     *  01.c.getMethod(方法名称，参数类型)  只能是public修饰的
     *  02.c.getMethods() 只能是public修饰的
     *  03.c.getDeclaredMethods() 所有
     */
    @Test
    public void testFour(){
        try {
            Class c = Class.forName("com.tjx.bean.User");
            Method[] methods = c.getDeclaredMethods();//获取所有包含private
            for (int i = 0; i < methods.length; i++) {
                System.out.println("方法名："+methods[i].getName());
                System.out.println("方法修饰符数值："+methods[i].getModifiers());
                System.out.println("方法修饰符："+Modifier.toString(methods[i].getModifiers()));
                System.out.println("方法返回值类型"+methods[i].getReturnType());
                System.out.println("*********************************");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取类中所有的构造方法方法相关信息
     */
    @Test
    public void testFive(){
        try {
            Class c = Class.forName("com.tjx.bean.User");
            Constructor[] constructors = c.getDeclaredConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println("构造方法名："+constructors[i].getName());
                System.out.println("构造方法修饰符："+Modifier.toString(constructors[i].getModifiers()));
                System.out.println("构造方法修饰符数值："+constructors[i].getModifiers());
                System.out.println("构造方法参数个数是："+constructors[i].getParameterCount());
                System.out.println("********************************");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 访问类中私有的属性和方法并且让它执行
     */
    @Test
    public void testSix(){
        try {
            Class c = Class.forName("com.tjx.bean.User");
            User user = (User) c.newInstance();//实例化
            Field userName = c.getDeclaredField("userName");//获取私有字段
            System.out.println("字段名称："+ userName.getName());
            //获取私有方法
            Method getSum = c.getDeclaredMethod("getSum", double.class);
            getSum.setAccessible(true);//去除私有性
            //invoke(class, method)  调用类中的方法
            double result = (double) getSum.invoke(user,50.5);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
