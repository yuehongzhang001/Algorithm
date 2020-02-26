/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class SinglyLinkedList<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public SinglyLinkedList() {
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            head = new Node<>(e, null);
            tail = head;
        } else {
            Node<E> newest = new Node<>(e, head);
            head = newest;
        }
        size++;
    }

    public void addLast(E e) {
        if (isEmpty()) {
            addFirst(e);
        } else {
            tail.setNext(new Node(e, null));
            tail = tail.next;
        }
        size++; 
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        if(size==1) tail=head;
        size--;
        return answer;
    }

}
