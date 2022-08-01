package live.midreamsheep.tools.download.downloaders.tencent;

import live.midreamsheep.tools.download.downloaders.DownloadParseInter;
import live.midreamsheep.tools.download.pojo.APP;

import static live.midreamsheep.tools.download.downloaders.tencent.TencentParse.unicodeToCN;

public class I360Parse implements DownloadParseInter {
    @Override
    public APP[] parseJson(APP[] apps) {
        for (APP app : apps) {
            app.setName(unicodeToCN(app.getName()));
        }
        return apps;
    }
}
