package design_pattern;

import java.util.HashMap;
import java.util.Map;

public class StrategyDemo {
    Map<Integer, CreativeHandler> map = new HashMap<>();
    public StrategyDemo() {
        map.put(0, new TencentCreativeHandler());
        map.put(1, new BaiduCreativeHandler());
    }

    public void handle(int idx) {
        map.get(idx).creativeHandle();
    }
}

interface CreativeHandler {
    void creativeHandle();
}

class TencentCreativeHandler implements CreativeHandler{

    @Override
    public void creativeHandle() {
        System.out.println("处理腾讯广告创意");
    }
}

class BaiduCreativeHandler implements CreativeHandler{

    @Override
    public void creativeHandle() {
        System.out.println("处理百度广告创意");
    }
}
