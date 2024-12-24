int largest(NODE root)
{
    if (root == NULL)
        return -1; // Base case: if the tree is empty, return -1 (or some other sentinel value)

    int leftLargest = largest(root->llink);  // Recursively find the largest value in the left subtree
    int rightLargest = largest(root->rlink); // Recursively find the largest value in the right subtree

    // The current node's value is root->info. We compare it with the largest in the left and right subtrees.
    int maxVal = root->info; // Assume the current node's value is the largest

    // Compare with the largest value in the left subtree
    if (leftLargest > maxVal)
        maxVal = leftLargest;

    // Compare with the largest value in the right subtree
    if (rightLargest > maxVal)
        maxVal = rightLargest;

    return maxVal; // Return the largest value found
}
