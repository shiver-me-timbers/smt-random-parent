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

/**
 * @author Karl Bennett
 */
class NumbersOverflowChecker<N extends Number> implements OverflowChecker<N> {

    private final BoundNumberOperations<N> ops;

    public NumbersOverflowChecker(BoundNumberOperations<N> ops) {
        this.ops = ops;
    }

    @Override
    public boolean willNotOverflowIfSummed(N left, N right) {

        if (ops.isNegative(left) && ops.isPositive(right)) {
            return true;
        }

        if (ops.isPositive(left) && ops.isNegative(right)) {
            return true;
        }

        if (ops.min().equals(left) || ops.min().equals(right)) {
            return false;
        }

        if (ops.max().equals(left) || ops.max().equals(right)) {
            return false;
        }

        final N absLeft = ops.abs(left);
        final N absRight = ops.abs(right);

        return ops.greaterThan(ops.minus(ops.max(), absLeft), absRight);
    }

    @Override
    public boolean willNotOverflowIfSubtracted(N left, N right) {
        return willNotOverflowIfSummed(left, ops.switchSign(right));
    }
}
