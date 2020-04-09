package org.jiage.srpc.server.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class createXmlText {

    /**
     * 生成xml方法
     */
    public static String createXmlContent() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        Document document = db.newDocument();
        document.setXmlStandalone(true);
        Element content = document.createElement("content");
        Element text = document.createElement("text");
        text.setTextContent("PublicBookshelf has science books that cover a wide...");
        content.appendChild(text);
        Element text2 = document.createElement("text");
        text2.setTextContent("Social science titles included in...");
        content.appendChild(text2);
        //book.setAttribute("id", "1");
        document.appendChild(content);
        Element image = document.createElement("image");
        image.setAttribute("src","http://loops.com/image/xxxx.jpg");
        content.appendChild(image);
        Element image2 = document.createElement("image");
        image2.setAttribute("src","http://loops.com/image/xxxx2.jpg");
        content.appendChild(image2);
        Element video = document.createElement("video");
        video.setAttribute("src","http://loops.com/video/xxxx.jpg");
        content.appendChild(video);
        //output xml to string
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString(); // .replaceAll("\n|\r", "");
        writer.close();
        return output;
    }

    public static ContentXml parseXmlContent(String content) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new ByteArrayInputStream(content.getBytes()));
        Element rootElement = document.getDocumentElement();
        NodeList list = rootElement.getChildNodes();
        if(list == null || list.getLength() == 0) return null;
        //texts
        List<String> texts = new ArrayList<>();
        //images
        List<String> images = new ArrayList<>();
        //videos
        List<String> videos = new ArrayList<>();
        for(int i=0; i<list.getLength(); i++){
            Node node = list.item(i);
            switch (node.getNodeName()){
                case "text":
                    texts.add(node.getTextContent());
                    break;
                case "image":
                    images.add(node.getAttributes().getNamedItem("src").getTextContent());
                    break;
                case "video":
                    videos.add(node.getAttributes().getNamedItem("src").getTextContent());
            }
        }
        return new ContentXml(texts,images,videos);
    }


    @Test
    public void parseTest() throws Exception{
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><content><text>PublicBookshelf has science books that cover a wide...</text><text>Social science titles included in...</text><image src=\"http://loops.com/image/xxxx.jpg\"/><image src=\"http://loops.com/image/xxxx2.jpg\"/><video src=\"http://loops.com/video/xxxx.jpg\"/></content>";
        ContentXml contentXml = parseXmlContent(content);
        System.out.println(contentXml);
    }


    @Test
    public void createTest() throws Exception {
        String xmlContent = createXmlContent();
        System.out.println(xmlContent);

    }
}
