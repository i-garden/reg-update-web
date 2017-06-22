package regUpdate.download;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * RegUpdateService Class.
 *
 * @author NE08117
 */
@Service
@Scope("prototype")
public class RegUpdateService {

    /**
     * DB Insert
     */
    protected void insert() {
    }

    /**
     * Hoge
     */
    protected void hoge(HttpServletRequest req) {
        Map<String, String[]> paramMap = req.getParameterMap();
        String ip = req.getRemoteAddr();
        String pcName[] = paramMap.get("pcName");
        String beforeReg[] = paramMap.get("beforeReg");
        String afterReg[] = paramMap.get("afterReg");
        System.out.println("ip:" + ip + "  pcName:" + pcName[0] + "  beforeReg:" + beforeReg[0] + "  afterReg:" + afterReg[0]);
    }
}
