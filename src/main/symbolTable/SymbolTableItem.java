package main.symbolTable;

import main.ast.Type.Type;

public abstract class SymbolTableItem {
	protected String name;

	public SymbolTableItem() {
	}
	public void setName(String _name)
	{
		name = _name;
	}

	public abstract String getKey();

}