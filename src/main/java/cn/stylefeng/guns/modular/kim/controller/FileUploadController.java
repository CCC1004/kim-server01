package cn.stylefeng.guns.modular.kim.controller;

import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 上传文件
 * @Author: superC
 * @Date: 2018/11/25 12:26
 */
public class FileUploadController {

    @RequestMapping(value = "/singleUpload")
    @ResponseBody
    public String singleUpload(@RequestParam("file")MultipartFile file,
                               HttpServletRequest request, String upPath){
        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date()).replace("-", "");
        //设置文件需要上传到的路径
        String pathStr = upPath + dateStr;
        //文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(pathStr) ;

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
        }

        // 返回图片的存放路径
        return filePath;
    }
}
