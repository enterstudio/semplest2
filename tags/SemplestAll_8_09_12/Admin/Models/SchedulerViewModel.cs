using System.Collections.Generic;

namespace Semplest.Admin.Models
{

    public class SchedulerViewModel
    {
        public string CustomerName { get; set; }
        public string PromotionName { get; set; }
        public string ScheduleName { get; set; }
        public int SchedulePK { get; set; }
        public string Frequency { get; set; }
        public System.DateTime ExecutionStartTime { get; set; }
        public bool IsComplete { get; set; }
        public bool IsSuccessful { get; set; }
        public bool IsEnabled { get; set; }
        public bool IsInactive { get; set; }
        public int ScheduleJobPK { get; set; }
        
    }

    public class SchedulerViewModelCollection
    {
        public List<Semplest.Admin.Models.SchedulerViewModel> SVM = new List<SchedulerViewModel>();
        public string Status { get; set; }
    }

}