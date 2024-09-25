# Android Java

## Intents
- An Intent is an abstract description of an operation to be performed. It can be thought of as a message that you can use to request an action from another app component.
- Intents can be used to:
	- Start a new activity (e.g., navigating to another screen).
	- Start a service (e.g., starting a background task).
	- Deliver a broadcast (e.g., sending a system-wide message).


## Explicit Intents: 
- These are used to start a specific component within your app. With explicit intents, you specify the component that should handle the intent by setting the component’s class name.
- Example: Starting a specific activity within the same app.
- Intent intent = new Intent(CurrentActivity.this, TargetActivity.class);
- startActivity(intent);

## Implicit intents
- Implicit Intents: These do not specify the component that should handle the intent. Instead, they declare a general action to perform, and the Android system will find an appropriate component (activity, service, etc.) that can handle the intent.
- Example: Sharing content via other apps.
- Intent intent = new Intent(Intent.ACTION_SEND);
- intent.setType("text/plain");
- intent.putExtra(Intent.EXTRA_TEXT, "Hello, World!");
- startActivity(Intent.createChooser(intent, "Share using"));



## Fundmentals of UI

### Views 
- base class for all visual interface
- commonlykmown as controls
- All UI classes extends view
- textview , edittext , button , checkbox , radio button

### Activities -> put compnontes on it
- ViewGroup -> view + view + viewgroup
- the root element is the layout or viewgroup
	- this root is put on activity

## creating Activity GUI with views
- setcontent view -> take the root to create the UI
- setcontentview makes a layout inflation
- it can take either layout resource ID or a single View instance













