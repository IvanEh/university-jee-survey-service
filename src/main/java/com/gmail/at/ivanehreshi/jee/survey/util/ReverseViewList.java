package com.gmail.at.ivanehreshi.jee.survey.util;

import java.util.*;
import java.util.function.UnaryOperator;

public class ReverseViewList<E> implements List<E> {
    private List<E> listDelegate;
    private boolean reversed = false;

    public ReverseViewList(List<E> listDelegate) {
        this.listDelegate = listDelegate;
    }

    public boolean reverse() {
        reversed = !reversed;
        return reversed;
    }

    @Override
    public boolean add(E e) {
        return listDelegate.add(e);
    }

    private int realIndex(int i) {
        if(reversed) {
            return listDelegate.size() - i - 1;
        } else {
            return i;
        }
    }

    @Override
    public void add(int index, E element) {
        listDelegate.add(realIndex(index), element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return listDelegate.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return listDelegate.addAll(realIndex(index), c);
    }

    @Override
    public void clear() {
        listDelegate.clear();
    }

    @Override
    public boolean contains(Object o) {
        return listDelegate.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return listDelegate.containsAll(c);
    }

    @Override
    public boolean equals(Object o) {
        return listDelegate.equals(o);
    }

    @Override
    public E get(int index) {
        System.out.println("Reversed get " + index + "; Real " + realIndex(index) + "; reversed: " + reversed);
        return listDelegate.get(realIndex(index));
    }

    @Override
    public int hashCode() {
        return listDelegate.hashCode();
    }

    @Override
    public int indexOf(Object o) {
        return realIndex(listDelegate.indexOf(o));
    }

    @Override
    public boolean isEmpty() {
        return listDelegate.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return listDelegate.iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        return listDelegate.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return listDelegate.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return listDelegate.listIterator(realIndex(index));
    }

    @Override
    public E remove(int index) {
        return listDelegate.remove(realIndex(index));
    }

    @Override
    public boolean remove(Object o) {
        return listDelegate.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return listDelegate.removeAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        listDelegate.replaceAll(operator);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return listDelegate.retainAll(c);
    }

    @Override
    public E set(int index, E element) {
        return listDelegate.set(realIndex(index), element);
    }

    @Override
    public int size() {
        return listDelegate.size();
    }

    @Override
    public void sort(Comparator<? super E> c) {
        listDelegate.sort(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return listDelegate.spliterator();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return listDelegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return listDelegate.toArray(a);
    }

    public boolean isReversed() {
        return reversed;
    }
}
