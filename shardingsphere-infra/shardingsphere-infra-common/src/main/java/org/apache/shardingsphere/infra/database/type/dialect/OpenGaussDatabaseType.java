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

package org.apache.shardingsphere.infra.database.type.dialect;

import org.apache.shardingsphere.infra.database.metadata.dialect.OpenGaussDataSourceMetaData;
import org.apache.shardingsphere.infra.database.type.DatabaseType;
import org.apache.shardingsphere.sql.parser.sql.common.constant.QuoteCharacter;
import org.postgresql.ds.PGSimpleDataSource;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Database type of openGauss.
 */
public final class OpenGaussDatabaseType implements DatabaseType {
    
    @Override
    public String getName() {
        return "openGauss";
    }
    
    @Override
    public QuoteCharacter getQuoteCharacter() {
        return QuoteCharacter.QUOTE;
    }
    
    @Override
    public Collection<String> getJdbcUrlPrefixes() {
        return Collections.singleton(String.format("jdbc:%s:", getName().toLowerCase()));
    }
    
    @Override
    public OpenGaussDataSourceMetaData getDataSourceMetaData(final String url, final String username) {
        return new OpenGaussDataSourceMetaData(url);
    }
    
    @Override
    public Optional<String> getDataSourceClassName() {
        return Optional.of(PGSimpleDataSource.class.getName());
    }
}
