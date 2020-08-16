package miniCode;

import org.springframework.context.ApplicationListener;

/**
 * 自定义监听类
 * @author xpt
 */
public class CustomListener implements ApplicationListener<ConsolePrintlnServiceImpl> {

    @Override
    public void onApplicationEvent(ConsolePrintlnServiceImpl event) {
        event.writer();
    }
}
