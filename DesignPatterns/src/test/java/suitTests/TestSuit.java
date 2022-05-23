package suitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import builders.BoatBuilderTest;
import builders.BookBuilderTest;
import builders.MonitorBuilderTest;
import builders.ShirtBuilderTest;
import entities.BackOfficeTest;
import entities.CartTest;
import entities.CatalogTest;
import entities.OrderListTest;
import entities.OrderTest;
import productsTest.BoatTest;
import productsTest.BookTest;
import productsTest.MonitorTest;
import productsTest.ShirtTest;

@RunWith(Suite.class)
@SuiteClasses({
	BoatBuilderTest.class,
	BookBuilderTest.class,
	MonitorBuilderTest.class,
	ShirtBuilderTest.class,
	CartTest.class,
	CatalogTest.class,
	OrderTest.class,
	BookTest.class,
	BoatTest.class,
	MonitorTest.class,
	ShirtTest.class,
	BackOfficeTest.class,
	OrderListTest.class
	
})	

public class TestSuit {

}
