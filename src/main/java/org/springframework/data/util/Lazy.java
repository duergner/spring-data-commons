/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.util;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author Oliver Gierke
 */
@RequiredArgsConstructor
@EqualsAndHashCode
public class Lazy<T> {

	private final Supplier<T> supplier;
	private Optional<T> value;

	public static <T> Lazy<T> of(Supplier<T> supplier) {
		return new Lazy<>(supplier);
	}

	/**
	 * Returns the value created by the configured {@link Supplier}.
	 * 
	 * @return
	 */
	public T get() {

		if (value == null) {
			this.value = Optional.ofNullable(supplier.get());
		}

		return value.orElse(null);
	}
}
