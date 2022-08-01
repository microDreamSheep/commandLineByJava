package live.midreamsheep.tools.download;

import com.midream.sheep.swcj.Exception.ConfigException;
import com.midream.sheep.swcj.Exception.EmptyMatchMethodException;
import com.midream.sheep.swcj.Exception.InterfaceIllegal;
import live.midreamsheep.command.publicresource.swcj.StaticXmlFactory;
import live.midreamsheep.tools.download.data.Constant;
import live.midreamsheep.tools.download.downloaders.DownloadParseInter;
import live.midreamsheep.tools.download.downloaders.Downloader;
import live.midreamsheep.tools.download.pojo.APP;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class DownloaderStarter {
    private static final Scanner s = new Scanner(System.in);
    public void run(String name,String resource,String nowFilePath) {
        //解析配置文件
        try {
            StaticXmlFactory.loadXml("downloadExeTool/"+resource+".xml");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        //选择下载源
        try {
            //执行下载
            downloadByApp(getCheckoutApp(parseJson((Downloader) StaticXmlFactory.xmlFactory.getWebSpiderById("downloader"), Constant.parse[Integer.parseInt(resource) - 1], name)),nowFilePath);
        } catch (EmptyMatchMethodException | ConfigException | InterfaceIllegal e) {
            throw new RuntimeException(e);
        }
    }
    private void downloadByApp(APP app,String nowFilePath){
        String path = nowFilePath +"//"+ app.getUrl().substring(app.getUrl().lastIndexOf("/") + 1);
        File pare = new File(nowFilePath);
        if(!pare.exists()){
            pare.mkdirs();
        }
        URLConnection urlConnection = null;
        try {
            urlConnection = new URL(app.getUrl().replaceAll("\\\\", "")).openConnection();
        } catch (IOException e) {
            System.exit(0);
            throw new RuntimeException(e);
        }
        try (InputStream inputStream = urlConnection.getInputStream();
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(path)){
            int all = urlConnection.getContentLength();
            int had = 0;
            byte[] bytes = new byte[1024];
            int len;
            int count = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                if (count%10==0) {
                    System.out.print("\r");
                    System.out.print("已经下载:" + (had += len) + "/" + all);
                }
                count++;
            }
            System.out.println("\n下载成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    private APP getCheckoutApp(APP[] apps){
        System.out.println("请选择你要下载的app");
        for (int i = 0; i < apps.length; i++) {
            System.out.println(i+1+"."+apps[i].getName());
        }
        return apps[s.nextInt()-1];
    }

    private APP[] parseJson(Downloader downloader, DownloadParseInter parse,String key){
        return parse.parseJson(downloader.getDownloadJson(key));
    }


    private String inputString(InputStream stream){
        StringBuilder stringBuilder = new StringBuilder();
        int len;
        byte[] bytes = new byte[1024];
        try {
            while ((len = stream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, len));
            }
            return stringBuilder.toString();
        }catch (IOException e){
            System.exit(0);
        }
        System.exit(0);
        return "";
    }
}