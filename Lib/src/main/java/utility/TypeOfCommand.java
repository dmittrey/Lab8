package utility;

public enum TypeOfCommand {
    Help("Help"),
    Info("Info"),
    Show("Show"),
    Clear("Clear"),
    History("History"),
    Min_by_students_count("Min by students"),
    Remove_by_id("Remove by id"),
    Count_less_than_students_count("Count less than students count"),
    Filter_starts_with_name("Filter starts with name"),
    Add("Add"),
    Add_if_max("Add if max"),
    Add_if_min("Add if min"),
    Execute_script("Execute script"),
    Update("Update"),
    Register("Register"),
    Login("Login"),
    Exit("Exit");

    private String value;

    TypeOfCommand(String aValue) {
        value = aValue;
    }

    public String getValue() {
        return value;
    }

    public static TypeOfCommand getEnum(String value) {
        for(TypeOfCommand v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        return null;
    }
}
