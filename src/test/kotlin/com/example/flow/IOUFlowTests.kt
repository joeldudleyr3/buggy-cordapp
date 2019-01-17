package com.example.flow

import net.corda.testing.node.MockNetwork
import net.corda.testing.node.MockNetworkParameters
import net.corda.testing.node.StartedMockNode
import net.corda.testing.node.TestCordapp
import org.junit.After
import org.junit.Before
import org.junit.Test

class IOUFlowTests {
    private lateinit var network: MockNetwork
    private lateinit var a: StartedMockNode
    private lateinit var b: StartedMockNode

    @Before
    fun setup() {
        val cordapps = listOf(
                TestCordapp.findCordapp("com.example.contract"),
                TestCordapp.findCordapp("com.example.schema"))
        network = MockNetwork(MockNetworkParameters(cordapps))

        a = network.createPartyNode()
        a.registerInitiatedFlow(ExampleFlow.Acceptor::class.java)

        b = network.createPartyNode()
        b.registerInitiatedFlow(ExampleFlow.Acceptor::class.java)

        network.runNetwork()
    }

    @After
    fun tearDown() {
        network.stopNodes()
    }

    @Test
    fun `write your first flow test here`() {

    }
}