/*
 *  Copyright (c) 2023 DMG
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO DMG
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.lowleveldesign;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Piyush Kumar.
 * @since 30/03/23.
 */
public class Router {

    private Map<String, String> routes;

    public Router(){
        routes = new HashMap<>();
    }

    public void addRoutes(String route, String serviceName){

        if (isNull(route) || isNull(serviceName) || route.isEmpty() || serviceName.isEmpty()){
            throw new RuntimeException("Invalid Configuration");
        }

        if (route.endsWith("/")){

            route = route.substring(0, route.length()-1);
        }

        if (route.contains("/*/")){
            route = route.replace("/*/", "/[a-z0-9]*/");
        }

        if (route.endsWith("/*")){

            route = route.replace("/*", "[a-z0-9]*");
        }

        routes.put(route, serviceName);
    }

    public String getServiceForRoute(String route){

        if (isNull(route) || route.isEmpty()){
            throw new RuntimeException("Invalid route");
        }

        if (route.endsWith("/")){
            route = route.substring(0, route.length()-1);
        }

        String serviceName = routes.get(route);

        if (nonNull(serviceName)){
            return serviceName;

        }

        Set<String> routeSet = new TreeSet<>(Comparator.reverseOrder());
        for (Map.Entry<String, String> routeEntry : routes.entrySet()){

            Pattern compiledRoute = Pattern.compile(routeEntry.getKey());

            Matcher matcher = compiledRoute.matcher(route);
            if (matcher.matches()){

                routeSet.add(routeEntry.getKey());
            }
        }

        return !routeSet.isEmpty() ? routes.get(routeSet.iterator().next()) : "";

    }


    public static void main(String[] args) {

        Router router = new Router();

        router.addRoutes("/foo/*", "service1");
        router.addRoutes("/foo/bar", "service2");
        router.addRoutes("/foo/*/bar", "service3");

        System.out.println(router.getServiceForRoute("/foo/"));
        System.out.println(router.getServiceForRoute("/foo"));
        System.out.println(router.getServiceForRoute("/foo/123/bar"));
    }
}
