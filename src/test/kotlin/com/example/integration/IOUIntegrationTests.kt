package com.example.integration

import net.corda.core.identity.CordaX500Name
import net.corda.testing.core.TestIdentity
import net.corda.testing.driver.DriverParameters
import net.corda.testing.driver.driver
import org.junit.Test

class IOUIntegrationTests {
    private val partyA = TestIdentity(CordaX500Name("BankA", "", "GB"))
    private val partyB = TestIdentity(CordaX500Name("BankB", "", "US"))

    @Test
    fun `write your integration test here`() {
        driver(DriverParameters(isDebug = true, startNodesInProcess = true)) {
            val partyARpc = startNode(providedName = partyA.name).get().rpc
            val partyBRpc = startNode(providedName = partyB.name).get().rpc


        }
    }
}
