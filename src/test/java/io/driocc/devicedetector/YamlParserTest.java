/**
 * 
 */
package io.driocc.devicedetector;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;

/**
 * @author kyon
 *
 */
public class YamlParserTest {
	@Test
	public void test() throws Exception {
		String path = "regexes/oss.yml";

        Yaml yaml = new Yaml();
        InputStream is = YamlParserTest.class.getClassLoader().getResourceAsStream(path);
        Iterator<Event> events = yaml.parse(new InputStreamReader(is)).iterator();
        assertTrue(events.next() instanceof StreamStartEvent);
        DocumentStartEvent documentStartEvent = (DocumentStartEvent) events.next();
        assertTrue(documentStartEvent.getExplicit());
        assertEquals(DumperOptions.Version.V1_1, documentStartEvent.getVersion());
        Map<String, String> DEFAULT_TAGS = new HashMap<String, String>();
        DEFAULT_TAGS.put("!", "!");
        DEFAULT_TAGS.put("!!", Tag.PREFIX);
        assertEquals(DEFAULT_TAGS, documentStartEvent.getTags());
        ScalarEvent scalarEvent = (ScalarEvent) events.next();
        assertNull(scalarEvent.getAnchor());
        assertNull(scalarEvent.getTag());
        assertEquals(new ImplicitTuple(true, false).toString(), scalarEvent.getImplicit().toString());
        DocumentEndEvent documentEndEvent = (DocumentEndEvent) events.next();
        assertFalse(documentEndEvent.getExplicit());
        assertTrue("Unexpected event.", events.next() instanceof StreamEndEvent);
        assertFalse(events.hasNext());
	}
}
