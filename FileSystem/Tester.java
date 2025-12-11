public class Tester {

    private FileSystemTree fileSystem;
    private FolderNode currentDirectory;
    private boolean shouldExit;

    public void setCd(FolderNode cd){
        currentDirectory = cd;
    }

    private void cd(String[] args) {
        cdHelper(currentDirectory, args);
    }
    
    public void cdHelper(FileSystemNode currentdir, String args[]) {
        if (args.length == 0 || !currentdir.isFolder()) {
            return;
        }
        if (args[0].equals(".")) {
            // currentDirectory = currentDirectory; //comment out
        } else if (args[0].equals("..")) {
            currentDirectory = currentDirectory.getParent();
        } else if (args[0].equals("/")) {
            currentDirectory = fileSystem.getRoot();
        }
        for (int i = 1; i < args.length; i++) {
            String toFind = args[1];
            if (findForCdBool(toFind)) {
                if (currentdir.isFolder()) {
                    currentDirectory = (FolderNode) findForCdReturn(toFind);
                } else {
                    System.out.println("no such file or directory: " + args[0]);
                    return;
                }
            } else {
                System.out.println("no such file or directory: " + args[0]);
                return;
            }
        }
        String[] newArgs = new String[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            newArgs[i] = args[i + 1];
        }
        if (currentDirectory.isFolder()) {
            // FileSystemTree currentFile = new FileSystemTree(currentDirectory);
            cdHelper(currentDirectory, newArgs);
        }
    }
    
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

    private boolean findForCdBool(String name) {
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            if (currentDirectory.getChildren().get(i).getName().equals(name)) {
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
    
    public static void main(String[] args) {
        Tester t = new Tester();
        String[] arr = new String[3];
        arr[0] = ".";
        arr[1] = "2";
        arr[2] = "3";
        t.cd(arr);
    }
}
