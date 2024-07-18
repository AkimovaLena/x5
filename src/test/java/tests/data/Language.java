package tests.data;

public enum Language {
    RU("Выбор в пользу будущего"),
    EN("For the future");

    public final String description;

    Language(String description) {
        this.description = description;
    }

    public String nameLower(){
        return this.name().toLowerCase();
    }

    public Language another(){
        if (this == RU)
            return EN;
        else return RU;
    }
}
