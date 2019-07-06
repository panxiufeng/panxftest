
package com.pxf.project.design.pattern.behavior.iterator;

/**
 *
 * @author panxiufeng
 * @version Id: MyCollection.java, v 0.1 2018/9/25 14:52 panxiufeng Exp $$
 */
public class MyCollection implements Collection {

    public String string[] = {"A","B","C","D","E"};
    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}