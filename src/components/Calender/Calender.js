import React from 'react'
import './Calender.css'
import { Calendar, dateFnsLocalizer } from 'react-big-calendar'
import format from 'date-fns/format'
import parse from 'date-fns/parse'
import startOfWeek from 'date-fns/startOfWeek'
import getDay from 'date-fns/getDay'
import enUS from 'date-fns/locale/en-US'
import 'react-big-calendar/lib/css/react-big-calendar.css'

const locales = {
  'en-US': enUS,
}

const localizer = dateFnsLocalizer({
  format,
  parse,
  startOfWeek,
  getDay,
  locales,
})

const events = [

    {
        title:'Hi',
        start: new Date(2023,20,10),
        start: new Date(2023,20,10)       
    },
    {
        title:'Bye',
        start: new Date(2023,21,10),
        start: new Date(2023,21,10)       
    },
    {
        title:'hl',
        start: new Date(2023,22,10),
        start: new Date(2023,22,10)       
    },

]



function Calender() {
  return (
    <div>
        <Calendar
      localizer={localizer}
      events={events}
      startAccessor="start"
      endAccessor="end"
      style={{ height: 500 }}
    />
    </div>
  )
}

export default Calender