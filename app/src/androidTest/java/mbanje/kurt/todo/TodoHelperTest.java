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

package mbanje.kurt.todo;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.test.ProviderTestCase2;

import java.io.IOException;

import mbanje.kurt.todo.models.TodoItem;
import mbanje.kurt.todo.provider.TodoHelper;

/**
 * Created by kurt on 2014/07/19.
 */
public class TodoHelperTest extends ProviderTestCase2<TodoProvider> {
    private ContentResolver resolver;

    public TodoHelperTest() {
        super(TodoProvider.class,"mbanje.kurt.todo.debug");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        resolver = getContext().getContentResolver();
    }

    public void testInsertDelete () throws IOException {
        //INSERT
        TodoItem item = new TodoItem("one","the description",false);
        Uri uri = TodoHelper.createTodo(resolver, item);
        assertNotNull(uri);
        //DELETE
//        long id = ContentUris.parseId(uri);
//        item.label = id;
//        int result = TodoHelper.deleteTodo(resolver, item);
//        assertEquals(1,result);
    }


    public void testInsertUpdateQueryDelete () throws Exception {
        //INSERT
        TodoItem item = new TodoItem("one","the description",false);
        item._id =1;
        Uri uri = TodoHelper.createTodo(resolver, item);
        assertNotNull(uri);
        long id = ContentUris.parseId(uri);
        item._id = id;

        //UPDATE
        item.label = "kurt";
        int updates = TodoHelper.updateTodo(resolver, item);
        assertEquals(1,updates);

        //QUERY
        TodoItem upItem = TodoHelper.getTodo(resolver, item.label);
        assertNotNull(upItem);
        assertEquals("kurt",upItem.label);

        //DELETE
        int result = TodoHelper.deleteTodo(resolver, upItem);
        assertEquals(1,result);
    }

}
