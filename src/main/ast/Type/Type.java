package main.ast.Type;

public abstract class Type {
    public abstract String toString();
    private String code;
    public String getCode()
    {
        return code;
    }
    public void setCode(String _code)
    {
        this.code = _code;
    }
}
