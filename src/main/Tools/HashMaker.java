package main.Tools;

import javafx.util.Pair;
import main.ast.Type.Type;
import main.symbolTable.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMaker {

    private static HashMap<String, ArrayList<String> > classesTree = new HashMap<String, ArrayList<String>>();
    private static HashMap<String, SymbolTable> symbolTables;
    public static HashMap<String, Boolean> involvedCircularInh = new HashMap<String, Boolean>();
    public static HashMap<String, Boolean> involvedBadParent = new HashMap<String, Boolean>();
    private static boolean hasCycle (String type, String parent) {
        ArrayList<String> children = classesTree.get(parent);
        if (children.contains(type)) {
            return true;
        } else {
            boolean contain = false;
            for (String child : children) {
                if (hasCycle(type, child)) {
                    contain = true;
                    break;
                }
            }
            return contain;
        }
    }
    private static void checkCircularInheritence()
    {
        for(Map.Entry<String, ArrayList<String> > entry : classesTree.entrySet())
        {
            String className = entry.getKey();
            involvedCircularInh.put(className, hasCycle(className, className));
        }

    }
    private static boolean containsParent(String name)
    {
        for(Map.Entry<String, ArrayList<String> > entry : classesTree.entrySet())
        {
            String className = entry.getKey();
            if(className.equals(name))
                return true;
        }
        return false;
    }
    private static void makeClassesTree(ArrayList< Pair<String , String> > ArrayOfClasses)
    {
        for (Pair<String, String> ArrayOfClass : ArrayOfClasses) {
            ArrayList<String> childs = new ArrayList<>();
            classesTree.put(ArrayOfClass.getKey(), childs);
        }
        for (Pair<String, String> ArrayOfClass : ArrayOfClasses) {
            String parrent = ArrayOfClass.getValue();
            if(parrent != null) {
                if(!containsParent(parrent))
                {
                    involvedBadParent.put(ArrayOfClass.getKey(), true);
                }
                else
                {
                    involvedBadParent.put(ArrayOfClass.getKey(), false);
                    ArrayList<String> childs = classesTree.get(parrent);
                    childs.add(ArrayOfClass.getKey());
                    classesTree.replace(parrent, childs);
                }

            }
        }

    }
    public static HashMap<String, SymbolTable> makeHash(
            ArrayList< Pair<String , String> > ArrayOfClasses, HashMap<String, SymbolTable> allClassesSymbolTable )
    {
        symbolTables = allClassesSymbolTable;
        makeClassesTree(ArrayOfClasses);
        checkCircularInheritence();

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
