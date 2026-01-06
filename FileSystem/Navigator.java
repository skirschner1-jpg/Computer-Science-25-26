import java.util.Scanner;

/**
 * Handles interactive navigation of the file system
 * This class reads commands from standard input, interprets them,
 * and invokes operations on the current directory node.
 */
public class Navigator {

    private final FileSystemTree fileSystem;
    private FolderNode currentDirectory;
    private boolean shouldExit;

    /**
     * Constructs a navigator for a given file system tree.
     * The starting location is the root directory.
     */
    public Navigator(FileSystemTree fst) {
        this.fileSystem = fst;
        this.currentDirectory = fst.getRoot();
    }

    public FolderNode getCurrentDirectory() {
        return currentDirectory;
    }

    /**
     * Starts a command loop that repeatedly reads a line of input,
     * interprets it as a command with arguments, and executes it until
     * a request to terminate is received.
     */
    public void run() {
        shouldExit = false;
        Scanner kb = new Scanner(System.in);

        while (!shouldExit) {
            // Prompt can be customized to show current path if desired.
            String line = kb.nextLine();
            processUserInputString(line);
        }

        kb.close();
    }
    // not me

    /**
     * Changes the current directory based on a single path argument.
     * Behavior should mirror typical Unix shells:
     *   - "."  refers to the current directory (no change).
     *   - ".." moves to the parent directory (if one exists).
     *   - Paths starting with "/" are interpreted from the root directory.
     *   - Other paths are interpreted relative to the current directory.
     */
    public void cd(String[] args) {
        if (args.length == 0 || args[0] == null) {
            return;
        }
        String[] newArgs = new String[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            newArgs[i] = args[i + 1];
        }
        if (args[0].equals(".")) {
            cdHelper(currentDirectory, newArgs);
        } else if (args[0].equals("..")) {
            if (!currentDirectory.getName().equals("/")) {
                currentDirectory = currentDirectory.getParent();
            }
            cdHelper(currentDirectory, newArgs);
        } else if (args[0].equals("/")) {
            currentDirectory = fileSystem.getRoot();
            cdHelper(currentDirectory, newArgs);
        }else{
            cdHelper(currentDirectory, args);
        } // LEFT THIS OUT!!!!! :(
    }
    // also changed to public??
    // CD HELPERS
    public void cdHelper(FileSystemNode currentdir, String args[]) {
        // System.out.println("here1");
        // System.out.println("args[0]: " + args[0]);
        if (args.length == 0 || args[0] == null) {
            // System.out.println("here2");
            return;
        }
        String[] newArgs = new String[args.length - 1];
        // System.out.println("args[0]: " + args[0]);
        for (int i = 0; i < args.length - 1; i++) {
            newArgs[i] = args[i + 1];
        }
        if (args.length == 0 || !currentdir.isFolder()) {
            return;
        }
        if (args[0].equals(".")) {
            // currentDirectory = currentDirectory; //comment out
        } else if (args[0].equals("..")) {
            currentDirectory = currentDirectory.getParent();
            cdHelper(currentDirectory, newArgs);
        } else if (args[0].equals("/")) {
            // currentDirectory = fileSystem.getRoot();
            cdHelper(currentDirectory, newArgs);
        }
        for (int i = 0; i < args.length; i++) {
            String toFind = args[0];
            if (findForCdBool(toFind)) {
                // System.out.println("here");
                if (currentdir.isFolder()) {
                    currentDirectory = (FolderNode) findForCdReturn(toFind);
                } else {
                    System.out.println("no such directory" + currentDirectory); // should make sure we're not allowed to go into a file
                    return;
                }
            } 
            // else {
            //     // System.out.println("here");
            //     System.out.println("no such file or directory: " + args[0]);
            //     return;
            // }
        }
        if (currentDirectory.isFolder()) {
            // FileSystemTree currentFile = new FileSystemTree(currentDirectory);
            cdHelper(currentDirectory, newArgs);
        }
    }
    

    private boolean findForCdBool(String name) {
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            if (currentDirectory.getChildren().get(i).getName().equals(name)) {
                // System.out.println("found");
                return true;
            }
        }
        return false;   
    }

    private FileSystemNode findForCdReturn(String name) {
        FileSystemNode toReturn = null;
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            if (currentDirectory.getChildren().get(i).getName().equals(name)) {
                toReturn = currentDirectory.getChildren().get(i);
            }
        }
        return toReturn;
    }
    // in progress

    // END OF CD HELPERS

    /**
     * Lists all items contained directly in the current directory.
     * Output formatting can mirror typical file system listings.
     */
    public void ls(String[] args) {
        // TODO: print names of all child nodes of currentDirectory
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            // System.out.println("here");
            System.out.print(currentDirectory.getChildren().get(i).getName());
            if (currentDirectory.getChildren().get(i).isFolder()) {
                System.out.print("/");
            }
            System.out.println();
        }
    }
    // not done
    // doesn't work on a folder that has folders within it?????
    // again changed to public???

    /**
     * Creates a new directory inside the current directory using the provided name.
     */
    private void mkdir(String[] args) {
        // TODO: read folder name from args and delegate to currentDirectory.addFolder(...)
        currentDirectory.addFolder(args[1]);
    }
    // DONE

    /**
     * Creates a new file inside the current directory with a given name and size.
     */
    private void touch(String[] args) {
        // TODO: read file name and size from args and delegate to currentDirectory.addFile(...)
        int size = Integer.parseInt(args[2]);
        currentDirectory.addFile(args[1], size);
    }
    // DONE
    // am i even right that it's index 1 & index 2??

    /**
     * Searches the current directory and its descendants for nodes with a given name
     * and prints their paths.
     */
    private void find(String[] args) {
        // TODO: use recursive search starting at currentDirectory
        if (args.length == 0) {
            return;
        }
        FolderNode save = currentDirectory;
        findHelper(args[0]);
        currentDirectory = save;
    }
    // DONE

    private void findHelper(String toFind) {
        // String toReturn = "";
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            if (currentDirectory.getChildren().get(i).getName().equals(toFind)) {
                System.out.println(currentDirectory.getChildren().get(i));
            }
            if (currentDirectory.getChildren().get(i).isFolder()) {
                FolderNode thisFolder = (FolderNode) currentDirectory.getChildren().get(i);
                currentDirectory = thisFolder;
                findHelper(toFind);
            }
        }
        // return toReturn;
    }

    /**
     * Prints the absolute path of the current directory, from the root to this node.
     */
    public void pwd(String[] args) {
        // TODO: use currentDirectory.toString() or similar path builder
        System.out.println(currentDirectory.toString());
    }
    // DONE (nvm)
    // also made public?

    /**
     * Displays the contents of the current directory as a tree, optionally
     * respecting flags or depth limits if provided by the arguments.
     */
    public void tree(String[] args) {
        // TODO: implement tree-style printing with indentation and branch characters
        treeHelper(currentDirectory, 0);
    }
    // changed to public
    
    private void treeHelper(FolderNode curr, int tabNumber) {
        for (int i = 0; i < curr.getChildren().size(); i++) {
            System.out.print("|");
            if (tabNumber > 0) {
                System.out.print("   ");
                for (int j = 1; j < tabNumber; j++) {
                    System.out.print("    ");
                }
                System.out.print("|");
            }
            System.out.print("---");
            System.out.println(curr.getChildren().get(i).getName());
            if (curr.getChildren().get(i).isFolder() //was using currentDirectory instead of curr!
                    && ((FolderNode) curr.getChildren().get(i)).getHeight() >= 1) {
                FolderNode newCurr = (FolderNode) curr.getChildren().get(i);
                treeHelper(newCurr, tabNumber+1); // need ++ before, otherwise it'll add AFTER line, also ++ modified for future
            }
        }
    }
    // i think stack overflow is result of issue w/ size maybe??
    // would be really evil if they put the folders in each other (!!!)

    /**
     * Prints how many nodes (files and folders) exist in the current directory
     * and all of its subdirectories.
     */
    public void count(String[] args) {
        // TODO: call a counting method on currentDirectory
        System.out.println(countHelper());
    }
    // confused about why there are arguments??? do i need to account for if they're weird? do i need to use them?
    // changed to public (is that ok?)
    // DONE

    // HELPER METHOD
    private int countHelper() {
        // int count = 0;
        int curr = currentDirectory.getChildren().size();
        if (currentDirectory.isFolder()) {
            for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
                if (currentDirectory.getChildren().get(i).isFolder()) {
                    // FolderNode prevDirectory = currentDirectory;
                    currentDirectory = (FolderNode) currentDirectory.getChildren().get(i);
                    return curr + countHelper();
                }
            }   
        }
        return curr;
    }

    /**
     * Prints the total size of all files reachable from the current directory.
     */
    public void size(String[] args) {
        // TODO: call a size-calculation method on currentDirectory
        FolderNode save = currentDirectory;
        System.out.println(sizeHelper(currentDirectory));
        currentDirectory = save;
        // return curr;
    }
    // in progress
    // made public

    private int sizeHelper(FolderNode curr) {
        int count = 0;
        if (curr.isFolder()) {
            for (int i = 0; i < curr.getChildren().size(); i++) {
                if (curr.getChildren().get(i).isFolder()) {
                    count += sizeHelper((FolderNode) curr.getChildren().get(i));
                } else {
                    count += curr.getChildren().get(i).getSize();
                }
            }
        }
        return count;
    }
    // had to do curr

    /**
     * Prints the depth of the current directory, defined as the number of edges
     * from the root directory down to this directory.
     */
    private void depth(String[] args) {
        // TODO: use a depth method on currentDirectory
        FolderNode save = currentDirectory;
        int counter = 0;
        String[] toCd = { ".." };
        while (!currentDirectory.getName().equals("/")) {
            counter++;
            cd(toCd);
        }
        System.out.println(counter);
    }
    // DONE

    /**
     * Prints the height of the current directory, defined as the longest downward
     * distance from this directory to any file or subdirectory beneath it.
     * An empty directory has value 0.
     */
    private void height(String[] args) {
        // TODO: use a height method on currentDirectory
        // System.out.println(heightHelper(currentDirectory));
        System.out.println(currentDirectory.getHeight());
    }

    // private int heightHelper(FolderNode curr) {
    //     if (currentDirectory.getChildren().size() == 0) {
    //         return 0;
    //     }
    //     int counter = 0;
    //     for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
    //         if (currentDirectory.getChildren().get(i).isFolder()
    //                 && heightHelper((FolderNode) currentDirectory.getChildren().get(i)) > counter) {
    //             counter = heightHelper((FolderNode) currentDirectory.getChildren().get(i));
    //         }
    //     }
    //     return counter;
    // }
    // DONE

    /**
     * Signals that the interactive loop should terminate after the current command.
     */
    private void quit(String[] args) {
        shouldExit = true;
    }
    // not me

    /**
     * Interprets a line of user input by splitting it into a command and arguments,
     * then forwarding control to the appropriate helper method.
     *
     * Example inputs and how they are interpreted:
     *   "ls"
     *       -> command: "ls"
     *          args: []
     *
     *   "mkdir docs"
     *       -> command: "mkdir"
     *          args: ["docs"]
     *
     *   "touch notes.txt 100"
     *       -> command: "touch"
     *          args: ["notes.txt", "100"]
     *
     *   "cd .."
     *       -> command: "cd"
     *          args: [".."]
     */
    public void processUserInputString(String line) {
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        String[] parts = line.trim().split("\\s+");
        String command = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, args.length);

        switch (command) {
            case "cd":
                cd(args);
                break;
            case "ls":
                ls(args);
                break;
            case "mkdir":
                mkdir(args);
                break;
            case "touch":
                touch(args);
                break;
            case "find":
                find(args);
                break;
            case "pwd":
                pwd(args);
                break;
            case "tree":
                tree(args);
                break;
            case "count":
                count(args);
                break;
            case "size":
                size(args);
                break;
            case "depth":
                depth(args);
                break;
            case "height":
                height(args);
                break;
            case "quit":
                quit(args);
                break;
            default:
                // Unknown commands can be reported back to the user.
                System.out.println("Unrecognized command: " + command);
        }
    }
    // not me
}
