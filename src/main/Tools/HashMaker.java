package main.Tools;

import javafx.util.Pair;
import main.symbolTable.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMaker {

    private static HashMap<String, ArrayList<String> > classesTree = new HashMap<String, ArrayList<String>>();
    private static HashMap<String, SymbolTable> symbolTables;

    private static void makeClassesTree(ArrayList< Pair<String , String> > ArrayOfClasses)
    {
        for (Pair<String, String> ArrayOfClass : ArrayOfClasses) {
            ArrayList<String> childs = new ArrayList<>();
            classesTree.put(ArrayOfClass.getKey(), childs);
        }
        for (Pair<String, String> ArrayOfClass : ArrayOfClasses) {
            String parrent = ArrayOfClass.getValue();
            if(parrent != null) {
                ArrayList<String> childs = classesTree.get(parrent);
                childs.add(ArrayOfClass.getKey());
                classesTree.replace(parrent, childs);
            }
        }
    }
    public static HashMap<String, SymbolTable> makeHash(
            ArrayList< Pair<String , String> > ArrayOfClasses, HashMap<String, SymbolTable> allClassesSymbolTable )
    {
        symbolTables = allClassesSymbolTable;
        makeClassesTree(ArrayOfClasses);
        for (Pair<String, String> ArrayOfClass : ArrayOfClasses) {
            if(ArrayOfClass.getValue() == null)
                addChildSymbolTables(ArrayOfClass.getKey());
        }
        return symbolTables;
    }
    private static void addChildSymbolTables(String name)
    {
        ArrayList<String> childs = classesTree.get(name);
        for(String child : childs)
        {
            symbolTables.get(child).putMultiple(symbolTables.get(name).getItems());
            addChildSymbolTables(child);
        }
    }
    public static HashMap<String, ArrayList<String> > getClassesTree() {
        return classesTree;
    }

}
