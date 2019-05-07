/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import com.mysite.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @param <E>
 * @param <K>
 * @author Rémi
 */
@SuppressWarnings("unchecked")
public abstract class AbstractGenericDao<E, K extends Serializable> implements GenericDao<E, K> {

	private Session session;

	abstract Class<E> getEntityClass();

	public E findById(final Serializable id) {
		session = HibernateUtil.getSessionFactory().openSession();
		E result = null;
		try {
			session.beginTransaction();
			result = (E) session.get(this.getEntityClass(), id);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}

		return result;
	}

	@Override
	public Serializable save(E entity) {

		session = HibernateUtil.getSessionFactory().openSession();
		Serializable result = null;
		try {
			session.beginTransaction();
			result = session.save(entity);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}

		return result;
	}

	@Override
	public void saveOrUpdate(E entity) {

		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}

	}

	@Override
	public void delete(E entity) {

		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}

	}

	@Override
	public List<E> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<E> result = null;
		try {
			session.beginTransaction();
			result = session.createCriteria(this.getEntityClass()).list();
			//result =session.createQuery("from "+E.class.getName());
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}
		return result;
	}

	@Override
	public List<E> findAllByExample(E entity) {

		Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();

		session = HibernateUtil.getSessionFactory().openSession();
		List<E> result = null;
		try {
			session.beginTransaction();
			result = session.createCriteria(this.getEntityClass()).add(example).list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}
		return result;
	}

	@Override
	public E find(K key) {
		return executeInTransaction(session -> (E) session.get(this.getEntityClass(), key))
			.orElse(null);
	}

	@Override
	public void clear() {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.clear();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}

	}

	@Override
	public void flush() {
		executeInTransaction(session -> {
			session.flush();
			return null;
		});
	}

	private Optional<E> executeInTransaction(Function<Session, E> methode) {

		session = HibernateUtil.getSessionFactory().openSession();
		Optional<E> result = Optional.empty();
		try {
			session.beginTransaction();
			result = Optional.ofNullable(methode.apply(session));
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}

		}

		return result;
	}
}
