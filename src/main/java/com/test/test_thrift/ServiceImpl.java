package com.test.test_thrift;

import java.util.Collections;
import java.util.List;

import org.apache.thrift.TException;

import com.baeldung.thrift.impl.*;

public class ServiceImpl implements CrossPlatformService.Iface {

	@Override
	public CrossPlatformResource get(int id) throws InvalidOperationException, TException {
		return new CrossPlatformResource()
				.setId(id)
				.setName("HoaiPN")
				.setSalutation("Vui phet");
	}

	@Override
	public void save(CrossPlatformResource resource) throws InvalidOperationException, TException {
		
	}

	@Override
	public List<CrossPlatformResource> getList() throws InvalidOperationException, TException {
		return Collections.emptyList();
	}

	@Override
	public boolean ping() throws InvalidOperationException, TException {
		return true;
	}

}
