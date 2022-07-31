package live.midreamsheep.tools.download.downloaders.tencent;

import live.midreamsheep.tools.download.downloaders.DownloadParseInter;
import live.midreamsheep.tools.download.pojo.APP;

import static live.midreamsheep.tools.download.downloaders.tencent.TencentParse.unicodeToCN;

public class I360Parse implements DownloadParseInter {
    @Override
    public APP[] parseJson(APP[] apps) {
        for (APP app : apps) {
            app.setName(unicodeToCN(app.getName().substring(
                    app.getName().indexOf("\"softname\":\"")+"\"softname\":\"".length(),
                    app.getName().lastIndexOf("\"")
            )));
            app.setUrl(unicodeToCN(
                    app.getUrl().substring(
                            app.getUrl().indexOf("\"soft_download\":\"")+"\"soft_download\":\"".length(),
                            app.getUrl().lastIndexOf("\"")
                    )
            ));
        }
        return apps;
    }
}
