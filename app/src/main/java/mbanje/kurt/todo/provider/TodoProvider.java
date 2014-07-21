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

package mbanje.kurt.todo.provider;

import com.peirr.droidprovider.sqlite.BaseDataStore;
import com.peirr.droidprovider.sqlite.BaseProvider;

/**
 * Created by kurt on 2014/07/18.
 */
public class TodoProvider extends BaseProvider {
    @Override
    public BaseDataStore getMyDB() {
        return new TodoDataStore(getContext());
    }
}
