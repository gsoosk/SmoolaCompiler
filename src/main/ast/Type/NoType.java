package main.ast.Type;

public class NoType extends Type {
    String typeErrorMsg;

    @Override
    public String toString() {
        return "NoType";
    }
    public NoType()
    {
        typeErrorMsg = "";
    }
    public boolean hasError()
    {
        return !typeErrorMsg.equals("");
    }
    public NoType(String _typeErrorMsg)
    {
        typeErrorMsg = _typeErrorMsg;
    }
    public void setTypeErrorMsg(String msg)
    {
        typeErrorMsg = msg;
    }
    public String getTypeErrorMsg()
    {
        return typeErrorMsg;
    }
}
