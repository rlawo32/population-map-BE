package com.pm.pmproject.util;

import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EmailAuthUtil {

    private static final String ADMIN_EMAIL = "gandi779@gmail.com";
//    private static final String ADMIN_EMAIL = "rlawo32@naver.com";

    @Value("${EMAILAUTH_GOOGLE_SECRETKEY}")
//    @Value("${EMAILAUTH_NAVER_SECRETKEY}")
    private static String ADMIN_PASSWORD;

    public static String authRandomCode() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 6; i++) {
            if(Math.random() < 0.5) {
                sb.append( (char)((int)(Math.random() * 10) + '0') );
            } else {
                sb.append( (char)((int)(Math.random() * 26) + 'A') );
            }
        }
        return sb.toString();
    }

    private static Session sendMailSession() {

        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ADMIN_EMAIL, ADMIN_PASSWORD);
            }
        });
        return session;
    }

    public static Map<String, Object> sendAuthCode(String memberEmail) {

        String authCode = authRandomCode();

        try {
            Message message = new MimeMessage(sendMailSession());

            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress(ADMIN_EMAIL, "DuDu 문화센터 관리자"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(memberEmail));
            message.setSubject("[DuDu 문화센터] 인증 요청 메일입니다.");
            message.setText("인증번호는 " + authCode + "입니다.");

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("authCode", authCode);

        return map;
    }
}
