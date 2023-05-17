package commands;

public final record CarrierSumOfImpactSpeed() implements Carrier {
  @Override
  public CommandIdentity identity() {
    return CommandIdentity.SumOfImpactSpeed;
  }

  public String syntax() {
    return "sumOfImpactSpeed";
  }
}
