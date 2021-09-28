package application.util;

public class EnumHelper {

    // static and generic!!! because of the T as input any of enum is OK ... column or table, no matter! (just 1 thing be ENUM!)

    public static <T extends Enum<T>> int getDataBaseIndex(Enum<T> tEnum) {
        return (tEnum.ordinal() + 1);
    }

    public static <T extends Enum<T>> String getDataBaseName(Enum<T> enumToUse, boolean isEnumInDB) {
        String name = enumToUse.name().toLowerCase();

        if (isEnumInDB) {
            return name.replace("_", " ");
        } else if ("ID".equals(name)) {
            return name.toUpperCase();
        }

        return name;
    }
}
