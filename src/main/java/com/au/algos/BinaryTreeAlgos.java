package com.au.algos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeAlgos {

    public void depthFirstTravseral(BinaryTree root) {  //PostOrder
        if (root != null) {
            depthFirstTravseral(root.left);
            depthFirstTravseral(root.right);
            System.out.print(root.key + ", ");
        }
    }

    public void breadthFirstTravel(BinaryTree root) {
        if (root != null) {
            Queue<BinaryTree> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                // get first element
                BinaryTree node = queue.remove();
                System.out.print(node.key + ", ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
         }
    }

    public void breadthFirstTraversalByLine(BinaryTree root) {
        if (root != null) {
            int nodeCount = 0;
            Queue<BinaryTree> queue = new LinkedList<>();
            queue.add(root);

            while (true) {
                nodeCount = queue.size();
                if (nodeCount == 0) {
                    break;
                }

                while (nodeCount > 0) {
                    BinaryTree node = queue.remove();
                    System.out.print(node.key + " ");
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    nodeCount--;
                }
                System.out.println();
            }
        }
    }

    public void inorderTraversal(BinaryTree root, boolean asc) {
        if (root != null) {
            if (asc) {
                inorderTraversal(root.left, asc);
                System.out.print(root.key + ", ");
                inorderTraversal(root.right, asc);
            } else {
                inorderTraversal(root.right, asc);
                System.out.print(root.key + ", ");
                inorderTraversal(root.left, asc);
            }
        }
    }

    public void inorderTraversalIter(BinaryTree root, boolean asc) {
        Stack<BinaryTree> stack = new Stack<>();

        while (true) {
            if (root != null) {
                if (asc) {
                    stack.push(root.right);
                    stack.push(root);
                    root = root.left;
                } else {
                    stack.push(root.left);
                    stack.push(root);
                    root = root.right;
                }
            } else {
                if (!stack.empty()) {
                    root = stack.pop();
                    System.out.print(root.key + " ");
                    root = stack.pop();
                } else {
                    break;
                }
            }
        }
    }

    public BinaryTree init(int[] arr) {
        BinaryTree root = null;
        for (int num : arr) {
            root = insert(root, num);
        }
        return root;
    }

    public BinaryTree insert(BinaryTree root, int num) {
        if (root == null) {
            root = new BinaryTree();
            root.key = num;
        } else {
            if (num < root.key) {
                root.left = insert(root.left, num);
            } else {
                root.right = insert(root.right, num);
            }
        }
        return root;
    }

    public BinaryTree deleteNode(BinaryTree root, int num) {
        if (root != null) {
            if (root.key == num) {
                int childCount = root.noOfChildren();
                // If node is a leaf
                if (childCount == 0) {
                    return null;
                } else if (childCount == 1) {
                        // If node has one child
                    return root.left != null? root.left : root.right;
                } else {
                    InorderSucc inorderSucc = findInorderSuccessor(root);
                    removeInorderSuccessor(inorderSucc);
                    root.key = inorderSucc.successor.key;
                }
            } else {
                if (num < root.key) {
                    root.left = deleteNode(root.left, num);
                } else {
                    root.right = deleteNode(root.right, num);
                }
            }
        }
        return root;
    }

    private InorderSucc findInorderSuccessor(BinaryTree node) {
        InorderSucc succ = new InorderSucc();
        succ.parent = node;
        succ.successor = node.right;
        node = node.right;
        while (node.left != null) {
            succ.parent = node;
            node = node.left;
        }
        succ.successor = node;
        return succ;
    }

    private void removeInorderSuccessor(InorderSucc succ) {
        int succChildCount = succ.successor.noOfChildren();
        if (succChildCount == 0) {
            if (succ.successor == succ.parent.left) {
                succ.parent.left = null;
            } else {
                succ.parent.right = null;
            }
        } else {
            if (succ.successor == succ.parent.left) {
                succ.parent.left = succ.successor.right;
            } else {
                succ.parent.right = succ.successor.right;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeAlgos algos = new BinaryTreeAlgos();
        BinaryTree root = algos.init(new int[]{50, 30, 20, 40, 70, 80, 60, 65});
//        algos.depthFirstTravseral(root);
//        System.out.println();
//        algos.inorderTraversal(root, true);
//        System.out.println();
//        algos.inorderTraversal(root, false);
//        System.out.println();
//        algos.breadthFirstTravel(root);
//        System.out.println();
//        algos.breadthFirstTraversalByLine(root);
//        algos.inorderTraversalIter(root, false);
        root = algos.deleteNode(root, 50);
    }

    private class BinaryTree {
        int key;
        BinaryTree left;
        BinaryTree right;

        public int noOfChildren() {
            int count = 0;
            if (this.left != null) {
                count++;
            }
            if (this.right != null) {
                count++;
            }
            return count;
        }

        @Override
        public String toString() {
            return String.valueOf(this.key);
        }
    }

    private class InorderSucc {
        BinaryTree parent;
        BinaryTree successor;

        @Override
        public String toString() {
            return parent.key + ", " + successor.key;
        }
    }
}
