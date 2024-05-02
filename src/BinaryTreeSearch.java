class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeSearch {
    public static TreeNode search(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }
        if (root.val < key) {
            return search(root.right, key);
        }
        return search(root.left, key);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        int key = 7;

        TreeNode result = search(root, key);
        if (result != null) {
            System.out.println("Элемент найден в бинарном дереве");
        } else {
            System.out.println("Элемент не найден в бинарном дереве");
        }
    }
}

