package ng.bayue.generator.gen.factory;

import ng.bayue.generator.gen.Generator;

public final class FactoryProducer {

	private static final class SingletonFreemarkerGeneratorFactory {
		private static volatile FreemarkerGeneratorFactory generatorFactoryInstance;

		private static FreemarkerGeneratorFactory getFactoryInstance() {
			if (null == generatorFactoryInstance) {
				synchronized (FreemarkerGeneratorFactory.class) {
					if (null == generatorFactoryInstance) {
						generatorFactoryInstance = new FreemarkerGeneratorFactory();
					}
				}
			}
			return generatorFactoryInstance;
		}
	}

	private static final class SingletonDaoGeneratorFactory {
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

	private static final class SingletonSqlMapperXMLGeneratorFactory {
		private static volatile SqlMapperXMLGeneratorFactory generatorFactoryInstance;

		private static SqlMapperXMLGeneratorFactory getFactoryInstance() {
			if (null == generatorFactoryInstance) {
				synchronized (SqlMapperXMLGeneratorFactory.class) {
					if (null == generatorFactoryInstance) {
						generatorFactoryInstance = new SqlMapperXMLGeneratorFactory();
					}
				}
			}
			return generatorFactoryInstance;
		}
	}

	private static final class SingletonServiceGeneratorFactory {
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

	private static final class SingletonEntityGeneratorFactory {
		private static volatile EntityGeneratorFactory generatorFactoryInstance;

		private static EntityGeneratorFactory getFactoryInstance() {
			if (null == generatorFactoryInstance) {
				synchronized (EntityGeneratorFactory.class) {
					if (null == generatorFactoryInstance) {
						generatorFactoryInstance = new EntityGeneratorFactory();
					}
				}
			}
			return generatorFactoryInstance;
		}
	}

	private static final class SingletonKeyGeneratorFactory {
		private static volatile KeyGeneratorFactory generatorFactoryInstance;

		private static KeyGeneratorFactory getFactoryInstance() {
			if (null == generatorFactoryInstance) {
				synchronized (KeyGeneratorFactory.class) {
					if (null == generatorFactoryInstance) {
						generatorFactoryInstance = new KeyGeneratorFactory();
					}
				}
			}
			return generatorFactoryInstance;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends FactoryGenerator<?>> T getFactory(Class<T> clazz) {
		try {
			if (null == clazz)
				throw new NullPointerException();
			if (FreemarkerGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
				return (T) SingletonFreemarkerGeneratorFactory.getFactoryInstance();
			}
			if (SqlMapperXMLGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
				return (T) SingletonSqlMapperXMLGeneratorFactory.getFactoryInstance();
			}
			if (DaoGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
				return (T) SingletonDaoGeneratorFactory.getFactoryInstance();
			}
			if (ServiceGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
				return (T) SingletonServiceGeneratorFactory.getFactoryInstance();
			}
			if (EntityGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
				return (T) SingletonEntityGeneratorFactory.getFactoryInstance();
			}
			if (KeyGeneratorFactory.class.getSimpleName().equals(clazz.getSimpleName())) {
				return (T) SingletonKeyGeneratorFactory.getFactoryInstance();
			}
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
