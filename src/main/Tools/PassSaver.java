package main.Tools;

public class PassSaver {
    private String key;
    private String parrentName;
    private String className;
    public  PassSaver(String _key, String _parrentName, String _className){
        key = _key;
        parrentName = _parrentName;
        className = _className;
    }
    public PassSaver(String _key, String _className, boolean _methodVar){
        key = _key;
        parrentName = null;
        className = _className;
    }
    public boolean doesItHaveConflict(String name, String _className, String _parrentName){
        if(key.equals(name))
        {
            if(_parrentName != null)
                if(_parrentName.equals(className))
                    return true;
            if(parrentName != null)
                if(_className.equals(parrentName))
                    return true;

        }
        return false;
    }
    public boolean isEqual(String name)
    {
        return key.equals(name);
    }
    public String getClassName(){
        return className;
    }
    public void print(){
        System.out.println(key + " " + className + " " + parrentName );
    }
}
