package se.blinfo.regexp.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import se.blinfo.regexp.sample.AbstractValidator;

/**
 * Validate UUID Format.
 * <p>
 * Check if input corresponds to the expected format:
 * <ol>
 * <li>a group of eight hexadecimal digits (0 - 9 and lower case a - f)</li>
 * <li>three groups of four hexadecimal digits</li>
 * <li>a group of twelve hexadecimal digits</li>
 * <li>each group is separated by a hyphen</li>
 * </ol>
 * E. g. 4b4ec661-eef0-4147-b928-a62c6f53f3a4,
 * 862ea32b-77dc-4055-a94f-0c4d43df7901, 331b9c89-fcfc-4701-86a1-8428dfeb5aea
 *
 * @author hl
 */
public class UUIDValidator extends AbstractValidator {

    private static final String REGEXP = "";

    public UUIDValidator(String input) {
        super(input, REGEXP);
    }

    public static void main(String[] args) {
        System.out.println("The following should validate to \"true\"");
        List<String> validInput = Arrays.asList("6a44bda9-1e95-4fb5-a982-c03927cc0402", "b82aed21-3a6f-3a4f-93db-2fc45a7a4737", "7c9f8479-9ede-3fce-bf59-c154a5f73d4e");
        validInput.forEach(s -> System.out.println(new UUIDValidator(s).validate()));
        IntStream.range(0, 5).forEach(i -> {
            System.out.println(new UUIDValidator(UUID.randomUUID().toString()).validate());
        });
        System.out.println("\nThe following should validate to \"false\"");
        List<String> invalidInput = Arrays.asList("6a44bda9-1e95-4fb5-c03927cc0402",
                "6a44bda9e-1e95-4fb5-a982-c03927cc0402", "2908gfe2-a81e-4797-b324-b3f2b18b428c",
                "6A44BDA9-1E95-4FB5-A982-C03927CC0402");
        invalidInput.forEach(s -> System.out.println(new UUIDValidator(s).validate()));
    }
}
