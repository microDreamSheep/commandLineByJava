package live.midreamsheep.tools.download.downloaders;

import live.midreamsheep.tools.download.pojo.APP;

public interface DownloadParseInter {
    APP[] parseJson(APP[] apps);
}
