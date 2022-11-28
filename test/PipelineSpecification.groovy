import com.lesfurets.jenkins.unit.BasePipelineTest
import spock.lang.Specification

class PipelineSpecification extends  Specification {

    @Delegate BasePipelineTest basePipelineTest

    def setup() {
        basePipelineTest = new BasePipelineTest() {}
        basePipelineTest.setUp()
    }

}
