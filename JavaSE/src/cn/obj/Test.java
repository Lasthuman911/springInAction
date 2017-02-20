package cn.obj;

import java.util.HashMap;

/**
 * Created by admin on 2017/2/16.
 */
public class Test {
/*    public static void main(String[] args){
*//*        Test t1 = new Test();
        Test t2 = new Test();
        System.out.println(t1.equals(t2));
        System.out.println(t1==t2);
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
        System.out.println(t1);

*//**//*        Integer L1 = new Integer(19399);
        System.out.println(L1.hashCode());*//**//*
    }*/

    //重写Equals不重写HashCode
    static class Key {
        private Integer id;
        private String value;

        public Key(Integer id, String value) {
            super();
            this.id = id;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Key)) {
                return false;
            } else {
                return this.id.equals(((Key) o).id);
            }
        }
    }

    //重写Equals也重写HashCode
    static class Key_ {
        private Integer id;
        private String value;

        public Key_(Integer id, String value) {
            super();
            this.id = id;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Key_)) {
                return false;
            } else {
                return this.id.equals(((Key_) o).id);
            }
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

    }

    public static void main(String[] args) {
        //test hashcode
        HashMap<Object, String> values = new HashMap<Object, String>(5);
        Test.Key key1 = new Test.Key(1, "one");
        Test.Key key2 = new Test.Key(1, "one");
        System.out.println(key1.equals(key2));
        //System.out.println(key1 == key2);
        /*values.put(key1, "value 1");
        System.out.println(values.get(key2));

        Test.Key_ key_1 = new Test.Key_(1, "one");
        Test.Key_ key_2 = new Test.Key_(1, "two");
        System.out.println(key_1.equals(key_2));
        System.out.println(key_1 == key_2);
        values.put(key_1, "value 1");
        //values.put(key_1, "value 2");
        System.out.println(values.get(key_2));*/
    }
}
