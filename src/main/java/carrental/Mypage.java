package carrental;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Mypage_table")
public class Mypage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long carNo;
        private Double carPrice;
        private String reserveDate;
        private String status;
        private String reserveCancelDate;
        private String paymentDate;
        private String paymentCancelDate;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getCarNo() {
            return carNo;
        }

        public void setCarNo(Long carNo) {
            this.carNo = carNo;
        }
        public Double getCarPrice() {
            return carPrice;
        }

        public void setCarPrice(Double carPrice) {
            this.carPrice = carPrice;
        }
        public String getReserveDate() {
            return reserveDate;
        }

        public void setReserveDate(String reserveDate) {
            this.reserveDate = reserveDate;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getReserveCancelDate() {
            return reserveCancelDate;
        }

        public void setReserveCancelDate(String reserveCancelDate) {
            this.reserveCancelDate = reserveCancelDate;
        }
        public String getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
        }
        public String getPaymentCancelDate() {
            return paymentCancelDate;
        }

        public void setPaymentCancelDate(String paymentCancelDate) {
            this.paymentCancelDate = paymentCancelDate;
        }

}
