package Advanced.JavaVisitorPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
    RED, GREEN
}

// 데이터 인터페이스 (accept 함수 제공)
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

// 데이터 클래스 (visitor에게 자신을 던져줌으로써 끝)
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

//데이터 클래스 (visitor에게 자신을 던져줌으로써 끝)
class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

// visitor 인터페이스
abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

// visitor 구현체 1 (알고리즘)
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

//visitor 구현체 2 (알고리즘)
class ProductOfRedNodesVisitor extends TreeVis {
	
	private long result = 1; // long 으로 해야 result 제대로 나온다.
	private final int M = 1000000007;
	
    public int getResult() {
    	return (int) result;
    }

    public void visitNode(TreeNode node) {
    	if(node.getColor().equals(Color.RED))
    		result = (result * node.getValue()) % M;
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor().equals(Color.RED))
    		result = (result * leaf.getValue()) % M;
    }
}

//visitor 구현체 3 (알고리즘)
class FancyVisitor extends TreeVis {
	
	private int nonLeafEvenDepthSum = 0;
    private int greenLeavesSum = 0;
	
    public int getResult() {
    	return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
    	if(node.getDepth()%2 == 0)
    		nonLeafEvenDepthSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor().equals(Color.GREEN))
    		greenLeavesSum += leaf.getValue();
    }
}

public class Solution {
	private static int[] values;
	private static Color[] colors;
	private static Map<Integer, Set<Integer>> nodesMap;
	
    public static Tree solve() {
    	Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		values = new int[n];
		colors = new Color[n];
		nodesMap = new HashMap<>(n);
		
		for(int i=0; i<n; i++) {
			values[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			colors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
		}
    	
		Tree rootNode;
		if(n == 1) {
			rootNode = new TreeLeaf(values[0], colors[0], 0);
		}
		else {
			for(int i=0; i<n-1; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				
				Set<Integer> uEdges = nodesMap.get(u);
				if(uEdges == null) {
					uEdges = new HashSet<>();
				}
				uEdges.add(v);
				nodesMap.put(u, uEdges);
				
				Set<Integer> vEdges = nodesMap.get(v);
				if(vEdges == null) {
					vEdges = new HashSet<>();
				}
				vEdges.add(u);
				nodesMap.put(v, vEdges);
			}
			
			rootNode = new TreeNode(values[0], colors[0], 0);
			Set<Integer> rootEdges = nodesMap.get(1);
			Iterator<Integer> itr = rootEdges.iterator();
			// 부모노드(1) 부터 시작
			while(itr.hasNext()) {
				Integer nodeIdentifier = itr.next();
				// 부모노드의 자식노드를 제거 (시작!!)
				nodesMap.get(nodeIdentifier).remove(1);
				// 자식노드가 자식이 없으면 리프에 추가 아니면 노드에 추가
				createEdge(rootNode, nodeIdentifier);
			}
		}
		
		return rootNode;
	}
    
    private static void createEdge(Tree parentNode, Integer nodeIdentifier) {
    	Set<Integer> nodeEdges = nodesMap.get(nodeIdentifier);
    	boolean hasChild = false;
    	if(nodeEdges != null && !nodeEdges.isEmpty())
    		hasChild = true;
    	
    	if(hasChild) { // 자식이 있으면 노드에 넣는다
    		TreeNode node = new TreeNode(values[nodeIdentifier-1], colors[nodeIdentifier-1], parentNode.getDepth()+1);
    		((TreeNode)parentNode).addChild(node); // 자식이 있으므로 노드에 추가
    		Iterator<Integer> nodeIterator = nodeEdges.iterator();
    		while(nodeIterator.hasNext()) { // 자식이 없을 때까지 계속 반복
    			Integer neighborNodeIdentifier = nodeIterator.next();
    			nodesMap.get(neighborNodeIdentifier).remove(nodeIdentifier); // 자식 노드 제거
    			
    			createEdge(node, neighborNodeIdentifier);
    		}
    	}
    	else { // 자식이 없으면 리프에 넣는다 (끝!!)
    		TreeLeaf leaf = new TreeLeaf(values[nodeIdentifier-1], colors[nodeIdentifier-1], parentNode.getDepth()+1);
    		((TreeNode)parentNode).addChild(leaf);
    	}
    	
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

