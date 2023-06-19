package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;

import java.util.Arrays;

public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        AluraVpcStack vpcStack = new AluraVpcStack(app, "Vpc");

        //indicamos ao cluster que a vpc deve ser provisionada primeiro e depois o cluster
        AluraClusterStack clusterStack = new AluraClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        //indicamos ao RDS que a vpc deve ser provisionada primeiro e depois o rds
        AluraRdsStack rdsStack = new AluraRdsStack(app, "Rds", vpcStack.getVpc());
        rdsStack.addDependency(vpcStack);

        //indicamos ao service que o cluster deve ser provisionado primeiro e depois o service
        AluraServiceStack aluraServiceStack = new AluraServiceStack(app, "Service", clusterStack.getCluster());
        aluraServiceStack.addDependency(clusterStack);
        aluraServiceStack.addDependency(rdsStack);

        app.synth();

        // If you don't specify 'env', this stack will be environment-agnostic.
        // Account/Region-dependent features and context lookups will not work,
        // but a single synthesized template can be deployed anywhere.

        // Uncomment the next block to specialize this stack for the AWS Account
        // and Region that are implied by the current CLI configuration.
                /*
                .env(Environment.builder()
                        .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
                        .region(System.getenv("CDK_DEFAULT_REGION"))
                        .build())
                */

        // Uncomment the next block if you know exactly what Account and Region you
        // want to deploy the stack to.
                /*
                .env(Environment.builder()
                        .account("123456789012")
                        .region("us-east-1")
                        .build())
                */

        // For more information, see https://docs.aws.amazon.com/cdk/latest/guide/environments.html
    }
}

