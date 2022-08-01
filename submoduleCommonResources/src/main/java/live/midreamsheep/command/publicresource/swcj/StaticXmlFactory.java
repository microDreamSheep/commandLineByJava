package live.midreamsheep.command.publicresource.swcj;

import com.midream.sheep.swcj.Exception.ConfigException;
import com.midream.sheep.swcj.core.build.builds.effecient.EffecientCompiler;
import com.midream.sheep.swcj.core.factory.SWCJXmlFactory;
import com.midream.sheep.swcj.core.factory.xmlfactory.CoreXmlFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class StaticXmlFactory {
    public static final SWCJXmlFactory xmlFactory = new CoreXmlFactory();
    static{
        xmlFactory.setCompiler(new EffecientCompiler());
        try {
            loadXml("config.xml");
        } catch (IOException | SAXException | ConfigException | ParserConfigurationException e) {
            System.out.println("配置文件加载失败");
            throw new RuntimeException(e);
        }
    }

    public static void loadXml(String url) throws ConfigException, IOException, ParserConfigurationException, SAXException {
        xmlFactory.parse(inputString(Objects.requireNonNull(StaticXmlFactory.class.getClassLoader().getResourceAsStream(url))));
    }


    private static String inputString(InputStream stream){
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
