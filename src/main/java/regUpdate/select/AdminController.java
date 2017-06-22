package regUpdate.select;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String hoge1(@ModelAttribute DataForm form,Model model){

    	List<DataForm> list = new ArrayList<>();

    	DataForm dataForm1 = new DataForm();
    	dataForm1.setIpAddress("192.168.10.1");
    	dataForm1.setPcName("PC_AAA");
    	dataForm1.setExecutionTime("2017/06/22");
    	dataForm1.setPropriety("完了");
    	list.add(dataForm1);

        model.addAttribute("dataList", list);
        return "admin";
    }


}
