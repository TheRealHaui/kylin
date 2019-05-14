/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kylin.engine.mr.steps.lookup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for class {@link LookupExecutableUtil}.
 *
 * @see LookupExecutableUtil
 */
public class LookupExecutableUtilTest {

    @Test
    public void testSetAndGetLookupTableName() {
        Map<String, String> map = new HashMap<>();
        LookupExecutableUtil.setLookupTableName("bxI,*2 $r", map);

        assertEquals("bxI,*2 $r", LookupExecutableUtil.getLookupTableName(map));
    }

    @Test
    public void testSetAndGetSegments() {
        Map<String, String> map = new HashMap<>();
        List<String> segmentList = new ArrayList<>(0);
        LookupExecutableUtil.setSegments(segmentList, map);

        assertEquals(0, LookupExecutableUtil.getSegments(map).size());


        map = new HashMap<>();
        segmentList = new ArrayList<>(1);
        segmentList.add("a a");
        LookupExecutableUtil.setSegments(segmentList, map);

        assertEquals(1, LookupExecutableUtil.getSegments(map).size());
        assertEquals("[a a]", LookupExecutableUtil.getSegments(map).toString());
    }

}