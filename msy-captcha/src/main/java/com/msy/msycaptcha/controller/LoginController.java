package com.msy.msycaptcha.controller;

import com.msy.msycaptcha.bo.VerificationCode;
import com.wf.captcha.SpecCaptcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;

/**
 * @author: msy
 * @create: 2023-11-16
 **/
@RestController
public class LoginController {


    @GetMapping("/captcha")
    public void getVerifyCode(HttpServletResponse response) throws IOException, FontFormatException {
        try {
            // 设置请求头为输出图片类型
            VerificationCode code = new VerificationCode();
            SpecCaptcha specCaptcha = code.createVerificationCode();
            // 创建字节数组输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 将验证码图片输出到字节数组输出流中
            specCaptcha.out(baos);
            // 将字节数组转换为 Base64 编码
            byte[] imageBytes = baos.toByteArray();
            InputStream inStream = new ByteArrayInputStream(imageBytes);
            OutputStream outputStream = null;
            outputStream = new BufferedOutputStream(response.getOutputStream());

            //创建存放文件内容的数组
            byte[] buff = new byte[1024];
            //所读取的内容使用n来接收
            int n;
            //当没有读取完时,继续读取,循环
            while ((n = inStream.read(buff)) != -1) {
                //将字节数组的数据全部写入到输出流中
                outputStream.write(buff, 0, n);
            }
            //强制将缓存区的数据进行输出
            outputStream.flush();
            //关流
            outputStream.close();
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
