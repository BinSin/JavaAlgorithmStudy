package Advanced.JavaVisitorPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	
	private int result = 0;
	
    public int getResult() {
    	return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
      	result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
	
	private int result = 1;
	private final int M = 1000000007;
	
    public int getResult() {
    	return result;
    }

    public void visitNode(TreeNode node) {
    	if(node.getColor().equals(Color.RED))
    		result *= node.getValue() % M;
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor().equals(Color.RED))
    		result *= leaf.getValue() % M;
    }
}

class FancyVisitor extends TreeVis {
	
	private int result = 0;
	
    public int getResult() {
    	return Math.abs(result);
    }

    public void visitNode(TreeNode node) {
    	if(node.getDepth()%2 == 0)
			result += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor().equals(Color.GREEN))
    		result -= leaf.getValue();
    }
}

public class Solution {
	
    public static Tree solve() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] values = new int[n];
		Color[] colors = new Color[n];
		HashMap<Integer, LinkedList<Integer>> nodesMap = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 0 : colors[i] = Color.RED; break;
			case 1 : colors[i] = Color.GREEN; break;
			}
		}
    	
		Tree rootNode;
		if(n == 1) {
			rootNode = new TreeLeaf(values[0], colors[0], 0);
		}
		else {
			for(int i=0; i<n-1; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				LinkedList<Integer> edges = nodesMap.get(u);
				if(edges == null) {
					edges = new LinkedList<>();
				}
				edges.add(v);
				nodesMap.put(v, edges);
			}
			
			rootNode = new TreeNode(values[0], colors[0], 0);
			LinkedList<Integer> 
		}
		
    	return null;
    }


    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}

