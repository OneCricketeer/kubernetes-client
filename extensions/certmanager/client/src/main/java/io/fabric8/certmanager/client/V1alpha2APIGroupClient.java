/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.certmanager.client;

import io.fabric8.certmanager.api.model.acme.v1alpha2.Challenge;
import io.fabric8.certmanager.api.model.acme.v1alpha2.ChallengeList;
import io.fabric8.certmanager.api.model.acme.v1alpha2.Order;
import io.fabric8.certmanager.api.model.acme.v1alpha2.OrderList;
import io.fabric8.certmanager.api.model.v1alpha2.Certificate;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateList;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequest;
import io.fabric8.certmanager.api.model.v1alpha2.CertificateRequestList;
import io.fabric8.certmanager.api.model.v1alpha2.ClusterIssuer;
import io.fabric8.certmanager.api.model.v1alpha2.ClusterIssuerList;
import io.fabric8.certmanager.api.model.v1alpha2.Issuer;
import io.fabric8.certmanager.api.model.v1alpha2.IssuerList;
import io.fabric8.certmanager.client.dsl.V1alpha2APIGroupDSL;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class V1alpha2APIGroupClient extends ClientAdapter<V1alpha2APIGroupDSL> implements V1alpha2APIGroupDSL {
  public V1alpha2APIGroupClient() {
    super();
  }

  public V1alpha2APIGroupClient(Client client) {
    super(client);
  }

  @Override
  protected V1alpha2APIGroupDSL newInstance(Client client) {
    return new V1alpha2APIGroupClient(client);
  }

  @Override
  public MixedOperation<Certificate, CertificateList, Resource<Certificate>> certificates() {
    return resources(Certificate.class, CertificateList.class);
  }

  @Override
  public MixedOperation<CertificateRequest, CertificateRequestList, Resource<CertificateRequest>> certificateRequests() {
    return resources(CertificateRequest.class, CertificateRequestList.class);
  }

  @Override
  public MixedOperation<Issuer, IssuerList, Resource<Issuer>> issuers() {
    return resources(Issuer.class, IssuerList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterIssuer, ClusterIssuerList, Resource<ClusterIssuer>> clusterIssuers() {
    return resources(ClusterIssuer.class, ClusterIssuerList.class);
  }

  @Override
  public MixedOperation<Challenge, ChallengeList, Resource<Challenge>> challenges() {
    return resources(Challenge.class, ChallengeList.class);
  }

  @Override
  public MixedOperation<Order, OrderList, Resource<Order>> orders() {
    return resources(Order.class, OrderList.class);
  }
}
