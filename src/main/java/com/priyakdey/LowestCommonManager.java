package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class LowestCommonManager {

    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne,
                                                  OrgChart reportTwo) {
        if (reportOne == topManager || reportTwo == topManager) return topManager;

        Deque<OrgChart> reportOneOrgChart = buildHierarchy(topManager, reportOne);
        Deque<OrgChart> reportTwoOrgChart = buildHierarchy(topManager, reportTwo);

        while (!reportOneOrgChart.isEmpty() && !reportTwoOrgChart.isEmpty() &&
            reportOneOrgChart.peek() != reportTwoOrgChart.peek()) {
            if (reportOneOrgChart.size() > reportTwoOrgChart.size()) {
                reportOneOrgChart.pop();
            } else if (reportOneOrgChart.size() < reportTwoOrgChart.size()) {
                reportTwoOrgChart.pop();
            } else {
                reportOneOrgChart.pop();
                reportTwoOrgChart.pop();
            }
        }

        return !reportOneOrgChart.isEmpty() ? reportOneOrgChart.poll() : topManager;
    }

    private static Deque<OrgChart> buildHierarchy(OrgChart topManager, OrgChart reportee) {
        Deque<OrgChart> hierarchy = new ArrayDeque<>();
        if (!findReportee(topManager, reportee, hierarchy)) {
            throw new IllegalArgumentException("There is not reportOne employee");
        }

        return hierarchy;
    }


    private static boolean findReportee(OrgChart currPerson, OrgChart reportee,
                                        Deque<OrgChart> hierarchy) {
        if (currPerson == null) return false;
        if (currPerson == reportee) {
            hierarchy.push(currPerson);
            return true;
        }

        boolean found = false;

        hierarchy.push(currPerson);
        for (OrgChart directReport : currPerson.directReports) {
            if (findReportee(directReport, reportee, hierarchy)) {
                found = true;
                break;
            }
        }

        if (!found) {
            hierarchy.pop();
        }
        return found;
    }

    private static class OrgChart {
        private char name;
        private List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            Collections.addAll(this.directReports, directReports);
        }

        @Override
        public String toString() {
            return String.valueOf(name);
        }
    }

    public static void main(String[] args) {
        OrgChart a = new OrgChart('a');
        OrgChart b = new OrgChart('b');
        OrgChart c = new OrgChart('c');
        OrgChart d = new OrgChart('d');
        OrgChart e = new OrgChart('e');
        OrgChart f = new OrgChart('f');
        OrgChart g = new OrgChart('g');
        OrgChart h = new OrgChart('h');
        OrgChart i = new OrgChart('i');
        OrgChart j = new OrgChart('j');
        OrgChart k = new OrgChart('k');
        OrgChart l = new OrgChart('l');
        OrgChart m = new OrgChart('m');
        OrgChart n = new OrgChart('n');
        OrgChart o = new OrgChart('o');
        OrgChart p = new OrgChart('p');
        OrgChart q = new OrgChart('q');
        OrgChart r = new OrgChart('r');
        OrgChart s = new OrgChart('s');
        OrgChart t = new OrgChart('t');
        OrgChart u = new OrgChart('u');
        OrgChart v = new OrgChart('v');
        OrgChart w = new OrgChart('w');
        OrgChart x = new OrgChart('x');
        OrgChart y = new OrgChart('y');


        a.addDirectReports(new OrgChart[]{b, c});
        b.addDirectReports(new OrgChart[]{d, e});
        d.addDirectReports(new OrgChart[]{h, i});
        c.addDirectReports(new OrgChart[]{f, g});

        getLowestCommonManager(a, e, f);

    }


}
