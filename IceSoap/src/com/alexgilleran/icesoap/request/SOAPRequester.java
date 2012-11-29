package com.alexgilleran.icesoap.request;

import java.io.IOException;

import com.alexgilleran.icesoap.envelope.SOAPEnvelope;
import com.alexgilleran.icesoap.request.impl.Response;

/**
 * Handles SOAP requests
 * 
 * Ideally this should allow for transport-independent resolution of SOAP
 * requests but unfortunately the handling of HTTP errors inside the
 * {@link Request} object makes this a fairly leaky abstraction - stay tuned for
 * a fix.
 * 
 * @author Alex Gilleran
 * 
 */
public interface SOAPRequester {
	/**
	 * Performs a SOAP request
	 * 
	 * @param envelope
	 *            The SOAP envelope to send
	 * @param targetUrl
	 *            The url of the SOAP web service to communicate with.
	 * @return An InputStream representing the
	 * @throws IOException
	 */
	public Response doSoapRequest(SOAPEnvelope envelope, String targetUrl)
			throws IOException;

	/**
	 * Performs a SOAP request
	 * 
	 * @param envelope
	 *            The SOAP envelope to send
	 * @param targetUrl
	 *            The url of the SOAP web service to communicate with.
	 * @param soapAction
	 *            The SOAP Action to perform - this is put in the
	 *            <code>SOAPAction</code> field of the outgoing HTTP post.
	 * @return An InputStream representing the
	 * @throws IOException
	 */
	public Response doSoapRequest(SOAPEnvelope envelope, String targetUrl,
			String soapAction) throws IOException;

	/**
	 * Set the timeout for making connections to the server.
	 * 
	 * @param timeout
	 *            Timeout time in milliseconds.
	 */
	public void setConnectionTimeout(int timeout);

	/**
	 * Set the timeout for receiving data from the server - note that this takes
	 * into account time to establish a connection, send the envelope, wait for
	 * the server to process and then recieve it.
	 * 
	 * @param timeout
	 *            Timeout time in milliseconds.
	 */
	public void setSocketTimeout(int timeout);
}