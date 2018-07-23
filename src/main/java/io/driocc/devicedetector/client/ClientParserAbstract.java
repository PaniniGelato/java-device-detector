/**
 * 
 */
package io.driocc.devicedetector.client;

import java.util.List;

import io.driocc.devicedetector.DetectResult;
import io.driocc.devicedetector.ParserAbstract;

/**
 * @author kyon
 *
 */
public class ClientParserAbstract extends ParserAbstract{

	private static final long serialVersionUID = 1L;

	public DetectResult parse(String userAgent) {
		//TODO
		return null;
	}
	
	/**
     * Returns all names defined in the regexes
     *
     * Attention: This method might not return all names of detected clients
     *
     * @return array
     */
	public List<String> getAvailableClients(){
		//TODO
		return null;
	}
}
