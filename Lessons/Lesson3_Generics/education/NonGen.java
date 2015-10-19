package education;
// Lesson 2   root
public class NonGen {
    Object ob;

    NonGen(Object o) {
        ob = o;
    }

    Object getOb() {
        return ob;
    }

    void showType() {
        System.out.println(ob.getClass().getName());
    }
}

class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb;
        iOb = new NonGen(88);
        iOb.showType();
        int v = (Integer)iOb.getOb();
        iOb = new NonGen(42.0);
        System.out.println(v);
        System.out.println(iOb);

        NonGen strOb = new NonGen("text without generic");
        strOb.showType();
        String str = (String)strOb.getOb();
        System.out.println(str);
        iOb = strOb;
        System.out.println(iOb.getOb());
        //v = (Integer)iOb.getOb();
    }
}
