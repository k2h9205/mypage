package carrental;

import carrental.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {


    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                Mypage mypage = new Mypage();
                // view 객체에 이벤트의 Value 를 set 함
                mypage.setCarNo(reserved.getCarNo());
                mypage.setStatus(reserved.getStatus());
                mypage.setCarPrice(reserved.getCarPrice());
                mypage.setReserveDate(reserved.getReserveDate());
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            System.out.println("##### whenPaid_then_UPDATE_1--1");
            if (paid.isMe()) {
                System.out.println("##### whenPaid_then_UPDATE_1--2");
                // view 객체 조회
                List<Mypage> mypageList = mypageRepository.findByCarNo(paid.getCarNo());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(paid.getStatus());
                    mypage.setPaymentDate(paid.getPaymentDate());
                    // view 레파지 토리에 save
                    mypageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarRented_then_UPDATE_2(@Payload CarRented carRented) {
        try {
            System.out.println("##### whenCarRented_then_UPDATE_2--1");
            if (carRented.isMe()) {
                System.out.println("##### whenCarRented_then_UPDATE_2--2");
                // view 객체 조회
                List<Mypage> mypageList = mypageRepository.findByCarNo(carRented.getCarNo());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(carRented.getStatus());
                    // view 레파지 토리에 save
                    mypageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaidCanceled_then_UPDATE_3(@Payload PaidCanceled paidCanceled) {
        try {
            if (paidCanceled.isMe()) {
                // view 객체 조회
                List<Mypage> mypageList = mypageRepository.findByCarNo(paidCanceled.getCarNo());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(paidCanceled.getStatus());
                    mypage.setPaymentCancelDate(paidCanceled.getPaymentCancelDate());
                    // view 레파지 토리에 save
                    mypageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarRentCanceled_then_UPDATE_4(@Payload CarRentCanceled carRentCanceled) {
        try {
            if (carRentCanceled.isMe()) {
                // view 객체 조회
                List<Mypage> mypageList = mypageRepository.findByCarNo(carRentCanceled.getCarNo());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(carRentCanceled.getStatus());
                    // view 레파지 토리에 save
                    mypageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void ReservationCanceled_then_UPDATE_5(@Payload ReservationCanceled reservationCanceled) {
        try {
            if (reservationCanceled.isMe()) {
                // view 객체 조회
                List<Mypage> mypageList = mypageRepository.findByCarNo(reservationCanceled.getCarNo());
                for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setStatus(reservationCanceled.getStatus());
                    mypage.setReserveCancelDate(reservationCanceled.getReserveCancelDate());
                    // view 레파지 토리에 save
                    mypageRepository.save(mypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}