package ng.bayue.generator.gen;

public final class FactoryProducer {

	private static final class SingleDaoGeneratorFactory {
		private static volatile DaoGeneratorFactory generatorFactoryInstance;

		private static DaoGeneratorFactory getFactoryInstance() {
			if (null == generatorFactoryInstance) {
				synchronized (DaoGeneratorFactory.class) {
					if (null == generatorFactoryInstance) {
						generatorFactoryInstance = new DaoGeneratorFactory();
					}
				}
			}
			return generatorFactoryInstance;
		}
	}

	private static final class SingleSqlMapperGeneratorFactory {
		private static volatile SqlMapperGeneratorFactory generatorFactoryInstance;

		private static SqlMapperGeneratorFactory getFactoryInstance() {
			if (null == generatorFactoryInstance) {
				synchronized (SqlMapperGeneratorFactory.class) {
					if (null == generatorFactoryInstance) {
						generatorFactoryInstance = new SqlMapperGeneratorFactory();
					}
				}
			}
			return generatorFactoryInstance;
		}
	}

	private static final class SingleServiceGeneratorFactory {
		private static volatile ServiceGeneratorFactory generatorFactoryInstance;

		private static ServiceGeneratorFactory getFactoryInstance() {
			if (null == generatorFactoryInstance) {
				synchronized (ServiceGeneratorFactory.class) {
					if (null == generatorFactoryInstance) {
						generatorFactoryInstance = new ServiceGeneratorFactory();
					}
				}
			}
			return generatorFactoryInstance;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends FactoryGenerator> T getFactory(Class<T> clazz) throws Exception {
		if (null == clazz)
			throw new NullPointerException();
		if (SqlMapperGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
			return (T) SingleSqlMapperGeneratorFactory.getFactoryInstance();
		}
		if (DaoGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
			return (T) SingleDaoGeneratorFactory.getFactoryInstance();
		}
		if (ServiceGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
			return (T) SingleServiceGeneratorFactory.getFactoryInstance();
		}
		return clazz.newInstance();
	}

}
