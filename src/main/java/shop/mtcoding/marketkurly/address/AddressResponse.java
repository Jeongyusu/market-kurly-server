package shop.mtcoding.marketkurly.address;

import lombok.Getter;

public class AddressResponse {

    @Getter
    public static class DefaultAddressDTO {

        private Integer id;
        private String destination;
        private String destinationDetail;
        private String receiverName;
        private String receiverTel;
        private Boolean isDefaultAddress;

        public DefaultAddressDTO(Address address) {
            this.id = address.getId();
            this.destination = address.getDestination();
            this.destinationDetail = address.getDestinationDetail();
            this.receiverName = address.getReceiverName();
            this.receiverTel = address.getReceiverTel();
            this.isDefaultAddress = address.getIsDefaultAddress();
        }
    }
}
