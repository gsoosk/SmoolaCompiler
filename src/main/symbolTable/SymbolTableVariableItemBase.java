package symbolTable;

import ast.Type.Type;

public abstract class SymbolTableVariableItemBase extends SymbolTableItem {

    private int index;
    protected Type type;

    public SymbolTableVariableItemBase(String name, Type type, int index) {
        this.name = name;
        this.type = type;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String getKey() {
        return name;
    }

    public int getIndex() {
        return index;
    }


}