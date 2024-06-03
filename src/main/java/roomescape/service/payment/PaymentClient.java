package roomescape.service.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;
import roomescape.exception.payment.PaymentConfirmErrorCode;
import roomescape.exception.payment.PaymentConfirmException;
import roomescape.service.payment.dto.PaymentConfirmFailOutput;
import roomescape.service.payment.dto.PaymentConfirmInput;
import roomescape.service.payment.dto.PaymentConfirmOutput;

public class PaymentClient {
    private final ObjectMapper objectMapper;
    private final RestClient restClient;

    public PaymentClient(ObjectMapper objectMapper, RestClient restClient) {
        this.objectMapper = objectMapper;
        this.restClient = restClient;
    }

    public PaymentConfirmOutput confirmPayment(PaymentConfirmInput paymentConfirmInput) {
        try {
            System.out.println("스타트으으으으");
            Thread.sleep(10000);
            System.out.println("하이이이이");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return restClient.method(HttpMethod.POST)
                    .uri("/confirm")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(paymentConfirmInput)
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, (request, response) -> {
                        throw new PaymentConfirmException(getPaymentConfirmErrorCode(response));
                    })
                    .body(PaymentConfirmOutput.class);
        } catch (ResourceAccessException e) {
            if (e.getCause() instanceof SocketTimeoutException) {
                throw new PaymentConfirmException(PaymentConfirmErrorCode.PAYMENT_CONFIRM_ERROR_MISMATCH);
            }
            throw e;
        }
    }

    /**
     * @see <a href="https://docs.tosspayments.com/reference/error-codes#%EA%B2%B0%EC%A0%9C-%EC%8A%B9%EC%9D%B8">결제 승인
     * API 에러 코드 문서</a>
     */
    private PaymentConfirmErrorCode getPaymentConfirmErrorCode(final ClientHttpResponse response) throws IOException {
        PaymentConfirmFailOutput confirmFailResponse = objectMapper.readValue(
                response.getBody(), PaymentConfirmFailOutput.class);
        return PaymentConfirmErrorCode.findByName(confirmFailResponse.code());
    }
}
