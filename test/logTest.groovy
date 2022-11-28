import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

// class logTest extends  BasePipelineTest {

//     def log

//     @Before
//     void setUp() {
//         super.setUp()
//         log = loadScript("vars/log.groovy")
//     }

//     @Test
//     void logInfo() {
//         log.info("info message")
//         assertThat(helper.methodCallCount("info"), is(1L))
//     }

//     @Test
//     void logWarn() {
//         log.warn("warn message")
//         assertThat(helper.methodCallCount("warn"), is(1L))
//         printCallStack()
//     }

// }


class logGroovyTest extends PipelineSpecification {

    def log

    def setup() {
        log = loadScript("vars/log.groovy")
    }

    def 'log info'() {
        when:
        log.info("info message")
        then:
        helper.methodCallCount("info") == 1
        helper.callStack.find {call -> call.methodName == 'info'}.args[0] == 'info message'
    }

    def 'log warn'() {
        when:
        log.warn('warn message')
        then:
        helper.methodCallCount('warn') == 1
        helper.callStack.find {call -> call.methodName == 'warn'}.args[0] == 'warn message'
    }
}
