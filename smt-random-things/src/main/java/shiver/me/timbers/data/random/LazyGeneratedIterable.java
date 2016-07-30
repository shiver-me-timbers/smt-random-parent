/*
 * Copyright 2016 Karl Bennett
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package shiver.me.timbers.data.random;

import shiver.me.timbers.building.Block;
import shiver.me.timbers.building.Builder;
import shiver.me.timbers.building.QueueBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Karl Bennett
 */
class LazyGeneratedIterable<T> implements GeneratedIterable<T> {

    private final Class<T> type;
    private int length;
    private final Block<T> defaultGenerator;
    private final List<T> delegate;
    private final Builder<T> builder;

    public LazyGeneratedIterable(Class<T> type, int length, Block<T> defaultGenerator) {
        this.type = type;
        this.length = length;
        this.defaultGenerator = defaultGenerator;
        this.delegate = new ArrayList<>(this.length);
        this.builder = new QueueBuilder<>(new LinkedList<Block<T>>());
    }

    @Override
    public GeneratedIterable<T> withGenerator(Block<T> generator) {
        builder.add(generator);
        return this;
    }

    @Override
    public GeneratedIterable<T> withLength(int length) {
        this.length = length;
        return this;
    }

    @Override
    public List<T> list() {

        final List<T> list = new ArrayList<>();

        // We iterate over this instead of just returning the delegate because we need to make sure the building and
        // caching logic in the iterator() method has been run.
        for (T t : this) {
            list.add(t);
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] array() {
        final List<T> list = list();
        return list.toArray((T[]) Array.newInstance(type, list.size()));
    }

    @Override
    public Set<T> set() {
        return new HashSet<>(list());
    }

    @Override
    public Iterator<T> iterator() {

        if (builder.isEmpty()) {
            builder.add(defaultGenerator);
        }

        if (delegate.isEmpty()) {
            for (T number : builder.iterable(length)) {
                delegate.add(number);
            }
        }

        return delegate.iterator();
    }

}
