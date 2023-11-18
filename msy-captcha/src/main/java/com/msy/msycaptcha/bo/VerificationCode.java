package com.msy.msycaptcha.bo;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;

import java.awt.*;
import java.io.IOException;

/**
 * @author: msy
 * @create: 2023-11-16
 **/
public class VerificationCode {

    /**
     * 生成验证码图片的宽度
     */
    private int width = 100;
    /**
     * 生成验证码图片的高度
     */
    private int height = 30;
    /**
     * 生成验证码的位数
     */
    private int digit = 4;
    /**
     * 生成的验证码code
     */
    private String captchaCode;

    /**
     * 生成验证码
     *
     * @return
     */
    public SpecCaptcha createVerificationCode() throws IOException, FontFormatException {

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(width, height, digit);
        // 设置字体
        specCaptcha.setFont(Captcha.FONT_9);
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        // 验证码
        this.captchaCode = specCaptcha.text().toLowerCase();

        return specCaptcha;
    }

    public String getCaptchaCode() {
        return captchaCode;
    }
}
