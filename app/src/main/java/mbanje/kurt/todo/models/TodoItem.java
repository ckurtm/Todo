/*
 * Copyright (c) 2012 Kurt Mbanje
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *   ckurtm at gmail dot com
 *   https://github.com/ckurtm/DroidProvider
 */

package mbanje.kurt.todo.models;


import ckm.simple.sql_provider.annotation.SimpleSQLColumn;
import ckm.simple.sql_provider.annotation.SimpleSQLTable;
import mbanje.kurt.todo.TodoProviderConfig;

/**
 * Created by kurt on 2014/07/18.
 */
@SimpleSQLTable(table = "todo",provider = TodoProviderConfig.PROVIDER_CLASS)
public class TodoItem {

    @SimpleSQLColumn(value = "_id",primary = true)
    public long _id;

    @SimpleSQLColumn(Mapper.label)
    public String label;

    @SimpleSQLColumn(Mapper.description)
    public String description;

    @SimpleSQLColumn(Mapper.completed)
    public boolean completed;


    public TodoItem() {
    }

    public TodoItem(String label, String description, boolean completed) {
        this.label = label;
        this.description = description;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        final TodoItem item = (TodoItem) o;

        if (completed != item.completed) return false;
        if (!description.equals(item.description)) return false;
        if (!label.equals(item.label)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + label.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (completed ? 1 : 0);
        return result;
    }

    public static final class Mapper {
        public static final String label = "label";
        public static final String description = "description";
        public static final String completed = "completed";
    }
}