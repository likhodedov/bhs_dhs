package com.company;

/**
 * Created by d.lihodedov on 12.12.2016.
 */
public class JQueue {
        private int[] array;//массив для хранения элементов
        private int size;//количество элементов в очереди
        private int count;//текущее количество элементов
        private int front;//элемент, который находится в начале очереди
        private int rear;//элемент, который находится в конце очереди

        public JQueue(int queueSize)
        {
            size = queueSize;
            array = new int[size];
            front = 0;
            rear = -1;
            count = 0;//элементов в очереди пока нет
        }
    public void insert(int value)
    {
        if(rear == size - 1)
            rear = -1;
        array[++rear] = value;
        count++;
    }
    public int pop()
    {
        int temp = array[front++];
        if(front == size)
            front = 0;
        count--;
        return temp;
    }
    public int size()
    {
        return count;
    }
    public boolean isEmpty()
    {
        return (count == 0);
    }
}
