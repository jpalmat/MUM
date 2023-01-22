package lesson7.labsolns.prob3_staticstorage;

public interface Cache {
	default long timeout() {
		//seconds
		return 1;
	}
}
