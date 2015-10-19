package education;
// Lesson 1
public class Gen<T> {    //erasure  T extend String --> String
    T ob;    // T  type parameter

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println(ob.getClass().getName());
    }
}

class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb;
        iOb = new Gen<>(88);//Gen<> JDK 7 (88.0)

        iOb.showType();
        int v = iOb.getOb();//.intValue();
        //iOb = new Gen<Double>(42.0);
        System.out.println(v);
        System.out.println();

        Gen strOb = new Gen("some text");//Objact
        strOb.showType();
        String str = (String)strOb.getOb();
        System.out.println(str);
        //iOb = strOb;




// Lesson 10
        Gen raw = new Gen(new Double(42.0)); // make Object
        double d = (double) raw.getOb();
        System.out.println(d);
        strOb = raw;
        raw = iOb;

        Gen iob = new Gen(99);
        int y = (Integer) iob.getOb();
        System.out.println(iOb.getClass().getName());
        System.out.println(strOb.getClass().getName());
    }
}

