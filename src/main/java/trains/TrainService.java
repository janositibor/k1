package trains;

import java.util.List;

public class TrainService {
    private TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train buyTicketForTrain(String destination, int amount){
        List<Train> trains=trainRepository.getTrainsByDestination(destination);
        Long trainId=trains.stream().filter(t->(t.getNumberOfPassengers()+amount<=t.getMaxCapacity()))
                .mapToLong(t->t.getId())
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Cannot buy ticket for train to: "+destination));
        trainRepository.updateNumberOfPassengersById(trainId, amount);
        return trainRepository.findById(trainId);
    }
}
