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

    	for (int i = 0; i < 8; i++) {
    		int k = 1;
        	DataForm dataForm = new DataForm();
        	dataForm.setIpAddress("192.168.10." + i);
        	dataForm.setPcName("PC_AAA" + i);
        	dataForm.setExecutionTime("2017/0" + i +"/2" + k);
        	dataForm.setPropriety("完了");
        	list.add(dataForm);
        	k++;
    	}

    	for (int i = 70; i < 79; i++) {
    		int j = 10;
    		int k = 2;
        	DataForm dataForm = new DataForm();
        	dataForm.setIpAddress("192.168."+ j +"." + i);
        	dataForm.setPcName("PC_BBB" + i);
        	dataForm.setExecutionTime("2017/0" + k +"/1" + k);
        	dataForm.setPropriety("完了");
        	list.add(dataForm);
        	j = j + 10;
        	k++;
    	}

    	for (int i = 30; i < 36; i++) {
    		int j = 400;
    		int k = 4;
        	DataForm dataForm = new DataForm();
        	dataForm.setIpAddress("192.168."+ j +"." + i);
        	dataForm.setPcName("PC_BBB" + i);
        	dataForm.setExecutionTime("2017/0" + k +"/1" + k);
        	dataForm.setPropriety("未完了");
        	list.add(dataForm);
        	j = j + 10;
        	k++;
    	}

        model.addAttribute("dataList", list);
        return "admin";
    }


}
