package com.qin.util;

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

import java.util.*;

/**
 * @program: my-blog
 * @description:
 * @author: qinda
 * @create: 2020-04-21 14:11
 **/
public class MarkdownUtil {

    public static String markdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    public static String markdownToHtmlExtensions(String markdown) {
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());

        List<Extension> tableExtension = Arrays.asList(TablesExtension.create());

        Parser parser = Parser.builder().extensions(tableExtension).build();

        Node document = parser.parse(markdown);

        HtmlRenderer renderer = HtmlRenderer.builder().extensions(headingAnchorExtensions).extensions(tableExtension).attributeProviderFactory(new AttributeProviderFactory() {
            @Override
            public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                return new CustomAttributeProvider();
            }
        }).build();
        return renderer.render(document);
    }

    static class CustomAttributeProvider implements AttributeProvider
    {

        @Override
        public void setAttributes(Node node, String s, Map<String, String> map) {
            if (node instanceof Link)
            {
                map.put("target","_blank");
            }
            if (node instanceof TableBlock)
            {
                map.put("class","ui celled table");
            }
        }
    }
}
