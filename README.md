<p align="center">
  <img src="https://www.corda.net/wp-content/uploads/2016/11/fg005_corda_b.png" alt="Corda" width="500">
</p>

# Buggy CorDapp

The Example CorDapp. Except... no-one wrote any tests and two bugs have slipped through. One in the contract, and one in the flow. You need to write tests to identify these bugs.

Here are the constraints we expect the IOU contract to impose:

* The transaction has a single command of type `IOUContract.Commands.Create`
* The transaction has zero inputs
* The transaction has one output of type `IOUState`
* In the `IOUState` output:
  * The `lender` and the `borrower` are not the same party
  * The `iouValue` is positive

And here's what we expect the IOU flow to do:

* Take two arguments, `iouValue` and `otherParty`
* Create a transaction with no inputs and one output, a new `IOUState` with:
  * A value of `iouValue`
  * The initiator of the flow as the `lender`
  * `otherParty` as the borrower
* Get both parties to sign the transaction
* Store the new `IOUState` in both parties' vaults
