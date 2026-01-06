import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Small manual tester for the solution file-system implementation.
 *
 * This does NOT use JUnit. It just runs a few operations and prints out
 * what it's doing plus the observed behavior.or
 *
 * And also assumes (based on our design):
 *  - FileSystemTree#getRoot() returns a non-null FolderNode
 *  - FolderNode has addFolder(String) and addFile(String, int) that return boolean
 *  - FileSystemNode has getDepth(), getHeight(), getSize(), getTotalNodeCount()
 *  - Navigator has processUserInputString(String) which prints results to System.out
 */
public class FileSystemTester {

    public static void main(String[] args) {

        // 1. Construct a tree and check root
        FileSystemTree tree = new FileSystemTree();
        FolderNode root = tree.getRoot();

        if (root == null) {
            System.out.println("[FAIL] Root is null. FileSystemTree.getRoot() must return a non-null root folder.");
            return;
        } else {
            System.out.println("[PASS] Root is non-null.");
        }

        System.out.println("Root toString(): " + root.toString());
        System.out.println("Expected at root: '/' (or equivalent)");

        // 2. Build a small structure under root
        System.out.println("\n=== Building tree structure under root ===");
        boolean addedDocs = root.addFolder("docs");
        boolean addedSrc = root.addFolder("src");
        boolean addedMainJava = root.addFile("main.java", 120);
        boolean addedReadme = root.addFile("README.md", 80);

        int depthRoot = root.getDepth();
        int heightRoot = root.getHeight();
        int sizeRoot = root.getSize();
        int totalNodesRoot = root.getTotalNodeCount();
        // System.out.println(root);
        // System.out.println(root.getChildren().get(0));

        FolderNode docs = (FolderNode) root.getChildren().get(0);
        System.out.println("docs children.size(): " + docs.getChildren().size()); // claims that docs has four children when we add english essays :(, it's including the essay within the folder...
        docs.addFile("compSciAssignment", 90); // adding this does add one to count which is good but doesn't print in tree :(
        docs.addFile("chemLab", 90);
        docs.addFolder("englishEssays");
        FolderNode englishEssays = (FolderNode) ((FolderNode) root.getChildren().get(0)).getChildren().get(2);
        englishEssays.addFile("bookOfJob", 80);
        System.out.println(tree);
        // System.out.println(docs);
        Navigator nav = new Navigator(tree);
        String[] argus = new String[0];
        System.out.print("nav.count: ");
        nav.count(argus);
        System.out.println();
        System.out.println("docs children.size(): " + docs.getChildren().size()); // claims that docs has four children when we add english essays :(, it's including the essay within the folder...
        System.out.println("root children.size(): " + root.getChildren().size()); // works for root though???
        nav.ls(argus);

        String[] cdString1 = { "/", "src" };
        System.out.println();
        System.out.println(nav.getCurrentDirectory());
        nav.cd(cdString1);
        System.out.println();
        System.out.println(nav.getCurrentDirectory());

        String[] cdString2 = { "/", "docs", "/", "englishEssays" };
        String[] empty = {};
        System.out.println();
        System.out.print("with print: ");
        System.out.println(nav.getCurrentDirectory());
        System.out.print("with pwd: ");
        nav.pwd(empty);
        nav.cd(cdString2);
        System.out.println();
        System.out.println(nav.getCurrentDirectory());

        String[] cdString3 = { "..", "/" };
        nav.cd(cdString3);
        System.out.println();
        nav.pwd(empty);
        // works??? even w/ dash after?????
        // codegrade >:(

        String[] cdString4 = { ".", "/" };
        nav.cd(cdString4);
        System.out.println();
        nav.pwd(empty);

        String[] cdString5 = { "/"};
        nav.cd(cdString5);
        System.out.println();
        nav.pwd(empty);

        String[] cdString6 = { "docs"};
        nav.cd(cdString6);
        System.out.println();
        nav.pwd(empty);

        nav.tree(empty);

        System.out.println(root.getTotalNodeCount());

        nav.size(empty);
        System.out.println(root.getHeight());
    }

}