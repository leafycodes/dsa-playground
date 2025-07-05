public class AVLTree {
    static class Node {
        int val, height;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
            this.height = 1;
        }
    }

    private static Node root;

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 60);
        root = delete(root, 30);

        /*
         *
         *
         *
         * .. 40
         * .. / \
         * .20 ..50
         * ./ \ ...\
         * 10 /30/. 60
         *
         *
         */

        preorder(root);
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    private static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (node.val > val) {
            node.left = insert(node.left, val);
        } else if (node.val < val) {
            node.right = insert(node.right, val);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance_factor = get_balance_factor(node);

        if (balance_factor > 1) {
            if (val < node.left.val) {
                return right_rotate(node);
            } else if (val > node.left.val) {
                node.left = left_rotate(node.left);
                return right_rotate(node);
            }
        } else if (balance_factor < -1) {
            if (val > node.right.val) {
                return left_rotate(node);
            } else if (val < node.right.val) {
                node.right = right_rotate(node.right);
                return left_rotate(node);
            }
        }

        return node;
    }

    private static Node delete(Node node, int val) {
        if (node == null) {
            return null;
        }

        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (temp == node.right) {
                    temp = node.left;
                } else {
                    temp = node.right;
                }

                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                // get inorder successor (leftmost in right subtree)
                Node temp = get_min_node(root.right);
                node.val = temp.val;
                node.right = delete(node.right, temp.val);
            }
        }

        if (node == null) {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance_factor = get_balance_factor(node);

        if (balance_factor > 1) {
            if (get_balance_factor(node.left) >= 0) {
                return right_rotate(node);
            } else {
                node.left = left_rotate(node.left);
                return right_rotate(node);
            }
        } else if (balance_factor < -1) {
            if (get_balance_factor(node.right) <= 0) {
                return left_rotate(node);
            } else {
                node.right = right_rotate(node.right);
                return left_rotate(node);
            }
        }

        return node;
    }

    private static Node get_min_node(Node node) {
        Node curr = node;

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    private static Node left_rotate(Node node) {
        Node y = node.right;
        Node z = y.left;

        y.left = node;
        node.right = z;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private static Node right_rotate(Node node) {
        Node y = node.left;
        Node z = y.right;
        /*
         * ........10
         * ......./
         * ......20
         * ...../
         * ....30
         */

        y.right = node;
        node.left = z;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        y.height = Math.max(height(node.left), height(node.right)) + 1;

        return y;
    }

    private static int get_balance_factor(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }
}