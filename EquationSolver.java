import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class EquationSolver {
    private static Scanner scanner = new Scanner(System.in);
	static Scanner scan = new Scanner(System.in);
public static void main(String[] args) {
    	System.out.print("Enter your Equation : ");
        String equation = scan.next();
        int[] result = processEquation(equation);
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] processEquation(String equation) {
        String[] segments = equation.split("_");
        int[] segmentValues = new int[segments.length];

        int currentGroup = 0;
        int value;
        boolean skipNext = false;

        for (int i = 0; i < segments.length; i++) {
            String segment = segments[i];

            if (skipNext) {
                skipNext = false;
                continue;
            }

            if (segment.equals("z")) {
                if (i + 1 < segments.length && segments[i + 1].equals("z")) {
                    value = 26 + 26;
                    skipNext = true;
                } else {
                    value = 26;
                }
            } else {
                value = segment.length() > 0 ? segment.charAt(0) - 'a' + 1 : 0;
            }

           if (currentGroup % 5 != 0) {
                segmentValues[currentGroup / 5] += value;
            }

            currentGroup++;
           if (currentGroup == 5) {
               currentGroup = 0;
          }
       }

       return segmentValues;
    }
}

	
	
	
	
/*
    public static void main(String[] args) {
        System.out.print("Enter the equation: ");
        String input = scanner.nextLine();

        if (isValidEquation(input)) {
            int[] measurements = processEquation(input);
            System.out.println("The total of measurements is: " + formatMeasurements(measurements));
        } else {
            System.out.println("Invalid equation format.");
        }
    }

    private static boolean isValidEquation(String equation) {
        // Check if the equation contains only underscores, letters, and digits
        return equation.matches("[a-z_-za]+");
    }

    private static int[] processEquation(String equation) {
        String[] segments = equation.split("_");
        int[] segmentValues = new int[segments.length];

        int currentGroup = 0;
        int total = 0;
        boolean skipNext = false;

        for (int i = 0; i < segments.length; i++) {
            String segment = segments[i];

            if (skipNext) {
                skipNext = false;
                continue;
            }

            int value;

            if (segment.equals("_")) {
                value = 0;
            } else if (segment.equals("z")) {
                if (i + 1 < segments.length && segments[i + 1].equals("z")) {
                    value = 26 + 26;
                    skipNext = true;
                } else {
                    value = 26;
                }
            } else {
                value = segment.charAt(0) - 'a' + 1;
            }

            if (currentGroup % 5 != 0) {
                segmentValues[currentGroup / 5] += value;
            }

            if (value != 0 && value != 26) {
                total += value;
            }

            currentGroup++;

            if (currentGroup == 5) {
                currentGroup = 0;
            }
        }

        return segmentValues;
    }

    private static String formatMeasurements(int[] measurements) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < measurements.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            int value = measurements[i];
            if (value > 0) {
                sb.append(value);
            } else {
                sb.append("-");
            }
      }
        return sb.toString();
    }
}
	
*/	
	
	

	
//public class EquationSolver {
//	static Scanner scan = new Scanner(System.in);
//    public static void main(String[] args){
//    	
//    
//        int[] result = processEquation(equation);
//        ListModel.addAttribute("result", result);
//        return "result";
//    }
//
//    public int[] processEquation(String equation) {
//        String[] segments = equation.split("_");
//        int[] segmentValues = new int[segments.length];
//
//        int currentGroup = 0;
//        int total = 0;
//        boolean skipNext = false;
//
//        for (int i = 0; i < segments.length; i++) {
//            String segment = segments[i];
//
//            if (skipNext) {
//                skipNext = false;
//                continue;
//            }
//
//            if (segment.equals("_")) {
//                segmentValues[i] = 0;
//            } else {
//                int value;
//                if (segment.equals("z")) {
//                    if (i + 1 < segments.length && segments[i + 1].equals("z")) {
//                        value = 26 + 26;
//                        skipNext = true;
//                    } else {
//                        value = 26;
//                    }
//                } else {
//                    value = segment.length() > 0 ? segment.charAt(0) - 'a' + 1 : 0;
//                }
//
//                if (currentGroup % 5 != 0) {
//                    segmentValues[currentGroup / 5] += value;
//                }
//
//                if (value != 0 && value != 26) {
//                    total += value;
//                }
//
//                currentGroup++;
//                if (currentGroup == 5) {
//                    currentGroup = 0;
//                }
//            }
//        }
//
//        return segmentValues;
//    }
//   }
//
//}
	
	
	
	
	
	
//static Scanner scan = new Scanner(System.in);
// public static void main(String[] args){
// 	 
//     int[] result = processEquation(equation);
//     ListModel.addAttribute("result", result);
//     return "result";
// }
//  static int[] solveEquation(String equation) {
//    String[] segments = equation.split("_");
//    int[] values = new int[segments.length];
//
//    for (int i = 0; i < segments.length; i++) {
//        String segment = segments[i];
//
//        if (segment.equals("z")) {
//            if (i < segments.length - 1 && segments[i + 1].length() > 0) {
//                String nextSegment = segments[i + 1];
//                int combinedValue = 26;
//                if (nextSegment.charAt(0) != 'z') {
//                    combinedValue += nextSegment.charAt(0) - 'a' + 1;
//                }
//                values[i] = combinedValue;
//                values[i + 1] = -1; // mark the next segment as combined
//                i++; // skip the next segment
//            } else {
//                values[i] = 26;
//            }
//        } else {
//            values[i] = segment.charAt(0) - 'a' + 1;
//        }
//    }
//
//    int[] result = new int[(segments.length + 3) / 4];
//    int groupIndex = 0;
//    int groupSum = 0;
//    for (int i = 0; i < values.length; i++) {
//        if (i % 4 == 0 && i > 0) {
//            result[groupIndex++] = groupSum;
//            groupSum = 0;
//        }
//        if (values[i] != -1 && i % 4 != 0) {
//            groupSum += values[i];
//        }
//    }
//    if (values.length % 4 != 0) {
//        result[result.length - 1] = groupSum;
//    }
//
//    return result;
//}
//}
