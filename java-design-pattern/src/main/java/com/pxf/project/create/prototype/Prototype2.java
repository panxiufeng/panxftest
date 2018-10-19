package com.pxf.project.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype2  implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject obj;

    /* 浅复制 */
    public Object clone() throws CloneNotSupportedException {
        Prototype2 proto = (Prototype2) super.clone();

//        //在深入复制内部的引用对象，否则obj 就是浅复制，会随着修改而修改 ；还有一种深拷贝方法，就是将对象串行化
//        proto.obj = (SerializableObject)obj.clone();
        return proto;
    }

    /* 深复制  将对象串行化 */
    public Object deepClone() throws IOException, ClassNotFoundException {

        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }


    public static void main(String[] args) {

        Prototype2 prototype2 = new Prototype2();
        prototype2.setString("aaaaaaaaaaaaa");
        SerializableObject serializableObject = new SerializableObject();
        serializableObject.setName("zhagnsan");
        serializableObject.setAge(25);
        prototype2.setObj(serializableObject);
        try {
//            Prototype2 obj =  (Prototype2)prototype2.deepClone();
            Prototype2 obj =  (Prototype2)prototype2.clone();
            System.out.println("--------->"+prototype2.getString());
            obj.setString("bbbbbbbbbbbb");
            System.out.println("--------->"+obj.getString());
            System.out.println("--------->"+prototype2.getString());

            //引用对象在浅复制后，会随着修改而修改 ，除非在cloone()中再深入复制引用对象
            SerializableObject serializableObject2 = obj.getObj();
            serializableObject2.setName("lisi");
            serializableObject2.setAge(28);
            System.out.println("--------->"+ serializableObject.getName());
            System.out.println("--------->"+ serializableObject.getAge());
            System.out.println("--------->"+ serializableObject2.getName());
            System.out.println("--------->"+ serializableObject2.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SerializableObject implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException{
         return super.clone();
    }
}