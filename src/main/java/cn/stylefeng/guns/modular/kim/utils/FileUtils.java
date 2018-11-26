package cn.stylefeng.guns.modular.kim.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: superC
 * @Date: 2018/11/25 12:21
 */
public class FileUtils {

    /**
     * 上传单个文件
     * @param file
     * @param request
     * @return
     */
    public static String singleUpload(MultipartFile file, HttpServletRequest request){

        //图片名字
        String fileName = file.getOriginalFilename();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date()).replace("-", "");
        //设置文件需要上传到的路径
        String pathStr = "/upload/kim/" + dateStr + "/";
        //文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(pathStr) ;

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
        }

        // 返回图片的存放路径
        return pathStr + fileName;
    }

    /**
     *  文件上传工具类服务方法
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{

        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
