package com.liuxiankai.blog.utils;

import com.liuxiankai.blog.po.User;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.servlet.http.HttpSession;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liuxiankai
 */
public class Utils {

    public static boolean check(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getType() != 1) {
            return false;
        }
        return true;
    }

    public static String[] getNullPropertyNames(Object source) {
        BeanWrapper beanWrapper = new BeanWrapperImpl();
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        List<String> nullPropertyNames = new ArrayList<>();
        for (PropertyDescriptor pd: pds) {
            String propertyName = pd.getName();
            if (beanWrapper.getPropertyValue(propertyName) == null){
                nullPropertyNames.add(propertyName);
            }
        }
        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }
    public static String markDownToHTML(String markdown){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    public static String markDownToHTMLExtensions(String markdown){
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        List<Extension> tableExtensions = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(tableExtensions)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
        .extensions(headingAnchorExtensions)
        .extensions(tableExtensions)
        .attributeProviderFactory(new AttributeProviderFactory() {
            @Override
            public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                return new CustomAttributeProvider();
            }
        })
        .build();
        return renderer.render(document);
    }

    static class CustomAttributeProvider implements AttributeProvider{

        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            if (node instanceof Link){
                attributes.put("target","_blank");
            }
            if (node instanceof TableBlock){
                attributes.put("class","ui celled table");
            }
        }
    }
}
