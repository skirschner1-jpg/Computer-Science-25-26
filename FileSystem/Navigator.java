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
    private void cd(String[] args) {
        // TODO: implement directory navigation
        if (args[0].equals(".")) {
            
        }
        if (args[0].equals("..")) {
            currentDirectory = currentDirectory.getParent();
        }
        if (args[0].equals("/")) {
            currentDirectory = fileSystem.getRoot();
            for (int i = 1; i < args.length; i++) {
                String[] toFind = {args[0]};
                find(toFind);
            }
        }
    }
    // in progress

    /**
     * Lists all items contained directly in the current directory.
     * Output formatting can mirror typical file system listings.
     */
    public void ls(String[] args) {
        // TODO: print names of all child nodes of currentDirectory
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            // System.out.println("here");
            System.out.println(currentDirectory.getChildren().get(i).getName());
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
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            if (currentDirectory.getChildren().get(i).getName().equals(args[1])) {

            }
            if (currentDirectory.getChildren().get(i).isFolder()) {
                // FolderNode thisFolder = (FolderNode) currentDirectory.getChildren().get(i);
                // Navigator thisNav = new Navigator(thisFolder);
                // thisNav.find(args);
            }
        }
    }
    // in progress

    /**
     * Prints the absolute path of the current directory, from the root to this node.
     */
    private void pwd(String[] args) {
        // TODO: use currentDirectory.toString() or similar path builder
        currentDirectory.toString();
    }
    // DONE

    /**
     * Displays the contents of the current directory as a tree, optionally
     * respecting flags or depth limits if provided by the arguments.
     */
    private void tree(String[] args) {
        // TODO: implement tree-style printing with indentation and branch characters
        fileSystem.toString();

    }

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
    private void size(String[] args) {
        // TODO: call a size-calculation method on currentDirectory
        int count = 0;
        if (currentDirectory.isFolder()) {
            for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
                if (!currentDirectory.getChildren().get(i).isFolder()) {
                    // FolderNode prevDirectory = currentDirectory;
                    count += currentDirectory.getChildren().get(i).getSize();
                    currentDirectory = (FolderNode) currentDirectory.getChildren().get(i);
                    // return curr + countHelper();
                }
            }
        }
        // return curr;
    }
    // in progress

    /**
     * Prints the depth of the current directory, defined as the number of edges
     * from the root directory down to this directory.
     */
    private void depth(String[] args) {
        // TODO: use a depth method on currentDirectory
    }

    /**
     * Prints the height of the current directory, defined as the longest downward
     * distance from this directory to any file or subdirectory beneath it.
     * An empty directory has value 0.
     */
    private void height(String[] args) {
        // TODO: use a height method on currentDirectory
    }

    /**
     * Signals that the interactive loop should terminate after the current command.
     */
    private void quit(String[] args) {
        shouldExit = true;
    }

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
