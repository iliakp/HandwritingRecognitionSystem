package ge.edu.tsu.hcrs.control_panel.service.neuralnetwork;

import ge.edu.tsu.hcrs.control_panel.model.network.NetworkResult;
import ge.edu.tsu.hcrs.control_panel.model.network.NeuralNetworkProcessorType;
import ge.edu.tsu.hcrs.control_panel.model.network.NormalizedData;
import ge.edu.tsu.hcrs.control_panel.server.manager.neuralnetwork.HCRSINeuralNetworkProcessor;
import ge.edu.tsu.hcrs.control_panel.server.manager.neuralnetwork.INeuralNetworkProcessor;
import ge.edu.tsu.hcrs.control_panel.server.manager.neuralnetwork.NeurophINeuralNetworkProcessor;

public class NeuralNetworkServiceImpl implements NeuralNetworkService {

    private INeuralNetworkProcessor INeuralNetworkProcessor;

    public NeuralNetworkServiceImpl(NeuralNetworkProcessorType type) {
        switch (type) {
            case MY_NEURAL_NETWORK:
                INeuralNetworkProcessor = new HCRSINeuralNetworkProcessor();
            case NEUROPH_NEURAL_NETWORK:
                INeuralNetworkProcessor = new NeurophINeuralNetworkProcessor();
            default:
                INeuralNetworkProcessor = new HCRSINeuralNetworkProcessor();
        }
    }

    @Override
    public void trainNeural(int width, int height, String generation) {
        INeuralNetworkProcessor.trainNeural(width, height, generation);
    }

    @Override
    public NetworkResult getNetworkResult(NormalizedData normalizedData, String networkPath) {
        return INeuralNetworkProcessor.getNetworkResult(normalizedData, networkPath);
    }

    @Override
    public float test(int width, int height, String generation, String path, int networkId) {
        return INeuralNetworkProcessor.test(width, height, generation, path, networkId);
    }
}
