package com.WorkStride.notification;
import com.WorkStride.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public void send(NotificationRequest notificationRequest) {
    }
}
