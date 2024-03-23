import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		streams s = new streams();
		s.streamFilter();
	}
	
	
	public void streamFilter() {
		
		ArrayList<String> name = new ArrayList();
		name.add("Ananya");
		name.add("A Rohit");
		name.add("Umesh");
		name.add("Swaroopa");
		
		Long c = name.stream().filter(s->s.endsWith("a")).count();
		System.out.println(c);
		name.stream().filter(s->
			s.length()>5).forEach(s->System.out.println(s));
		
		name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Stream.of(1,3, 6, 4 ,5, 2, 1, 7, 3, 9).distinct().sorted().forEach(s->System.out.println(s));
		Stream.of(1,3, 6, 4 ,5, 2, 1, 7, 3, 9).distinct().sorted().limit(4).forEach(s->System.out.println(s));
		Stream.of(12,31, 60, 47 ,51, 2, 1).filter(s->s<50).forEach(s->System.out.println(s));
		List<String> output = name.stream().filter(s->s.startsWith("A")).sorted().collect(Collectors.toList());
		System.out.println(output.get(0));
		
		List<String> names = Arrays.asList("Anu", "Ananya1", "Rohit1", "Ramus");
		names.stream().map(s->s.toUpperCase()).forEach(s->System.out.println(s +"---------------"));
		
		Stream<String> newstream = Stream.concat(names.stream(), name.stream());
		//newstream.sorted().forEach(s->System.out.println(s)); //it is modified stream with sorted values
		
		boolean flag = newstream.anyMatch(s->s.equalsIgnoreCase("Anu"));
		Assert.assertTrue(flag);
		
		List<Integer> values = Arrays.asList(3, 2,2, 7, 5, 1, 9, 7);
		values.stream().distinct().forEach(s->System.out.println(s));

		
	}

}
