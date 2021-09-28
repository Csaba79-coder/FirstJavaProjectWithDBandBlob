package application.database;

import application.util.EnumHelper;

public class QueryBuilder {

    StringBuilder query;

    public QueryBuilder() {
        query = new StringBuilder();
    }

    // means none or more column!
    public QueryBuilder select(Table table, Column... columns) {
        query.append("SELECT ");
        if (columns.length > 0) {
            addColumns(columns);
        } else {
            query.append("*");
        }
        query.append(" FROM ").append(EnumHelper.getDataBaseName(table, false));
        return this;
    }

    public QueryBuilder where(Column column, boolean useLike) {
        query.append(" WHERE ")
                .append(EnumHelper.getDataBaseName(column, false))
                .append( (useLike ? " LIKE " : " = ") )
                .append("?");
        return this;
    }

    public QueryBuilder insert(Table table, Column... columns) {
        query.append("INSERT INTO ")
                .append(EnumHelper.getDataBaseName(table, false));

        int questionMark = (columns.length > 0 ? columns.length : table.COLUMN_NUM);

        if (columns.length > 0) {
            query.append("(");
            addColumns(columns);
            query.append(")");
        }

        prepareValues(questionMark);

        return this;
    }

    private void addColumns(Column... columns) {
        for (Column column : columns) {
            query.append(EnumHelper.getDataBaseName(column, false))
                    .append(", ");
        }
        query.setLength(query.length() - 2); // cutting off the last 2 chars, that is the last coma & space included!!!
    }

    private void prepareValues(int repeat) {
        query.append(" VALUES (")
                .append("?,".repeat(repeat));
        query.setLength(query.length() - 1);
        query.append(")");
    }

    // this one makes a String and close the line with ; and gives back!
    public String build() {
        query.append(";");
        return query.toString();
    }
}