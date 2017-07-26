package egorikem.bidrushkotlin.controller.cache.framework

import egorikem.bidrushkotlin.controller.cache.TimedCacheObject


/**
 * Created by egorikem on 2/5/17.
 */
abstract class ImpTimedAbstractPaperService<T> : ImpAbstractPaperService<TimedCacheObject<T>>()