package live.midreamsheep.tools.download.downloaders;

import live.midreamsheep.tools.download.pojo.APP;

public interface Downloader {
    /**
     * 获取下载json数据
     * */
    APP[] getDownloadJson(String key);
}
