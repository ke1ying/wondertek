package com.miu.web.huaWei;

import lombok.Data;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author keying
 * @date 2022-11-23 10:10:37
 */
public class ListNode1123 {

    /**
     * struct ListNode
     * {
     * int m_nKey;
     * ListNode* m_pNext;
     * };
     * <p>
     * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
     * * 输入描述：
     * * 输入说明
     * * 1 输入链表结点个数
     * * 2 输入链表的值
     * * 3 输入k的值
     * <p>
     * 输入：
     * 8
     * 1 2 3 4 5 6 7 8
     * 4
     * 复制
     * 输出：
     * 5
     * *
     * * 输出描述：
     * * 输出一个整数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            Integer num = scanner.nextInt();
            ListNode listNodeZ = new ListNode();
            // 放入
            for (Integer i = num; i > 0; i--) {
                Integer string = scanner.nextInt();
                ListNode listNode = new ListNode(string,listNodeZ.nextListNode);

                listNodeZ.nextListNode = listNode;
            }

            Integer huoQ = scanner.nextInt();
            for (int i = 0; i < huoQ; i++) {
                listNodeZ = listNodeZ.nextListNode;
            }
            System.out.println(listNodeZ.m_key);
        }
    }

    static class ListNode {
        int m_key;
        ListNode nextListNode;

        ListNode(){
        }

        ListNode(int m_key,ListNode nextListNode){
            this.m_key = m_key;
            this.nextListNode = nextListNode;
        }
    }



}