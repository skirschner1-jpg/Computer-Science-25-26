/**
 * Represents an entire file system hierarchy.
 * This class owns the root directory and can provide access to it.
 */
public class FileSystemTree {

    private FolderNode root;

    /**
     * Constructs a file system with a single root directory.
     * The root has no parent and typically uses a fixed name such as "/".
     */
    public FileSystemTree() {
        this.root = new FolderNode("/", null); // or equivalent
    }
    public FileSystemTree(FolderNode folder) {
        this.root = folder; // or equivalent
    }

    /**
     * Provides the root of the directory tree so callers can navigate from the top.
     */
    public FolderNode getRoot() {
        if (root != null) {
            return root;
        }
        return null;
    }
    // DONE

    public String toString() {
        String toReturn = new String();
        for (int i = 0; i < root.getChildren().size(); i++) {
            toReturn += root.getChildren().get(i) + "\n";
            if (root.getChildren().get(i).isFolder()) {
                // System.out.println("here");
                // System.out.println(root.getChildren().get(i));
                root.getChildren().get(i).toString();
            }
        }
        return toReturn;
    }
}
