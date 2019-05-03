 import java.util.List;
 import java.util.ArrayList;

 public class GraphImplementation implements Graph {
 	public int[][] adjmatrix;//store the vertices and edges
 	public int vertices;//how many vertices it has

 	public GraphImplementation(int v) {
 		vertices = v;//save the number of vertices
 		adjmatrix = new int[v][v];//initialize the graph
 	}

 	public void addEdge(int src,int tar) {
 		adjmatrix[src][tar]=1;//mark there is a edge between src and tar
 	}

 	public int[] neighbors(int vertex) {
 		int size = 0;//size of the array to be returned
 		for(int i = 0; i < vertices; i++) {//find out the number of how many vertices are connected to this one
 			if(adjmatrix[vertex][i]==1) {
 				size++;
 			}
 		}
 		int[] n = new int[size];//create a new array
 		int pos = 0;
 		for(int j = 0; j<vertices;j++) {//store the neighbors
 			if(adjmatrix[vertex][j]==1) {
 				n[pos++]=j;
 			}
 		}
 		return n;
 	}

 	public List<Integer> topologicalSort() {
 		ArrayList<Integer> schedule = new ArrayList<Integer>();
 		int[] incident = new int[vertices];
 		for(int i = 0; i<vertices;i++) {//initialize the incident array
 			incident[i] = 0;
 		}
 		for(int j=0; j<vertices;j++) {//find out the number of incidents of every vertices
 			for(int k = 0; k < vertices;k++) {
 				if(adjmatrix[k][j]==1) {
 					incident[j]++;
 				}
 			}
 		}
 		for(int i = 0;i<vertices;i++) {
 			for(int j=0;j<vertices;j++) {
 				if(incident[j]==0) {// if incident=0, choose it
 					schedule.add(j);//add it to schedule
 					incident[j]=-1;
 					int[] temp = neighbors(j);//get its neighbors
 					for(int k = 0; k < temp.length;k++) {
 						incident[temp[k]]--;//-1 incident to all its neighbors
 					} 
 				}
 			}
 		}
 		return schedule;
 	}









 }