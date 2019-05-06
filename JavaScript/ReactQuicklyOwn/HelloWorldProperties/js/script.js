class HelloWorldWithProps extends React.Component {
    render() {
        console.log(Object.isFrozen(this.props))
        return React.createElement(
            'h1', 
            this.props, 
            'Hello ' + this.props.frameworkName)
    }
}
ReactDOM.render(
    React.createElement(
        'div', 
        null, 
        React.createElement(HelloWorldWithProps, {
            id: 'ember',
            frameworkName: 'Ember.js',
            title: 'A framework for creating ambitious web applications'
        }),
        React.createElement(HelloWorldWithProps, {
            id: 'backbone',
            frameworkName: 'BackBone.js',
            title: 'Backbone.js gives structure to web applications...'
        }),
        React.createElement(HelloWorldWithProps, {
            id: 'angular',
            frameworkName: 'Angular.js',
            title: 'Superheroic JavaScript MVW Framework'
        })
    ),
    document.getElementById('content')
)