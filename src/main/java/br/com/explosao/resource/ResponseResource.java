package br.com.explosao.resource;

import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

@Resource
public class ResponseResource {

    private Integer statusCode;
    private String message;
    private Object additionalInfo;

    public ResponseResource(
            final Integer statusCode, final String message, final Object additionalInfo) {
        this.statusCode = statusCode;
        this.message = message;
        this.additionalInfo = additionalInfo;
    }


    public ResponseResource(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Object additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "ResponseResource{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", additionalInfo=" + additionalInfo +
                '}';
    }

    public ResponseEntity<?> build(){
        return ResponseEntity.ok().body(this);
    }
}
