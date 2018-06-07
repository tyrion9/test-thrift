package com.test.test_thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.baeldung.thrift.impl.CrossPlatformResource;
import com.baeldung.thrift.impl.CrossPlatformService;

public class Client {
	public boolean ping() {
		try {
			TTransport transport;

			transport = new TSocket("localhost", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			CrossPlatformService.Client client = new CrossPlatformService.Client(protocol);

			System.out.println("Calling remote method...");

			boolean result = client.ping();
			
			long start = System.currentTimeMillis();
			
			CrossPlatformResource resource = client.get(10);
			
			System.out.println("ResourceName: " + resource.getName() + ", take " + (System.currentTimeMillis() - start));

			System.out.println("done.");

			transport.close();

			return result;
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException x) {
			x.printStackTrace();
		}

		return false;
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.ping();
	}
}
