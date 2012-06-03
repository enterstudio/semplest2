//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;

namespace SemplestModel
{
    public partial class ScheduleJob
    {
        #region Primitive Properties
    
        public virtual int ScheduleJobPK
        {
            get;
            set;
        }
    
        public virtual int ScheduleFK
        {
            get { return _scheduleFK; }
            set
            {
                if (_scheduleFK != value)
                {
                    if (Schedule != null && Schedule.SchedulePK != value)
                    {
                        Schedule = null;
                    }
                    _scheduleFK = value;
                }
            }
        }
        private int _scheduleFK;
    
        public virtual System.DateTime ExecutionStartTime
        {
            get;
            set;
        }
    
        public virtual bool IsSuccessful
        {
            get;
            set;
        }
    
        public virtual bool IsComplete
        {
            get;
            set;
        }
    
        public virtual System.DateTime CreatedDate
        {
            get;
            set;
        }
    
        public virtual Nullable<System.DateTime> EditedDate
        {
            get;
            set;
        }

        #endregion
        #region Navigation Properties
    
        public virtual Schedule Schedule
        {
            get { return _schedule; }
            set
            {
                if (!ReferenceEquals(_schedule, value))
                {
                    var previousValue = _schedule;
                    _schedule = value;
                    FixupSchedule(previousValue);
                }
            }
        }
        private Schedule _schedule;
    
        public virtual ICollection<ScheduleLog> ScheduleLogs
        {
            get
            {
                if (_scheduleLogs == null)
                {
                    var newCollection = new FixupCollection<ScheduleLog>();
                    newCollection.CollectionChanged += FixupScheduleLogs;
                    _scheduleLogs = newCollection;
                }
                return _scheduleLogs;
            }
            set
            {
                if (!ReferenceEquals(_scheduleLogs, value))
                {
                    var previousValue = _scheduleLogs as FixupCollection<ScheduleLog>;
                    if (previousValue != null)
                    {
                        previousValue.CollectionChanged -= FixupScheduleLogs;
                    }
                    _scheduleLogs = value;
                    var newValue = value as FixupCollection<ScheduleLog>;
                    if (newValue != null)
                    {
                        newValue.CollectionChanged += FixupScheduleLogs;
                    }
                }
            }
        }
        private ICollection<ScheduleLog> _scheduleLogs;

        #endregion
        #region Association Fixup
    
        private void FixupSchedule(Schedule previousValue)
        {
            if (previousValue != null && previousValue.ScheduleJobs.Contains(this))
            {
                previousValue.ScheduleJobs.Remove(this);
            }
    
            if (Schedule != null)
            {
                if (!Schedule.ScheduleJobs.Contains(this))
                {
                    Schedule.ScheduleJobs.Add(this);
                }
                if (ScheduleFK != Schedule.SchedulePK)
                {
                    ScheduleFK = Schedule.SchedulePK;
                }
            }
        }
    
        private void FixupScheduleLogs(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (e.NewItems != null)
            {
                foreach (ScheduleLog item in e.NewItems)
                {
                    item.ScheduleJob = this;
                }
            }
    
            if (e.OldItems != null)
            {
                foreach (ScheduleLog item in e.OldItems)
                {
                    if (ReferenceEquals(item.ScheduleJob, this))
                    {
                        item.ScheduleJob = null;
                    }
                }
            }
        }

        #endregion
    }
}
