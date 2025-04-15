package com.company.arithmetic.link;

public class ReverseLinkedList {

    String sa = "111";
    //迭代方法
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null; // 指向前一个节点，初始为 null
        ListNode current = head; // 指向当前节点，初始为链表头
        ListNode next = null;  // 指向下一个节点

        while (current != null) {
            next = current.next; // 保存下一个节点
            current.next = prev; // 将当前节点的 next 指向它的前一个节点（反转）
            prev = current;      // 将 prev 移动到当前节点
            current = next;      // 将 current 移动到下一个节点
        }

        // 当循环结束时，prev 指向原链表的尾节点，也就是反转后的头节点
        return prev;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // 创建一个示例链表: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原始链表 (Iterative):");
        solution.printList(head);

        ListNode reversedHeadIterative = solution.reverseListIterative(head);
        System.out.println("反转后的链表 (Iterative):");
        solution.printList(reversedHeadIterative);

        // 注意：经过迭代反转后，head 已经指向了 null。
        // 为了演示递归方法，我们需要重新创建一个新的链表。
        ListNode headRecursive = new ListNode(1);
        headRecursive.next = new ListNode(2);
        headRecursive.next.next = new ListNode(3);
        headRecursive.next.next.next = new ListNode(4);
        headRecursive.next.next.next.next = new ListNode(5);

        System.out.println("\n原始链表 (Recursive):");
        solution.printList(headRecursive);

        ListNode reversedHeadRecursive = solution.reverseListRecursive(headRecursive);
        System.out.println("反转后的链表 (Recursive):");
        solution.printList(reversedHeadRecursive);
    }

    //递归
    public ListNode reverseListRecursive(ListNode head) {
        // 基本情况：空链表或只有一个节点的链表，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 递归地反转 head 之后的链表
        ListNode reversedHead = reverseListRecursive(head.next);

        // 将当前节点 head 的 next 指向它的前一个节点
        head.next.next = head;
        head.next = null; // 将原来的 head 的 next 设置为 null，因为它现在是尾节点

        return reversedHead; // 返回反转后的头节点
    }
}
