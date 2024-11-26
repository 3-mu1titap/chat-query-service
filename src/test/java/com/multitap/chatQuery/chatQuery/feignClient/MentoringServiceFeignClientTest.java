package com.multitap.chatQuery.chatQuery.feignClient;

import com.multitap.chatQuery.chatQuery.feignClient.dto.MentoringDto;
import com.multitap.chatQuery.chatQuery.feignClient.dto.SessionRoomResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MentoringServiceFeignClientTest {
    @Autowired
    MentoringServiceFeignClient feignClient;

    @Test
    void feignCall(){
        String uuid = "ecce4ae5-bc59-45dd-90a9-e529a0964096";
        SessionRoomResponseDto sessionTime = feignClient.getSessionRoom(uuid);
        System.out.println(sessionTime);
        //SessionRoomResponseDto getSessionTime(@PathVariable(name = "uuid") String uuid);
    }


}