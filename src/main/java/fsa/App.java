package fsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private StateMachine<String, String> stateMachine;

    private void start() {
        stateMachine.start();
        System.out.println(stateMachine.getState());
        System.out.println(getStateName(stateMachine.getState().toString()));
        stateMachine.sendEvent("E1");
        System.out.println(getStateName(stateMachine.getState().toString()));
        stateMachine.sendEvent("E2");
        System.out.println(getStateName(stateMachine.getState().toString()));
        stateMachine.sendEvent("end");
        System.out.println(getStateName(stateMachine.getState().toString()));
    }

    private String getStateName(String state) {
        return state.split(",")[0].split("=")[1];
    }

    @Override
    public void run(String... args) throws Exception {
        start();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
