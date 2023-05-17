package execution.commands;

import commands.CarrierSumOfImpactSpeed;
import data.CollectionManager;
import data.ServerResponse;
import execution.Command;

public final class CommandSumOfImpactSpeed implements Command {
  private final CollectionManager collection;

  public CommandSumOfImpactSpeed(final CarrierSumOfImpactSpeed carrier, final CollectionManager collection) {
    this.collection = collection;
  }

  public ServerResponse execute() {
    if (collection.data().size() > 0) {
      return new ServerResponse("Sum: " +
          collection
              .data()
              .entrySet()
              .stream()
              .map(entry -> entry.getValue().impactSpeed())
              .reduce((a, b) -> a + b).get());
    } else {
      return new ServerResponse("Collection is empty");
    }
  }

  public String name() {
    return "sumOfImpactSpeed";
  }

  public String description() {
    return this.name() + " : shows the sum of impactspeed stat of all characters";
  }
}
