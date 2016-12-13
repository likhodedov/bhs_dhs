package com.company;

/**
 * Created by d.lihodedov on 12.12.2016.
 */
public class Graph {
    //максимальное количество вершин в графе
    private final int VERTEX_MAX = 10000;
    //массив для хранения вершин
    private Vertex[] vertexList;
    //текущее количество вершин в графе
    private int vertexCount;
    //матрица смежности
    private int[][] matrix;
        JQueue queue = new JQueue(1000);
    Stack stack= new Stack();

    public Graph()
    {
        matrix = new int[VERTEX_MAX][VERTEX_MAX];
        //перед началом работы заполняем матрицу смежности нулями
        for(int i = 0; i < VERTEX_MAX; i++)
            for(int j = 0; j < VERTEX_MAX; j++)
                matrix[i][j] = getRandomNumberInRange(0,1);
        vertexCount = 0;
        vertexList = new Vertex[VERTEX_MAX];
    }
    public void addVertex(String label)
    {
try{
        vertexList[vertexCount] = new Vertex(label);
vertexCount++;}
        catch (ArrayIndexOutOfBoundsException e){
            }
    }
    public void addEdge(int begin, int end)
    {
        matrix[begin][end] = 1;
        matrix[end][begin] = 0;
    }
    //обход в ширину
    void bfs(int v)
    {
        vertexList[v].isVisited = true;
        queue.insert(v);
        int vertex;

        //выведем вершину, с которой начинается обход, на экран
        System.out.println(vertexList[v].getLabel());

        while(!queue.isEmpty())//пока очередь не опустеет
        {
            int current = queue.pop();
            while((vertex = getSuccessor(current)) != -1)
            {
                vertexList[vertex].isVisited = true;
                queue.insert(vertex);
                //вывод вершины на экран
                System.out.println(vertexList[vertex].getLabel());
            }

        }

        //сброс флагов
        for(int j = 0; j < vertexCount; j++)
            vertexList[j].isVisited = false;
    }
    int getSuccessor (int v)
    {
        for(int j = 0; j < vertexCount; j++)
            if(matrix[v][j] == 1 && vertexList[j].isVisited == false)
                return j; //возвращает первую найденную вершину
        return -1; //таких вершин нет
    }
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    // обход в глубину
    void dfs(int v){
        vertexList[v].setVisited(true);//алгоритм начинает обход с вершины 0
        stack.push(0);//занесение в стек
        int i = 0;
//выведем вершину, с которой начинается обход, на экран
        System.out.println(vertexList[v].getLabel());


        while(!stack.isEmpty()) //пока стек не опустеет
        {
            int current = stack.peek();
            //получение непосещенной вершины, смежной с текущей
            int vertex = getSuccessor (current);
            if(vertex == -1)
                stack.pop();//элемент извлекается из стека
            else //если вершина найдена
            {
                vertexList[vertex].setVisited(true);//пометка
                //displayVertex(vertex);//вывод
                System.out.println(vertexList[vertex].getLabel());
                stack.push(vertex);//занесение в стек
            }
        }

//сброс флагов
        for(int j = 0; j < vertexCount; j++)//сброс флагов
            vertexList[j].setVisited(false);

    }
}
