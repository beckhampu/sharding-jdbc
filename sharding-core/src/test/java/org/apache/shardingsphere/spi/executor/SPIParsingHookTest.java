/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.spi.executor;

import org.apache.shardingsphere.core.bootstrap.ShardingBootstrap;
import org.apache.shardingsphere.spi.fixture.ParsingHookFixture;
import org.apache.shardingsphere.spi.parsing.SPIParsingHook;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public final class SPIParsingHookTest {
    
    private SPIParsingHook spiParsingHook;
    
    @Before
    public void setUp() {
        ShardingBootstrap.init();
        ParsingHookFixture.clearActions();
        spiParsingHook = new SPIParsingHook();
    }
    
    @Test
    public void assertStart() {
        spiParsingHook.start("");
        assertTrue(ParsingHookFixture.containsAction("start"));
    }
    
    @Test
    public void assertFinishSuccess() {
        spiParsingHook.finishSuccess(null, null);
        assertTrue(ParsingHookFixture.containsAction("finishSuccess"));
    }
    
    @Test
    public void assertFinishFailure() {
        spiParsingHook.finishFailure(null);
        assertTrue(ParsingHookFixture.containsAction("finishFailure"));
    }
}
