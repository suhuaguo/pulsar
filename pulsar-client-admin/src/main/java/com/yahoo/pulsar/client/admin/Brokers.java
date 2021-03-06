/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.pulsar.client.admin;

import java.util.List;
import java.util.Map;

import com.yahoo.pulsar.client.admin.PulsarAdminException.NotAuthorizedException;
import com.yahoo.pulsar.client.admin.PulsarAdminException.NotFoundException;
import com.yahoo.pulsar.common.policies.data.NamespaceOwnershipStatus;

/**
 * Admin interface for brokers management.
 */
public interface Brokers {
    /**
     * Get the list of active brokers in the cluster.
     * <p>
     * Get the list of active brokers (web service addresses) in the cluster.
     * <p>
     * Response Example:
     *
     * <pre>
     * <code>["prod1-broker1.messaging.use.example.com:8080", "prod1-broker2.messaging.use.example.com:8080", "prod1-broker3.messaging.use.example.com:8080"]</code>
     * </pre>
     *
     * @param cluster
     *            Cluster name
     * @return a list of (host:port)
     * @throws NotAuthorizedException
     *             You don't have admin permission to get the list of active brokers in the cluster
     * @throws NotFoundException
     *             Cluster doesn't exist
     * @throws PulsarAdminException
     *             Unexpected error
     */
    List<String> getActiveBrokers(String cluster) throws PulsarAdminException;


    /**
     * Get the map of owned namespaces and their status from a single broker in the cluster
     * <p>
     * The map is returned in a JSON object format below
     * <p>
     * Response Example:
     *
     * <pre>
     * <code>{"ns-1":{"broker_assignment":"shared","is_active":"true","is_controlled":"false"}, "ns-2":{"broker_assignment":"primary","is_active":"true","is_controlled":"true"}}</code>
     * </pre>
     *
     * @param cluster
     * @param brokerUrl
     * @return
     * @throws PulsarAdminException
     */
    Map<String, NamespaceOwnershipStatus> getOwnedNamespaces(String cluster, String brokerUrl) throws PulsarAdminException;
}
