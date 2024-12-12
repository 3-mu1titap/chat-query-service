package com.multitap.chatQuery.chatQuery.infrastructure;

import com.multitap.chatQuery.chatQuery.entity.ChatList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatListRepository extends MongoRepository<ChatList, String> {

    Optional<ChatList> findById(String id);

    @Query(value = "{ 'memberInfo.chatMemberUuid': ?0 }", sort = "{ 'chatInfo.sentAt': -1 }")
    List<ChatList> findAllByChatMemberUuidSorted(String memberUuid);

    boolean existsById(String mentoringSessionUuid);
}
