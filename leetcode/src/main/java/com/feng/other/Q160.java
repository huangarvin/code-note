package com.feng.other;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class Q160 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

/*        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node11.next = node12;
        node12.next = node3;*/


        node11.next = node1;
        System.out.println(getIntersectionNode(node1, node11));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }
        ListNode next = headA;
        boolean flag = false;
        while (next != null) {
            ListNode nextB = headB;
            while (nextB != null) {
                if (next == nextB) {
                    flag = true;
                    break;
                }
                nextB = nextB.next;
            }
            if (flag) {
                break;
            }
            next = next.next;
        }
        return flag ? next : null;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            '}';
    }
}
