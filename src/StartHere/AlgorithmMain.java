package StartHere;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import Graph.GraphNode;

public class AlgorithmMain {

	public static void main(String[] args0) throws FileNotFoundException, IOException, ClassNotFoundException{

		System.out.println("De-Serialization started at"+ LocalDateTime.now() );

		ObjectInputStream oos_graph_read = new ObjectInputStream(new FileInputStream("ObjectWarehouse/DDWGraph.obj"));

		//Construct Graph
		DefaultDirectedWeightedGraph <GraphNode,DefaultWeightedEdge> gr_t = new  
				DefaultDirectedWeightedGraph <GraphNode,DefaultWeightedEdge>(DefaultWeightedEdge.class);

		gr_t =  (DefaultDirectedWeightedGraph<GraphNode, DefaultWeightedEdge>) oos_graph_read.readObject();
		oos_graph_read.close();
		
		
		// Start BFS
/*		GraphNode hub_node = new GraphNode();
		hub_node.setLat(40.7743819);
		hub_node.setLon(-73.8729252);
		hub_node.setId(-533655);*/
		
		Set<GraphNode> vertex_set = gr_t.vertexSet();
		
		Iterator<GraphNode> vertex_itr = vertex_set.iterator();
		
		//while(vertex_itr.hasNext()){
			
			GraphNode vertex = vertex_itr.next();
			GraphIterator<GraphNode, DefaultWeightedEdge> bfs_itr = 
	                new BreadthFirstIterator<GraphNode, DefaultWeightedEdge>(gr_t,vertex);
			int ctr = 0;
			while(bfs_itr.hasNext()){
				GraphNode bfs_next_node = bfs_itr.next();
				System.out.println( bfs_next_node +"->"+ctr);
				ctr++;
			}
            
            
	}

}
