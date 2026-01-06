import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in the file system tree.
 * A directory can contain other directories and files as children.
 */
public class FolderNode extends FileSystemNode {

    private List<FileSystemNode> children;

    public FolderNode(String name, FolderNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    @Override
    public boolean isFolder() {
        return true;
    }

    /**
     * Returns a list view of the children contained directly inside this directory.
     * Modifying the returned list is not required to be supported.
     */
    public List<FileSystemNode> getChildren() {
        // TODO: return the list of child nodes (possibly a defensive copy)
        return children;
    }
    // DONE

    /**
     * Searches the children of this directory for a node whose name matches the input.
     * Only direct children are considered, not deeper descendants.
     */
    public FileSystemNode getChildByName(String childName) {
        // TODO: scan children for a matching name and return the node if found
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(childName)) {
                return children.get(i);
            }
        }
        return null;
    }
    // DONE

    /**
     * Creates a new file directly inside this directory with the given name and size.
     * If a child with the same name already exists, no file is created and false is returned.
     * Otherwise the new file is added and true is returned.
     */
    public boolean addFile(String fileName, int size) {
        // TODO: implement uniqueness check and insertion of a new FileNode
        if (getChildByName(fileName) != null) {
            return false;
        }
        FileNode addition = new FileNode(fileName, this, size);
        children.add(addition);
        return true;
    }
    // DONE

    /**
     * Creates a new subdirectory directly inside this directory with the given name.
     * If a child with the same name already exists, no folder is created and false is returned.
     * Otherwise the new folder is added and true is returned.
     */
    public boolean addFolder(String folderName) {
        // TODO: implement uniqueness check and insertion of a new FolderNode
        if (getChildByName(folderName) != null) {
            return false;
        }
        FolderNode addition = new FolderNode(folderName, this);
        children.add(addition);
        return true;
    }
    // DONE

    /**
     * Searches this directory and all of its descendants for nodes whose name matches the input.
     * When a match is found, its full path can be printed by the caller using toString().
     */
    public boolean containsNameRecursive(String searchName) {
        // TODO: check this directory and all descendants for the given name
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(searchName)) {
                return true;
            }
            if (children.get(i).isFolder()) {
                FolderNode thisFolder = (FolderNode) children.get(i);
                thisFolder.containsNameRecursive(searchName);
            }
        }
        return false;
    }
    // DONE

    @Override
    public int getHeight() {
        // TODO: compute the maximum height among children; empty folders have value 0
        // int thisFolder = children.size();
        // int childSize = 0;
        // for (int i = 0; i < children.size(); i++) {
        //     if (children.get(i).getHeight() > childSize) {
        //         childSize = 1 + children.get(i).getHeight(); // needed to add one
        //     }
        // }
        // return childSize;
        return getHeightHelper(this) -1; // -1 for root
    }

    // private int heightHelper(FileSystemNode curr, int childSize) {
    //     for (int i = 0; i < children.size(); i++) {
    //         if (heightHelper(children.get(i), childSize+1) > childSize) {
    //             childSize = heightHelper(children.get(i), childSize+1); // needed to add one
    //         }
    //     }
    //     return childSize;
    // }
    // DONE

    public int getHeightHelper(FileSystemNode node) {
        if (!node.isFolder() || ((FolderNode)node).getChildren().size() == 0) {
            return 1;
        }
        int maxHeight = 0;
        for (int i = 0; i < ((FolderNode) node).getChildren().size(); i++ ){
        // for (FileSystemNode child : ((FolderNode)node).getChildren()) {
            int childHeight = getHeightHelper(((FolderNode) node).getChildren().get(i));
            if (childHeight> maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight+1;
    }

    @Override
    public int getSize() {
        // TODO: sum the sizes of all files contained in this directory and its descendants
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).isFolder()) {
                return children.size() + children.get(i).getSize();
            }
        }
        return children.size();
    }
    // i think this one has something wrong with it (children.size() seems off as the method to use)
    // in progress

    @Override
    public int getTotalNodeCount() {
        // TODO: count this directory plus all descendant files and folders
        return getTotalNodeCountHelper() + 1; // couldn't think of better way for make it to count for bonus from og folder????
    }

    public int getTotalNodeCountHelper() {
        int descCount = 0;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).isFolder()) {
                descCount += ((FolderNode)children.get(i)).getTotalNodeCountHelper();
            }
        }
        return children.size() + descCount;
    }

    public String folderTree() {
        // System.out.println("here");
        String toReturn = new String();
        for (int i = 0; i < getChildren().size(); i++) {
            toReturn += getChildren().get(i) + "\n";
            if (getChildren().get(i).isFolder()) {
                getChildren().get(i).toString();
            }
        }
        return toReturn;
    }
    // DONE
}
