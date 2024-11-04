package com.JL_code.stu.SpecialFile;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
public class XMLReader {
    public static void main(String[] args) {
        try {
            // 创建一个DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // 创建一个DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 解析XML文件并获取Document对象
            Document document = builder.parse(new File("JL\\src\\com\\JL_code\\stu\\SpecialFile\\users.xml"));
            /**
             * filename must start from File ,not module
             * run successfully with absolute path
             * but NOT with filename even in the same module
             */
            // 获取根元素
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            // 获取所有user元素
            NodeList userList = document.getElementsByTagName("user");

            // 遍历user元素
            for (int i = 0; i < userList.getLength(); i++) {
                Node userNode = userList.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;
                    String id = userElement.getAttribute("id");
                    String name = userElement.getElementsByTagName("name").item(0).getTextContent();
                    String email = userElement.getElementsByTagName("email").item(0).getTextContent();
                    String age = userElement.getElementsByTagName("age").item(0).getTextContent();
                    String nickname = userElement.getElementsByTagName("nickname").item(0).getTextContent();
                    System.out.println("User  ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                    System.out.println("Age: " + age);
                    System.out.println("Nickname: " + nickname);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}