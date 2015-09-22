/*
 * Copyright 2015 Karl Bennett
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

import shiver.me.timbers.building.AtomicBlock;
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
class LazyNumbersIterable<N extends Number> implements NumbersIterable<N> {

    private final Class<N> type;
    private final SingleNumbers<N> singleNumbers;
    private final int length;
    private final List<N> delegate;
    private final Builder<N> builder;

    public LazyNumbersIterable(Class<N> type, SingleNumbers<N> singleNumbers, int length) {
        this.type = type;
        this.singleNumbers = singleNumbers;
        this.length = length;
        this.delegate = new ArrayList<>(length);
        this.builder = new QueueBuilder<>(new LinkedList<Block<N>>());
    }

    @Override
    public List<N> list() {

        final List<N> list = new ArrayList<>();

        for (N n : this) {
            list.add(n);
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public N[] array() {

        final List<N> list = list();

        return list.toArray((N[]) Array.newInstance(type, list.size()));
    }

    @Override
    public Set<N> set() {
        return new HashSet<>(list());
    }

    @Override
    public NumbersIterable<N> thatAreRandom() {
        return addBlock(new AtomicBlock<N>() {
            @Override
            public N build() {
                return singleNumbers.someNumber();
            }
        });
    }

    @Override
    public NumbersIterable<N> thatArePositive() {
        return addBlock(new AtomicBlock<N>() {
            @Override
            public N build() {
                return singleNumbers.somePositiveNumber();
            }
        });
    }

    @Override
    public NumbersIterable<N> thatAreNegative() {
        return addBlock(new AtomicBlock<N>() {
            @Override
            public N build() {
                return singleNumbers.someNegativeNumber();
            }
        });
    }

    @Override
    public NumbersIterable<N> thatAreGreaterThan(final N size) {
        return addBlock(new AtomicBlock<N>() {
            @Override
            public N build() {
                return singleNumbers.someNumberGreaterThan(size);
            }
        });
    }

    @Override
    public NumbersIterable<N> thatAreLessThan(final N size) {
        return addBlock(new AtomicBlock<N>() {
            @Override
            public N build() {
                return singleNumbers.someNumberLessThan(size);
            }
        });
    }

    @Override
    public NumbersIterable<N> thatAreBetween(final N min, final N max) {
        return addBlock(new AtomicBlock<N>() {
            @Override
            public N build() {
                return singleNumbers.someNumberBetween(min, max);
            }
        });
    }

    @Override
    public Iterator<N> iterator() {

        if (delegate.isEmpty()) {
            for (N number : builder.iterable(length)) {
                delegate.add(number);
            }
        }

        if (delegate.isEmpty()) {
            for (int i = 0; i < length; i++) {
                delegate.add(singleNumbers.someNumber());
            }
        }

        return delegate.iterator();
    }

    private NumbersIterable<N> addBlock(Block<N> block) {

        builder.add(block);

        return this;
    }
}
