package main.Tools;

public class PassSaver {
    private String key;
    private String parrentName;
    private String className;
    private boolean methodOrNot;

    public  PassSaver(String _key, String _parrentName, String _className, boolean _methodOrNot){
        key = _key;
        parrentName = _parrentName;
        className = _className;
        methodOrNot = _methodOrNot;
    }
    public PassSaver(String _key, String _className, boolean _methodVar){
        key = _key;
        parrentName = null;
        className = _className;
        methodOrNot = _methodVar;
    }
    public boolean doesItHaveConflict(String name, String _className, String _parrentName, boolean type){
        if(key.equals(name) && type == methodOrNot)
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
    public boolean isEqual(String name, boolean type)
    {
        return key.equals(name) && type == methodOrNot;
    }
    public String getClassName(){
        return className;
    }
    public void print(){
        System.out.println(key + " " + className + " " + parrentName );
    }
}
