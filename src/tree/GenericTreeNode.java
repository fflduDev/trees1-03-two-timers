package tree;

import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children;
	
	public GenericTreeNode(E theItem) {
		data = theItem;
		children = new ArrayList<>();
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {
		GenericTreeNode <E> targetNode = null;
		
		for (GenericTreeNode<E> child: children) {
			if (child.data.equals(theItem)) {
				targetNode = child;
				break;
			}
		}
		
		if (targetNode == null) {
			return;
		}
		
		ArrayList<GenericTreeNode<E>> targetChildren = new ArrayList<>(targetNode.children);
		
		for (GenericTreeNode<E> child: targetChildren) {
			children.add(child);
		}
		
		children.remove(targetNode);
		
		// this one is a little harder.
		// what do you do when the item has children?
		// I suggest "give them to the parent"
	}
	
	// Hello this is grayson
} 
