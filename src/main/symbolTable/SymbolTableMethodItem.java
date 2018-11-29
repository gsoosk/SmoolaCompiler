package main.symbolTable;

import main.ast.Type.Type;

import java.util.ArrayList;


public class SymbolTableMethodItem extends SymbolTableItem {

    ArrayList<Type> argTypes = new ArrayList<>();

    public SymbolTableMethodItem(String name, ArrayList<Type> argTypes) {
        this.name = name;
        this.argTypes = argTypes;
    }
    public String setName(String name)
    {
        return this.name = name;
    }

    @Override
    public String getKey() { // it can be Method:<MethodName>
        String key = "Method:<";
        key = key.concat(name);
        key = key.concat(">");
        return key;
    }
}
