package ua.nure.malahin.Practice6.part5;

/**
 * Created by sergey on 15.06.16.
 */
public class Tree<E extends Comparable<E>> {
    private Node<E> root;

    public boolean add(E element){
        if(root == null) {
            root = new Node<E>(element);
            return true;
        }else{
            goToDeep(new Node<E>(element), root);
        }
        return false;
    }

    private boolean goToDeep(Node<E> element, Node<E> top){

            if(top.current.compareTo(element.current) < 0){
                if(top.right == null) {
                    element.top = top;
                    top.right = element;
                    return true;
                }
                goToDeep(element, top.right);

            }else if(top.current.compareTo(element.current) > 0){
                if(top.left == null) {
                    element.top = top;
                    top.left = element;
                    return true;
                }
                goToDeep(element, top.left);

            }else {
                return false;
            }
        return true;
    }

    public void add(E[] elements){
        for (E e : elements){
            add(e);
        }
    }

    public boolean remove(E element){
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && root.current.compareTo(element) == 0){
            root = null;
            return true;
        }
        if (goToDeepDelete(new Node<E>(element), root)){
            return true;
        }
        return false;
    }

    private boolean goToDeepDelete(Node<E> element, Node<E> top){

        if(top.current.compareTo(element.current) < 0){
            if (top.right == null && top.left == null) {
                return false;
            }
            if (top.right != null && goToDeepDelete(element, top.right)) {
               
                    return true;
                
            }

            if (top.left != null && goToDeepDelete(element, top.left) ) {
                
                    return true;
                
            }

        }else if(top.current.compareTo(element.current) > 0){
            if (top.left == null) {
                return false;
            }
            if (goToDeepDelete(element, top.left)){
                return true;
            }
        } else {
            deleteMaster(top);
            return true;
        }
        return false;
    }

    public void deleteMaster(Node<E> current){

        int underTree = checkIsThereUnderTree(current, 0);
        if(underTree == 0){
            deleteNode(current);
        }else if(underTree == 1){
            deleteNode(current, current);
        }else {
            if(current.left == null){
                current.top = current.right;
            }else if(current.right == null){
                current.current = current.left.current;
                current.left = current.left.left;
            }else if(current.left != null && current.right != null){
                Node<E> min =  current.right != null ? findMinValue(current.right) : (current.left!= null) ?  findMinValue(current.left) : null;
		if (min != null) {
		    if (min.right != (null)) {
			min.right.top = min.top;
		    }
		    if (min.left != (null)) {
			min.left.top = min.top;
		    }
		    deleteMaster(min);
	            current.current = min.current;
		}
                
            }
        }
        fixTree(root);
    }

    private void fixTree(Node<E> node){
        if(node.left != null){
            node.left.top = node;
            fixTree(node.left);
        }

        if(node.right != null){
            node.right.top = node;
            fixTree(node.right);
        }

    }

    // delete node with one under node
    private void deleteNode(Node<E> element, Node<E> top){
        if(top.top != null){
            if (top.top.left != null && top.top.left.current == element.current) {
                element.top.left = element.left;
                if(top.top.left == null) {
                    top.top.left = element.right;
                    top.top.left.left = element.left;
                }else{
                    element.top.left.right = element.right;
                }
            } else if (top.top.right != null && top.top.right.current == element.current) {
                element.top.right = element.right;

                if(top.top.right == null) {
                    top.top.right = element.left;
                    top.top.right.right = element.right;
                }else{
                    element.top.right.left = element.left;
                }
            } else {
                top.top = null;
            }
        }else{
            Node<E> min =  top.right != null ? findMinValue(top.right) : (top.left!= null) ?  findMinValue(top.left) : null;
            if(min != null){
                if (min.right != null) {
                    min.right.top = min.top;
                }
                if (min.left != null) {
                    min.left.top = min.top;
                }
                deleteMaster(min);
                top.current = min.current;
            }
        }
    }

    // delete node without under tree
    public void deleteNode(Node<E> node){
        if(node.top != null) {

            if (node.top.left != null && node.top.left.current == node.current) {
                node.top.left = null;
            } else if (node.top.right != null && node.top.right.current == node.current) {
                node.top.right = null;
            }
        }else{
            node.left = null;
            node.right = null;
            node.current = null;
        }
    }

    public int checkIsThereUnderTree(Node<E> node, int i){
        if(node.right == null && node.left == null){
            return i;
        }

        int tmp = 0;
        if(node.left != null){
            tmp = checkIsThereUnderTree(node.left, i + 1);
        }

        if(node.right != null){
            int citut = checkIsThereUnderTree(node.right, i + 1);
            tmp = (tmp > citut)? tmp : citut;
        }

        return tmp;
    }

    public Node<E> findMinValue(Node<E> node){
        if(node.left != null){
            return findMinValue(node.left);
        }else if(node.right != null){
            return findMinFromRight(node, node.right);
        }else {
            return node;
        }
    }

    public Node<E> findMinFromRight(Node<E> m, Node<E> t){
	Node<E> min = m;
	Node<E> tree = t;
        if(tree.left == null && tree.right == null){
            return min;
        }else if(tree.left != null){
            if(min.current.compareTo(tree.left.current) > 0){
                min = tree.left;
            }
            return findMinFromRight(min, tree.left);
        } else if(tree.right != null){
            return findMinFromRight(min, tree.right);
        }else {
            return null;
        }
    }

    public void print(){
        if(root == null) {
            System.out.println("Tree is empty");
            return;
        }
        showTree(root, 0);
    }

    private boolean showTree(Node<E> node, int i){

        if(node.left == null && node.right == null){
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println(node.current);
            return true;
        }
        if(node.left != null) {
            if (showTree(node.left, i + 3)) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                System.out.println(node.current);
            }
        } else {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println(node.current);
        }

        if (node.right != null) {
            if (showTree(node.right, i + 3)) {
                return true;
            }
        } else {
            return true;
        }

        return false;
    }

    private static class Node<E>{
        private Node<E> top;
        private Node<E> left;
        private Node<E> right;
        private E current;

        public Node(E element) {
            current = element;
        }
    }
    
    public static void main(String[] args) {
	Tree<Integer> tree = new Tree<>();
        
	System.out.println(tree.add(3));
	System.out.println(tree.add(3));
	         
	System.out.println("~~~~~~~");
	tree.add(new Integer[] {1, 2, 5, 4, 6, 0});
	tree.print();
	         
	System.out.println("~~~~~~~");
	System.out.println(tree.remove(5));
	System.out.println(tree.remove(3));     
	 
	System.out.println("~~~~~~~");
	tree.print();
    }

}
