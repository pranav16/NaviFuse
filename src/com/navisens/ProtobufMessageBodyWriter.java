package com.navisens;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.protobuf.Message;

@Provider
@Produces("application/x-protobuf")
public class ProtobufMessageBodyWriter implements MessageBodyWriter<Message> {

	private Map<Object, byte[]> buffer = new WeakHashMap<Object, byte[]>();

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return Message.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Message t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			t.writeTo(baos);
		} catch (IOException e) {
			return -1;
		}
		byte[] bytes = baos.toByteArray();
		buffer.put(t, bytes);
		return bytes.length;
	}

	@Override
	public void writeTo(Message t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {

		entityStream.write(buffer.remove(t));
	}
}