package live.midreamsheep.tools.download.data;

import live.midreamsheep.tools.download.downloaders.DownloadParseInter;
import live.midreamsheep.tools.download.downloaders.tencent.I360Parse;
import live.midreamsheep.tools.download.downloaders.tencent.TencentParse;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Constant {

    public static DownloadParseInter[] parse;
    static {
        List<DownloadParseInter> list = new LinkedList<>();
        list.add(new TencentParse());
        list.add(new I360Parse());
        parse = list.toArray(new DownloadParseInter[0]);
    }
}
