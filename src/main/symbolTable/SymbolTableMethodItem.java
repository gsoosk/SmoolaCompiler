package main.symbolTable;

import main.ast.Type.Type;

import java.util.ArrayList;


public class SymbolTableMethodItem extends SymbolTableItem {

    ArrayList<Type> argTypes = new ArrayList<>();
    Type returnType;
    public SymbolTableMethodItem(String name, ArrayList<Type> argTypes, Type retType) {
        this.name = name;
        this.argTypes = argTypes;
        this.returnType = retType;
    }
    public Type getReturnType()
    {
        return returnType;
    }
    public ArrayList<Type> getArgTypes()
    {
        return argTypes;
    }


    @Override
    public String getKey() { // it can be Method:<MethodName>
        String key = "Method:<";
        key = key.concat(name);
        key = key.concat(">");
        return key;
    }
}
