import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
    
    if (head == null) 
    {   
        // insert in empty list
        return newNode;
    } 
    else if (data < head.data) 
    {   
        // insert in front of list
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }
    else 
    {
        /* Walk list with 2 pointers */
        DoublyLinkedListNode n1 = null;
        DoublyLinkedListNode n2 = head;
        while (n2 != null && n2.data < data) 
        {
            n1 = n2;
            n2 = n2.next;
        }
        
        if (n2 == null) 
        {   
            // insert at end of list
            n1.next = newNode;
            newNode.prev = n1;
        } 
        else 
        {   // insert in empty list
            n1.next = newNode;
            n2.prev = newNode;
            newNode.prev = n1;
            newNode.next = n2;
        }
        return head;
    }
     
    }

    private static final Scanner scanner = new Scanner(System.in);
