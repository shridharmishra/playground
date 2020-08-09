# playground-rule-engine

## What this project all about?

I was searching for a simple java based rule engine. But didn't find any. I got the chance to read an article by Martin Flower on Java Rules, in which he says:

<i>You can build a simple rules engine yourself. All you need is to create a bunch of objects with conditions and actions, store them in a collection, and run through them to evaluate the conditions and execute the actions.</i>

In this project, I have created a simple framework for rules. Anyone can use this library, to create a simple rule engine. 
Implementer needs to build a rule with the Action, Condition, and Priority. Action will be performed only when the condition evaluates to true.

## Example

#### Create an action class by implementing IAction

```
@Component("firstAction")
public class FirstAction implements IAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstAction.class);
    
    @Override
    public String getName() {
        return "FirstAction";
    }

    @Override
    public Data execute(Data data) {
        LOGGER.info("Executing the firstAction ");
        // Logic of the action
        return data;
    }
}
```
#### Create condition class by implementing ICondition
```
@Component("firstCondition")
public class FirstCondition implements ICondition {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstCondition.class);
    @Override
    public boolean evaluate(Data D) {

        System.out.println("Apply Condition 1");
        return false;
    }
}

```
####  Build the rule
```
 IRule rule1 = new RuleBuilder()
                .withRuleName("Rule1")
                .withDescription("Rule1 Description")
                .withAction(action1)
                .withCondition(condition1)
                .withPriority(10)
                .build();
```

####  Example to execute

```
@Component
public class ProcessRequestWithRules {

    List<IRule> rules = new ArrayList<>();

    @Autowired
    @Qualifier("firstCondition")
    ICondition condition1;

    @Autowired
    @Qualifier("secCondition")
    ICondition condition2;

    @Autowired
    @Qualifier("thirdCondition")
    ICondition condition3;


    @Autowired
    @Qualifier("firstAction")
    IAction action1;
    @Autowired
    @Qualifier("secAction")
    IAction action2;

    @Autowired
    @Qualifier("thirdAction")
    IAction action3;

    @PostConstruct
    public void buildRules(){
        IRule rule1 = new RuleBuilder()
                .withRuleName("Rule1")
                .withDescription("Rule1 Description")
                .withAction(action1)
                .withCondition(condition1)
                .withPriority(10)
                .build();
        IRule rule2 = new RuleBuilder()
                .withRuleName("Rule2")
                .withDescription("Rule2 Description")
                .withAction(action2)
                .withCondition(condition2)
                .withPriority(5)
                .build();

        IRule rule3 = new RuleBuilder()
                .withRuleName("Rule3")
                .withDescription("Rule3 Description")
                .withAction(action3)
                .withCondition(condition3)
                .withPriority(7)
                .build();

        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
    }

    public void applyRule() throws Exception {
        RuleProcessor processor = new RuleProcessor();
        processor.process(rules,new Data<Integer>(2));
    }

}
```
