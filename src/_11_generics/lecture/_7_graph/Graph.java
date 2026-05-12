package _11_generics.lecture._7_graph;

import java.util.ArrayList;
import java.util.List;

interface Node {}
interface Edge {}

/**
 * A generic graph class that we could implement graph algorithms on,
 * such as Breadth First Search. However, the types of the nodes and
 * edges are generic. We could construct a graph with nodes and edges
 * that store any kind of data.
 */
public class Graph<N extends Node, E extends Edge>
{
    private GraphAbstractFactory<N, E> factory;
    private List<N> nodes = new ArrayList<N>();
    private List<E> edges = new ArrayList<E>();

    public Graph(GraphAbstractFactory<N, E> factory)
    {
        this.factory = factory;
    }

    public N addNode() {
        N n = factory.createNode();
        nodes.add(n);
        return n;
    }

    public int countNodes() {
        return nodes.size();
    }

    public int countEdges() {
        return edges.size();
    }

    public void join(N a, N b) { 
        edges.add(factory.createEdge(a, b));
    }

    public static void main(String[] args) {
        Graph<MyNode, MyEdge> g = new Graph(new MyGraphFactory());
        MyNode a = g.addNode();
        MyNode b = g.addNode();
        g.join(a, b);
        System.out.println(g.countNodes());
        System.out.println(g.countEdges());
    }
}

/**
 * This interface lets us define an abstract factory that creates 
 * nodes and edges within our graph. Asking for this is much
 * better than asking for Class<N> and Class<E> objects, as those
 * give us much more far-reaching control over the object.
 */
interface GraphAbstractFactory<N extends Node, E extends Edge>
{
    N createNode();
    E createEdge(N a, N b);
}

class MyNode implements Node {}
class MyEdge implements Edge {}

class MyGraphFactory implements GraphAbstractFactory<MyNode, MyEdge> {
    public MyGraphBuilder() {}
    public MyNode createNode()  { return new MyNode(); }
    public MyEdge createEdge(MyNode a, MyNode b) { return new MyEdge(); }
}