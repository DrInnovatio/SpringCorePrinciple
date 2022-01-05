package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient(){
        System.out.println("Calling the constructor, url = " + url);
        connect();
        call("초기화 연결");

    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println(" Connect : " + url);
    }

    public void call(String message){
        System.out.println("Call " + url + " message = " + message);
    }

    public void disconnect(){
        System.out.println("close : " + url);
    }
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기 연결 메세지");
    }
    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.destroy");
        disconnect();
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
