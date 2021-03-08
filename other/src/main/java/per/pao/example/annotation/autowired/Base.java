package per.pao.example.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 藉由 constructor injection 的好處在於
 * 當 Other 有更多的衍生類別 對應在不同需求
 * 那他彈性會更好。
 */
public abstract class Base {

    private Other other;

    public Base(Other other) {
        this.other = other;
    }

    public abstract void printX();

    public void print() {
        other.print();
    }

//    @Autowired
//    public final void setOther(Other other){
//        this.other = other;
//    }

    @Component
    public static class A extends Base {

        @Autowired
        public A(Other other) {
            super(other);
        }

        @Override
        public void printX() {
            System.out.println("AAA");
            print();
            System.out.println("AAA");
        }
    }

}