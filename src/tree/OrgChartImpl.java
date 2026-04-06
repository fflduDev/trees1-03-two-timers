package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();

	@Override
	public void addRoot(Employee e) {
		GenericTreeNode<Employee> rootEmployee = new GenericTreeNode<Employee>(e);
		nodes.add(rootEmployee);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		for (int i = 0; i < nodes.size(); i++) {
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);
			if (currentEmployee.data.equals(manager)) {
				GenericTreeNode<Employee> newE = new GenericTreeNode<Employee>(newPerson);
				currentEmployee.addChild(newE);
				nodes.add(newE);
				break;
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEmployee(Employee firedPerson) {
		for (int i = 0; i < nodes.size(); i++) {
		GenericTreeNode<Employee> currentEmployee = nodes.get(i);
		
		for (GenericTreeNode<Employee> child: currentEmployee.children)
		if (child.data.equals(firedPerson)) {
			currentEmployee.removeChild(firedPerson);
			break;
			}
		}
		
		
	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub
		if (nodes == null) {
			
			return;
			
		}
		
		GenericTreeNode<Employee> rootEmployee = nodes.get(0);
		Stack<GenericTreeNode<Employee>> stack = new Stack<>();
		
			
		stack.push(rootEmployee);
		
		while (!stack.empty()) {
			
			GenericTreeNode<Employee> currentNode = stack.pop();
			System.out.println(currentNode.data);
			
			ArrayList<GenericTreeNode<Employee>> childrenOfCurrent = currentNode.children;
			
			for (int i = childrenOfCurrent.size() - 1; i >= 0; i--) {
				
				stack.push(childrenOfCurrent.get(i));
				
			}
			
		}
		
	}

	@Override
	public void showOrgChartBreadthFirst() {
		GenericTreeNode<Employee> rootEmployee = nodes.get(0);
		if (rootEmployee == null) {
			return;
		}
		
		Queue<GenericTreeNode<Employee>> q = new LinkedList<>();
		q.add(rootEmployee);
		
		while (!q.isEmpty()) {
			int n = q.size();
			
			while (n > 0) {
				GenericTreeNode <Employee> e = q.peek();
				q.remove();
				System.out.println(e.data + " ");
				
				for (int i = 0; i < e.children.size(); i++) {
					q.add(e.children.get(i));
				}
				n--;
			}
			
			System.out.println();
		}
		
		
		// TODO Auto-generated method stub
		
	}
	
	
}
