package regUpdate.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Regstory Change Class.
 *
 * @author Junichi Tsuchiya
 */
@Controller
@Scope("prototype")
@RequestMapping("/")
public class RegUpdateController {

    private static final String VBS_PATH = "src\\main\\resources\\static\\vbs\\";
    private static final String VBS_WIN_7_64 = "win7_64.vbs";
    private static final String SUCCESS_PAGE = "src\\main\\resources\\static\\success\\";
    private static final String SUCCESS = "success.txt";

    /**
     * Regstory Change Page Init.
     *
     * @param model Model
     * @return Regstory Change Page
     */
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("header", "Registory Change Site");
        model.addAttribute("content", "プロキシサーバの設定を変更するスクリプトをダウンロードし、実行してください。");
        return "sample";
    }

    /**
     * VBScript Download
     *
     * @param model Model
     * @return Regstory Change Page
     * @throws IOException
     */
    @RequestMapping(value="/download", method = RequestMethod.GET)
    public void download(HttpServletResponse res) throws IOException {
        // String vbsFilePath = new File(VBS_PATH + VBS_WIN_7_64).getAbsoluteFile().getPath();
        String vbsFilePath = "C:\\home\\work\\vbs\\win7_64.vbs";
        System.out.println(vbsFilePath);

        if (new File(vbsFilePath).exists()) {
            // LOCAL
            System.out.println("OK");
        } else {
            // PRODUCT
            // vbsFilePath = "C:\\home\\work\\vps\\" + VBS_WIN_7_64;
        }

        InputStream is = null;
        byte[] fileContent = null;
        try {
            is = new FileInputStream(vbsFilePath);
            fileContent = IOUtils.toByteArray(is);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            IOUtils.closeQuietly(is);
        }

        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment; filename=" + VBS_WIN_7_64);
        res.setContentLength(fileContent.length);

        OutputStream os = null;
        try {
            os = res.getOutputStream();
            os.write(fileContent);
            os.flush();
        } catch (IOException e) {
        } finally {
            IOUtils.closeQuietly(os);
        }
    }

    /**
     * Regstory Change Execute.
     *
     * @param model Model
     * @return Regstory Change Page
     * @throws IOException
     */
    @RequestMapping(value="change", method = RequestMethod.POST)
    public void change(Model model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        RegUpdateService service = new RegUpdateService();
        service.hoge(req);

        String vbsFilePath = new File(SUCCESS_PAGE + SUCCESS).getAbsoluteFile().getPath();
        File file = new File("C:\\home\\work\\vbs\\success.txt");

        if (!file.exists()) {
        }
        res.setContentLength((int) file.length());
        res.setContentType(MediaType.TEXT_PLAIN_VALUE);
        FileCopyUtils.copy(new FileInputStream(file), res.getOutputStream());
    }
}
