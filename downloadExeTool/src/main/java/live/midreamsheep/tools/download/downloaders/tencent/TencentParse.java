package live.midreamsheep.tools.download.downloaders.tencent;

import live.midreamsheep.tools.download.downloaders.DownloadParseInter;
import live.midreamsheep.tools.download.pojo.APP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TencentParse implements DownloadParseInter {
    @Override
    public APP[] parseJson(APP[] apps) {
        for (APP app : apps) {
            app.setName(unicodeToCN(app.getName().substring(
                    app.getName().indexOf("\"SoftName\":\"")+"\"SoftName\":\"".length(),
                    app.getName().lastIndexOf("\"")
            )));
            app.setUrl(app.getUrl().substring(
                    app.getUrl().indexOf("<url>\\n                <![CDATA[")+"<url>\\n                <![CDATA[".length(),
                    app.getUrl().lastIndexOf("]]>\\n")
            ));
            if(!app.getUrl().contains("http:")){
                app.setUrl("http:/"+app.getUrl());
            }
            app.setUrl(app.getUrl().replaceAll("http:","https:"));
        }
        return apps;
    }
    public static String unicodeToCN(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }
}
