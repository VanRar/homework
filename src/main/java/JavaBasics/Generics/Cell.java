package JavaBasics.Generics;

public class Cell <T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
//По факту после уомпиляции будет так же как было до версии 1.5:

//public class Cell{
//    Object object;
//
//    public Object getT() {
//        return t;
//    }
//
//    public void setT(Object object) {
//        this.object = object;
//    }
//}