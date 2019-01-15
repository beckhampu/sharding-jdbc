/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
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
 * </p>
 */

package io.shardingsphere.transaction.xa.jta.resource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

/**
 * Single XA resource.
 *
 * @author zhaojun
 */
@RequiredArgsConstructor
@Getter
public final class SingleXAResource implements XAResource {
    
    private final String resourceName;
    
    private final XAResource delegate;
    
    @Override
    public void commit(final Xid xid, final boolean b) throws XAException {
        delegate.commit(xid, b);
    }
    
    @Override
    public void end(final Xid xid, final int i) throws XAException {
        delegate.end(xid, i);
    }
    
    @Override
    public void forget(final Xid xid) throws XAException {
        delegate.forget(xid);
    }
    
    @Override
    public int getTransactionTimeout() throws XAException {
        return delegate.getTransactionTimeout();
    }
    
    @Override
    public boolean isSameRM(final XAResource xaResource) {
        SingleXAResource singleXAResource = (SingleXAResource) xaResource;
        return resourceName.equals(singleXAResource.getResourceName());
    }
    
    @Override
    public int prepare(final Xid xid) throws XAException {
        return delegate.prepare(xid);
    }
    
    @Override
    public Xid[] recover(final int i) throws XAException {
        return delegate.recover(i);
    }
    
    @Override
    public void rollback(final Xid xid) throws XAException {
        delegate.rollback(xid);
    }
    
    @Override
    public boolean setTransactionTimeout(final int i) throws XAException {
        return delegate.setTransactionTimeout(i);
    }
    
    @Override
    public void start(final Xid xid, final int i) throws XAException {
        delegate.start(xid, i);
    }
}
