package education;

public class Wrong<T> {  //implements Throwable
    T ob;
    T[] nums;
    //static T ob2;

    Wrong(T[] o) {
        nums = o;
        //ob = new T();
        //nums = new T[];
    }

    /*static T getOb() {
        return ob;
    }*/
}
