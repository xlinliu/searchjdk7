/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.net;

import java.util.List;
import java.util.Map;

/**
 * A CookieStore object represents a storage for cookie. Can store and retrieve
 * cookies.
 *
 * <p>{@link CookieManager} will call <tt>CookieStore.add</tt> to save cookies
 * for every incoming HTTP response, and call <tt>CookieStore.get</tt> to
 * retrieve cookie for every outgoing HTTP request. A CookieStore
 * is responsible for removing HttpCookie instances which have expired.
 *
 * @author Edward Wang
 * @since 1.6
 */
public interface CookieStore {
    /**
     * Adds one HTTP cookie to the store. This is called for every
     * incoming HTTP response.
     *
     * <p>A cookie to store may or may not be associated with an URI. If it
     * is not associated with an URI, the cookie's domain and path attribute
     * will indicate where it comes from. If it is associated with an URI and
     * its domain and path attribute are not speicifed, given URI will indicate
     * where this cookie comes from.
     *
     * <p>If a cookie corresponding to the given URI already exists,
     * then it is replaced with the new one.
     *
     * @param uri       the uri this cookie associated with.
     *                  if <tt>null</tt>, this cookie will not be associated
     *                  with an URI
     * @param cookie    the cookie to store
     *
     * @throws NullPointerException if <tt>cookie</tt> is <tt>null</tt>
     *
     * @see #get
     *
     */
    public void add(URI uri, HttpCookie cookie);


    /**
     * Retrieve cookies associated with given URI, or whose domain matches the
     * given URI. Only cookies that have not expired are returned.
     * This is called for every outgoing HTTP request.
     *
     * @return          an immutable list of HttpCookie,
     *                  return empty list if no cookies match the given URI
     *
     * @throws NullPointerException if <tt>uri</tt> is <tt>null</tt>
     *
     * @see #add
     *
     */
    public List<HttpCookie> get(URI uri);


    /**
     * Get all not-expired cookies in cookie store.
     *
     * @return          an immutable list of http cookies;
     *                  return empty list if there's no http cookie in store
     */
    public List<HttpCookie> getCookies();


    /**
     * Get all URIs which identify the cookies in this cookie store.
     *
     * @return          an immutable list of URIs;
     *                  return empty list if no cookie in this cookie store
     *                  is associated with an URI
     */
    public List<URI> getURIs();


    /**
     * Remove a cookie from store.
     *
     * @param uri       the uri this cookie associated with.
     *                  if <tt>null</tt>, the cookie to be removed is not associated
     *                  with an URI when added; if not <tt>null</tt>, the cookie
     *                  to be removed is associated with the given URI when added.
     * @param cookie    the cookie to remove
     *
     * @return          <tt>true</tt> if this store contained the specified cookie
     *
     * @throws NullPointerException if <tt>cookie</tt> is <tt>null</tt>
     */
    public boolean remove(URI uri, HttpCookie cookie);


    /**
     * Remove all cookies in this cookie store.
     *
     * @return          <tt>true</tt> if this store changed as a result of the call
     */
    public boolean removeAll();
}
